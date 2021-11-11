package net.sf.aldrigo.reverseCraft.commands;

import net.sf.aldrigo.reverseCraft.Messages;
import net.sf.aldrigo.reverseCraft.ReverseCraft;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.*;

public class RvForbidCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        if(args.length < 1){
            sender.sendMessage(Messages.BadUsage);
            return false;
        }

        try {
            var mat = Material.valueOf(args[0]);
            ReverseCraft.NotInvertible.add(mat);
        }catch(Exception ex){
            sender.sendMessage(ChatColor.RED+"[ReverseCraft] Invalid material"+ChatColor.RESET);
            return false;
        }
        sender.sendMessage(ChatColor.YELLOW+"[ReverseCraft] Item forbidden!"+ChatColor.RESET);
        return true;
    }
}
