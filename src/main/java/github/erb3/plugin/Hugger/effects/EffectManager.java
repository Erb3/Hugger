package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class EffectManager {
    private final Main main;
    private final HashMap<String, Effect> effectDatabase = new HashMap<>();
    private final HashMap<String, HashMap<String, String>> argumentDatabase = new HashMap<>();

    public EffectManager(Main main) {
        this.main = main;

        effectDatabase.put("chatMessage",   new ChatMessage());
        effectDatabase.put("title",         new Title());
        effectDatabase.put("actionBar",     new ActionBar());
        effectDatabase.put("broadcast",     new Broadcast(this.main));
        effectDatabase.put("sound",         new Sound(this.main));
    }

    public void updateEffectList() {
        ArrayList<HashMap<String, HashMap<String, String>>> effectsInConfig = this.main.conf.getArray("effects");
        for (HashMap<String, HashMap<String, String>> e : effectsInConfig) {
            ArrayList<String> effectTypes = new ArrayList<>(e.keySet());
            HashMap<String, String> args = e.get(effectTypes.get(0));

            String hash = Integer.toString(this.main.random.nextInt(999999999));
            String effectNameWithHash = effectTypes.get(0) + "." + hash;
            argumentDatabase.put(effectNameWithHash, args);
        }
    }

    public void runAllEffects(CommandSender from, Player to) {
        for (String rawEffectName : argumentDatabase.keySet()) {

            String effectName = rawEffectName.split("\\.")[0];

            Effect effect = effectDatabase.get(effectName);
            HashMap<String, String> args = argumentDatabase.get(rawEffectName);

            effect.runEffect(from, to, args);
        }
    }
}
