package github.erb3.plugin.Hugger.command;

import github.erb3.plugin.Hugger.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Hug implements CommandExecutor {

    private final Main main;
    public Hug(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

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

        return true;
    }
}
