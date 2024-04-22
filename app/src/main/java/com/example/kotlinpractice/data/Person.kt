package com.example.kotlinpractice.data

// Genrerate Person data class with atleast 6 properties

data class Person(
    var name: String,
    var age: Int = 0,
    var city : String = "Bangalore",
    val address: String = "1234 Wonderland",
    val phoneNumber: String = "1234567890",
    val email: String   = "test@gmail.com",
    val isMarried: Boolean = false
) {
    // Create a companion object with a function to return a list of 5 persons
    companion object {
        fun getPersons(): List<Person> {
            return listOf(
                Person("Alice", 25, "London", "1234 Wonderland", "1234567890", "", true),
                Person("Bob", 30, "Paris", "1234 Wonderland", "1234567890", "", true),
                Person("Charlie", 35, "New York", "1234 Wonderland", "1234567890", "", true),
                Person("David", 40, "Tokyo", "1234 Wonderland", "1234567890", "", true),
                Person("Eve", 45, "Sydney", "1234 Wonderland", "1234567890", "", true),
                Person("Frank", 50, "Berlin", "1234 Wonderland", "1234567890", "", true),
                Person("Grace", 55, "Mumbai", "1234 Wonderland", "1234567890", "", true)
            )
        }
    }
}

fun main() {
    val persons = Person.getPersons()
    persons.forEach {
        println(it)
    }
}


