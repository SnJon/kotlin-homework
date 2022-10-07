fun main(args: Array<String>) {
    val firstLevel = 1000
    val secondLevel = 10000
    val isMusicLover = true

    var amount = 10001

    println("покупка - $amount ${getNumEnding(amount)} ->")

    if (amount <= firstLevel) {
        println("Нет скидок")
    } else if (amount in (firstLevel + 1)..secondLevel) {
        amount -= 100
        println("после применения стандартной скидки - $amount ${getNumEnding(amount)}.")
    } else {
        amount -= (amount * 0.05).toInt()
        println("после применения 5% скидки - $amount ${getNumEnding(amount)}.")
    }

    if (isMusicLover) {
        amount -= (amount * 0.01).toInt()
        println("после применения 1% скидки - $amount ${getNumEnding(amount)}.")
    }
}

fun getNumEnding(number: Int): String {
    if (number == 0) {
        return "рублей"
    }

    val preLastDigit = number % 100 / 10

    if (preLastDigit == 1) {
        return "рублей"
    }

    return when (number % 10) {
        1 -> "рубль"
        4 -> "рублей"
        else -> "рублей"
    }
}