package github.erb3.plugin.Hugger;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils {
    public static String generateCommandSenderName(CommandSender from) {
        String fromName;
        if (from instanceof Player) fromName = ((Player) from).getDisplayName();
        else fromName = "&d" + from.getName();

        return fromName;
    }
}
