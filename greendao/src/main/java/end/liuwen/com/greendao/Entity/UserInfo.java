package end.liuwen.com.greendao.Entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by liuwen on 2016/12/26.
 */
@Entity
public class UserInfo {

    @Id
    public long id;
    public String name;
    public String tel;
    public String address;
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getTel() {
        return this.tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Generated(hash = 1615828856)
    public UserInfo(long id, String name, String tel, String address) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.address = address;
    }
    @Generated(hash = 1279772520)
    public UserInfo() {
    }

}
