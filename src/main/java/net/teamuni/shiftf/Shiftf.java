package net.teamuni.shiftf;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;


public final class Shiftf extends JavaPlugin implements Listener {

    String action = "";
    List<String> commands;

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
        this.action = getConfig().getString("action");
        this.commands = getConfig().getStringList("commands");
    }

    @EventHandler
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
        if (action.equals("SHIFT")) {
            if (event.getPlayer().isSneaking()) {
                for (String command : commands) {
                    event.getPlayer().performCommand(command);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent event) {
        event.setCancelled(true);
        if (action.equals("F")) {
            for (String command : commands) {
                event.getPlayer().performCommand(command);
            }
        } else if (action.equals("SHIFT+F")) {
            if (event.getPlayer().isSneaking()) {
                for (String command : commands) {
                    event.getPlayer().performCommand(command);
                }
            }
        }
    }
}