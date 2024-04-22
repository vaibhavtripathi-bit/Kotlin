package com.example.kotlinpractice.kotlin

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

fun interface MyFunctionalInterface {
    fun printMessage()
}

fun main() {
//    val functionalInterface = object : MyFunctionalInterface {
//        override fun printMessage() {
//            println("I'm inside the functional interface!")
//        }
//    }

    val functionalInterface = MyFunctionalInterface {
        println("I'm inside the functional interface!")
    }
    functionalInterface.printMessage() // Prints: I'm inside the functional interface!


    val isEven = IntPredicate { it % 2 == 0 }
    println(isEven.accept(10)) // Prints: true
    println(isEven.accept(5)) // Prints: false
}