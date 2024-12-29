package me.oliver193.basicplugin.commands;

import me.oliver193.basicplugin.Msg;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class RepairCommand implements CommandExecutor, TabCompleter {

    // Command execution logic
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] strings) {
        if (!(commandSender instanceof Player)) {
            Msg.send(commandSender, "&4Only players can use this command!");
            return true;
        }

        Player player = (Player) commandSender;

        // Check permissions
        if (!player.hasPermission("plugin.repair")) {
            Msg.send(commandSender,"&4You don't have permission to use this command!");
            return true;
        }

        if (strings.length == 0 || (!strings[0].equalsIgnoreCase("hand") && !strings[0].equalsIgnoreCase("all"))) {
            Msg.send(commandSender, "&eUsage: /repair <hand|all>");
            return true;
        }

        if (strings[0].equalsIgnoreCase("hand")) {
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            if (itemInHand == null || itemInHand.getType() == Material.AIR || itemInHand.getType().getMaxDurability() == 0) {
                Msg.send(commandSender,"&4You must hold a repairable item in your main hand!");
                return true;
            }

            itemInHand.setDurability((short) 0); // Repair the item
            Msg.send(commandSender,"&aThe item in your hand has been repaired!");
            return true;
        }

        if (strings[0].equalsIgnoreCase("all")) {
            boolean repaired = false;
            for (ItemStack item : player.getInventory().getContents()) {
                if (item != null && item.getType().getMaxDurability() > 0) {
                    item.setDurability((short) 0); // Repair the item
                    repaired = true;
                }
            }

            if (repaired) {
                Msg.send(commandSender,"&aAll repairable items in your inventory have been repaired!");
            } else {
                Msg.send(commandSender,"&4No repairable items were found in your inventory!");
            }

            return true;
        }

        return true;
    }

    // Tab completion logic
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] strings) {
        List<String> suggestions = new ArrayList<>();

        if (strings.length == 1) {
            if ("hand".startsWith(strings[0].toLowerCase())) {
                suggestions.add("hand");
            }
            if ("all".startsWith(strings[0].toLowerCase())) {
                suggestions.add("all");
            }
        }

        return suggestions;
    }
}
