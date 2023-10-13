package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.inventory.ItemStack

class ShootBow : Listener, Mission {
    // ID: 26

    override fun run() {
        for (i in Bukkit.getOnlinePlayers()) {
            i.inventory.addItem(ItemStack(Material.BOW))
            i.inventory.addItem(ItemStack(Material.ARROW))
        }
    }

    @EventHandler
    fun onShoot(e : EntityShootBowEvent) {
        if (Main.nowMission == 26 && e.entity.type == EntityType.PLAYER) {
            val player = e.entity as Player
            Main.score[player.name] = Main.score[player.name]!! + 1
            if (Main.rd.nextInt(20) == 0) {
                Main.broadCastScore()
            }

            else {
                Main.randomMission()
            }
        }
    }
}