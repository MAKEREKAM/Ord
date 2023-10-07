package kr.vanilage.main.missions

import kr.vanilage.main.Main
import kr.vanilage.main.Mission
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.enchantment.EnchantItemEvent
import org.bukkit.inventory.ItemStack


class EnchantPickaxe : Listener, Mission {
    // ID: 20

    override fun run() {
        for (i in Bukkit.getOnlinePlayers()) {
            i.inventory.addItem(ItemStack(Material.ENCHANTING_TABLE))
            i.inventory.addItem(ItemStack(Material.LAPIS_LAZULI))
            i.inventory.addItem(ItemStack(Material.DIAMOND, 3))
            i.inventory.addItem(ItemStack(Material.STICK, 2))
            i.inventory.addItem(ItemStack(Material.OAK_LOG))
            i.level = 5
        }
    }

    @EventHandler
    fun onEnchant(e : EnchantItemEvent) {
        if (Main.nowMission == 20 && e.item.type == Material.DIAMOND_PICKAXE) {
            Main.score[e.enchanter.name] = Main.score[e.enchanter.name]!! + 1
            if (Main.rd.nextInt(20) == 0) {
                Main.broadCastScore()
            }

            else {
                Main.randomMission()
            }
        }
    }
}