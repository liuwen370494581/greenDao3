package star.liuwen.com.endgreendao3.Base;

import android.app.Application;

import star.liuwen.com.endgreendao3.DaoHelper.DaoManager;

/**
 * Created by liuwen on 2017/6/21.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DaoManager.init(this);
    }
}
