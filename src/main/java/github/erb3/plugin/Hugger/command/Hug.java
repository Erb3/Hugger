package github.erb3.plugin.Hugger.command;

import github.erb3.plugin.Hugger.Main;
import github.erb3.plugin.Hugger.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Objects;

public class Hug implements CommandExecutor {

    private final Main main;
    private final HashMap<String, Long> cooldowns = new HashMap<>();

    public Hug(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {

        // Check if there are arguments
        if (!(args.length > 0)) {
            sender.sendMessage(this.main.conf.getFormattedString("translation.hugSyntaxError"));
            return true;
        }

        if (!sender.hasPermission("hugger.hug")) {
            sender.sendMessage(this.main.conf.getFormattedString("translation.permissionDenied", "hugger.hug"));
            return true;
        }

        // Check if player exists
        Player pTo = Bukkit.getPlayer(args[0]);
        if (pTo == null) {
            sender.sendMessage(this.main.conf.getFormattedString("translation.playerNotFoundError"));
            return true;
        }

        if (Objects.equals(Utils.toUUID(sender), Utils.toUUID(pTo))) {
            if (!sender.hasPermission("hugger.hug.self")) {
                sender.sendMessage(this.main.conf.getFormattedString("translation.permissionDenied", "hugger.hug.self"));
                return true;
            }
        }

        if (!cooldowns.containsKey(Utils.toUUID(sender))) {
            cooldowns.put(Utils.toUUID(sender), System.currentTimeMillis());
        } else {
            long diff = System.currentTimeMillis() - cooldowns.get(Utils.toUUID(sender));

            if (diff <= Integer.parseInt(this.main.conf.getRawString("cooldown")) * 1000L) {
                sender.sendMessage(this.main.conf.getFormattedString("translation.cooldownReached",
                        Integer.toString(Math.round(diff / 1000F)), this.main.conf.getRawString("cooldown")));
                return true;
            }

            cooldowns.put(Utils.toUUID(sender), System.currentTimeMillis());
         }

        // Run effects
        this.main.em.runAllEffects(sender, pTo);

        // Update statistics

        if (Objects.equals(Utils.toUUID(sender), Utils.toUUID(pTo))) {
            if (this.main.conf.getRawString("selfhugCountsStatistics").equalsIgnoreCase("true")) {
                if (this.main.conf.getRawString("enableStatistics").equalsIgnoreCase("true")) {
                    this.main.sm.increaseStats(sender, pTo);
                }
            }
        } else {
            if (this.main.conf.getRawString("enableStatistics").equalsIgnoreCase("true")) {
                this.main.sm.increaseStats(sender, pTo);
            }
        }

        return true;
    }
}
