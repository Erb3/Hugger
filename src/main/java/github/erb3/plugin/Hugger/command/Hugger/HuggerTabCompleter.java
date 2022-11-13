package github.erb3.plugin.Hugger.command.Hugger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HuggerTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> arguments = new ArrayList<>();

        if (args.length == 2 && Objects.equals(args[0], "config")) {
            arguments.add("reload");
        } else if (args.length == 1){
            arguments.add("config");
            arguments.add("help");
        }

        List<String> output = new ArrayList<>();
        if (args.length >= 1) {
            for (String arg : arguments) {
                if (arg.startsWith(args[args.length - 1])) output.add(arg);
            }

            return output;
        }

        return null;
    }
}
