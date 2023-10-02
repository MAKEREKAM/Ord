package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.inventory.ItemStack

class FallDamage : Listener, Mission {
    // ID: 8

    override fun run() {
    }

    @EventHandler
    fun onDamage(e : EntityDamageEvent) {
        if (e.entity.type == EntityType.PLAYER && e.cause == EntityDamageEvent.DamageCause.FALL) {
            if (Main.nowMission == 8) {
                val player = e.entity as Player
                Main.score[player.name] = Main.score[player.name]!! + 1
                if (Main.rd.nextInt(20) == 0) {
                    Main.broadCastScore()
                }

                else {
                    Main.randomMission()
                }
            }
        }
    }
}