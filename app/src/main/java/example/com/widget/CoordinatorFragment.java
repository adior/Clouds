package example.com.widget;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import example.com.adapter.MyRecyclerAdapter;
import example.com.cloud.R;

/**
 * Created by IT-CTY on 2018/4/25.
 */

public class CoordinatorFragment extends Fragment {

    public String TAG = "RECYCLE";
    private RecyclerView mRecycleView;
//    private RecyclerView mRecycleView1;
    private List<String> mData;
//    private List<String> mData1;
    private MyRecyclerAdapter myRecyclerAdapter;
//    private MyAdapter myAdapter1;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TabLayout mytab;
    private TextView textView;
    private Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.coordinator,container,false);
        mRecycleView = (RecyclerView)view.findViewById(R.id.recycler_view_coor);

        mRecycleView.setItemViewCacheSize(20);
                //view.home_recyclerview.setItemViewCacheSize(20));
//        mRecycleView1 = (RecyclerView)view.findViewById(R.id.recycler_view_coor1);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh);
        mytab = view.findViewById(R.id.mytab);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initrefresh();
        initdata();
        initview();
        inittab();


    }



    //
//
    private void initdata() {
        mData = new ArrayList<String>();
//        mData1 = new ArrayList<String>();
        for (int i = 0; i < 43; i++) {
            mData.add("item" + i);
            Log.i(TAG, "initdata: item" + i);
        }
//        for (int k = 0; k < 12; k++) {
//            mData1.add("itemok" + k);
//            Log.i(TAG, "initdata: itemok" + k);
//        }
    }
//
    private void initview() {

        myRecyclerAdapter = new MyRecyclerAdapter(getContext(), mData);
//        myAdapter1 = new MyAdapter(getContext(), mData1);
        mRecycleView.setAdapter(myRecyclerAdapter);//设置适配器
//        mRecycleView1.setAdapter(myAdapter1);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
//        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(), 2);

        //设置布局管理器 , 将布局设置成纵向

        mRecycleView.setLayoutManager(gridLayoutManager);
//        mRecycleView1.setLayoutManager(gridLayoutManager1);

        //设置分隔线
        //mRecycleView.addItemDecoration(new DividerItemDecoration(this , DividerItemDecoration.VERTICAL_LIST));

        //设置增加或删除条目动画
        mRecycleView.setItemAnimator(new DefaultItemAnimator());
//        mRecycleView1.setItemAnimator(new DefaultItemAnimator());

    }

    private void initrefresh(){


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

    private void inittab() {
        mytab.addTab(mytab.newTab().setText("筛选").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("分类").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("推荐").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("全部").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("优选").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("精选").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("陪玩").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("陪聊").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("陪吃").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("陪逛街").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("选项卡五").setIcon(R.mipmap.ic_launcher));
        mytab.addTab(mytab.newTab().setText("选项卡六").setIcon(R.mipmap.ic_launcher));
    }
}