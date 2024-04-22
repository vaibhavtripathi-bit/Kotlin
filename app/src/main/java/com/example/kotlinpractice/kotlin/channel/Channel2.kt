import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

data class Job(val id: Int)

fun CoroutineScope.launchWorker(id: Int, channel: Channel<Job>) = launch {
    for (job in channel) {
        println("Worker $id processing job ${job.id}")
        delay(1000) // simulate work
    }
}

fun main(): Unit = runBlocking {
    val jobChannel = Channel<Job>()

    repeat(5) { id ->
        launchWorker(id, jobChannel)
    }

    for (i in 1..10) {
        jobChannel.send(Job(i))
    }

    delay(5000) // give workers some time to process
    jobChannel.close() // no more jobs
}
