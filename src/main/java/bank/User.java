package bank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private long id; //유저 아이디
    private String name; //사용자 이름

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
