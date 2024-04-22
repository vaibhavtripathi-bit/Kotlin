package com.example.kotlinpractice.kotlin

class MapIterator {

    fun runExamples() {
        // map iteration
        val map = mapOf("one" to 1, "two" to 2, "three" to 3)

        println("\nFor loop:")
        for ((key, value) in map) {
            println("$key = $value")
        }

        println("\nforEach function:")
        map.forEach { (key, value) ->
            println("$key = $value")
        }

        println("\nFor loop with values:")
        for (value in map.values) {
            println("value: $value")
        }

        println("\nFor loop with keys:")
        for (key in map.keys) {
            println("value: $key")
        }

        println("\nFor loop with entries:")
        for (entry in map.entries) {
            println("${entry.key} = ${entry.value}")
        }

        println("\nIterator:")
        val mapIterator = map.iterator()
        while (mapIterator.hasNext()) {
            val entry = mapIterator.next()
            println("${entry.key} = ${entry.value}")
        }
    }
}

fun main() {
    val list = listOf(1, 2, 3, 4, 5)
    val (even, odd) = list.partition { it % 2 == 0 }
    println("Even elements: $even, Odd elements: $odd")
    // Output: Even elements: [2, 4], Odd elements: [1, 3, 5]
    val examples = MapIterator()
    examples.runExamples()
}