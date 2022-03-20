package com.planetgallium.kitpvp.command;

import com.planetgallium.kitpvp.Game;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (!Game.getInstance().getBuildPlayers().contains(player)) {
                    Game.getInstance().getBuildPlayers().add(player);
                    player.sendMessage(ChatColor.YELLOW + "Your build mode was turned " + ChatColor.GREEN + "on" + ChatColor.YELLOW + "!");
                } else {
                    Game.getInstance().getBuildPlayers().remove(player);
                    player.sendMessage(ChatColor.YELLOW + "Your build mode was turned " + ChatColor.RED + "off" + ChatColor.YELLOW + "!");
                }
            }

            if (args.length == 1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (!Game.getInstance().getBuildPlayers().contains(target)) {
                        Game.getInstance().getBuildPlayers().add(target);
                        target.sendMessage(ChatColor.YELLOW + "Your build mode was turned " + ChatColor.GREEN + "on" + ChatColor.YELLOW + "!");
                        player.sendMessage(ChatColor.YELLOW + "You have turned " + ChatColor.GREEN + "on " + ChatColor.YELLOW + target.getName() + "'s build mode!");
                    } else {
                        Game.getInstance().getBuildPlayers().remove(target);
                        target.sendMessage(ChatColor.YELLOW + "Your build mode was turned " + ChatColor.RED + "off" + ChatColor.YELLOW + "!");
                        player.sendMessage(ChatColor.YELLOW + "You have turned " + ChatColor.RED + "off " + ChatColor.YELLOW + target.getName() + "'s build mode!");
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    player.sendMessage(ChatColor.RED + "Player not found.");
                }
            }
        } else {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "Usage: /build <player>");
            }

            if (args.length == 1) {
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (!Game.getInstance().getBuildPlayers().contains(target)) {
                        Game.getInstance().getBuildPlayers().add(target);
                        target.sendMessage(ChatColor.YELLOW + "Your build mode was turned " + ChatColor.GREEN + "on" + ChatColor.YELLOW + "!");
                        sender.sendMessage(ChatColor.YELLOW + "You have turned " + ChatColor.GREEN + "on " + ChatColor.YELLOW + target.getName() + "'s build mode!");
                    } else {
                        Game.getInstance().getBuildPlayers().remove(target);
                        target.sendMessage(ChatColor.YELLOW + "Your build mode was turned " + ChatColor.RED + "off" + ChatColor.YELLOW + "!");
                        sender.sendMessage(ChatColor.YELLOW + "You have turned " + ChatColor.RED + "off " + ChatColor.YELLOW + target.getName() + "'s build mode!");
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    sender.sendMessage(ChatColor.RED + "Player not found.");
                }
            }
        }

        return true;
    }
}
