package gulyaka


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
        "Вас закусали гигантские насекомые.",
        "Вы наступили на ядовитый шип."
)

fun smallDamageEvent() {
    val index = random.nextInt(smallDamageEvents.size)
    println(smallDamageEvents[index])
    damage(random.nextInt(4) + 1)
}

fun smallChoiceEvent() {
    println("Вы наткнулись на неизвестную ягоду красного цвета, будете есть?")
    println("1. Да. ")
    println("2. Нет. ")

    while (true) {
        val choice = input()
        when (choice) {
            "1" -> when {
                random.nextInt(20) < 10 -> {
                    damage(4)
                    println("Ягода оказалась отравленой и вам нехорошо скрутило живот.")
                    return
                }
                else -> {
                    heal(4)
                    println("Ням-Ням.")
                    return
                }
            }
            "2" -> {
                println("Не хотите, как хотите.")
                return
            }
            else -> {
                println("Введите 1 или 2.")
            }
        }
    }
}
