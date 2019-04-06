package blue.feelingso.khaos

import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class Khaos : JavaPlugin() {
    val playerConfig = KhaosPlayerConfig(File(dataFolder, "player.yml"))
    var khaosConfig = KhaosConfig(config)

    override fun onEnable() {
        saveDefaultConfig()
        server.pluginManager.registerEvents(KhaosListener(this), this)
        getCommand("khaos").executor = KhaosCommandExecutor(this)
    }

    override fun onDisable() {
    }

    override fun reloadConfig() {
        super.reloadConfig()
        khaosConfig = KhaosConfig(config)
    }
}
