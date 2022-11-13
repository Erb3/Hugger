package github.erb3.plugin.Hugger.command.Hugger;

import github.erb3.plugin.Hugger.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Config implements Subcommand {
    private final Main main;
    public Config(Main main) {
        this.main = main;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("Not enough arguments!");
            return true;
        }

        switch (args[1]) {
            case "reload": {
                this.main.conf.reload();
                sender.sendMessage(this.main.conf.getFormattedString("translation.configReloaded"));
                break;
            }

            // Only for debugging purposes
            case "get": {
                if (args.length != 3) {
                    sender.sendMessage("Not right amount of arguments!");
                    return true;
                }

                sender.sendMessage(this.main.conf.getRawString(args[2]));
                break;
            }
        }

        return true;
    }
}
