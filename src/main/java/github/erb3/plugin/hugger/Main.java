package github.erb3.plugin.hugger;

import github.erb3.plugin.hugger.command.Hug;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Configurator conf = new Configurator(this);

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Enabling Hugger!");

        this.conf.createConfig();

        if (!this.conf.getBoolean("enabled")) {
            Bukkit.getLogger().info("Hugging has been disabled in its config. You can re-enable it in plugins/hugger/config.yml");
            this.getServer().getPluginManager().disablePlugin(this);
        } else {
            this.getCommand("hug").setExecutor(new Hug(this.conf));
        }

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabling Hugger!");

        conf.saveConfig();
    }
}
