package com.example.kotlinpractice.kotlin

class Other {

    inline fun <reified T> printType(value: T) {
        println(T::class)
    }
}

fun main() {
    val list = listOf(1, "Alice", 2, "Bob", 3, null, "Charlie")
    val stringList = list.filterNotNull()
    println("String elements: $stringList")
    // Output: [Alice, Bob, Charlie]

    Other().apply {
        printType("Hello") // Prints: class kotlin.String
        Other().printType(123) // Prints: class kotlin.Int
    }
}