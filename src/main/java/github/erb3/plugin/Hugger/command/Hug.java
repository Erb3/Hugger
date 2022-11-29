package github.erb3.plugin.Hugger.command;

import github.erb3.plugin.Hugger.Main;
import github.erb3.plugin.Hugger.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Hug implements CommandExecutor {

    private final Main main;

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

        // Check if player exists
        Player pTo = Bukkit.getPlayer(args[0]);
        if (pTo == null) {
            sender.sendMessage(this.main.conf.getFormattedString("translation.playerNotFoundError"));
            return true;
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
