package bank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankService {

    /**
     * 입금 메서드
     * @param bankAccount 계좌매핑 정보
     * @param amount 입금액
     */
    public void deposit(BankAccount bankAccount, int amount) {
        bankAccount.getAccount().deposit(amount);
    }

    /**
     * 출금 메서드
     * @param bankAccount  계좌매핑 정보
     * @param amount 출금액
     */
    public void withdrawal(BankAccount bankAccount, int amount) {
        bankAccount.getAccount().withdrawal(amount);
    }

    /**
     * 송금 메서드
     * @param sender    송신자
     * @param receiver  수신자
     * @param amount   송금액
     */
    public void transfer(BankAccount sender, BankAccount receiver, int amount) {
        sender.getAccount().withdrawal(amount);
        receiver.getAccount().deposit(amount);
    }

    /**
     * 잔액 출력 메서드
     * @param bankAccount   계좌매핑 정보
     */
    public void printBalance(BankAccount bankAccount) {
        System.out.println(bankAccount.getUser().getName() + "의 잔고 : " + bankAccount.getAccount().getBalance());
    }


//    private static long accountCounterNumber = 1000000000L;
//    Map<Long, BankAccount> accountMap = new HashMap<Long, BankAccount>();
//    Map<Long, User> userMap = new HashMap<Long,User>();
//    Map<String, User> userNameMap = new HashMap<>();
//
//
//    public void createUser(String name, long account) throws IOException {
//        FileWriter fw = new FileWriter("./BankService.txt",true);
//        BankAccount bankAccount = new BankAccount();
//        bankAccount.setAccountNumber(account);
//        long accountNumber = accountCounterNumber++;
//        bankAccount.setAccountNumber(accountNumber);
//        try {
//            if(getUserName(name) != null){
//
//                // todo JSON serialize/deserialize 를 사용하여 객체를 복사하고, 객체를 복사하여 새로운 객체를 생성합니다.
//                System.out.println("이미 존재하는 회원입니다.");
//            }else{
//                User user = new User();  // 고유 ID 설정
//                user.setName(name);
//                userNameMap.put(name, user);
//                userMap.put(user.getId(), user);
//                accountMap.put(accountNumber, bankAccount);
//                user.setBankAccount(bankAccount);
//                bankAccount.setUser(user);
//                fw.write("이름"+name +" : 계좌번호"+accountNumber + "\n");
//                fw.flush();
//                System.out.println("회원가입이 완료되었습니다.");
//                System.out.println("계좌가 생성되었습니다. 계좌번호 : " + accountNumber);
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            fw.close();
//        }
//    }
//
//    public User getUserName(String name){
//        return userNameMap.get(name);
//    }
//
//    public void selectUser(String name) {
//        User user = getUserName(name);
//        if (user != null) {
//            BankAccount account = user.getBankAccount();
//            if (account != null) {
//                System.out.println("회원이름 : " + user.getName());
//                System.out.println("계좌번호 : " + account.getAccountNumber());
//                System.out.println("잔액 : " + account.getBalance());
//            } else {
//                System.out.println("해당 회원의 계좌가 없습니다.");
//            }
//        } else {
//            System.out.println("해당 회원이 존재하지 않습니다.");
//        }
//    }
//
//    public BankAccount getUserAccount(Long bankAccount){
//        return accountMap.get(bankAccount);
//    }
//
//    public void deleteUser(String name){
//        if (getUserName(name) != null) {
//            System.out.println("회원 " + name + "이(가) 삭제되었습니다.");
//            userNameMap.remove(name);
//        } else {
//            System.out.println("해당 회원이 존재하지 않습니다.");
//        }
//    }
}
