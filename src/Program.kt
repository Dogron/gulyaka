package gulyaka

import java.util.*

var day = 0
val random = Random()

fun input(): String {
    print ("> ")
    val read = readLine()!!
    return read
}

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
        println("День $day. Персонаж $name жив, у него $HP здоровья и $smallHPpotions Маленьких зелий здоровья.")

        // ввести команду
        val command = input().toLowerCase()

        // выполнить команду
        if (command == "exit") {
            break
        }
         if (command == "shp") {
            drinkSmallHPPotion()
         }

        // События
        val dice = random.nextInt(20)
        when (dice) {
            in 0..4 -> smallDamageEvent()
            in 5..8 -> smallHealEvent()
            in 9..12 -> smallChoiceEvent()
            in 13..13 -> smallGiveSmallHealPotionEvent()
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

