package github.erb3.plugin.Hugger.command.Hugger;

import github.erb3.plugin.Hugger.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Hugger implements CommandExecutor {
    private final Main main;

    public Hugger(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Config config = new Config(main);
        Help help = new Help();

        if (args.length == 0) {
            return help.onCommand(sender, cmd, label, args);
        }

        switch (args[0]) {
            case "config": {
                return config.onCommand(sender, cmd, label, args);
            }

            default: {
                return help.onCommand(sender, cmd, label, args);
            }
        }
    }
}
