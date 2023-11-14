package kr.vanilage.main.missions

import com.destroystokyo.paper.event.player.PlayerJumpEvent
import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class Jump : Listener, Mission {
    // ID: 28

    override fun run() {
    }

    @EventHandler
    fun onJump(e : PlayerJumpEvent) {
        if (Main.nowMission == 28) {
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