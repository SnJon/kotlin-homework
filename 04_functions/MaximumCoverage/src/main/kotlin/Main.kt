const val ERROR_LIMIT = -1
const val ERROR_TYPE = -2
const val TYPE_VK = "Vk Pay"
const val TYPE_MAESTRO = "Maestro"
const val TYPE_MASTERCARD = "Mastercard"
const val TYPE_VISA = "Visa"
const val TYPE_MIR = "Мир"


fun main() {
    transfer(type = TYPE_MAESTRO, previousTransfers = 66_000, amount = 14_600)
}

fun transfer(type: String = TYPE_VK, previousTransfers: Int = 0, amount: Int): Int {
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
        TYPE_VK -> {
            if (amount > transferOnceVK || amount + previousTransfers > transferPerMonthVK) {
                return ERROR_LIMIT
            }
        }

        else -> {
            if (amount > transferOnce || amount + previousTransfers > transferPerMonth) {
                return ERROR_LIMIT
            }
        }
    }

//transfer Fee
    when (type) {
        TYPE_MASTERCARD, TYPE_MAESTRO -> {
            return if (amount + previousTransfers > transferPerMonthMM) {
                (amount * transferFeeMM).toInt() + additionalTransferFeeMM
            } else {
                0
            }
        }

        TYPE_VISA, TYPE_MIR -> {
            return if ((amount * transferFeeVM) < minTransferFeeVM) {
                minTransferFeeVM
            } else {
                (amount * transferFeeVM).toInt()
            }
        }

        TYPE_VK -> {
            return 0
        }
    }
    return ERROR_TYPE
}