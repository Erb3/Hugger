package github.erb3.plugin.hugger;

import github.erb3.plugin.hugger.command.Hug;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Enabling Hugger!");
        this.getCommand("hug").setExecutor(new Hug());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabling Hugger!");
    }
}
