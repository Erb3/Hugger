package github.erb3.plugin.Hugger.effects;

import github.erb3.plugin.Hugger.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class EffectManager {
    private final Main main;
    private final ArrayList<Effect> allPossibleEffects = new ArrayList<>();
    private final ArrayList<Effect> effectList = new ArrayList<>();

    public EffectManager(Main main) {
        this.main = main;

        allPossibleEffects.add(new ChatMessage(main));
        allPossibleEffects.add(new ActionBar(main));
    }

    public void updateEffectList() {

        effectList.clear();

        for (Effect e : allPossibleEffects) {
            String name = e.getName();

            if (main.conf.exists("effects." + name + ".enabled")) {
                effectList.add(e);
            }
        }
    }

    public void runAllEffects(CommandSender from, Player to) {
        for (Effect e : effectList) {
            e.runEffect(from, to);
        }
    }
}
