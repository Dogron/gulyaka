package gulyaka

var HP = 20
var maxHP = 20
var name = ""

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
