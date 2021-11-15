package dev.siro256.spigotpl.floatingguide.command

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object WandCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("This command can't execute on console.")
            return true
        }

        sender.inventory.addItem(
            CraftItemStack.asBukkitCopy(
                CraftItemStack.asNMSCopy(ItemStack(Material.WOODEN_AXE)).apply {
                    tag!!.setBoolean("IsFgWand", true)
                }
            )
        )
        sender.sendMessage("${ChatColor.LIGHT_PURPLE}Left click: select pos #1; Right click: select pos #2")
        return true
    }

}
