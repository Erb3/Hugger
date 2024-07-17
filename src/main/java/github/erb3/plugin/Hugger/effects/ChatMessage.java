package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ChatMessage implements Effect {

    @Override
    public void runEffect(CommandSender from, Player to, HashMap<String, String> args) {
        to.sendMessage(Utils.formatString(args.get("gotHugged"), Utils.generateCommandSenderName(from)));
        from.sendMessage(Utils.formatString(args.get("huggingPlayer"), to.getDisplayName()));
    }
}
