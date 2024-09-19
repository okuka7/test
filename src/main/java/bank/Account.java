package bank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {
    private String accountNumber; // 계좌번호
    private int balance; //잔고

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    /**
     * 입금 메서드
     * @param amount 입금액
     */
    public void deposit(int amount) {
        // validation check logic
        if(amount <= 0) {
            throw new RuntimeException("입금액은 0보다 커야합니다.");
        }

        this.balance += amount;
    }

    /**
     * 출금 메서드
     * @param amount 출금액
     */
    public void withdrawal(int amount) {
        // validation check logic
        if(amount <= 0) {
            throw new RuntimeException("출금액은 0보다 커야합니다.");
        }

        if(this.balance < amount) {
            throw new RuntimeException("잔액이 부족합니다.");
        }

        this.balance -= amount;
    }
}
