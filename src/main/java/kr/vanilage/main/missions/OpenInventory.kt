package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryOpenEvent

class OpenInventory : Listener, Mission {
    // ID: 23

    override fun run() {
    }

    @EventHandler
    fun onOpenInventory(e : InventoryOpenEvent) {
        if (Main.nowMission == 23) {
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