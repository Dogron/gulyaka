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
        hero.name = args[0]
    } else {
        println("Привет, как тебя зовут?")
        hero.name = input()
    }

    println("Рад тебя видеть, ${hero.name}.")

    while (true) {
        println("День $day. ")

        hero.status()
        hero.command()

        val dice = random.nextInt(20)
        when (dice) {
            in 0..14 -> event()
            in 16..17-> battle()
            else -> println("Ничего не произошло.")
        }

        if (hero.HP <= 0) {
            println("Вы погибли.")
            break
        }
        day = day + 1
    }
    println("Игра окончена. Вы прожили $day дней.")
}


