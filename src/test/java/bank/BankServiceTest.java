package bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankServiceTest {

    @Test
    public void testDeposit() {
        // given
        Account account = new Account("1234");

        // when
        account.deposit(1000);

        // then
        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void testWithdrawal() {
        // given
        Account account = new Account("1234");
        account.deposit(1000);

        // when
        account.withdrawal(600);

        // then
        Assertions.assertEquals(400, account.getBalance());
    }

    @Test
    public void testWithdrawalWithNotEnoughBalance() {
        // given
        Account account = new Account("1234");
        account.deposit(2000);

        // when
        // then
        Assertions.assertThrows(RuntimeException.class, () -> account.withdrawal(2000));
    }

    @Test
    public void test() {
        BankAccount sender = new BankAccount(new Account("1234"), new User(1L, "홍길동"));
        BankAccount receiver = new BankAccount(new Account("5678"), new User(2L, "이순신"));

        BankService bankService = new BankService();
        bankService.deposit(sender, 1000);
        bankService.printBalance(sender);   // 1000

        bankService.withdrawal(sender, 100);
        bankService.printBalance(sender);   // 900

        bankService.transfer(sender, receiver, 800);
        bankService.printBalance(sender);   // 100
        bankService.printBalance(receiver); // 800
    }
}