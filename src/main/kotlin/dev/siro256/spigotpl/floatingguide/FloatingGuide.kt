package dev.siro256.spigotpl.floatingguide

import dev.siro256.spigotpl.floatingguide.command.TestCommand
import dev.siro256.spigotpl.floatingguide.command.WandCommand
import dev.siro256.spigotpl.floatingguide.listener.WandListener
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Logger

class FloatingGuide: JavaPlugin() {
    init {
        instance = this
        Companion.logger = logger
    }

    override fun onEnable() {
        //Register event listeners
        listOf(
            WandListener
        ).forEach { server.pluginManager.registerEvents(it, this) }

        //Register commands
        mapOf(
            "test" to TestCommand,
            "wand" to WandCommand
        ).forEach { (command, executor) -> getCommand(command)?.setExecutor(executor) }

        logger.info("Enabled.")
    }

    override fun onDisable() {
        logger.info("Disabled.")
    }

    companion object {
        lateinit var instance: JavaPlugin
            private set

        lateinit var logger: Logger
            private set

        val wandPosition = mutableMapOf<Player, Pair<Location?, Location?>>()
    }
}
