package github.erb3.plugin.Hugger.command;

import github.erb3.plugin.Hugger.Configurator;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hug implements CommandExecutor {

    private final Configurator conf;
    public Hug(Configurator conf) {
        this.conf = conf;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // Check if there are arguments
        if (!(args.length > 0)) {
            sender.sendMessage(this.conf.getString("translation.syntaxError"));
            return true;
        }

        // Check if player exists
        Player pTo = Bukkit.getPlayer(args[0]);
        if (pTo == null) {
            sender.sendMessage(this.conf.getString("translation.playerNotFoundError"));
            return true;
        }

        // Add extra check in case of getting hugged from Console.
        String pFrom;
        if (sender instanceof Player) pFrom = ((Player) sender).getDisplayName();
        else pFrom = "&d" + sender.getName();

        // Send chat messages
        pTo.sendMessage(this.conf.getString("translation.youGotHugged", pFrom));
        sender.sendMessage(this.conf.getString("translation.huggingPlayer", pTo.getDisplayName()));
        return true;
    }
}
