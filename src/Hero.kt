package gulyaka

var HP = 20
var maxHP = 20
var name = ""
var smallHPpotions = 3
fun heal(points: Int) {
    HP += points
    println("Вас вылечили на $points hp ")
    if (HP > maxHP) {
        HP = maxHP
    }
}

fun attack(monster: Monster) {
    monster.damage(random.nextInt(4) + 1)
}

fun damage(points: Int) {
    HP -= points
    println("Вас повредили на $points HP ")
    if (HP < 0) {
        HP = 0
    }
}

fun drinkSmallHPPotion() {
    if (smallHPpotions == 0) {
        println("Маленьких зелий здоровья больше нет!")
        return
    }
    smallHPpotions -= 1
    heal(3)

}
