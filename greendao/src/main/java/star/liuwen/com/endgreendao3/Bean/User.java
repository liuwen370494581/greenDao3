package star.liuwen.com.endgreendao3.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by liuwen on 2017/6/21.
 */
@Entity
public class User {

    @Id
    private long id;
    private String userName;
    private String Code;
    private String Fneshu;
    private int age;
    @Transient
    private String gender;
    private String six;

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFneshu() {
        return this.Fneshu;
    }

    public void setFneshu(String Fneshu) {
        this.Fneshu = Fneshu;
    }

    public String getCode() {
        return this.Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSix() {
        return this.six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    @Generated(hash = 628452955)
    public User(long id, String userName, String Code, String Fneshu, int age,
            String six) {
        this.id = id;
        this.userName = userName;
        this.Code = Code;
        this.Fneshu = Fneshu;
        this.age = age;
        this.six = six;
    }

    @Generated(hash = 586692638)
    public User() {
    }
}
