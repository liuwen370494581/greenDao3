package star.liuwen.com.endgreendao3.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by liuwen on 2017/6/21.
 */
@Entity
public class Test {
    @Id
    private Long id;
    private int url;
    private String name;
    private String desc;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUrl() {
        return this.url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Generated(hash = 542938339)
    public Test(Long id, int url, String name, String desc) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.desc = desc;
    }

    @Generated(hash = 372557997)
    public Test() {
    }
}
