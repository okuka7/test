package BankMain;

import Account.Account;
import BankAccount.BankAccount;
import BankService.BankService;
import User.User;

import java.io.IOException;
import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) throws IOException {
        System.out.println("구구은행에 오신것을 환영합니다.");
        Account account = new Account();
        User user = new User();
        BankAccount bankAccount = new BankAccount();
        BankService bankService = new BankService();
        boolean power = true;

        Scanner sc = new Scanner(System.in);
        while(power){
            System.out.println("이용할 서비스를 입력하세요");
            System.out.println("1. 회원가입 2. 입금 및 출금 3.계좌이체 4.회원정보 5. 회원탈퇴 6. 나가기");
            int select = sc.nextInt();
            switch (select){
                case 1: user.createUser(bankService,account.getAccountNumber()); break; // 회원가입
                case 2: bankAccount.money(bankService,account.getAccountNumber());break; // 입금 및 출금
                case 3: bankAccount.moveMoney(bankService,account.getAccountNumber());break;//계좌이제
                case 4: user.selectOneUser(bankService,bankAccount);break; // 회원정보
                case 5: user.deleteUser(bankService);break; // 회원탈퇴
                case 6: power = false; break; // 나가기
            }
        }
    }

}
