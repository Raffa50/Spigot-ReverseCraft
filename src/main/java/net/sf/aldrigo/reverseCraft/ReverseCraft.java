package net.sf.aldrigo.reverseCraft;

import java.util.*;

import net.sf.aldrigo.reverseCraft.commands.RvAllowCommand;
import net.sf.aldrigo.reverseCraft.commands.RvForbidCommand;
import net.sf.aldrigo.reverseCraft.commands.RvCommand;
import net.sf.aldrigo.reverseCraft.commands.RvcForbiddenCommand;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ReverseCraft extends JavaPlugin {
    public static final HashSet<Material> NotInvertible = new HashSet<Material>();
    static FileConfiguration config;

    public void onEnable() {
        config = this.getConfig();
        config.addDefault("notinvertible", new ArrayList());
        config.options().copyDefaults(true);
        this.saveConfig();
        var nonInv = config.getIntegerList("notinvertible");

        for (var e : nonInv){
            NotInvertible.add(Material.values()[e]);
        }

        this.getLogger().info("[ReverseCraft] v0.1.1 by Aldrigo R. ENABLED!");

        getCommand("rvcraft").setExecutor(new RvCommand());
        getCommand("rvcforbid").setExecutor(new RvForbidCommand());
        getCommand("rvcallow").setExecutor(new RvAllowCommand());
        getCommand("rvcforbidden").setExecutor(new RvcForbiddenCommand());
    }

    public void onDisable() {
        var nonInv = new ArrayList<Integer>();

        for(var e : NotInvertible) {
            nonInv.add(e.ordinal());
        }

        config.set("notinvertible", nonInv);
        this.saveConfig();
        this.getLogger().info("[ReverseCraft] by Aldrigo R. DISABLED!");
    }
}
