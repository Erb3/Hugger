package github.erb3.plugin.hugger.utils;

import org.bukkit.ChatColor;

public class Colorify {
    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
