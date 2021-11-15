package dev.siro256.spigotpl.floatingguide

import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Logger

class FloatingGuide: JavaPlugin() {
    init {
        instance = this
        Companion.logger = logger
    }

    override fun onEnable() {
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
    }
}
