/**
 * Created by Dogron on 29.05.16.
 */
package gulyaka

class Monster(val name: String, val initialHP: Int, val maxDamage: Int)

val monsters = arrayOf(
        Monster("Гоблин", 5, 4),
        Monster("Разбойник", 3, 10)
)

fun Monster() {
    val monster = monsters[random.nextInt(monsters.size)]
    var hpMonster = monster.initialHP
    println("Вы встретили ${monster.name}.")
    println("У ${monster.name} $hpMonster HP")
    while (true) {
        val playerAttack = random.nextInt(4) + 1
        println("Вы ударили на $playerAttack HP.")
        hpMonster -= playerAttack
        if (hpMonster <= 0) {
            println("${monster.name} побеждён.")
            return
        } else
            println("у ${monster.name} осталось $hpMonster HP")
        damage(random.nextInt(monster.maxDamage) + 1)
        if (HP <= 0) {
            break
        }
    }
}


