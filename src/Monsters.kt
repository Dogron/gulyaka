/**
 * Created by Dogron on 29.05.16.
 */
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
}

val monsterTypes = arrayOf(
        MonsterType("Гоблин", 5, 4),
        MonsterType("Разбойник", 3, 10)
)

fun Monster() {
    val monsterType = monsterTypes[random.nextInt(monsterTypes.size)]
    val monster = monsterType.createMonster()

    println("Вы встретили ${monster.name}.")
    println("У ${monster.name} ${monster.HP} HP")
    while (true) {
        monster.damage(random.nextInt(4) + 1)
        if (monster.HP == 0) {
            println("${monster.name} побеждён.")
            return
        } else
            println("у ${monster.name} осталось ${monster.HP} HP")
        damage(random.nextInt(monster.maxDamage) + 1)
        if (HP <= 0) {
            break
        }
    }
}


