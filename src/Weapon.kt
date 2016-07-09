package gulyaka

abstract class Weapon() {
    abstract fun attack(monster: Monster)
}

class Dagger() : Weapon() {
    override fun attack(monster: Monster) {
        monster.damage(dice(4))
    }

    override fun toString() = "Кинжал"
}

class Sword() : Weapon() {
    override fun attack(monster: Monster) {
        monster.damage(dice(4, 2))
    }

    override fun toString() = "Меч"
}

class VampiricSword() : Weapon() {
    override fun attack(monster: Monster) {
        val damage = dice(4, 2)
        monster.damage(damage)
        hero.heal(damage / 2)
    }

    override fun toString() = "Вампирский Меч"
}

class Fist() : Weapon() {
    override fun attack(monster: Monster) {
        monster.damage(2)
    }

    override fun toString() = "Кулак"
}

