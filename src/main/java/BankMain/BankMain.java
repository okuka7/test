package BankMain;

import Account.Account;
import BankAccount.BankAccount;
import BankService.BankService;
import User.User;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        System.out.println("구구은행에 오신것을 환영합니다.");
        Account account = new Account();
        User user = new User();
        BankAccount bankAccount = new BankAccount();
        BankService bankService = new BankService();
        boolean power = true;
        Scanner sc = new Scanner(System.in);
        while(power){
            System.out.println("이용할 서비스를 입력하세요");
            System.out.println("1. 회원가입 2. 계좌생성 3. 입금 및 출금 4.계좌이체 5.회원정보 6. 회원탈퇴 7. 나가기");
            int select = sc.nextInt();
            switch (select){
                case 1: user.createUser(bankService); break; // 회원가입
                case 2: account.createAccount(user,bankAccount,bankService);break; // 계좌생성
                case 3: bankAccount.money(bankService,account.getAccountNumber());break; // 입금 및 출금
                case 4: bankAccount.moveMoney(bankService,account.getAccountNumber());break;//계좌이제
                case 5: user.selectOneUser(bankService);break; // 회원정보
                case 6: user.deleteUser(bankService);break; // 회원탈퇴
                case 7: power = false; break; // 나가기
            }
        }
    }

}
