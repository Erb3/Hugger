package github.erb3.plugin.Hugger.files;

import github.erb3.plugin.Hugger.Main;
import github.erb3.plugin.Hugger.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class StatManager {
    private final Main main;
    public File statFile;
    public FileConfiguration statConfig;

    public StatManager(Main main) {
        this.main = main;
    }

    public void createFile() {
        statFile = new File(this.main.getDataFolder(), "stats.yml");

        if (!statFile.exists()) {
            boolean couldCreateDirs = statFile.getParentFile().mkdirs();

            if (!couldCreateDirs) {
                this.main.getLogger().severe("Severe error!!  Could not create the needed directories for stats!");
                return;
            }

            this.main.saveResource("stats.yml", false);
        }

        statConfig = new YamlConfiguration();

        YamlConfiguration.loadConfiguration(statFile);
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
        try {
            this.statConfig.save(this.statFile);
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

    public void increaseStats(CommandSender from, CommandSender to) {
        String fromStr = Utils.toUUID(from);
        String toStr = Utils.toUUID(to);

        this.main.sm.increaseTotalHugs();
        this.main.sm.increasePlayerSent(fromStr);
        this.main.sm.increasePlayerReceived(toStr);
        this.main.sm.save();
    }
}
