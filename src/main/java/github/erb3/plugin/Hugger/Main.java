package github.erb3.plugin.Hugger;

import github.erb3.plugin.Hugger.command.Hug;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Configurator conf = new Configurator(this);

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Enabling Hugger!");

        this.conf.createConfig();

        if (!this.conf.getBoolean("enabled")) {
            Bukkit.getLogger().warning("Hugging has been disabled in its config. You can re-enable it in plugins/hugger/config.yml");
            this.getServer().getPluginManager().disablePlugin(this);
        } else {
            PluginCommand hugCmd = this.getCommand("hug");

            if (hugCmd == null ) {
                Bukkit.getLogger().warning("/Hug not registered in plugin.yml? Please contact the mod developers. This is not supposed to happen!");
                this.getServer().getPluginManager().disablePlugin(this);
                return;
            }

            hugCmd.setExecutor(new Hug(this.conf));
        }

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabling Hugger!");

        conf.saveConfig();
    }
}
