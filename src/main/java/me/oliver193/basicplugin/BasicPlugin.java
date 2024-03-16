package me.oliver193.basicplugin;

import me.oliver193.basicplugin.commands.FeedCommand;
import me.oliver193.basicplugin.commands.FlyCommand;
import me.oliver193.basicplugin.commands.HealCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Enabling BasicPlugin.");

        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("heal").setExecutor(new HealCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Disabling BasicPlugin.");

    }
}
