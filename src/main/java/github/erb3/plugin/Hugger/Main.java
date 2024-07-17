package github.erb3.plugin.Hugger;

import github.erb3.plugin.Hugger.command.Hug;
import github.erb3.plugin.Hugger.command.HugTabCompleter;
import github.erb3.plugin.Hugger.command.Hugger;
import github.erb3.plugin.Hugger.command.HuggerTabCompleter;
import github.erb3.plugin.Hugger.effects.EffectManager;
import github.erb3.plugin.Hugger.files.Configurator;
import github.erb3.plugin.Hugger.files.StatManager;
import github.erb3.plugin.Hugger.hooks.Papi;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.Random;

public class Main extends JavaPlugin {

    public final Configurator config = new Configurator(this);
    public final EffectManager effectManager =  new EffectManager(this);
    public final StatManager statManager = new StatManager(this);
    public final Random random = new Random();

    @Override
    public void onEnable() {
        this.config.createConfig();
        this.statManager.createFile();

        if (Objects.equals(this.config.getRawString("enabled"), "false")) {
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

        hugCmd.setExecutor(new Hug(this));
        hugCmd.setTabCompleter(new HugTabCompleter());
        huggerCmd.setExecutor(new Hugger(this));
        huggerCmd.setTabCompleter(new HuggerTabCompleter());

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new Papi(this).register();
        }

        new Metrics(this, 16976);
        getLogger().info("bStats enabled for Hugger. This can be disabled in the bStats config");
    }

    @Override
    public void onDisable() {
        this.statManager.save();
    }
}
