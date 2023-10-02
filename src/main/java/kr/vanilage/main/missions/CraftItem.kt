package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.CraftItemEvent
import org.bukkit.inventory.ItemStack

class CraftItem : Listener, Mission {
    // ID: 5

    override fun run() {
        for (i in Bukkit.getOnlinePlayers()) {
            i.inventory.addItem(ItemStack(Material.OAK_LOG, 1))
        }
    }

    @EventHandler
    fun onCraft(e : CraftItemEvent) {
        if (Main.nowMission == 5 && e.currentItem!!.type == Material.CRAFTING_TABLE) {
            Main.score[e.whoClicked.name] = Main.score[e.whoClicked.name]!! + 1
            if (Main.rd.nextInt(20) == 0) {
                Main.broadCastScore()
            }

            else {
                Main.randomMission()
            }
        }
    }
}