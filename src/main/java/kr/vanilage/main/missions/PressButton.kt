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

class PressButton : Listener, Mission {
    // ID: 6

    override fun run() {
        for (i in Bukkit.getOnlinePlayers()) {
            i.inventory.addItem(ItemStack(Material.OAK_BUTTON))
        }
    }

    @EventHandler
    fun onInteract(e : PlayerInteractEvent) {
        if (Main.nowMission == 6 && e.action == Action.RIGHT_CLICK_BLOCK && e.clickedBlock!!.type == Material.OAK_BUTTON) {
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