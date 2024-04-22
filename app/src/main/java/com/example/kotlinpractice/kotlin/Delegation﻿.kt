package com.example.kotlinpractice.kotlin

class Delegation {

    interface SoundBehavior {
        fun makeSound()
    }

    class ScreamBehavior(val n: String) : SoundBehavior {
        override fun makeSound() = println("${n.toUpperCase()} !!!")
    }

    class RockAndRollBehavior(val n: String) : SoundBehavior {
        override fun makeSound() = println("I'm the king of rock 'n' roll: $n")
    }

    class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n)
    class ElvisPresley(n: String) : SoundBehavior by RockAndRollBehavior(n)

}

fun main() {
    val tomAraya = Delegation.TomAraya("Trash Metal")
    tomAraya.makeSound() // Prints: TRASH METAL !!!

    val elvisPresley = Delegation.ElvisPresley("Dancin' to the Jailhouse Rock.")
    elvisPresley.makeSound() // Prints: I'm the king of rock 'n' roll: Dancin' to the Jailhouse Rock.
}