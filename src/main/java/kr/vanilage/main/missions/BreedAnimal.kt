package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityBreedEvent
import org.bukkit.inventory.ItemStack

class BreedAnimal : Listener, Mission {
    // ID: 27

    override fun run() {
        for (i in Bukkit.getOnlinePlayers()) {
            i.inventory.addItem(ItemStack(Material.PIG_SPAWN_EGG, 2))
            i.inventory.addItem(ItemStack(Material.CARROT, 2))
        }
    }
    @EventHandler
    fun onBreed(e : EntityBreedEvent) {
        if (Main.nowMission == 27 && e.breeder is Player) {
            val player = e.breeder as Player
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