package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.ItemStack

class ClickChestInventory : Listener, Mission {
    // ID: 25

    override fun run() {
        for (i in Bukkit.getOnlinePlayers()) {
            i.inventory.addItem(ItemStack(Material.OAK_LOG, 3))
        }
    }

    @EventHandler
    fun onClick(e : InventoryClickEvent) {
        if (Main.nowMission == 25 && e.inventory.type == InventoryType.CHEST) {
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