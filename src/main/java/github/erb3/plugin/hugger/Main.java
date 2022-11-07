package github.erb3.plugin.hugger;

import github.erb3.plugin.hugger.command.Hug;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Configurator conf = new Configurator(this);

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Enabling Hugger!");

        conf.createConfig();

        this.getCommand("hug").setExecutor(new Hug(this.conf));
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabling Hugger!");

        conf.saveConfig();
    }
}
