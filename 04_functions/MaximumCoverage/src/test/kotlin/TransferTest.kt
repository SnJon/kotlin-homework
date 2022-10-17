import org.junit.Test
import kotlin.test.assertEquals

class TransferTest {

    //limits
    @Test
    fun previousTransferVKLimitTest() {
        val previousTransfer = 66_000
        val amount = 14_600

        val result = transfer(previousTransfers = previousTransfer, amount = amount)
        assertEquals(-1, result)
    }

    @Test
    fun onceTransferVKLimitTest() {
        val previousTransfer = 0
        val amount = 15_001

        val result = transfer(previousTransfers = previousTransfer, amount = amount)
        assertEquals(-1, result)
    }

    @Test
    fun transferVKLimitTest() {
        val previousTransfer = 50_000
        val amount = 30_000

        val result = transfer(previousTransfers = previousTransfer, amount = amount)
        assertEquals(-1, result)
    }

    @Test
    fun previousTransferOtherLimitTest() {
        val previousTransfer = 450_000
        val amount = 200_000

        val result = transfer(type = TYPE_MAESTRO, previousTransfers = previousTransfer, amount = amount)
        assertEquals(-1, result)
    }

    @Test
    fun onceTransferOtherLimitTest() {
        val previousTransfer = 0
        val amount = 160_000

        val result = transfer(type = TYPE_VISA, previousTransfers = previousTransfer, amount = amount)
        assertEquals(-1, result)
    }

    @Test
    fun transferOtherLimitTest() {
        val previousTransfer = 750_000
        val amount = 100

        val result = transfer(type = TYPE_MAESTRO, previousTransfers = previousTransfer, amount = amount)
        assertEquals(-1, result)
    }

    //transfer Fee
    @Test
    fun transferPerMonthMMTest() {
        val previousTransfer = 50_000
        val amount = 35_000

        val result = transfer(previousTransfers = previousTransfer, type = TYPE_MAESTRO, amount = amount)
        assertEquals(230, result)
    }

    @Test
    fun transferOtherTest() {
        val amount = 100

        val result = transfer(type = TYPE_MAESTRO, amount = amount)
        assertEquals(0, result)
    }

    @Test
    fun beforeTransferPerMonthMaestroTest() {
        val amount = 1000

        val result = transfer(type = TYPE_MAESTRO, amount = amount)
        assertEquals(0, result)
    }

    @Test
    fun beforeTransferPerMonthMastercardTest() {
        val amount = 1000

        val result = transfer(type = TYPE_MASTERCARD, amount = amount)
        assertEquals(0, result)
    }

    @Test
    fun beforeMinTransferFeeVisa() {
        val amount = 10

        val result = transfer(type = TYPE_VISA, amount = amount)
        assertEquals(35, result)
    }

    @Test
    fun beforeMinTransferFeeMir() {
        val amount = 10

        val result = transfer(type = TYPE_MIR, amount = amount)
        assertEquals(35, result)
    }

    @Test
    fun minTransferFeeVM() {
        val amount = 5500

        val result = transfer(type = TYPE_VISA, amount = amount)
        assertEquals(41, result)
    }

    @Test
    fun transferFeeVK() {
        val amount = 300

        val result = transfer(type = TYPE_VK, amount = amount)
        assertEquals(0, result)
    }

    @Test
    fun transferWrongType() {
        val amount = 100

        val result = transfer(type = "Same", amount = amount)
        assertEquals(-2, result)
    }

}