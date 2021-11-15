package dev.siro256.spigotpl.floatingguide.listener

import dev.siro256.spigotpl.floatingguide.FloatingGuide
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent

object WandListener: Listener {
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        if (event.material != Material.WOODEN_AXE) return
        if (CraftItemStack.asNMSCopy(event.item).tag!!.get("IsFgWand") == null) return

        event.isCancelled = true

        var wandPosition = if (FloatingGuide.wandPosition.containsKey(event.player))
            FloatingGuide.wandPosition[event.player] else null to null

        if (event.action == Action.LEFT_CLICK_BLOCK) {
            wandPosition = wandPosition!!.copy(first = event.clickedBlock!!.location)
            event.player.sendMessage("${ChatColor.LIGHT_PURPLE}First position set to " +
                    "(${event.clickedBlock!!.location.blockX}, ${event.clickedBlock!!.location.blockY}, " +
                    "${event.clickedBlock!!.location.blockZ}).")
        } else if (event.action == Action.RIGHT_CLICK_BLOCK) {
            wandPosition = wandPosition!!.copy(second = event.clickedBlock!!.location)
            event.player.sendMessage("${ChatColor.LIGHT_PURPLE}Second position set to " +
                    "(${event.clickedBlock!!.location.blockX}, ${event.clickedBlock!!.location.blockY}, " +
                    "${event.clickedBlock!!.location.blockZ}).")
        }

        FloatingGuide.wandPosition[event.player] = wandPosition!!
    }
}
