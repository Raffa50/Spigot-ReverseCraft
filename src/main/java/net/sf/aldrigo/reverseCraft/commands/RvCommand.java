package net.sf.aldrigo.reverseCraft.commands;

import net.sf.aldrigo.reverseCraft.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

public class RvCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be run by a player.");
            return false;
        }

        var player = (Player)sender;
        var item = player.getInventory().getItemInMainHand();
        if (item.getType() == Material.AIR) {
            player.sendMessage(Messages.NoItem);
            return false;
        }

        var recipes = Bukkit.getServer().getRecipesFor(item);
        if(recipes.isEmpty() || ReverseCraft.NotInvertible.contains(item.getType())){
            player.sendMessage(Messages.CantRev);
            return false;
        }

        for(var r : recipes) {
            int required = r.getResult().getAmount();
            if (item.getAmount() < required)
                continue;

            if (r instanceof ShapelessRecipe) {
                var rec = (ShapelessRecipe) r;

                for (var in : rec.getIngredientList()) {
                    var back = new ItemStack(in.getType(), in.getAmount());
                    player.getInventory().addItem(back);
                }
            } else if (r instanceof ShapedRecipe) {
                var rec = (ShapedRecipe) r;

                for (var in : rec.getIngredientMap().values()) {
                    if (in.getType() != Material.AIR) {
                        var back = new ItemStack(in.getType(), in.getAmount());
                        player.getInventory().addItem(back);
                    }
                }
            }

            if (item.getAmount() == 1) {
                player.getInventory().remove(item);
            } else {
                item.setAmount(item.getAmount() - required);
            }

            player.sendMessage(Messages.Success);
            return true;
        }
        return false;
    }
}
