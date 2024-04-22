package com.example.kotlinpractice.kotlin

class KotlinExamples {

    fun runExamples() {
        // list iteration
        val list = listOf("Apple", "Banana", "Cherry")

        println("\nFor loop with indices:")
        for (i in list.indices) {
            println("Item at $i is ${list[i]}")
        }

        println("\nFor loop:")
        for (item in list) {
            println(item)
        }

        println("\nFor loop with withIndex function:")
        for ((index, value) in list.withIndex()) {
            println("Item at $index is $value")
        }


        println("\nIterator:")
        val iterator = list.iterator()
        while (iterator.hasNext()) {
            println(iterator.next())
        }

        println("\nforEach function:")
        list.forEach { item ->
            println(item)
        }

        println("\nforEachIndexed function:")
        list.forEachIndexed { index, item ->
            println("Item at $index is $item")
        }
    }
}

fun main() {
    val examples = KotlinExamples()
    examples.runExamples()
}