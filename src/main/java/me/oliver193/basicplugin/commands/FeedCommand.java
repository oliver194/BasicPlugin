package me.oliver193.basicplugin.commands;

import me.oliver193.basicplugin.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            Msg.send(commandSender, "&cThis command can only be used by players.");
            return true;
        }

        Player player = (Player) commandSender;
        player.setFoodLevel(20);
        player.setSaturation(8);
        Msg.send(commandSender, "&aYou are no longer hungry!");
        return true;
    }
}
