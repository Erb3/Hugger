package github.erb3.plugin.Hugger;

import github.erb3.plugin.Hugger.command.Hug;
import github.erb3.plugin.Hugger.command.Hugger.Hugger;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    public Configurator conf = new Configurator(this);

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Enabling Hugger!");

        this.conf.createConfig();

        if (Objects.equals(this.conf.getRawString("enabled"), "false")) {
            Bukkit.getLogger().warning("Hugger has been disabled in its config. You can re-enable it in plugins/hugger/config.yml");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        PluginCommand hugCmd = this.getCommand("hug");
        PluginCommand huggerCmd = this.getCommand("hugger");

        if (hugCmd == null || huggerCmd == null) {
            Bukkit.getLogger().warning("/Hug or /Hugger not registered in plugin.yml? Please contact the plugin developer. This is not supposed to happen at all!");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        hugCmd.setExecutor(new Hug(this.conf));
        huggerCmd.setExecutor(new Hugger(this));

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabling Hugger!");
    }
}
