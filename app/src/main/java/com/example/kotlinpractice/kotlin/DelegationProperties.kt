package com.example.kotlinpractice.kotlin

class TrimDelegate(private var value: String) {
    operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): String {
        return value
    }

    operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: String) {
        this.value = value.trim()
    }
}

class PositiveNumberDelegate(private var value: Int) {
    operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): Int {
        return value
    }

    operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: Int) {
        if (value < 0) {
            println("Error: Cannot assign a negative value to ${property.name}")
        } else {
            this.value = value
        }
    }
}

class DelegationProperties {
    var positiveNumber: Int by PositiveNumberDelegate(0)
}

fun main() {
    val delegationProperties = DelegationProperties()
    println(delegationProperties.positiveNumber) // Prints: 0
    delegationProperties.positiveNumber = 10
    println(delegationProperties.positiveNumber) // Prints: 10
    delegationProperties.positiveNumber = -5 // Prints: Error: Cannot assign a negative value to positiveNumber
    println(delegationProperties.positiveNumber) // Prints: 10
}