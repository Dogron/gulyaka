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
    val index = random.nextInt(smallChoiceEvents.size)
    val event = smallChoiceEvents[index]
    println(event.question)
    println("1. Да. ")
    println("2. Нет. ")
    while (true) {
        val choice = input()
        when (choice) {
            "1" -> when {
                random.nextInt(20) < 10 -> {
                    damage(event.amount)
                    println(event.damageText)
                    return
                } else -> {
                    heal(event.amount)
                    println(event.healText)
                    return
                }
            }
            "2" -> {
                println(event.negative)
                return
            }
            else -> {
                println("Введите 1 или 2.")
            }
        }
    }
}

class SmallChoiceEvent(val question: String,
                       val negative: String,
                       val healText: String,
                       val damageText: String,
                       val amount: Int)

val smallChoiceEvents = arrayOf(
        SmallChoiceEvent("Вы наткнулись на неизвестную ягоду, будете есть?",
                "Не хотите, как хотите.",
                "Ням-Ням.",
                "Ягода оказалась отравленой и вам нехорошо скрутило живот.",
                4),
        SmallChoiceEvent("Вам предложили бутылёчек с народным лекарством, будете пить?",
                "А зря, выглядит вкусно.",
                "Буль-буль.",
                "В глазах помутнело.",
                4)
)

fun smallGiveSmallHealPotionEvent() {
    smallHPpotions += 1
    val index = random.nextInt(smallGiveSmallHealPotionEvent.size)
    println(smallGiveSmallHealPotionEvent[index])
}


val smallGiveSmallHealPotionEvent = arrayOf(
        "Покопавшись в кустах вы нашли маленькую баночку!",
        "Внезапно залетали бабочки, на горизонте вспыхнула радуга и шишка у ваших ног превратилась в бутылочку."
)

