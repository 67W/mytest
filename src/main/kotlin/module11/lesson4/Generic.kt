package module11.lesson4

import java.util.*

class Generic<out T : Number>(value: T) {
    private var item: T? = value
        private set
    val initializeDate = Date()

    fun getItem() = item
}