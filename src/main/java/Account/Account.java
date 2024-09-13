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
    private long accountNumber; // 계좌번호
    private int balance; //잔고
    private long accountNumberCount = 1000000000L;
    private Scanner sc = new Scanner(System.in);
    BankService bankService = new BankService();

    public Account(BankService bankService) {
        this.bankService = bankService;
    }


    public void createAccount(User user, BankAccount account, BankService bankService){
        System.out.println("계좌생성");
        System.out.println("이름을 입력하세요");
        String name = sc.next();
        if(bankService.getUserName(name) != null){
            this.accountNumber = accountNumberCount++;
            System.out.println(accountNumber + "생성이 완료되었습니다.");
            bankService.createAccount(this.accountNumber, account);
        }else{
            System.out.println("존재하지 않는 회원입니다.");
        }
        System.out.println("계좌번호");
    }

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

    public void checkMoney(User user,BankService bankService){
        System.out.println("이름을 입력하세요");
        String name = sc.next();
        if(bankService.getUserName(name) != null){
            System.out.println(getBalance());
        }else{
            System.out.println("일치하지 않는 회원입니다.");
        }
    }
}
