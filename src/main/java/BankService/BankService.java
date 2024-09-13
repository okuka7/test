package BankService;

import BankAccount.BankAccount;
import User.User;

import java.util.HashMap;
import java.util.Map;

public class BankService {
    Map<Long, BankAccount> accountMap = new HashMap<Long, BankAccount>();
    Map<Long, User> userMap = new HashMap<Long,User>();
    Map<String, User> userNameMap = new HashMap<>();

    public void createUser(User user) {
        userMap.put(user.getId(), user);
        userNameMap.put(user.getName(), user);
    }

    public User getUserName(String name){
        return userNameMap.get(name);
    }

    public BankAccount getUserAccount(Long bankAccount){
        return accountMap.get(bankAccount);
    }

    public void createAccount(long accountNumber, BankAccount account) {
        accountMap.put(accountNumber, account);
        System.out.println("계좌가 생성되었습니다. 계좌번호: " + accountNumber);
    }

    public void deleteUser(User user){
        userNameMap.remove(user.getName());
        userMap.remove(user.getId());
    }
}
