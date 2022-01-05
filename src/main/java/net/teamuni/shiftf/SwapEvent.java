package net.teamuni.shiftf;

import org.bukkit.event.inventory.InventoryClickEvent;

public class SwapEvent {
    void onSwapHandInv(InventoryClickEvent event) {
        Integer slot = event.getSlot();
    }
}