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


import org.greenrobot.greendao.AbstractDao;

import end.liuwen.com.greendao.Entity.student;

/**
 * Created by liuwen on 2016/12/26.
 */
public class StudentHelper extends BaseDbHelper<student, Long> {

    public StudentHelper(AbstractDao dao) {
        super(dao);
    }
}
