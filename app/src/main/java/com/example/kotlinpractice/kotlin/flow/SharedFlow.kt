package com.example.kotlinpractice.kotlin.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

data class Update(val message: String)

val updatesFlow = MutableSharedFlow<Update>()

suspend fun sendUpdate(update: Update) {
    updatesFlow.emit(update)
}

suspend fun CoroutineScope.startCollector(id: Int) {
    updatesFlow.collect { update ->
        println("Collector $id received update: ${update.message}")
    }
}

fun main() = runBlocking {
    launch { startCollector(1) }
    launch { startCollector(2) }

    for (i in 1..5) {
        sendUpdate(Update("Update $i"))
        delay(500) // simulate delay between updates
    }
}
