package net.teamuni.shiftf;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Shiftf extends JavaPlugin implements Listener {
    private static Shiftf instance;

    public void onEnable() {
        instance = this;
        this.getDataFolder().mkdir();
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
    }

    public static Shiftf getInstance() {
        return instance;
    }

    @EventHandler(
            priority = EventPriority.NORMAL
    )
    public void onPlayerSwapHandItemsEvent1(PlayerSwapHandItemsEvent event) {
        if (event.getPlayer().isSneaking()) {
            event.getPlayer().performCommand(String.valueOf(getInstance().getConfig().get("command")));
        }
    }
}
