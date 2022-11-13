package github.erb3.plugin.Hugger.command.Hugger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface Subcommand {
    boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);
}
