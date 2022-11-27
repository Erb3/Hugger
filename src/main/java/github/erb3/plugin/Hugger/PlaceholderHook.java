package github.erb3.plugin.Hugger;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class PlaceholderHook extends PlaceholderExpansion {

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
        if (params.equalsIgnoreCase("abc")) {
            return "Test";
        }

        return null;
    }
}
