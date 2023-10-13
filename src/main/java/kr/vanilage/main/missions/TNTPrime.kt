package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

class TNTPrime : Listener, Mission {
    // ID: 24

    override fun run() {
        for (i in Bukkit.getOnlinePlayers()) {
            i.inventory.addItem(ItemStack(Material.FLINT_AND_STEEL))
            i.inventory.addItem(ItemStack(Material.TNT))
        }
    }

    @EventHandler
    fun onInteract(e : PlayerInteractEvent) {
        if (Main.nowMission == 24 && e.action == Action.RIGHT_CLICK_BLOCK && e.clickedBlock!!.type == Material.TNT && e.player.inventory.itemInMainHand.type == Material.FLINT_AND_STEEL) {
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