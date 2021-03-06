package module9.practice

class CreditCard1(balance: Int) : CreditCard(balance = balance) {
    private var potentialCashback = 0.05
    private var cashbackMax = 0.1
    private var cashback: Double = 0.0
    private var sumPay = 0
    private val cashForCashbackLevelUp = 50000


    // каждые 50к покупки +1% кэшбэк до 10% кэшбэк
    override fun pay(cashOut: Int): Boolean {
        return if (super.pay(cashOut)) {
            sumPay += cashOut
            cashback = cashOut * potentialCashback

            while (sumPay > cashForCashbackLevelUp && potentialCashback < cashbackMax) {
                potentialCashback += 0.01
                sumPay -= cashForCashbackLevelUp
            }
            deposit(cashback.toInt())
            true
        } else false
    }

    override fun getBalanceInfo(): Int {
        println("Credit card percentage: $potentialCashback")
        println("Credit card minimal maximun cashback: $cashbackMax")
        println("Credit card minimal current pay cashback: $cashback")
        println("Credit card minimal current sumPay: $sumPay")
        return super.getBalanceInfo()
    }
}