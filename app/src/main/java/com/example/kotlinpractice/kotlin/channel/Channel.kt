package com.example.kotlinpractice.kotlin.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

class ChannelExample {
    private val channel = Channel<Int>()

    suspend fun produce() {
        for (x in 1..5) {
            channel.send(x * x)
        }
        channel.close() // we're done sending
    }

    suspend fun consume() {
        for (y in channel) {
            println(y)
        }
        println("Done!")
    }
}

data class Job(val id: Int)

fun CoroutineScope.launchWorker(id: Int, channel: Channel<Job>) = launch {
    for (job in channel) {
        println("Worker $id processing job ${job.id}")
        delay(1000) // simulate work
    }
}

fun main() = runBlocking {
    val example = ChannelExample()
    launch { example.produce() }
    example.consume()
}
/*
`Channel` and `SharedFlow` in Kotlin are both used for communication between coroutines, but they have different characteristics and use cases.

Advantages of `Channel`:
1. `Channel` is hot, which means it starts emitting items as soon as it's created. It doesn't require a
subscription to start emitting.
2. `Channel` can have multiple producers and multiple consumers. This makes it suitable for scenarios where
you have multiple coroutines producing and consuming values.
3. `Channel` supports backpressure. If a producer is producing values faster than a consumer can
consume them, the producer is suspended until the consumer is ready.

Advantages of `SharedFlow`:
1. `SharedFlow` is cold, which means it doesn't start emitting items until it has at least one collector.
This makes it suitable for scenarios where you want to start producing values only when
 there's a consumer ready to consume them.
2. `SharedFlow` can have multiple collectors. This makes it suitable for scenarios where you want
to broadcast the same values to multiple consumers.
3. `SharedFlow` can replay previously emitted values to new collectors. This is useful when you want
new collectors to receive the same values that were previously emitted.

In summary, `Channel` is more suitable for producer-consumer scenarios where you have multiple producers
and consumers, and you need to handle backpressure. `SharedFlow` is more suitable for broadcasting
scenarios where you want to share the same values with multiple collectors and replay values to new collectors.

*/
