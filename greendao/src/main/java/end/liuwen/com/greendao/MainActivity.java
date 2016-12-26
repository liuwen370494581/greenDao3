package end.liuwen.com.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import end.liuwen.com.greendao.Entity.student;
import end.liuwen.com.greendao.dao.studentDao;
import end.liuwen.com.greendao.db.DbUtil;
import end.liuwen.com.greendao.db.StudentHelper;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DaoAdapter mAdapter;
    private List<student> mStudent = new ArrayList<>();
    private List<student> dStudent = new ArrayList<>();
    private StudentHelper mHelper;
    private Random random;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.greendao_recycler);
        mAdapter = new DaoAdapter(recyclerView);
        mHelper = DbUtil.getDriverHelper();
        random = new Random();
        LinearLayoutManager linear = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linear);
        if (mHelper.queryAll() != null) {
            dStudent = mHelper.queryAll();
            mAdapter.setData(dStudent);
        }
        recyclerView.setAdapter(mAdapter);
    }

    public void add(View view) {
        long id = mHelper.count();

        //界面添加
        student stu = new student();
        stu.id = id + 1;
        stu.name = "Nauto_" + (id + 1);
        stu.age = random.nextInt(60) + "";
        stu.number = 6 + "" + (id + 1);
        stu.score = random.nextInt(100) + "";

        mStudent.add(stu);
        mAdapter.addFirstItem(stu);
        mHelper.save(stu);
    }

    public void delete(View view) {
        dStudent = mHelper.queryAll();
        if (dStudent.size() > 0) {
            student s = dStudent.get(dStudent.size() - 1);
            mHelper.delete(s);
            mAdapter.removeItem(dStudent.size() - 1);
        } else {
            showToast("没有多余的数据可以删除了");
        }

    }

    public void select(View view) {
        // student s = mHelper.queryBuilder().where(studentDao.Properties.Age.eq("25")).build().unique();
        //  student s = mHelper.queryBuilder().where(studentDao.Properties.Id.eq(10)).build().unique();
        student s = mHelper.queryBuilder().where(studentDao.Properties.Name.eq("Nauto_1")).build().unique();
        mStudent = mHelper.queryBuilder().where(studentDao.Properties.Age.eq("41")).build().list();
        //     mStudent.clear();
        dStudent.clear();
//        mStudent.add(s);
//        dStudent.add(s);
        mAdapter.setData(mStudent);
    }

    public void update(View view) {

    }

    public class DaoAdapter extends BGARecyclerViewAdapter<student> {
        public DaoAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, student model) {

            helper.setText(R.id.tv_id, model.id + "").setText(R.id.tv_name, model.name)
                    .setText(R.id.tv_age, model.age).setText(R.id.tv_number, model.number)
                    .setText(R.id.tv_score, model.number);

        }
    }

    /**
     * 防多次点击的吐司
     *
     * @param msg
     */
    public void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT);
        } else {
            mToast.show();
        }
    }

}
