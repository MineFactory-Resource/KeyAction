package net.teamuni.shiftf;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
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
    public void onPlayerSwapHandItemsEvent1(PlayerSwapHandItemsEvent event) {
        if (event.getPlayer().isSneaking()) {
            List<String> commands = getConfig().getStringList("commands");
            for (String command : commands) {
                event.getPlayer().performCommand(command);
            }
        }
    }
}