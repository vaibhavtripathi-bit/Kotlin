package com.example.kotlinpractice.kotlin

class reducerfunctions {

    fun aggregate() {

        fun reduceSum() {
            val numbers = listOf(1, 2, 3, 4, 5)
            val sum = numbers.reduce { acc, i ->
                acc + i
            }
            println("reduce: $sum") // Output: 15
        }

        fun reduceSumWithIndex() {
            val numbers = listOf(1, 2, 3, 4, 5)
            val sum = numbers.reduceIndexed { index, acc,
                                              i -> acc + i * index
            }
            println(sum) // Output: 26
        }

        fun reduceRight() {
            val numbers = listOf(1, 2, 3, 4, 5)
            val sum = numbers.reduceRight { i, acc ->
                acc + i
            }
            println(sum) // Output: 15
        }

        fun reduceSumWithInitialValue() {
            val numbers = listOf(1, 2, 3, 4, 5)
            val sum = numbers.fold(10) { acc, i -> acc + i }
            println("fold: $sum") // Output: 25
        }

        fun reduceSumWithInitialValueAndIndex() {
            val numbers = listOf(1, 2, 3, 4, 5)
            val sum =
                numbers.foldIndexed(10) { index, acc, i -> if (index % 2 == 0) acc + i else acc }
            println("foldIndexed: $sum") // Output: 16
        }

        fun reduceSumWithInitialValueAndRightToLeft() {
            val numbers = listOf(1, 2, 3, 4, 5)
            val sum = numbers.foldRight(10) { i, acc -> acc + i }
            println("foldRight: $sum") // Output: 25
        }

        fun reduceSumWithInitialValueAndIndexAndRightToLeft() {
            val numbers = listOf(1, 2, 3, 4, 5)
            val sum =
                numbers.foldRightIndexed(10) { index, i, acc -> if (index % 2 == 0) acc + i else acc }
            println("foldRightIndexed: $sum") // Output: 16
        }

        reduceSum()
        reduceSumWithIndex()
        reduceRight()
        reduceSumWithInitialValue()
        reduceSumWithInitialValueAndIndex()
        reduceSumWithInitialValueAndRightToLeft()
        reduceSumWithInitialValueAndIndexAndRightToLeft()

    }

}


fun main() {
    val obj = reducerfunctions()
    obj.aggregate()
}
