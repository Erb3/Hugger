package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Title implements Effect{

    @Override
    public void runEffect(CommandSender from, Player to, HashMap<String, String> args) {
        String fromName = Utils.generateCommandSenderName(from);

        if (from instanceof Player) {
            Player fromPlayer = (Player) from;
            fromPlayer.sendTitle(Utils.formatString(args.get("huggingPlayer"), to.getDisplayName()),
                    "", 1, 1, 1);
        }

        to.sendTitle(Utils.formatString(args.get("gotHugged"), fromName),
                "", 5, 30, 5);
    }
}
