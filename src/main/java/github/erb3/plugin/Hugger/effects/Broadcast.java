package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Main;
import github.erb3.plugin.Hugger.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Broadcast implements Effect{

    private final Main main;
    public Broadcast(Main main) {
        this.main = main;
    }

    @Override
    public void runEffect(CommandSender from, Player to, HashMap<String, String> args) {
        this.main.getServer().broadcastMessage(Utils.formatString(args.get("message"), to.getDisplayName(), Utils.generateCommandSenderName(from)));
    }
}
