package module9.lesson2

import kotlin.random.Random

fun main() {
    val train = Train(10000)
    println("capacity - ${train.capacity}")
    train.move()

    val boeing737 = Boeing737()
    val passengerCount = Random.nextInt(1, boeing737.capacity)
    for (i in 0 until passengerCount) {
        val passenger = Passenger(
            name = "Ivan",
            lastName = "Petrov",
            passport = "${Random.nextInt(1000, 9999)} ${Random.nextInt(100000, 999999)}",
            seat =
        )
    }
}