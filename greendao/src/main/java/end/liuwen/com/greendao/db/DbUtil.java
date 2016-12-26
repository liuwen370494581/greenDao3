/*
******************************* Copyright (c)*********************************\
**
**                 (c) Copyright 2015, 蒋朋, china, qd. sd
**                          All Rights Reserved
**
**                           By()
**                         
**-----------------------------------版本信息------------------------------------
** 版    本: V0.1
**
**------------------------------------------------------------------------------
********************************End of Head************************************\
*/

package end.liuwen.com.greendao.db;


import end.liuwen.com.greendao.dao.UserInfoDao;
import end.liuwen.com.greendao.dao.studentDao;

/**
 * Created by liuwen on 2016/12/26.
 */
public class DbUtil {
    private static StudentHelper sStudentHelper;
    private static UserInfoHelper userInfoHelper;


    private static studentDao getDriverDao() {
        return DbCore.getDaoSession().getStudentDao();
    }

    public static StudentHelper getDriverHelper() {
        if (sStudentHelper == null) {
            sStudentHelper = new StudentHelper(getDriverDao());
        }
        return sStudentHelper;
    }


    private static UserInfoDao getUserInfoDao() {
        return DbCore.getDaoSession().getUserInfoDao();
    }

    private static UserInfoHelper getUserInfoHelper() {
        if (userInfoHelper == null) {
            userInfoHelper = new UserInfoHelper(getUserInfoDao());
        }
        return userInfoHelper;
    }
}
