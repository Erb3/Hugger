package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Main;
import github.erb3.plugin.Hugger.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatMessage implements Effect {
    private final Main main;
    public ChatMessage(Main main) {
        this.main = main;
    }

    @Override
    public void runEffect(CommandSender from, Player to) {
        String fromName = Utils.generateCommandSenderName(from);

        to.sendMessage(this.main.conf.getFormattedString("translation.youGotHugged", fromName));
        from.sendMessage(this.main.conf.getFormattedString("translation.huggingPlayer", to.getDisplayName()));
    }

    @Override
    public String getName() {
        return "chatMessage";
    }
}
