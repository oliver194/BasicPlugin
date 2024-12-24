package me.oliver193.basicplugin.commands;

import me.oliver193.basicplugin.Msg;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.lang.management.ManagementFactory;

public class ServerInfoCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        System.gc();
        Runtime rt = Runtime.getRuntime();
        long usedMB = (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
        long totalMB = (rt.totalMemory()) / 1024 / 1024;
        long maxMB = (rt.maxMemory()) / 1024 / 1024;


        // Get uptime in milliseconds
        long milliseconds = ManagementFactory.getRuntimeMXBean().getUptime();
        // formula for conversion for
        // milliseconds to minutes.
        long minutes = (milliseconds / 1000) / 60;

        // formula for conversion for
        // milliseconds to seconds
        long seconds = (milliseconds / 1000) % 60;


        Msg.send(commandSender, "&7------------= &aServer Info &7=------------");
        Msg.send(commandSender, "Server Version: " + Bukkit.getBukkitVersion());
        Msg.send(commandSender, "Software: " + Bukkit.getName());
        Msg.send(commandSender, "RAM Usage: " + usedMB + " MB" + " of " + maxMB + " MB");
        Msg.send(commandSender, "Uptime: " + minutes + " minutes and " + seconds + " seconds");

        return true;
    }
}
