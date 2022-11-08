package github.erb3.plugin.hugger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Configurator {
    private final Plugin pl;
    private FileConfiguration config;

    public Configurator(Plugin pl) {
        this.pl = pl;
        // this.config = pl.getConfig();
    }

    public void createConfig() {
        this.pl.saveDefaultConfig();
        this.config = pl.getConfig();
    }

    public void saveConfig() {
        this.pl.saveConfig();
    }

    public String getStringValue(String key) {
        return this.config.getString(key);
    }
}
