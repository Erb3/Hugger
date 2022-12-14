package github.erb3.plugin.Hugger.effects;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public interface Effect {
    /**
     * Function that executes when someone gets hugged. It should not return anything.
     * Both parameters are required.
     * @param from The sender of the hug. The one that hugs.
     * @param to The person that is getting hugged
     * @since 1.0.0
     */
    void runEffect(CommandSender from, Player to, HashMap<String, String> args);
}
