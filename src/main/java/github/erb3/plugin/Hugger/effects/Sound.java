package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Sound implements Effect {
    private final Main main;
    public Sound(Main main) {
        this.main = main;
    }

    @Override
    public void runEffect(CommandSender from, Player to, HashMap<String, String> args) {
        try {
            org.bukkit.Sound s = org.bukkit.Sound.valueOf(args.get("sound"));

            if (from instanceof Player) {
                playSound((Player) from, s);
            }

            playSound(to, s);
        } catch (IllegalArgumentException e) {
            this.main.getLogger().severe("Could not understand sound: " + args.get("sound"));
        }
    }

    private static void playSound(Player p, org.bukkit.Sound sound) {
        p.playSound(p.getLocation(), sound, 1f, 1f);
    }
}
