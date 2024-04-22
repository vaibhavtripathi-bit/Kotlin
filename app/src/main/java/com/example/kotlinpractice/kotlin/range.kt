package com.example.kotlinpractice.kotlin

class range {
    fun range() {
        // Create a range
        val range1 = 1..5
        println("Range1: $range1")

        // Iterate over a range
        for (i in 1..5) {
            println("Iterating over range: $i")
        }

        // Check if a number is in a range
        if (3 in 1..5) {
            println("3 is in the range")
        }

        // Create a range with a step
        for (i in 1..10 step 2) {
            println("Range with step: $i")
        }

        // Create a decreasing range
        for (i in 5 downTo 1) {
            println("Decreasing range: $i")
        }

        // Create a range with until
        for (i in 1 until 5) {
            println("Range with until: $i")
        }

        // Check if a range is empty
        val range2 = 5 downTo 10
        println("Is range2 empty? ${range2.isEmpty()}")

        // Get the first and last element of a range
        val range3 = 1..5
        println("First element of range3: ${range3.first}")
        println("Last element of range3: ${range3.last}")

        // Reverse a range
        val reversed = range3.reversed()
        println("Reversed range: $reversed")

    }
}

fun main() {
    val examples = range()
    examples.range()
}