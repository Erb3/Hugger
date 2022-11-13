package github.erb3.plugin.Hugger;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Configurator {
    private final Plugin pl;
    private FileConfiguration config;

    public Configurator(Plugin pl) {
        this.pl = pl;
    }

    public void createConfig() {
        this.pl.saveDefaultConfig();
        this.config = pl.getConfig();
    }

    public void reload() {
        this.pl.reloadConfig();
        this.config = this.pl.getConfig();
    }

    public String getRawString(String key) {
        return this.config.getString(key);
    }

    public String getFormattedString(String key, String... args) {
        if (args == null || args.length == 0) {
            return ChatColor.translateAlternateColorCodes('&', getRawString(key));
        } else {
            return ChatColor.translateAlternateColorCodes('&', String.format(getRawString(key), (Object[]) args));
        }
    }
}
