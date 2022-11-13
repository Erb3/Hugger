package github.erb3.plugin.Hugger.command;

import github.erb3.plugin.Hugger.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Hugger implements CommandExecutor {
    private final Main main;

    public Hugger(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            return helpCommand(sender, cmd, label, args);
        }

        switch (args[0]) {
            case "config": {
                return configCommand(sender, cmd, label, args);
            }

            default: {
                return helpCommand(sender, cmd, label, args);
            }
        }
    }

    public boolean configCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(this.main.conf.getFormattedString("translation.incorrectUsage"));
            return true;
        }

        switch (args[1]) {
            case "reload": {
                this.main.conf.reload();
                sender.sendMessage(this.main.conf.getFormattedString("translation.configReloaded"));
                break;
            }

            // Only for debugging purposes
            case "get": {
                if (args.length != 3) {
                    sender.sendMessage(this.main.conf.getFormattedString("translation.incorrectUsage"));
                    return true;
                }

                sender.sendMessage(this.main.conf.getRawString(args[2]));
                break;
            }
        }

        return true;
    }

    public boolean helpCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "\n        &8<< &3Hugger &7by &6Erb3 & Contributors &8>>" +
                "\n  &3>> &7/hug &d[player]" +
                "\n  &3>> &7/hugger &d[config/help]" +
                "\n  &3>> &7/hugger config reload" +
                "\n  &3>> &7/hugger help\n "));
        return true;
    }
}
