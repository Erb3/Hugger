package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Main;
import github.erb3.plugin.Hugger.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Title implements Effect{
    private final Main main;

    public Title(Main main) {
        this.main = main;
    }

    @Override
    public void runEffect(CommandSender from, Player to) {
        String fromName = Utils.generateCommandSenderName(from);

        if (from instanceof Player) {
            Player fromPlayer = (Player) from;
            fromPlayer.sendTitle(this.main.conf.getFormattedString("effects.title.huggingPlayer", to.getDisplayName()),
                    "", 1, 1, 1);
        }

        to.sendTitle(this.main.conf.getFormattedString("effects.title.gotHugged", fromName),
                "", 5, 30, 5);
    }

    @Override
    public String getName() {
        return "title";
    }
}
