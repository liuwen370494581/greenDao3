package star.liuwen.com.endgreendao3.DaoHelper;

import java.util.List;

import star.liuwen.com.endgreendao3.Bean.Test;

/**
 * Created by liuwen on 2017/6/21.
 */
public class DaoTest {


    /**
     * 插入对象数据
     * 插入对象为BudgetModel
     *
     * @param model
     */
    public static void insert(Test model) {
        DaoManager.getInstance().getDaoSession().getTestDao().insert(model);
    }

    /**
     * 删除指定的model的数据
     *
     * @param id
     */
    public static void delete(Long id) {
        DaoManager.getInstance().getDaoSession().getTestDao().deleteByKey(id);
    }


    /**
     * 删除所有
     */
    public static void deleteAllData() {
        DaoManager.getInstance().getDaoSession().getTestDao().deleteAll();
    }


    /**
     * 更新数据
     *
     * @param model
     */
    public static void update(Test model) {
        DaoManager.getInstance().getDaoSession().getTestDao().update(model);
    }

    /**
     * 查询 BudgetModel的集合对象
     *
     * @return
     */
    public static List<Test> query() {
        return DaoManager.getInstance().getDaoSession().getTestDao().queryBuilder().list();
    }


    /**
     * 获取总数
     *
     * @return
     */
    public static long getCount() {
        return DaoManager.getInstance().getDaoSession().getTestDao().count();
    }
}
