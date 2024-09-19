package bank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccount {
   private Account account;
   private User user;

   public BankAccount(Account account, User user) {
      this.account = account;
      this.user = user;
   }

   //   public void money(BankService bankService,Long account) throws IOException {
//      FileWriter fw = new FileWriter("./BankLog.txt",true);
//      System.out.println("1. 입금 2. 출금");
//      int select = sc.nextInt();
//      System.out.println("이름을 입력하세요");
//      String name = sc.next();
//      User userMoney = bankService.getUserName(name);
//      if (userMoney != null) {
//         BankAccount bankAccount = userMoney.getBankAccount();
//         if (bankService.getUserAccount(account) != null) {
//            if (select == 1) {
//               System.out.println("금액을 입력하세요");
//               int addMoney = sc.nextInt();
//               bankAccount.deposit(addMoney);
//               System.out.println("입금이 완료되었습니다. 현재 잔액: " + bankAccount.getBalance());
//               fw.write("이름"+name +"입금"+ addMoney + "\n");
//               fw.flush();
//            } else if (select == 2) {
//               System.out.println("금액을 입력하세요");
//               int minusMoney = sc.nextInt();
//               bankAccount.withdrawal(minusMoney);
//               System.out.println("출금이 완료되었습니다. 현재 잔액: " + bankAccount.getBalance());
//               fw.write("이름"+name +"출금"+ minusMoney + "\n");
//               fw.flush();
//            } else {
//               System.out.println("잘못된 선택입니다.");
//            }
//         } else {
//            System.out.println("계좌번호를 생성하세요.");
//         }
//      }else{
//         System.out.println("일치하지 않는 회원입니다.");
//      }
//   }
//
//
//   // todo 주석달기, moveMoney --> transfer
//   public void moveMoney(BankService bankService,Long account) throws IOException {
//      FileWriter fw = new FileWriter("./BankLog.txt",true);
//      System.out.println("이름을 입력하세요");
//      String name = sc.next();
//      User sender = bankService.getUserName(name);
//      if (sender != null) {
//         BankAccount bankAccount = sender.getBankAccount();
//         if (bankService.getUserAccount(account) != null) {
//            System.out.println("금액을 입력하세요");
//            int moveMoney = sc.nextInt();
//            System.out.println("이체하실 상대의 이름을 입력하세요");
//            String name2 = sc.next();
//            User receiver = bankService.getUserName(name2);
//            if (bankService.getUserName(name2) != null) {
//               sender.getBankAccount().withdrawal(moveMoney);
//               receiver.getBankAccount().deposit(moveMoney);
//               System.out.println("이체가 완료되었습니다." +"잔액"+ bankAccount.getBalance());
//               fw.write("from"+name +"to" + name2 + moveMoney + "\n");
//               fw.flush();
//            } else {
//               System.out.println("일치하지 않는 회원입니다.");
//            }
//         } else {
//            System.out.println("일치하지 않는 회원입니다.");
//         }
//      }else {
//         System.out.println("계좌번호를 생성하세요.");
//      }
//   }

}
