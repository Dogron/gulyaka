package gulyaka

val hero = Hero()

class Hero {
    val maxHP = 20
    var HP = 20
    var name = ""
    var smallHealingPotions = 3
    var weapon: Weapon = Fist()

    fun status() {
        println("Персонаж $name жив, у него $HP здоровья.")
    }

    fun heal(points: Int) {
        HP += points
        println("Вас вылечили на $points hp ")
        if (HP > maxHP) {
            HP = maxHP
        }
    }

    fun attack(monster: Monster) {
        weapon.attack(monster)
    }

    fun damage(points: Int) {
        HP -= points
        println("Вас повредили на $points HP ")
        if (HP < 0) {
            HP = 0
        }
    }

    fun drinkSmallHPPotion() {
        if (smallHealingPotions == 0) {
            println("Маленьких зелий здоровья больше нет!")
            return
        }
        smallHealingPotions -= 1
        heal(3)

    }

    fun command() : Boolean {
        while (true) {
            val command = input().toLowerCase()
            when (command) {
                "shp" -> {
                    drinkSmallHPPotion()
                    return true
                }
                "?" -> {
                    println("У вас $smallHealingPotions Маленьких зелий здоровья")
                    println("Ваше оружие $weapon")
                }
                else ->
                    return false
            }
        }
    }
}
