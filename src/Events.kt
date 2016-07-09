package gulyaka


abstract class Event() {
    abstract fun run()
}


class FindWeaponEvent(val question: String,
                      val negative: String,
                      val take: String,
                      val weapon: Weapon) : Event() {
    override fun run() {
        println(question)
        println("1. Да.")
        println("2. Нет.")
        while (true) {
            val choice = input()
            when (choice) {
                "1" -> {
                    println(take)
                    hero.weapon = weapon
                    return
                }
                "2" -> {
                    println(negative)
                    return
                }
                else -> {
                    println("Введите 1 или 2.")
                }
            }
        }
    }
}

class HealEvent(val text: String, val points: Int) : Event() {
    override fun run() {
        println(text)
        hero.heal(dice(points))
    }
}

class DamageEvent(val text: String, val points: Int) : Event() {
    override fun run() {
        println(text)
        hero.damage(dice(points))
    }
}

class HealingPotionEvent(val text: String) : Event() {
    override fun run() {
        println(text)
        hero.smallHealingPotions += 1
    }
}

class SmallChoiceEvent(val question: String,
                       val negative: String,
                       val healText: String,
                       val damageText: String,
                       val amount: Int) : Event() {
    override fun run() {
        println(question)
        println("1. Да.")
        println("2. Нет.")
        while (true) {
            val choice = input()
            when (choice) {
                "1" -> when {
                    dice(20) < 10 -> {
                        hero.damage(amount)
                        println(damageText)
                        return
                    }
                    else -> {
                        hero.heal(amount)
                        println(healText)
                        return
                    }
                }
                "2" -> {
                    println(negative)
                    return
                }
                else -> {
                    println("Введите 1 или 2.")
                }
            }
        }
    }
}

val events = arrayOf(
        HealEvent("Добрая фея поправила вам здоровье.", 4),
        HealEvent("Вам на нос упала живительная капля.", 4),

        DamageEvent("Вам на голову упал кирпич.", 4),
        DamageEvent("Вас закусали гигантские насекомые.", 4),
        DamageEvent("Вы наступили на ядовитый шип.", 4),

        SmallChoiceEvent("Вы наткнулись на неизвестную ягоду, будете есть?",
                "Не хотите, как хотите.",
                "Ням-Ням.",
                "Ягода оказалась отравленой и вам нехорошо скрутило живот.",
                4),
        SmallChoiceEvent("Вам предложили бутылёчек с народным лекарством, будете пить?",
                "А зря, выглядит вкусно.",
                "Буль-буль.",
                "В глазах помутнело.",
                4),

        HealingPotionEvent("Покопавшись в кустах вы нашли маленькую баночку!"),
        HealingPotionEvent("Внезапно залетали бабочки, на горизонте вспыхнула радуга " +
                "и шишка у ваших ног превратилась в бутылочку."),

        FindWeaponEvent("Нашли посреди дороги окрававленый кинжал, будете брать?", "Что нибудь", "Молодцы",
                Dagger()),
        FindWeaponEvent("Меч! Будете брать?", "Что нибудь", "Молодцы",
                Sword()),
        FindWeaponEvent("Вампирский Меч! Будете брать?", "Что нибудь", "Молодцы",
                VampiricSword())


)

fun event() {
    val event = events[random.nextInt(events.size)]
    event.run()
}
