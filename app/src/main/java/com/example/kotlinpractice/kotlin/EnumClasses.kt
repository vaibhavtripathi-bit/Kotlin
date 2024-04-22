package com.example.kotlinpractice.kotlin

class EnumClasses {

    enum class Direction {
        NORTH, SOUTH, EAST, WEST
    }

    enum class Planet(val mass: Double, val radius: Double) {
        MERCURY(3.303e+23, 2.4397e6),
        VENUS(4.869e+24, 6.0518e6),
        EARTH(5.976e+24, 6.37814e6),
        MARS(6.421e+23, 3.3972e6),
        JUPITER(1.9e+27, 7.1492e7),
        SATURN(5.688e+26, 6.0268e7),
        URANUS(8.686e+25, 2.5559e7),
        NEPTUNE(1.024e+26, 2.4746e7);
    }

    enum class Color {
        RED, GREEN, BLUE;

        fun rgb() = when (this) {
            RED -> "FF0000"
            GREEN -> "00FF00"
            BLUE -> "0000FF"
        }
    }

    enum class Operation {
        ADD {
            override fun apply(x: Double, y: Double): Double = x + y
        },
        SUBTRACT {
            override fun apply(x: Double, y: Double): Double = x - y
        },
        MULTIPLY {
            override fun apply(x: Double, y: Double): Double = x * y
        },
        DIVIDE {
            override fun apply(x: Double, y: Double): Double = x / y
        };

        abstract fun apply(x: Double, y: Double): Double
    }

    enum class State {
        IDLE, RUNNING, FINISHED
    }

    fun runExamples() {
        val direction = Direction.NORTH
        println("Direction: $direction")

        val planet = Planet.EARTH
        println("Planet: $planet, mass: ${planet.mass}, radius: ${planet.radius}")

        val color = Color.RED
        println("Color: $color, RGB: ${color.rgb()}")

        val operation = Operation.ADD
        val result = operation.apply(2.0, 3.0)
        println("Operation: $operation, result: $result")
    }
}

fun main() {
    val examples = EnumClasses()
    examples.runExamples()
}