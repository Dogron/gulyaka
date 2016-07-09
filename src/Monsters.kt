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
        hero.damage(dice(maxDamage))
    }
}

val monsterTypes = arrayOf(
        MonsterType("Гоблин", 5, 4),
        MonsterType("Разбойник", 3, 10)
)

fun battle() {
    val monsterType = monsterTypes[random.nextInt(monsterTypes.size)]
    val monster = monsterType.createMonster()

    println("Вы встретили ${monster.name}.")
    while (true) {
        hero.status()
        println("У ${monster.name} ${monster.HP} HP")
        hero.command()

        hero.attack(monster)
        if (monster.HP == 0) {
            println("${monster.name} побеждён.")
            return
        }
        monster.attack()
        if (hero.HP <= 0) {
            return
        }
    }
}


