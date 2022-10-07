fun main(args: Array<String>) {

    var savingsAccount: Float = 3500F
    var amount: Int = 10000
    val transferPercentage: Float = 0.0075F
    val minTransferFee: Int = 35
    var transferFee: Float = 0F

    println("Сберегательный счет: $savingsAccount\n")

    if (amount * transferPercentage < minTransferFee) {
        transferFee = minTransferFee.toFloat()
        savingsAccount -= transferFee
    } else {
        transferFee += amount * transferPercentage
        savingsAccount -= transferFee
    }

    println("""Сумма перевода: $amount руб.
        |Комиссия: $transferFee руб.
        |Сберегательный счет: $savingsAccount руб.
    """.trimMargin())
}