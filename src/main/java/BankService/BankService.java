package BankService;

import BankAccount.BankAccount;
import User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class BankService {

    private static long accountCounterNumber = 1000000000L;
    Map<Long, BankAccount> accountMap = new HashMap<Long, BankAccount>();
    Map<Long, User> userMap = new HashMap<Long,User>();
    Map<String, User> userNameMap = new HashMap<>();


    public void createUser(String name, long account) throws IOException {
        FileWriter fw = new FileWriter("./BankService.txt",true);
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(account);
        long accountNumber = accountCounterNumber++;
        bankAccount.setAccountNumber(accountNumber);
        try {
            if(getUserName(name) != null){
                System.out.println("이미 존재하는 회원입니다.");
            }else{
                User user = new User();  // 고유 ID 설정
                user.setName(name);
                userNameMap.put(name, user);
                userMap.put(user.getId(), user);
                accountMap.put(accountNumber, bankAccount);
                user.setBankAccount(bankAccount);
                bankAccount.setUser(user);
                fw.write("이름"+name +" : 계좌번호"+accountNumber + "\n");
                fw.flush();
                System.out.println("회원가입이 완료되었습니다.");
                System.out.println("계좌가 생성되었습니다. 계좌번호 : " + accountNumber);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            fw.close();
        }
    }

    public User getUserName(String name){
        return userNameMap.get(name);
    }

    public void selectUser(String name) {
        User user = getUserName(name);
        if (user != null) {
            BankAccount account = user.getBankAccount();
            if (account != null) {
                System.out.println("회원이름 : " + user.getName());
                System.out.println("계좌번호 : " + account.getAccountNumber());
                System.out.println("잔액 : " + account.getBalance());
            } else {
                System.out.println("해당 회원의 계좌가 없습니다.");
            }
        } else {
            System.out.println("해당 회원이 존재하지 않습니다.");
        }
    }

    public BankAccount getUserAccount(Long bankAccount){
        return accountMap.get(bankAccount);
    }

    public void deleteUser(String name){
        if (getUserName(name) != null) {
            System.out.println("회원 " + name + "이(가) 삭제되었습니다.");
            userNameMap.remove(name);
        } else {
            System.out.println("해당 회원이 존재하지 않습니다.");
        }
    }
}
