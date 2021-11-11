package net.sf.aldrigo.reverseCraft.commands;

import net.sf.aldrigo.reverseCraft.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.*;

public class RvAllowCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        if(args.length < 1){
            sender.sendMessage(Messages.BadUsage);
            return false;
        }

        try {
            var mat = Material.valueOf(args[0]);
            ReverseCraft.NotInvertible.remove(mat);
        }catch(Exception ex){
            sender.sendMessage(ChatColor.RED+"[ReverseCraft] Invalid material"+ChatColor.RESET);
            return false;
        }

        sender.sendMessage(ChatColor.YELLOW+"[ReverseCraft] Item allowed!"+ChatColor.RESET);
        return true;
    }
}
