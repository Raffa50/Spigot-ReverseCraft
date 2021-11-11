package net.sf.aldrigo.reverseCraft;

import org.bukkit.ChatColor;

public final class Messages {
    public static final String
            CantRev = ChatColor.RED + "[ReverseCraft] Item can't be reverted!" + ChatColor.RESET,
            NoItem = ChatColor.RED + "[ReverseCraft] No Item in hand!" + ChatColor.RESET,
            Success = ChatColor.GREEN + "[ReverseCraft] Item reverted!" + ChatColor.RESET,
            BadUsage = ChatColor.RED + "[ReverseCraft] wrong usage" + ChatColor.RESET;

    private Messages(){}
}
