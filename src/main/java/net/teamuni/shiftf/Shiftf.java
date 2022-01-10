package net.teamuni.shiftf;


import org.bukkit.entity.Player;
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

    private void performCommand(Player player) {
        for (String command : commands) {
            player.performCommand(command);
        }
    }

    @EventHandler
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
        if (action.equals("SHIFT") && event.isSneaking()) {
            performCommand(event.getPlayer());
        }
    }

    @EventHandler
    public void onPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent event) {
        if (action.equals("F") || action.equals("SHIFT+F") && event.getPlayer().isSneaking()) {
            event.setCancelled(true);
            performCommand(event.getPlayer());
        }
    }
}

