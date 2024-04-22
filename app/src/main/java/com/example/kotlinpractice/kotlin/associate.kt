package com.example.kotlinpractice.kotlin

import com.example.kotlinpractice.data.Person


fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)

    // associate, takes transform function as parameter and returns a map
    val associateMap = numbers.associate { it to it * 2 }
    println("associate: $associateMap")

    val people = listOf(Person("Alice", city = "London"), Person("Bob", city = "Paris"))

    // associateBy with one parameter, takes key selector and returns a map assiciating the key with the element
    val associateByMap = people.associateBy { it.name }
    println("associateBy: $associateByMap")

    // associateBy with two parameters, take key selector and value selector and returns a map
    // associating the key with the value
    val associateByMapWithValueTransform = people.associateBy({ it.name }, { it.city })
    println("associateBy with value transform: $associateByMapWithValueTransform")

    // associateWith takes value selector and returns a map associating the element with the value
    val associateWithMap = numbers.associateWith { it * 2 }
    println("associateWith: $associateWithMap")


    val destinationMap = mutableMapOf<String, Person>()
    people.associateByTo(destinationMap) { it.name }
    println(destinationMap) // Output: {Alice=Person(name=Alice, city=London), Bob=Person(name=Bob, city=Paris), Charlie=Person(name=Charlie, city=London)}

}

