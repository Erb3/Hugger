package github.erb3.plugin.hugger;

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

    public void saveConfig() {
        this.pl.saveConfig();
    }

    public String getRawStringValue(String key) {
        return this.config.getString(key);
    }

    public String getString(String key, String... args) {
        if (args == null || args.length == 0) {
            return ChatColor.translateAlternateColorCodes('&', getRawStringValue(key));
        } else {
            return ChatColor.translateAlternateColorCodes('&', String.format(getRawStringValue(key), (Object[]) args));
        }
    }

    public Boolean getBoolean(String key) {
        return this.config.getBoolean(key);
    }
}
