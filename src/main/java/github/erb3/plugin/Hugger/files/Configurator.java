package github.erb3.plugin.Hugger.files;

import github.erb3.plugin.Hugger.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.*;

public class Configurator {
    private final Main plugin;
    private FileConfiguration config;

    public Configurator(Main plugin) {
        this.plugin = plugin;
    }

    public void createConfig() {
        this.plugin.saveDefaultConfig();
        this.config = plugin.getConfig();
        this.plugin.effectManager.updateEffectList();
    }

    public void reload() {
        this.plugin.reloadConfig();
        this.config = this.plugin.getConfig();
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

    public ArrayList<HashMap<String, HashMap<String, String>>> getArray(String key) {
        ArrayList<HashMap<String, HashMap<String, String>>> list;
        Object o = this.config.get(key);

        assert o != null;
        if (o.getClass().isArray()) {
            this.plugin.getLogger().severe("Severe error loading config! The object `" + key + "` is a array, not a collection!");
            list = new ArrayList<>();
        } else if (o instanceof Collection) {
            //noinspection unchecked
            list = new ArrayList<>((Collection<HashMap<String, HashMap<String, String>>>) o);
        } else {
            this.plugin.getLogger().severe("Severe error loading config! The object `" + key + "` is not a array, nor a collection!");
            list = new ArrayList<>();
        }

        return list;
    }
}
