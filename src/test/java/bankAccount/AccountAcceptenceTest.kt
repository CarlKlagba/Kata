package bankAccount

import org.junit.Test
import org.mockito.Mockito.verify

class AccountAcceptenceTest {

    @Test
    internal fun accenptenceTest() {
        val displayInterface: DisplayInterface = MockDisplayInterface()
        val accountPrinter = AccountPrinter(displayInterface)
        val account = Account(accountPrinter)

        account.deposit(Amount("1000"), Date("10-01-2012"))
        account.deposit(Amount("2000"), Date("13-01-2012"))
        account.withdrawal(Amount("500"), Date("14-01-2012"))

        account.printStatment()

        verify{
            displayInterface
                .print("""
            date       || credit   || debit    || balance
            14/01/2012 ||          || 500.00   || 2500.00
            13/01/2012 || 2000.00  ||          || 3000.00
            10/01/2012 || 1000.00  ||          || 1000.00
            """)
        }
    }


}

class MockDisplayInterface: DisplayInterface {
    override fun print(s: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

