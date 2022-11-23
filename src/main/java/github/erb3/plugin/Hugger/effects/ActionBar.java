package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Main;
import github.erb3.plugin.Hugger.Utils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ActionBar implements Effect {
    private final Main main;

    public ActionBar(Main main) {
        this.main = main;
    }

    @Override
    public void runEffect(CommandSender from, Player to) {
        String fromName = Utils.generateCommandSenderName(from);

        if (from instanceof Player) {
            Player fromPlayer = (Player) from;
            fromPlayer.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                    new TextComponent(this.main.conf.getFormattedString("effects.actionBar.huggingPlayer", to.getDisplayName())));
        }

        to.spigot().sendMessage(ChatMessageType.ACTION_BAR,
                new TextComponent(this.main.conf.getFormattedString("effects.actionBar.gotHugged", fromName)));
    }

    @Override
    public String getName() {
        return "actionBar";
    }
}
