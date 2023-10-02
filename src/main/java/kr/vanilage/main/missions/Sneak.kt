package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerToggleSneakEvent

class Sneak : Listener, Mission {
    // ID: 11

    override fun run() {
    }

    @EventHandler
    fun onSneak(e : PlayerToggleSneakEvent) {
        if (Main.nowMission == 11 && e.isSneaking) {
            Main.score[e.player.name] = Main.score[e.player.name]!! + 1
            if (Main.rd.nextInt(20) == 0) {
                Main.broadCastScore()
            }

            else {
                Main.randomMission()
            }
        }
    }
}