package end.liuwen.com.greendao.App;

import android.app.Application;

import end.liuwen.com.greendao.db.DbCore;

/**
 * Created by liuwen on 2016/12/26.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DbCore.init(this);//初始化
        DbCore.enableQueryBuilderLog();// 开启调试模式
    }
}
