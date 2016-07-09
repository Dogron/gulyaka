package gulyaka

import java.util.*

var day = 0
val random = Random()

fun input(): String {
    print("> ")
    val read = readLine()!!
    return read
}

fun dice(amount: Int, times: Int = 1): Int {
    var result = 0
    repeat(times) {
        result += random.nextInt(amount) + 1
    }
    return result
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
        while (hero.command()) {}

        when (dice(20)) {
            in 0..14 -> event()
            in 16..17 -> battle()
            else -> println("Ничего не произошло.")
        }

        if (hero.HP <= 0) {
            println("Вы погибли.")
            break
        }
        day += 1
    }
    println("Игра окончена. Вы прожили $day дней.")
}


