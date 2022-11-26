package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Main;
import github.erb3.plugin.Hugger.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Statistics implements Effect{
    private final Main main;

    public Statistics(Main main) {
        this.main = main;
    }

    @Override
    public void runEffect(CommandSender from, Player to) {
        String fromStr = Utils.toUUID(from);
        String toStr = Utils.toUUID(to);

        this.main.sm.increaseTotalHugs();
        this.main.sm.increasePlayerSent(fromStr);
        this.main.sm.increasePlayerReceived(toStr);
        this.main.sm.save();
    }

    @Override
    public String getName() {
        return "statistics";
    }
}
