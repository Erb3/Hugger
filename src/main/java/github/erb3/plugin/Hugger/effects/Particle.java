package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Particle implements Effect{
    private final Main main;
    public Particle(Main main) {
        this.main = main;
    }


    @Override
    public void runEffect(CommandSender from, Player to, HashMap<String, String> args) {
        try {
            org.bukkit.Particle particle = org.bukkit.Particle.valueOf(args.get("type"));

            if (from instanceof Player) {
                spawnParticle((Player) from, particle);
            }

            spawnParticle(to, particle);
        } catch (IllegalArgumentException e) {
            this.main.getLogger().severe("Could not understand particle-type: " + args.get("type"));
        }
    }

    private static void spawnParticle(Player p, org.bukkit.Particle particle) {
        p.spawnParticle(particle, p.getLocation(), 25, 1, 1, 1, 5);
    }
}
