package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Statistics implements Effect{
    private final Main main;

    public Statistics(Main main) {
        this.main = main;
    }

    @Override
    public void runEffect(CommandSender from, Player to) {
        this.main.sm.increaseTotalHugs();
        this.main.sm.increasePlayerSent(from.getName());
        this.main.sm.increasePlayerReceived(to.getName());
        this.main.sm.save();
    }

    @Override
    public String getName() {
        return "statistics";
    }
}
