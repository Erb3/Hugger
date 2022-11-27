package github.erb3.plugin.Hugger;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils {
    public static String generateCommandSenderName(CommandSender from) {
        String fromName;
        if (from instanceof Player) fromName = ((Player) from).getDisplayName();
        else fromName = "&d" + from.getName();

        return fromName;
    }

    public static String toUUID(CommandSender s) {
        String name;
        if (s instanceof Player) {
            name = ((Player) s).getUniqueId().toString();
        } else {
            name = s.getName();
        }

        return name;
    }

    public static String formatString(String str, String... args) {
        if (args == null || args.length == 0) {
            return ChatColor.translateAlternateColorCodes('&', str);
        } else {
            return ChatColor.translateAlternateColorCodes('&', String.format(str, (Object[]) args));
        }
    }
}
