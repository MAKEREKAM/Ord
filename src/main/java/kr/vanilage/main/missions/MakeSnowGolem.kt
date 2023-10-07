package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.inventory.ItemStack


class MakeSnowGolem : Listener, Mission {
    // ID: 22

    override fun run() {
        for (i in Bukkit.getOnlinePlayers()) {
            i.inventory.addItem(ItemStack(Material.SNOW_BLOCK, 2))
            i.inventory.addItem(ItemStack(Material.CARVED_PUMPKIN))
        }
    }

    @EventHandler
    fun onPlace(e : BlockPlaceEvent) {
        if (Main.nowMission == 22 && e.block.type == Material.CARVED_PUMPKIN) {
            if (e.block.location.subtract(0.0, 1.0, 0.0).block.type == Material.SNOW_BLOCK && e.block.location.subtract(0.0, 2.0, 0.0).block.type == Material.SNOW_BLOCK) {
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