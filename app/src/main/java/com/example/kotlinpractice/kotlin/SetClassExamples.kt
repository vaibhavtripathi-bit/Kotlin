package com.example.kotlinpractice.kotlin

import com.example.kotlinpractice.data.Person

class SetClassExamples {

    fun intersect() {
        val set1 = setOf("Apple", "Banana", "Cherry")
        val set2 = setOf("Banana", "Cherry", "Date")
        println(set1.intersect(set2)) // [Banana, Cherry]
    }

    fun union() {
        val set1 = setOf("Apple", "Banana", "Cherry")
        val set2 = setOf("Banana", "Cherry", "Date")
        println(set1.union(set2)) // [Apple, Banana, Cherry, Date]
    }

    fun subtract() {
        val set1 = setOf("Apple", "Banana", "Cherry")
        val set2 = setOf("Banana", "Cherry", "Date")
        println(set1.subtract(set2)) // [Apple]
    }

    fun setdistinctBy() {
        val set1 = setOf("Apple", "Banana", "Cherry", "Bpple", "Banana")
        val set2 = setOf("Banana", "Cherry", "Date", "nameisempty")
        println("-----------------")
        println(set1.distinctBy { it.length }) // [Apple, Banana]

        val people = listOf(
            Person("John", 20),
            Person("John", 21),
            Person("Jane", 22),
            Person("Jake", 23)
        )

        val distinctPeople = people.distinctBy { it.name }

        println(distinctPeople) // Prints: [Person(name=John, age=20), Person(name=Jane, age=22), Person(name=Jake, age=23)]

    }

    fun runExamples() {
        intersect()
        union()
        subtract()
        setdistinctBy()
    }
}

fun main() {
    val examples = SetClassExamples()
    examples.runExamples()
}


