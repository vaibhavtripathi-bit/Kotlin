package com.example.kotlinpractice.kotlin.functionalapproach

class Pipeline {

}
// Define extension function to create a pipeline
fun <T> Iterable<T>.pipeline1(vararg functions: (T) -> T): List<T> {
    return this.map { item ->
        functions.fold(item) { acc, func ->
            func(acc)
        }
    }
}

fun <T, R> Iterable<T>.pipeline(vararg functions: (T) -> R): List<R> {
    val value = this.map { item ->
        functions.fold(mutableListOf<R>()) { acc, func ->
            acc.apply { add(func(item)) }
        }
    }
    val result = value.flatten()
    return result
}

// Define functions
fun square(x: Int): Int {
    return x * x
}

fun double(x: Int): Int {
    return x * 2
}

fun addOne(x: Int): Int {
    return x + 1
}

fun main() {
    // Create data
    val numbers = listOf(1, 2, 3, 4, 5)

    // Pipeline
    val result = numbers.pipeline1(::square, ::double, ::addOne)
    println(result)
}