package me.oliver193.basicplugin.commands;

import me.oliver193.basicplugin.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StarveCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            Msg.send(commandSender, "&cThis command can only be used by players.");
            return true;
        }

        Player player = (Player) commandSender;
        player.setFoodLevel(0);
        player.setSaturation(0);
        Msg.send(commandSender, "&aYou are now starving!");
        return true;
    }
}
