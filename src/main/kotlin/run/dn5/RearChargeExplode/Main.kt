package run.dn5.RearChargeExplode

import org.bukkit.entity.EntityType
import org.bukkit.entity.Villager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityBreedEvent
import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin(), Listener {
    override fun onEnable() {
        this.server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onEntityBreed(event: EntityBreedEvent){
        event.isCancelled = true

        val entity = event.entity
        val loc = entity.location

        entity.world.createExplosion(loc, 50f, true, true, entity)
    }
}