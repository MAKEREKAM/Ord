package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerItemHeldEvent
import org.bukkit.event.player.PlayerPortalEvent
import org.bukkit.inventory.ItemStack

class NetherPortal : Listener, Mission {
    // ID: 12

    override fun run() {
        for (i in Bukkit.getOnlinePlayers()) {
            i.inventory.addItem(ItemStack(Material.OBSIDIAN, 10))
            i.inventory.addItem(ItemStack(Material.FIRE_CHARGE))
        }
    }

    @EventHandler
    fun onPortal(e : PlayerPortalEvent) {
        if (Main.nowMission == 12) {
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