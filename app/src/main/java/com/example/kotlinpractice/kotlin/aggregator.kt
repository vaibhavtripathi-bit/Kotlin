package com.example.kotlinpractice.kotlin

class AggregatorAndReducer {

    fun runExamples() {
        val numbers = listOf(1, 2, 3, 4, 5)

        // reducer functions
        val sumReduce = numbers.reduce { acc, i ->
            acc + i
        }
        println("reduce: $sumReduce")

        val sumReduceIndexed = numbers.reduceIndexed { index, acc, i -> acc + i * index }
        println("reduceIndexed: $sumReduceIndexed")

        val sumReduceRight = numbers.reduceRight { i, acc -> acc + i }
        println("reduceRight: $sumReduceRight")

        val sumFold = numbers.fold(10) { acc, i -> acc + i }
        println("fold: $sumFold")

        val sumFoldIndexed = numbers.foldIndexed(10) { index, acc, i -> acc + i * index }
        println("foldIndexed: $sumFoldIndexed")

        val sumFoldRight = numbers.foldRight(10) { i, acc -> acc + i }
        println("foldRight: $sumFoldRight")

        // aggregator functions
        val average = numbers.average()
        println("average: $average")

        val sum = numbers.sum()
        println("sum: $sum")

        val max = numbers.maxOrNull()
        println("max: $max")

        val min = numbers.minOrNull()
        println("min: $min")

        val count = numbers.count()
        println("count: $count")
    }
}

fun main() {
    val examples = AggregatorAndReducer()
    examples.runExamples()
}