package me.oliver193.basicplugin;

import me.oliver193.basicplugin.bstats.Metrics;
import me.oliver193.basicplugin.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        int pluginId = 21341;
        Metrics metrics = new Metrics(this, pluginId);

        // Plugin startup logic
        getLogger().info("Enabling BasicPlugin.");

        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("starve").setExecutor(new StarveCommand());
        getCommand("serverinfo").setExecutor(new ServerInfoCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Disabling BasicPlugin.");

    }
}
