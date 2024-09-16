package Account;

import BankAccount.BankAccount;
import BankService.BankService;
import User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
@NoArgsConstructor
public class Account {
    private long accountNumber = 1000000000L; // 계좌번호
    private int balance; //잔고
    private Scanner sc = new Scanner(System.in);
    BankService bankService = new BankService();

    public void add(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    // 출금 메서드
    public void minus(int amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
        }
    }
}
