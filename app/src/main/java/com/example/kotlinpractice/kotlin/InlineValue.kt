package com.example.kotlinpractice.kotlin

@JvmInline
value class InlineValue(val age: Int) {
}



@JvmInline
value class Name(val s: String) {
    fun print() {
        println(s)
    }
    fun getAge(): String {
        return "$s is 20 years old"
    }
}

fun main() {
    val name = Name("John Doe")
    println(name.s) // Prints: John Doe
}