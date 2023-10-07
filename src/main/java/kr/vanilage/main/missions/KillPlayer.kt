package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.PlayerDeathEvent


class KillPlayer : Listener, Mission {
    // ID: 23

    override fun run() {
        val playerList = Bukkit.getOnlinePlayers().toList()
        Main.id23Target = playerList[Main.rd.nextInt(playerList.size)]
        Bukkit.broadcast(Component.text("여러분이 죽일 플레이어는 ${Main.id23Target.name}입니다.", NamedTextColor.RED))
    }

    @EventHandler
    fun onDeath(e : PlayerDeathEvent) {
        if (Main.nowMission == 23 && e.player.name == Main.id23Target.name) {
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