package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.SignChangeEvent
import org.bukkit.inventory.ItemStack


class WriteSign : Listener, Mission {
    // ID: 15

    override fun run() {
        for (i in Bukkit.getOnlinePlayers()) {
            i.inventory.addItem(ItemStack(Material.OAK_SIGN))
        }
    }

    @EventHandler
    fun onWriteSign(e : SignChangeEvent) {
        if (Main.nowMission == 15) {
            for (i in e.lines) {
                if (i.contains("메이커찬양")) {
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
    }
}