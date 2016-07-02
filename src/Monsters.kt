package gulyaka

class MonsterType(val name: String, val initialHP: Int, val maxDamage: Int) {
    fun createMonster() : Monster {
        return Monster(name, initialHP, maxDamage)
    }
}

class Monster(val name: String, var HP: Int, val maxDamage: Int) {
    fun damage(points: Int) {
        HP -= points
        println("Вы ударили на $points HP")
        if (HP < 0) {
            HP = 0
        }
    }

    fun attack() {
        damage(random.nextInt(maxDamage) + 1)
    }
}

val monsterTypes = arrayOf(
        MonsterType("Гоблин", 5, 4),
        MonsterType("Разбойник", 3, 10)
)

fun Monster() {
    val monsterType = monsterTypes[random.nextInt(monsterTypes.size)]
    val monster = monsterType.createMonster()

    println("Вы встретили ${monster.name}.")
    while (true) {
        println("У ${monster.name} ${monster.HP} HP")
        attack(monster)
        if (monster.HP == 0) {
            println("${monster.name} побеждён.")
            return
        }
        monster.attack()
        if (HP <= 0) {
            return
        }
    }
}


