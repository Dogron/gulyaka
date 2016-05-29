package gulyaka

import java.util.*

var HP = 20
var maxHP = 20
var day = 0
fun heal(points: Int) {
    HP = HP + points
    println("hp +$points")
    if (HP > maxHP) {
        HP = maxHP
    }
}

fun damage(points: Int) {
    HP = HP - points
    println("hp -$points")
    if (HP < 0) {
        HP = 0
    }
}

fun input(): String {
    print ("> ")
    val read = readLine()!!
    return read
}

val random = Random()
var name = ""
fun main(args: Array<String>) {

    if (args.size > 0) {
        name = args[0]
    } else {
        println("Привет, как тебя зовут?")
        name = input()
    }

    println("Рад тебя видеть, $name.")

    while (true) {
        // вывести состояние мира
        println("День $day. Персонаж $name жив, у него $HP здоровья.")

        // ввести команду
        val command = input()

        // выполнить команду
        if (command == "Выход") {
            break
        }

        // События
        val dice = random.nextInt(20)
        when (dice) {
            in 0..4 -> smallDamageEvent()
            in 5..8 -> smallHealEvent()
            in 9..12 -> smallChoiceEvent()
            else -> println("Ничего не произошло.")
        }

        // изменить мир
        if (HP <= 0) {
            println("Вы погибли.")
            break
        }
        day = day + 1
    }
    println("Игра окончена. Вы прожили $day дней.")
}

fun smallChoiceEvent() {
    println("Вы наткнулись на неизвестную ягоду красного цвета, будете есть?")
    println("1. Да. ")
    println("2. Нет. ")
    val choice = input()
    if (choice == "1") {
        when {
            random.nextInt(20) < 10 -> {
                damage(4)
                println("Ягода оказалась отравленой и вам нехорошо скрутило живот.")
            }
            else -> {
                heal(4)
                println("Ням-Ням.")
            }
        }
    }
}

val smallHealEvents = arrayOf(
        "Добрая фея поправила вам здоровье.",
        "Вам на нос упала живительная капля."
)

fun smallHealEvent() {
    val index = random.nextInt(smallHealEvents.size)
    println(smallHealEvents[index])
    heal(random.nextInt(4) + 1)
}

val smallDamageEvents = arrayOf(
        "Вам на голову упал кирпич.",
        "Вас закусали гигантские насекомые."

)

fun smallDamageEvent() {
    val index = random.nextInt(smallDamageEvents.size)
    println(smallDamageEvents[index])
    damage(random.nextInt(4) + 1)
}
