package net.sf.aldrigo.reverseCraft.commands;

import net.sf.aldrigo.reverseCraft.ReverseCraft;
import org.bukkit.command.*;

public class RvcForbiddenCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        var sb = new StringBuilder("[ReverseCraft] forbidden: ");

        for(var m : ReverseCraft.NotInvertible)
            sb.append(m.toString()).append(", ");

        sender.sendMessage(sb.toString());
        return true;
    }
}
