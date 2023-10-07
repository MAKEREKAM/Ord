package kr.vanilage.main

import kr.vanilage.main.missions.*
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.title.Title
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.time.Duration
import java.util.Random

class Main : JavaPlugin() {
    companion object {
        lateinit var instance : Main
        val score : HashMap<String, Int> = HashMap()
        val missions : HashMap<Int, Mission> = HashMap()
        val missionName : HashMap<Int, String> = HashMap()
        var nowMission = -1
        val rd = Random()

        fun broadCastScore() {
            var maxScore = 0
            var maxPlayer = ""
            for (i in score) {
                if (i.value > maxScore) {
                    maxScore = i.value
                    maxPlayer = i.key
                }

                Bukkit.broadcastMessage(String.format("%s : %d점", i.key, i.value))
            }

            Bukkit.broadcastMessage(String.format("%s 우승", maxPlayer))

            score.clear()
            nowMission = -1
        }

        fun randomMission() {
            nowMission = rd.nextInt(missions.size)
            for (i in Bukkit.getOnlinePlayers()) {
                i.showTitle(Title.title(Component.text(missionName[nowMission]!!, NamedTextColor.RED), Component.text("최대한 빨리 미션을 수행하세요!", NamedTextColor.YELLOW), Title.Times.times(Duration.ofMillis(100), Duration.ofMillis(1000), Duration.ofMillis(100))))
                if (!score.keys.contains(i.name)) {
                    score[i.name] = 0
                }
            }
            missions[nowMission]!!.run()
        }

        lateinit var id23Target : Player
    }

    override fun onEnable() {
        instance = this
        Bukkit.getConsoleSender().sendMessage("Hello, World!")

        Bukkit.getPluginManager().registerEvents(BreakBlock(), this)
        Bukkit.getPluginManager().registerEvents(CraftItem(), this)
        Bukkit.getPluginManager().registerEvents(Death(), this)
        Bukkit.getPluginManager().registerEvents(EatBread(), this)
        Bukkit.getPluginManager().registerEvents(Enchant(), this)
        Bukkit.getPluginManager().registerEvents(FallDamage(), this)
        Bukkit.getPluginManager().registerEvents(HeldItem(), this)
        Bukkit.getPluginManager().registerEvents(ItemDrop(), this)
        Bukkit.getPluginManager().registerEvents(KillOtherPlayer(), this)
        Bukkit.getPluginManager().registerEvents(LightFire(), this)
        Bukkit.getPluginManager().registerEvents(NetherPortal(), this)
        Bukkit.getPluginManager().registerEvents(PlaceBlock(), this)
        Bukkit.getPluginManager().registerEvents(PlaceTorch(), this)
        Bukkit.getPluginManager().registerEvents(PressButton(), this)
        Bukkit.getPluginManager().registerEvents(PullLever(), this)
        Bukkit.getPluginManager().registerEvents(RideBoat(), this)
        Bukkit.getPluginManager().registerEvents(Shear(), this)
        Bukkit.getPluginManager().registerEvents(Sneak(), this)
        Bukkit.getPluginManager().registerEvents(UseDye(), this)
        Bukkit.getPluginManager().registerEvents(WriteSign(), this)

        // 10/07/2023 업데이트

        Bukkit.getPluginManager().registerEvents(Chat(), this)
        Bukkit.getPluginManager().registerEvents(EnchantPickaxe(), this)
        Bukkit.getPluginManager().registerEvents(EnchantSword(), this)
        Bukkit.getPluginManager().registerEvents(KillPlayer(), this)
        Bukkit.getPluginManager().registerEvents(MakeSnowGolem(), this)

        registerMission(EatBread(), 0, "빵을 먹으세요!")
        registerMission(PlaceBlock(), 1, "블럭을 설치하세요!")
        registerMission(HeldItem(), 2, "아이템을 드세요!")
        registerMission(BreakBlock(), 3, "블럭을 부수세요!")
        registerMission(ItemDrop(), 4, "아이템을 버리세요!")
        registerMission(CraftItem(), 5, "제작대를 만드세요!")
        registerMission(PressButton(), 6, "버튼을 누르세요!")
        registerMission(PullLever(), 7, "레버를 당기세요!")
        registerMission(FallDamage(), 8, "낙하 데미지를 받으세요!")
        registerMission(RideBoat(), 9, "보트에 타세요!")
        registerMission(KillOtherPlayer(), 10, "다른 플레이어를 죽이세요!")
        registerMission(Sneak(), 11, "웅크리기를 하세요!")
        registerMission(NetherPortal(), 12, "네더 포탈을 통과하세요!")
        registerMission(LightFire(), 13, "불을 피우세요!")
        registerMission(Death(), 14, "죽으세요!")
        registerMission(WriteSign(), 15, "표지판에 'asdf'이라고 적으세요!")
        registerMission(Enchant(), 16, "마법 부여대를 사용하세요!")
        registerMission(PlaceTorch(), 17, "횃불을 설치하세요!")
        registerMission(UseDye(), 18, "양을 염색하세요!")
        registerMission(Shear(), 19, "양털을 깎으세요!")

        // 10/07/2023 업데이트

        registerMission(Chat(), 24, "채팅하세요!")
        registerMission(EnchantPickaxe(), 20, "곡괭이에 마법을 부여하세요!")
        registerMission(EnchantSword(), 21, "검에 마법을 부여하세요!")
        registerMission(KillPlayer(), 23, "채팅에 나오는 플레이어를 죽이세요!")
        registerMission(MakeSnowGolem(), 22, "눈 골렘을 만드세요!")
    }

    fun registerMission(mission : Mission, id : Int, name : String) {
        missions[id] = mission
        missionName[id] = name
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender.isOp && command.name == "gamestart") {
            randomMission()
        }
        return false
    }
}