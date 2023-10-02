package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.inventory.ItemStack

class LightFire : Listener, Mission {
    // ID: 13

    override fun run() {
        for (i in Bukkit.getOnlinePlayers()) {
            i.inventory.addItem(ItemStack(Material.FLINT_AND_STEEL))
        }
    }

    @EventHandler
    fun onPlace(e : BlockPlaceEvent) {
        if (Main.nowMission == 13 && e.block.type == Material.FIRE) {
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