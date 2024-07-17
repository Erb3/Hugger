package github.erb3.plugin.Hugger.files;

import github.erb3.plugin.Hugger.Main;
import github.erb3.plugin.Hugger.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;

public class StatManager {
    private final Main main;
    public File statFile;
    public FileConfiguration statConfig;
    private String recordHolder = "";
    private int recordAmount = 0;

    public StatManager(Main main) {
        this.main = main;
    }

    public void createFile() {
        statFile = new File(this.main.getDataFolder(), "stats.yml");

        if (!statFile.exists()) {
            this.main.getLogger().info("Statistics file not found! Creating a new one :)");
            //noinspection ResultOfMethodCallIgnored
            statFile.getParentFile().mkdirs();

            this.main.saveResource("stats.yml", false);
        }

        statConfig = YamlConfiguration.loadConfiguration(statFile);

        if (this.main.config.getRawString("enableRecords").equalsIgnoreCase("true")) {
            this.updateRecordReading();
        }
    }

    private void increase(String field) {
        String fieldVal = this.statConfig.getString(field);
        int fieldIntVal;

        if (fieldVal != null) {
            fieldIntVal = Integer.parseInt(fieldVal) + 1;
        } else {
            fieldIntVal = 1;
        }

        this.statConfig.set(field, Integer.toString(fieldIntVal));
    }

    private int fetch(String field) {
        String fieldStr = this.statConfig.getString(field);

        if (fieldStr == null) {
            this.statConfig.set(field, 0);
            return 0;
        }

        return Integer.parseInt(fieldStr);
    }

    public void increaseTotalHugs() {
        increase("total");
    }

    public void increasePlayerSent(String playerName) {
        increase("player." + playerName + ".sent");
    }

    public void increasePlayerReceived(String playerName) {
        increase("player." + playerName + ".received");
    }

    public void save() {
        this.main.getLogger().info("Saving statistics file.");
        try {
            this.statConfig.save(this.statFile);
            this.main.getLogger().info("Statistics file saved.");
        } catch (IOException e) {
            this.main.getLogger().log(Level.SEVERE, "Could not save stats file!\n" + e);
        }
    }

    public int getTotalHugs() {
        return fetch("total");
    }

    public int getPlayerSent(String playerName) {
        return fetch("player." + playerName + ".sent");
    }

    public int getPlayerReceived(String playerName) {
        return fetch("player." + playerName + ".received");
    }

    public void updateRecordReading() {
        String currentRecordAmountStr = this.statConfig.getString("record.amount");
        String currentRecordHolder = this.statConfig.getString("record.holder");

        if (currentRecordAmountStr == null || currentRecordHolder == null) {
            this.main.getLogger().severe("Severe Error! Trying to update record, but field not found!!");
            return;
        }

        this.recordHolder = currentRecordHolder;
        this.recordAmount = Integer.parseInt(currentRecordAmountStr);
    }

    public void updateRecord(CommandSender player) {
        if (!this.main.config.getRawString("enableRecords").equalsIgnoreCase("true")) {
            return;
        }

        int amountOfHugs = this.getPlayerReceived(Utils.toUUID(player));
        String currentRecordHolder = this.recordHolder;

        if (amountOfHugs <= this.recordAmount) return;

        this.statConfig.set("record.holder", Utils.toUUID(player));
        this.statConfig.set("record.amount", amountOfHugs);

        if (Objects.equals(currentRecordHolder, Utils.toUUID(player))) {
            return;
        }

        this.updateRecordReading();
        player.sendMessage(this.main.config.getFormattedString("translation.newRecord", currentRecordHolder));
        this.main.getServer().broadcastMessage(
                this.main.config.getFormattedString("translation.newRecordBroadcast", player.getName(), Integer.toString(amountOfHugs)));
    }

    public void increaseStats(CommandSender from, CommandSender to) {
        String fromStr = Utils.toUUID(from);
        String toStr = Utils.toUUID(to);

        this.increaseTotalHugs();
        this.increasePlayerSent(fromStr);
        this.increasePlayerReceived(toStr);
        this.updateRecord(to);

        this.save();
    }

    public String getRecordHolder() {
        return this.recordHolder;
    }

    public int getRecord() {
        return this.recordAmount;
    }
}
