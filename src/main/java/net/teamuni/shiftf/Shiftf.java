package net.teamuni.shiftf;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;


public final class Shiftf extends JavaPlugin implements Listener {

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
    }

    @EventHandler
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        String action = getConfig().getString("action");
        List<String> commands = getConfig().getStringList("commands");

        if (action.equals("SHIFT")) {
            if (player.isSneaking()) {
                for (String command : commands) {
                    event.getPlayer().performCommand(command);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerSwapHandItemsEvent(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        String action = getConfig().getString("action");
        List<String> commands = getConfig().getStringList("commands");

        if (action.equals("F")) {
            String offhand = event.getPlayer().getInventory().getItemInOffHand().toString();
            if (event.getMainHandItem().toString().equals(offhand)) {
                for (String command : commands) {
                    event.getPlayer().performCommand(command);
                }
            }
        } else if (action.equals("SHIFT+F")) {
            if (player.isSneaking()) {
                for (String command : commands) {
                    event.getPlayer().performCommand(command);
                }
            }
        }
        event.setCancelled(true);
    }
}