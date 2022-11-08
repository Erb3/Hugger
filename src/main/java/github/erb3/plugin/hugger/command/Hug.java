package github.erb3.plugin.hugger.command;

import github.erb3.plugin.hugger.Configurator;
import github.erb3.plugin.hugger.utils.Colorify;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

        if (!(args.length > 0)) {
            sender.sendMessage(Colorify.color(this.conf.getStringValue("translation.syntaxError")));
            return true;
        }

        Player pTo = Bukkit.getPlayer(args[0]);

        if (pTo == null) {
            sender.sendMessage(Colorify.color(this.conf.getStringValue("translation.playerNotFoundError")));
            return true;
        }

        pTo.sendMessage(Colorify.color(this.conf.getStringValue("translation.youGotHugged")));
        sender.sendMessage(Colorify.color(this.conf.getStringValue("translation.huggingPlayer")));
        return true;
    }
}
