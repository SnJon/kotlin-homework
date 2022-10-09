fun main(args: Array<String>) {
    println(agoToText(300))
}

fun agoToText(sec: Int): String {
    val minute = 60
    val hour = 3600
    val day = 86400

    return when (sec) {
        in 0..minute -> "была(а) только что"
        in minute + 1 until hour -> "была(а) ${sec / 60} ${getNumEnding(sec / 60, "minute")} назад"
        in hour..day -> "была(а) ${sec / 3600} ${getNumEnding(sec / 3600, "hour")} назад"
        in day + 1..day * 2 -> "была(а) вчера"
        in day * 2 + 1..day * 3 -> "был(а) позавчера"
        else -> {
            "была(а) давно"
        }
    }
}

fun getNumEnding(number: Int, type: String): String {

    val preLastDigit: Int = number % 100 / 10

    if (preLastDigit == 1) {
        return if (type == "minute") {
            "минут"
        } else {
            "часов"
        }
    }

    return if (type == "minute") {
        when (number % 10) {
            1 -> "минуту"
            in 2..4 -> "минуты"
            else -> "минут"
        }
    } else {
        when (number % 10) {
            1 -> "час"
            in 2..4 -> "часа"
            else -> "часов"
        }
    }
}