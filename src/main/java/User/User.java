package User;

import Account.Account;
import BankAccount.BankAccount;
import BankService.BankService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private static long userId = 1;
    private long id; //유저 아이디
    private String name; //사용자 이름
    private Account account;
    @Getter
    private BankAccount bankAccount;
    Scanner sc = new Scanner(System.in);


    public void createUser(BankService bankService,long accountNumber) throws IOException {
        System.out.println("회원가입");
        System.out.println("----");
        System.out.println("이름 입력");
        String inputName = sc.next();
        bankService.createUser(inputName,accountNumber);
    }
    public void selectOneUser(BankService bankService,BankAccount account){
        System.out.println("이름을 입력하세요");
        String name = sc.next();
        bankService.selectUser(name);
    }

    public void deleteUser(BankService bankService){
        System.out.println("이름을 입력하세요");
        String name = sc.next();
        bankService.deleteUser(name);


    }
}
