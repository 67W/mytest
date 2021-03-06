package module10.lesson4

import kotlin.random.Random

fun main() {
    val boeing737 = Boeing737()
    fillAircraft(boeing737)
    println(boeing737.getInfo())
    boeing737.getSeatScheme()
    printPassengerInfo(boeing737, Seat(0, 'c'))

    println()
    println("-----------------------")
    println()

    val zeppelin = Zeppelin()
    fillAircraft(zeppelin)
    println(zeppelin.getInfo())
    zeppelin.getSeatScheme()
    printPassengerInfo(zeppelin, Seat(0, 'c'))
}

fun printPassengerInfo(aircraft: Aircraft, seat: Seat) {
    aircraft.getPassenger(seat)
        ?.getInfo()
        ?.let { println(it) }
        ?: println("there is no passenger")
}

fun fillAircraft(aircraft: Aircraft) {
    val zeppelinPassengers = Random.nextInt(1, aircraft.capacity)
    for (i in 0 until zeppelinPassengers) {
        val seat = aircraft.getAvailableSeat() ?: return
        val passenger = Passenger(
            name = "Alex",
            lastName = "Ivanov",
            document = getRandomDocument(),
            seat = seat
        )
        aircraft.addPassenger(passenger)
    }
}

fun getRandomDocument(): Document =
    when (Random.nextInt(0, 2)) {
        0 -> ForeignPassport(
            series = Random.nextInt(1000, 9999).toString(),
            number = Random.nextInt(100_000, 999_999).toString()
        )
        else -> DeputyID(
            number = Random.nextInt(100_000, 999_999).toString(),
            issueDate = "01.01.1970"
        )
    }