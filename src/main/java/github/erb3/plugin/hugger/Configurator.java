package github.erb3.plugin.hugger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class Configurator {
    private final Plugin pl;
    private final FileConfiguration config;

    public Configurator(Plugin pl) {
        this.pl = pl;
        this.config = pl.getConfig();
    }

    public void createConfig() {
        this.config.addDefault("translation.youGotHugged", "&3Hugger &8>> &7You got hugged by: %s");

        this.pl.saveDefaultConfig();
    }

    public void saveConfig() {
        this.pl.saveConfig();
    }

    public String getStringValue(String key) {
        return this.config.getString(key);
    }
}
