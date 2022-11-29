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
            sendTitle(fromPlayer, Utils.formatString(args.get("huggingPlayer"), to.getDisplayName()));
        }

        sendTitle(to, Utils.formatString(args.get("gotHugged"), fromName));
    }

    private static void sendTitle(Player p, String oneliner) {
        String[] lines = oneliner.split(";");

        if (lines.length == 2) {
        p.sendTitle(
                Utils.formatString(lines[0]),
                Utils.formatString(lines[1]),
                5,
                20,
                5
        );
        } else {
            p.sendTitle(
                    Utils.formatString(lines[0]),
                    "",
                    5,
                    20,
                    5
            );
        }

    }
}
