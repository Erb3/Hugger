package github.erb3.plugin.Hugger.hooks;

import github.erb3.plugin.Hugger.Main;
import github.erb3.plugin.Hugger.Utils;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class Papi extends PlaceholderExpansion {
    private final Main main;
    public Papi(Main main) {
        this.main = main;
    }

    @Override
    public @NotNull String getAuthor() {
        return "Erb3";
    }

    @Override
    public @NotNull String getIdentifier() {
        return "Hugger";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        String key = params.toLowerCase();

        switch (key) {
            case "total": {
                return Integer.toString(this.main.sm.getTotalHugs());
            }

            case "sent": {
                return Integer.toString(this.main.sm.getPlayerSent(Utils.toUUID(player.getPlayer())));
            }

            case "received": {
                return Integer.toString(this.main.sm.getPlayerReceived(Utils.toUUID(player.getPlayer())));
            }

            default: {
                return null;
            }
        }
    }
}
