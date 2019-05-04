package example.com.cloud;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import example.com.adapter.MyRecyclerAdapter;
import example.com.cloud.R;


public class CoordinatorActivity extends AppCompatActivity {

    public String TAG = "RECYCLE";
    private RecyclerView mRecycleView;
    private List<String> mData;
    private MyRecyclerAdapter myAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator);

        initrefresh();

        initdata();
        initview();
//        toolbar();


    }

    private void initdata() {
        mData = new ArrayList<String>();
        for (int i = 0; i < 43; i++) {
            mData.add("item" + i);
            Log.i(TAG, "initdata: item" + i);
        }
    }

    private void initview() {

        mRecycleView = (RecyclerView) findViewById(R.id.recycler_view_coor);

        myAdapter = new MyRecyclerAdapter(this, mData);
        mRecycleView.setAdapter(myAdapter);//设置适配器


        //设置布局管理器 , 将布局设置成纵向
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecycleView.setLayoutManager(gridLayoutManager);

        //设置分隔线
        //mRecycleView.addItemDecoration(new DividerItemDecoration(this , DividerItemDecoration.VERTICAL_LIST));

        //设置增加或删除条目动画
        mRecycleView.setItemAnimator(new DefaultItemAnimator());

    }

    private void initrefresh(){

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });

        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
    }


    private void toolbar() {
//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myAdapter.addData(1);
//            }
//        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.nav_menu, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        switch (id) {
//            case R.id.action_gridview:
//                /**
//                 * GridLayoutManager(xx1 , xx2);
//                 * 参数1： content
//                 * 参数2： 列数
//                 * **/
//                mRecycleView.setLayoutManager(new GridLayoutManager(this, 3));
//                break;
//            case R.id.action_listview:
//                /**
//                 * 默认样式
//                 *
//                 * 垂直列表
//                 * **/
//                mRecycleView.setLayoutManager(new LinearLayoutManager(this));
//                break;
//            /**
//             *水平显示
//             *
//             * 参数1：列数
//             * 参数2：水平显示
//             * **/
//            case R.id.action_settings:
//                mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(5,
//                        StaggeredGridLayoutManager.HORIZONTAL));
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }




}