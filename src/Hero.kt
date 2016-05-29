package gulyaka

var HP = 20
var maxHP = 20
var name = ""
var smallHPpotions = 3
fun heal(points: Int) {
    HP += points
    println("hp +$points")
    if (HP > maxHP) {
        HP = maxHP
    }
}

fun damage(points: Int) {
    HP -= points
    println("hp -$points")
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
