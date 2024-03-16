package me.oliver193.basicplugin;

import me.oliver193.basicplugin.bstats.Metrics;
import me.oliver193.basicplugin.commands.FeedCommand;
import me.oliver193.basicplugin.commands.FlyCommand;
import me.oliver193.basicplugin.commands.HealCommand;
import me.oliver193.basicplugin.commands.StarveCommand;
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

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Disabling BasicPlugin.");

    }
}
