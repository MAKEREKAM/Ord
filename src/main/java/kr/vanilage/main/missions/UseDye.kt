package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.SheepDyeWoolEvent
import org.bukkit.inventory.ItemStack

class UseDye : Listener, Mission {
    // ID: 18

    override fun run() {
        for (i in Bukkit.getOnlinePlayers()) {
            i.inventory.addItem(ItemStack(Material.SHEEP_SPAWN_EGG))
            i.inventory.addItem(ItemStack(Material.RED_DYE))
        }
    }

    @EventHandler
    fun onUseDye(e : SheepDyeWoolEvent) {
        if (Main.nowMission == 18) {
            Main.score[e.player!!.name] = Main.score[e.player!!.name]!! + 1
            if (Main.rd.nextInt(20) == 0) {
                Main.broadCastScore()
            }

            else {
                Main.randomMission()
            }
        }
    }
}