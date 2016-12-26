package end.liuwen.com.greendao.db;

import org.greenrobot.greendao.AbstractDao;

import end.liuwen.com.greendao.Entity.UserInfo;

/**
 * Created by liuwen on 2016/12/26.
 */
public class UserInfoHelper extends BaseDbHelper<UserInfo, Long> {

    public UserInfoHelper(AbstractDao dao) {
        super(dao);
    }
}
