package github.erb3.plugin.hugger.command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hug implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(args.length > 0)) {
            sender.sendMessage(ChatColor.DARK_RED + "[Hugger] Syntax: /hug [player]");
            return true;
        }

        Player pTo = Bukkit.getPlayer(args[0]);

        if (pTo == null) {
            sender.sendMessage(ChatColor.DARK_RED + "[Hugger] The player specified doesn't exist!");
            return true;
        }

        pTo.sendMessage(ChatColor.RED + "You got hugged by: " + sender.getName() + "! ❤");
        sender.sendMessage(ChatColor.RED + "❤ Hugging: " + pTo.getName());
        return true;
    }
}
