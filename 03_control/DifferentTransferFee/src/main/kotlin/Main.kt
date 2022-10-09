fun main(args: Array<String>) {
    transfer(type = "Maestro", previousTransfers = 66_000, amount = 14_600)
}

fun transfer(type: String = "Vk Pay", previousTransfers: Int = 0, amount: Int) {
    val transferOnceVK = 15_000
    val transferPerMonthVK = 40_000
    val transferPerMonthMM = 75_000
    val transferOnce = 150_000
    val transferPerMonth = 600_000

    val transferFeeMM = 0.006
    val transferFeeVM = 0.0075
    val minTransferFeeVM = 35
    val additionalTransferFeeMM = 20

// limits
    when (type) {
        "Vk Pay" -> {
            if (amount > transferOnceVK || amount + previousTransfers > transferPerMonthVK) {
                println("Превышен лимит!")
                return
            }
        }

        else -> {
            if (amount > transferOnce || amount + previousTransfers > transferPerMonth) {
                println("Превышен лимит!")
                return
            }
        }
    }

//transfer Fee
    println("Перевод на сумму: $amount руб.")

    when (type) {
        "Mastercard", "Maestro" -> {
            if (amount + previousTransfers > transferPerMonthMM) {
                println("Комиссия за перевод c карт Mastercard и Maestro: ${(amount * transferFeeMM).toInt() + additionalTransferFeeMM} руб.")
            } else {
                println("Комиссия за перевод: 0 руб.")
            }
        }

        "Visa", "Мир" -> {
            if ((amount * transferFeeVM) < minTransferFeeVM) {
                println("Комиссия за перевод с карт Visa и Мир: $minTransferFeeVM руб.")
            } else {
                println("Комиссия за перевод с карт Visa и Мир: ${(amount * transferFeeVM).toInt()} руб.")
            }
        }

        "Vk Pay" -> {
            println("Комиссия за перевод: 0 руб.")
        }
    }
}
