package github.erb3.plugin.hugger.command;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hug implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(args.length > 0)) {
            return false;
        }

        Player pTo = Bukkit.getPlayer(args[0]);

        if (pTo == null) {
            sender.sendMessage("The player specified dosent exist!");
            return true;
        }

        pTo.sendMessage("You got hugged by: " + sender.getName());
        sender.sendMessage("Hugging: " + pTo.getDisplayName());
        return true;
    }
}
