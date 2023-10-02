package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.PlayerDeathEvent


class KillOtherPlayer : Listener, Mission {
    // ID: 10

    override fun run() {
    }

    @EventHandler
    fun onDeath(e : PlayerDeathEvent) {
        if (Main.nowMission == 10) {
            val entityDamageEvent = e.player.lastDamageCause!!
            if (!entityDamageEvent.isCancelled && entityDamageEvent is EntityDamageByEntityEvent) {
                val damager = entityDamageEvent.damager

                if (damager is Player) {
                    val player = damager as Player

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
}