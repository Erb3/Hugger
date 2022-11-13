package github.erb3.plugin.Hugger.command.Hugger;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Help implements Subcommand{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "\n        &8<< &3Hugger &7by &6Erb3 & Contributors &8>>" +
                "\n  &3>> &7/hug &d[player]" +
                "\n  &3>> &7/hugger &d[config/help]" +
                "\n  &3>> &7/hugger config reload" +
                "\n  &3>> &7/hugger help\n "));
        return true;
    }
}
