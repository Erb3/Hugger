package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ActionBar implements Effect {

    @Override
    public void runEffect(CommandSender from, Player to, HashMap<String, String> args) {
        String fromName = Utils.generateCommandSenderName(from);

        if (from instanceof Player fromPlayer) {
            fromPlayer.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                    new TextComponent(Utils.formatString(args.get("huggingPlayer"), to.getDisplayName())));
        }

        to.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                new TextComponent(Utils.formatString(args.get("gotHugged"), fromName)));
    }
}
