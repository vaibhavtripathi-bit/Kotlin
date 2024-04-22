package com.example.kotlinpractice.kotlin

class Generics {
}

class Box<T>(t: T) {
    var value = t
}

fun <T : Comparable<T>> sort(list: List<T>): List<T> {
    return list.sorted()
}

fun main() {
    val box: Box<Int> = Box<Int>(10)
    println(box.value) // Prints: 10
    val integers = listOf(1, 5, 2, 4, 3)
    println(sort(integers)) // Prints: [1, 2, 3, 4, 5]

    val strings = listOf("banana", "apple", "cherry", "blueberry")
    println(sort(strings)) // Prints: [apple, banana, blueberry, cherry]
}