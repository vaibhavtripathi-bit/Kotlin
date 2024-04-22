package com.example.kotlinpractice.kotlin

class Predicate {

    // all
    fun allExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val allGreaterThanZero = list.all { it > 0 }
        println("All elements are greater than zero: $allGreaterThanZero")
    }

    // any

    fun anyExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val anyGreaterThanZero = list.any { it > 0 }
        println("Any element is greater than zero: $anyGreaterThanZero")
    }

    // none

    fun noneExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val noneGreaterThanZero = list.none { it > 0 }
        println("No element is greater than zero: $noneGreaterThanZero")
    }

    // filter

    fun filterExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val greaterThanThree = list.filter { it > 3 }
        println("Elements greater than three: $greaterThanThree")
    }

    // chunked

    fun chunkedExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val chunked = list.chunked(2)
        println("Chunked list: $chunked")
        // Output: [[1, 2], [3, 4], [5]]
    }

    // drop
    fun dropExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val dropFirstThree = list.drop(3)
        println("Drop first three elements: $dropFirstThree")
    }

    // dropWhile
    fun dropWhileExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val dropWhileLessThanThree = list.dropWhile { it < 3 }
        println("Drop elements less than three: $dropWhileLessThanThree")
        // Output: [3, 4, 5]
    }

    // take

    fun takeExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val takeFirstThree = list.take(3)
        println("Take first three elements: $takeFirstThree")
        // Output: [1, 2, 3]
    }

    // takeWhile

    fun takeWhileExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val takeWhileLessThanThree = list.takeWhile { it < 3 }
        println("Take elements less than three: $takeWhileLessThanThree")
    }

    // distinct

    fun distinctExample() {
        val list = listOf(1, 2, 3, 4, 5, 1, 2, 3)
        val distinctList = list.distinct()
        println("Distinct list: $distinctList")
        // Output: [1, 2, 3, 4, 5]
    }

    // distinctBy

    fun distinctByExample() {
        val list = listOf(1, 2, 3, 4, 5, 1, 2, 3)
        val distinctList = list.distinctBy { it % 2 }
        println("Distinct list by even and odd: $distinctList")
        // Output: [1, 2]
    }

    // filterIsInstance
    fun filterIsInstanceExample() {
        val list = listOf(1, "Alice", 2, "Bob", 3, "Charlie")
        val stringList = list.filterIsInstance<String>()
        println("String elements: $stringList")
    }

    fun filterNotNullExample() {
        val list = listOf(1, "Alice", 2, "Bob", 3, null, "Charlie")
        val stringList = list.filterNotNull()
        println("String elements: $stringList")
        // Output: [Alice, Bob, Charlie]
    }

    // window
    fun windowExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val windowed = list.windowed(3)
        println("Windowed list: $windowed")
        // Output: [[1, 2, 3], [2, 3, 4], [3, 4, 5]]
    }

    // zip
    fun zipExample() {
        val list1 = listOf(1, 2, 3)
        val list2 = listOf("Alice", "Bob", "Charlie")
        val zipped = list1.zip(list2)
        println("Zipped list: $zipped")
        // Output: [(1, Alice), (2, Bob), (3, Charlie)]
    }

    // zipWithNext

    fun zipWithNextExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val zipped = list.zipWithNext()
        println("Zipped with next list: $zipped")
        // Output: [(1, 2), (2, 3), (3, 4), (4, 5)]
    }

    // joinTo

    fun joinToExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val joined = list.joinTo(StringBuilder())
        println("Joined list: $joined")
        // Output: 12345
    }

    // joinToString

    fun joinToStringExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val joined = list.joinToString()
        println("Joined list: $joined")
        // Output: 1, 2, 3, 4, 5
    }

    // partition

    fun partitionExample() {
        val list = listOf(1, 2, 3, 4, 5)
        val (even, odd) = list.partition { it % 2 == 0 }
        println("Even elements: $even, Odd elements: $odd")
        // Output: Even elements: [2, 4], Odd elements: [1, 3, 5]
    }

    // plusAssign

    fun plusAssignExample() {
        val list = mutableListOf(1, 2, 3, 4, 5)
        list += 6
        println("Plus assign list: $list")
        // Output: [1, 2, 3, 4, 5, 6]
    }

    // minusAssign

    fun minusAssignExample() {
        val list = mutableListOf(1, 2, 3, 4, 5)
        list -= 3
        println("Minus assign list: $list")
    }

    // plusAssignAll

    fun plusAssignAllExample() {
        val list = mutableListOf(1, 2, 3, 4, 5)
        list += listOf(6, 7, 8)
        println("Plus assign all list: $list")
    }

    // plusAssignSequence

    fun plusAssignSequenceExample() {
        val list = mutableListOf(1, 2, 3, 4, 5)
        list += sequenceOf(6, 7, 8)
        println("Plus assign sequence list: $list")
        // Output: [1, 2, 3, 4, 5, 6, 7, 8]
    }

    // Plus and minus operator in map

    fun plusAndMinusOperatorInMap() {
        val map = mutableMapOf("one" to 1, "two" to 2)
        map += "three" to 3
        println("Plus assign map: $map")
        // Output: {one=1, two=2, three=3}

        map -= "two"
        println("Minus assign map: $map")
        // Output: {one=1, three=3}
    }

    // plusAssignAllMap

    fun plusAssignAllMap() {
        val map = mutableMapOf("one" to 1, "two" to 2)
        map += mapOf("three" to 3, "four" to 4)
        println("Plus assign all map: $map")
        // Output: {one=1, two=2, three=3, four=4}
    }
}