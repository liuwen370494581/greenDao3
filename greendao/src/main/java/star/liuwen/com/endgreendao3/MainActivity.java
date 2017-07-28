package star.liuwen.com.endgreendao3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.androidcommon.adapter.BGARecyclerViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;
import star.liuwen.com.endgreendao3.Bean.Test;
import star.liuwen.com.endgreendao3.DaoHelper.DaoTest;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MyAdapter(mRecyclerView);
        final GridLayoutManager manager = new GridLayoutManager(this, 5, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        if (DaoTest.getCount() != 0) {
            mAdapter.setData(DaoTest.query());
        } else {
            mAdapter.setData(new ArrayList<Test>());
        }
        mRecyclerView.setAdapter(mAdapter);
    }

    public void onSelect(View view) {
        mAdapter.clear();
        if (DaoTest.getCount() == 0) {
            Toast.makeText(this, "暂无数据", Toast.LENGTH_SHORT).show();
            return;
        }
        mAdapter.setData(DaoTest.query());
    }

    public void onDelete(View view) {
        if (DaoTest.getCount() == 0) {
            Toast.makeText(this, "暂无数据", Toast.LENGTH_SHORT).show();
            return;
        } else {
            DaoTest.delete(DaoTest.getCount());
            mAdapter.setData(DaoTest.query());
        }
    }

    public void onAdd(View view) {
        DaoTest.insert(new Test(DaoTest.getCount() + 1, R.mipmap.huankuan, "还款", "还信用卡"));
        mAdapter.addItem(0, new Test(DaoTest.getCount() + 1, R.mipmap.huankuan, "还款", "还信用卡"));
    }

    public void onUpdate(View view) {
        if (DaoTest.getCount() != 0) {
            Test test = DaoTest.query().get(0);
            test.setName("飞机票");
            test.setUrl(R.mipmap.feijipiao);
            DaoTest.update(test);
            mAdapter.setData(DaoTest.query());
        } else {
            Toast.makeText(this, "暂无数据可以修改", Toast.LENGTH_SHORT).show();
            return;
        }
    }


    private class MyAdapter extends BGARecyclerViewAdapter<Test> {

        public MyAdapter(RecyclerView recyclerView) {
            super(recyclerView, R.layout.item_zhichu_fragment);
        }

        @Override
        protected void fillData(BGAViewHolderHelper helper, int position, Test model) {
            helper.setImageResource(R.id.item_imag, model.getUrl());
            helper.setText(R.id.item_name, model.getName());
            helper.setText(R.id.item_desc, model.getDesc());
        }
    }


}
