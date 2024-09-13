package User;

import Account.Account;
import BankService.BankService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private static long userId = 1;
    private long id; //유저 아이디
    private String name; //사용자 이름
    private Account account;
    Scanner sc = new Scanner(System.in);

    public void createUser(BankService bankService){
        System.out.println("회원가입");
        System.out.println("----");
        System.out.println("이름 입력");
        String inputName = sc.next();
        if(bankService.getUserName(inputName) != null){
            System.out.println("이미 존재하는 회원입니다.");
        }else{
            User user = new User();
            user.setName(inputName);        // 이름 설정
            user.setId(userId++);           // 고유 ID 설정
            user.setAccount(new Account()); // 새로운 계좌 생성

            System.out.println("회원가입이 완료되었습니다.");
            bankService.createUser(user);
        }
    }
    public void selectOneUser(BankService bankService){
        System.out.println("이름을 입력하세요");
        String name = sc.next();
        User user = bankService.getUserName(name);
        //bankService.getUserName(name) 에 저장되있는 이름으로가지고옴
        if(user != null){
            System.out.println("회원이름 : " + user.getName());
            System.out.println("계좌번호 : " + user.getAccount().getAccountNumber());
            System.out.println("잔액 : " + user.getAccount().getBalance());
        }else {
            System.out.println("해당회원이 존재하지 않습니다.");
        }
    }

    public void deleteUser(BankService bankService){
        System.out.println("이름을 입력하세요");
        String name = sc.next();
        User user = bankService.getUserName(name);
        if (user != null) {
            bankService.deleteUser(user);
            System.out.println("회원 " + user.getName() + "이(가) 삭제되었습니다.");
        } else {
            System.out.println("해당 회원이 존재하지 않습니다.");
        }

    }

}
