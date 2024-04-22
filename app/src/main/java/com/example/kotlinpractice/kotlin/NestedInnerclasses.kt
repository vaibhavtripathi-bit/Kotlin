package com.example.kotlinpractice.kotlin

class NestedInnerclasses {

    class OuterClass {
        class NestedClass {
            fun printMessage() {
                println("I'm inside the nested class!")
            }
        }

        class OuterClass {
            private val welcomeMessage: String = "Welcome to the outer class"

            inner class InnerClass {
                fun printMessage() {
                    println(welcomeMessage) // Can access properties of the outer class
                }
            }
        }
    }



}

fun main() {

    val nestedClass = NestedInnerclasses.OuterClass.NestedClass()
    nestedClass.printMessage() // Prints: I'm inside the nested class!
    NestedInnerclasses.OuterClass.OuterClass().InnerClass().printMessage() // Prints: Welcome to the outer class


}
