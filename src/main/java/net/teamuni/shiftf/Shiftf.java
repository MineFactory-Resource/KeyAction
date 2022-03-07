package net.teamuni.shiftf;

import me.clip.placeholderapi.PlaceholderAPI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.stream.Collectors;


public final class Shiftf extends JavaPlugin implements Listener {

    String action = "";
    List<String> commands;
    List<String> playerCommands;
    List<String> consoleCommands;
    List<String> opCommands;

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
        this.action = getConfig().getString("action");
        this.commands = getConfig().getStringList("command");
        this.playerCommands = commands.stream()
                .filter(p -> p.trim().contains("[PLAYER]"))
                .collect(Collectors.toList());
        this.consoleCommands = commands.stream()
                .filter(c -> c.trim().contains("[CONSOLE]"))
                .collect(Collectors.toList());
        this.opCommands = commands.stream()
                .filter(o -> o.trim().contains("[OP]"))
                .collect(Collectors.toList());
    }

    private void performPlayerCommand(Player player) {
        for (String playerCommand : playerCommands) {
            if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                player.performCommand(PlaceholderAPI.setPlaceholders(player, playerCommand).substring(9));
            } else {
                player.performCommand(playerCommand.substring(9));
            }
        }
    }

    private void performConsoleCommand(Player player) {
        for (String consoleCommand : consoleCommands) {
            if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), PlaceholderAPI.setPlaceholders(player, consoleCommand).substring(10));
            } else {
                Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), consoleCommand.substring(10));
            }
        }
    }

    private void performOpCommand(Player player) {
        for (String opCommand : opCommands) {
            if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                if (player.isOp()) {
                    player.performCommand(PlaceholderAPI.setPlaceholders(player, opCommand).substring(5));
                } else {
                    try {
                        player.setOp(true);
                        player.performCommand(PlaceholderAPI.setPlaceholders(player, opCommand).substring(5));
                    } finally {
                        player.setOp(false);
                    }
                }
            } else {
                if (player.isOp()) {
                    player.performCommand(opCommand.substring(5));
                } else {
                    try {
                        player.setOp(true);
                        player.performCommand(opCommand.substring(5));
                    } finally {
                        player.setOp(false);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
        if (action.equals("SHIFT") && event.isSneaking()) {
            performPlayerCommand(event.getPlayer());
            performConsoleCommand(event.getPlayer());
            performOpCommand(event.getPlayer());
        }
    }

    @EventHandler
    public void onPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent event) {
        if (action.equals("F") || action.equals("SHIFT+F") && event.getPlayer().isSneaking()) {
            event.setCancelled(true);
            performPlayerCommand(event.getPlayer());
            performConsoleCommand(event.getPlayer());
            performOpCommand(event.getPlayer());
        }
    }
}
