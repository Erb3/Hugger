package github.erb3.plugin.Hugger.effects;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface Effect {
    /**
     * Function that executes when someone gets hugged
     */
    void runEffect(CommandSender from, Player to);

    /**
     * String that contains the effect name. This is used in config file
     */
    String getName();
}
