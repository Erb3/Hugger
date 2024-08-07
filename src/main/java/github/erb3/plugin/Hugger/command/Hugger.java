package github.erb3.plugin.Hugger.command;

import github.erb3.plugin.Hugger.Main;
import github.erb3.plugin.Hugger.Utils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Hugger implements CommandExecutor {
    private final Main main;

    public Hugger(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, String[] args) {
        if (args.length == 0) {
            helpCommand(sender);
            return true;
        }

        switch (args[0]) {
            case "config": {
                configCommand(sender, args);
                break;
            }

            case "player": {
                playerCommand(sender, args);
                break;
            }

            case "record": {
                recordCommand(sender);
                break;
            }

            default: {
                helpCommand(sender);
                break;
            }
        }

        return true;
    }

    public void configCommand(CommandSender sender, String[] args) {
        if (!sender.hasPermission("hugger.config")) {
            sender.sendMessage(this.main.config.getFormattedString("translation.permissionDenied", "hugger.config"));
            return;
        }

        if (args.length < 2) {
            sender.sendMessage(this.main.config.getFormattedString("translation.incorrectUsage"));
            return;
        }

        switch (args[1]) {
            case "reload": {
                this.main.config.reload();
                sender.sendMessage(this.main.config.getFormattedString("translation.configReloaded"));
                break;
            }

            // Only for debugging purposes
            case "get": {
                if (args.length != 3) {
                    sender.sendMessage(this.main.config.getFormattedString("translation.incorrectUsage"));
                    return;
                }

                sender.sendMessage(this.main.config.getRawString(args[2]));
                break;
            }

            default: {
                helpCommand(sender);
            }
        }

    }

    public void helpCommand(CommandSender sender) {
        TextComponent hugPlayer = new TextComponent(ChatColor.translateAlternateColorCodes('&', "\n  &3>> &7/hug &d[player]"));
        TextComponent configReload = new TextComponent(ChatColor.translateAlternateColorCodes('&', "\n  &3>> &7/hugger config reload"));
        TextComponent help = new TextComponent(ChatColor.translateAlternateColorCodes('&', "\n  &3>> &7/hugger help\n "));

        hugPlayer.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/hug "));
        configReload.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/hugger config reload"));
        help.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/hugger help"));

        HoverEvent tabCompletion = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click for autocompletion"));
        hugPlayer.setHoverEvent(tabCompletion);
        configReload.setHoverEvent(tabCompletion);
        help.setHoverEvent(tabCompletion);

        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "\n        &8<< &3Hugger &7by &6Erb3/PC_Cat & Contributors &8>>"));
        sender.spigot().sendMessage(hugPlayer, configReload, help);

    }

    public void playerCommand(CommandSender sender, String[] args) {
        if (args.length == 1) {
            if (!sender.hasPermission("hugger.player")) {
                sender.sendMessage(this.main.config.getFormattedString("translation.permissionDenied", "hugger.player"));
                return;
            }
            printStats(sender, sender);
            return;
        }

        Player wantedPlayer = Bukkit.getPlayer(args[1]);
        if (wantedPlayer == null) {
            sender.sendMessage(this.main.config.getFormattedString("translation.playerNotFoundError"));
            return;
        }

        if (!sender.hasPermission("hugger.player.others") && !Utils.toUUID(wantedPlayer).equals(Utils.toUUID(sender))) {
            sender.sendMessage(this.main.config.getFormattedString("translation.permissionDenied", "hugger.player.others"));
            return;
        }

        printStats(sender, wantedPlayer);
    }

    private void printStats(CommandSender self, CommandSender wanted) {

        String name = Utils.toUUID(wanted);
        String sent = Integer.toString(this.main.statManager.getPlayerSent(name));
        String received = Integer.toString(this.main.statManager.getPlayerReceived(name));

        self.sendMessage(this.main.config.getFormattedString("translation.playerStatsHeader", wanted.getName()));
        self.sendMessage(this.main.config.getFormattedString("translation.hugsSentStat", sent));
        self.sendMessage(this.main.config.getFormattedString("translation.hugsReceivedStat", received));
    }

    public void recordCommand(CommandSender sender) {

        if (!sender.hasPermission("hugger.record")) {
            sender.sendMessage(this.main.config.getFormattedString("translation.permissionDenied", "hugger.record"));
            return;
        }

        Player recordHolder = Bukkit.getPlayer(this.main.statManager.getRecordHolder());
        String recordHolderName;

        if (recordHolder == null) {
            recordHolderName = this.main.statManager.getRecordHolder();
        } else {
            recordHolderName = recordHolder.getDisplayName();
        }

        sender.sendMessage(this.main.config.getFormattedString("translation.recordInfoTitle"));
        sender.sendMessage(this.main.config.getFormattedString("translation.recordInfo", recordHolderName,
                Integer.toString(this.main.statManager.getRecord())));
    }
}
