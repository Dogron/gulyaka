package gulyaka

abstract class Weapon() {
    abstract fun attack(monster: Monster)
}

class Dagger() : Weapon() {
    override fun attack(monster: Monster) {
        monster.damage(random.nextInt(4) + 1)

    }
}

class Fist() : Weapon() {
    override fun attack(monster: Monster) {
        monster.damage(2)
    }
}

