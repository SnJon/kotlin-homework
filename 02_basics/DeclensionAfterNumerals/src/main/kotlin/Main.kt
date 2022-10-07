fun main(args: Array<String>) {
    val likes = 1001
    println(getNumEnding(likes))
}

fun getNumEnding(number: Int): String {
    val liked = "Понравилось"

    if (number == 0) {
        return "Никому не понравилось"
    }

    val preLastDigit = number % 100 / 10

    if (preLastDigit == 1) {
        return "$liked $number людям"
    }

    return when (number % 10) {
        1 -> "$liked $number человеку"
        4 -> "$liked $number людям"
        else -> "$liked $number людям"
    }
}