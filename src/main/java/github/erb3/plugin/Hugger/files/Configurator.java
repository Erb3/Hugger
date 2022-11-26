package github.erb3.plugin.Hugger.files;

import github.erb3.plugin.Hugger.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Configurator {
    private final Main pl;
    private FileConfiguration config;

    public Configurator(Main pl) {
        this.pl = pl;
    }

    public void createConfig() {
        this.pl.saveDefaultConfig();
        this.config = pl.getConfig();
        this.pl.em.updateEffectList();
    }

    public void reload() {
        this.pl.reloadConfig();
        this.config = this.pl.getConfig();
    }

    public String getRawString(String key) {
        return this.config.getString(key);
    }

    public boolean exists(String key) {
        return this.config.contains(key);
    }

    public String getFormattedString(String key, String... args) {
        if (args == null || args.length == 0) {
            return ChatColor.translateAlternateColorCodes('&', getRawString(key));
        } else {
            return ChatColor.translateAlternateColorCodes('&', String.format(getRawString(key), (Object[]) args));
        }
    }
}
