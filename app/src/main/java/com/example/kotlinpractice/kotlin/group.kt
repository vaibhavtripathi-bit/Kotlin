package com.example.kotlinpractice.kotlin

import com.example.kotlinpractice.data.Person

class Group {
    fun groupExamples() {
        val people = Person.getPersons()

        // groupBy with one parameter, takes key selector and returns a map
        val groupByMap = people.groupBy { it.city }
        println("groupBy: $groupByMap")

        // groupBy with two parameters, take key selector and value selector and returns a map
        val groupByMapWithValueTransform = people.groupBy({ it.city }, { it.name })
        println("groupBy with value transform: $groupByMapWithValueTransform")

        // groupingBy, takes key selector and returns a Grouping object
        val grouping = people.groupingBy { it.city }
        val eachCount = grouping.eachCount()
        println("groupingBy: $eachCount")

        data class Order(val item: String, val quantity: Int)

        val orders =
            listOf(Order("Apple", 5), Order("Orange", 3), Order("Apple", 4), Order("Orange", 7))
        val totalQuantities = orders.groupingBy { it.item }.fold(0) { acc, order ->
            acc + order.quantity
        }
        println(totalQuantities) // Output: {Apple=9, Orange=10}

        data class Employee(val department: String, val salary: Int)

        val employees = listOf(
            Employee("Sales", 2000),
            Employee("HR", 3000),
            Employee("Sales", 2500),
            Employee("HR", 3500)
        )
        val highestSalaries = employees.groupingBy { it.department }.reduce { _, acc, e ->
            if (e.salary > acc.salary) e else acc
        }
        println(highestSalaries) // Output: {Sales=Employee(department=Sales, salary=2500), HR=Employee(department=HR, salary=3500)}

        people.groupBy { it.city }.forEach { (city, persons) ->
            println("$city: ${persons.joinToString { it.name }}")
        }
        println("GroupByTo:------")

        val destinationMap = mutableMapOf<String, MutableList<Person>>()
        people.groupByTo(destinationMap) { it.city }
        println(destinationMap) // Output: {London=[Person(name=Alice, city=London), Person(name=Charlie, city=London)], Paris=[Person(name=Bob, city=Paris)]}
        println("GroupByTo:------")

//        Person.getPersons().groupByTo(
//            destination = destinationMap,
//            keySelector = { it.city },
//            valueTransform = { it })
//            .forEach { (city, names) ->
//                println("$city: ${names.joinToString()}")
//            }
        destinationMap.forEach { (city, persons) ->
            println("$city: ${persons.joinToString { it.name }}")
        }
    }
}

fun main() {
    val group = Group()
    group.groupExamples()
}