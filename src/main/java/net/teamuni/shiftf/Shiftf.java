package net.teamuni.shiftf;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
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

    @EventHandler(
            priority = EventPriority.NORMAL
    )
    public void onPlayerToggleSneakEvent(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        List<String> action = getConfig().getStringList("action");

        if (action.contains("SHIFT")) {
            if (player.isSneaking()) {
                List<String> commands = getConfig().getStringList("commands");
                for (String command : commands) {
                    event.getPlayer().performCommand(command);
                }
            }
        }
    }

    public void onPlayerSwapHandItemsEvent1(PlayerSwapHandItemsEvent event) {
        List<String> action = getConfig().getStringList("action");
        if (action.contains("F")) {
            if () {
                List<String> commands = getConfig().getStringList("commands");
                for (String command : commands) {
                    event.getPlayer().performCommand(command);
                }
            }
        }
    }

    public void onPlayerSwapHandItemsEvent2(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        List<String> action = getConfig().getStringList("action");
        if (action.contains("SHIFT+F")) {
            if (player.isSneaking()) {
                List<String> commands = getConfig().getStringList("commands");
                for (String command : commands) {
                    event.getPlayer().performCommand(command);
                }
            }
        }
    }
}