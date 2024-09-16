package BankAccount;

import Account.Account;
import BankService.BankService;
import User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

@NoArgsConstructor
@Getter
@Setter
public class BankAccount extends Account {
   private User user;
   Scanner sc = new Scanner(System.in);

   public void money(BankService bankService,Long account) {
      System.out.println("1. 입금 2. 출금");
      int select = sc.nextInt();
      System.out.println("이름을 입력하세요");
      String name = sc.next();
      User userMoney = bankService.getUserName(name);
      if (userMoney != null) {
         BankAccount bankAccount = userMoney.getBankAccount();
         if (bankService.getUserAccount(account) != null) {
            if (select == 1) {
               System.out.println("금액을 입력하세요");
               int addMoney = sc.nextInt();
               bankAccount.add(addMoney);
               System.out.println("입금이 완료되었습니다. 현재 잔액: " + bankAccount.getBalance());
            } else if (select == 2) {
               System.out.println("금액을 입력하세요");
               int minusMoney = sc.nextInt();
               bankAccount.minus(minusMoney);
               System.out.println("출금이 완료되었습니다. 현재 잔액: " + bankAccount.getBalance());
            } else {
               System.out.println("잘못된 선택입니다.");
            }
         } else {
            System.out.println("계좌번호를 생성하세요.");
         }
      }else{
         System.out.println("일치하지 않는 회원입니다.");
      }
   }



   public void moveMoney(BankService bankService,Long account) {
      System.out.println("이름을 입력하세요");
      String name = sc.next();
      User sender = bankService.getUserName(name);
      if (sender != null) {
         BankAccount bankAccount = sender.getBankAccount();
         if (bankService.getUserAccount(account) != null) {
            System.out.println("금액을 입력하세요");
            int moveMoney = sc.nextInt();
            System.out.println("이체하실 상대의 이름을 입력하세요");
            String name2 = sc.next();
            User receiver = bankService.getUserName(name2);
            if (bankService.getUserName(name2) != null) {
               sender.getBankAccount().minus(moveMoney);
               receiver.getBankAccount().add(moveMoney);
               System.out.println("이체가 완료되었습니다." +"잔액"+ bankAccount.getBalance());
            } else {
               System.out.println("일치하지 않는 회원입니다.");
            }
         } else {
            System.out.println("일치하지 않는 회원입니다.");
         }
      }else {
         System.out.println("계좌번호를 생성하세요.");
      }
   }

}
