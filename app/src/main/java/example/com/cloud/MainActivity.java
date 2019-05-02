package example.com.cloud;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private CoordinatorFragment fragment1;
    private CoordinatorFragment fragment2;
    private CoordinatorFragment fragment3;
    private CoordinatorFragment fragment4;
    private CoordinatorFragment fragment5;
    private Fragment[] fragments;
    private int lastfragment;// 用于记录上个选择的Fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        initHttp();
    }



    //初始化fragment和fragment数组
    private void initFragment()
    {

        fragment1 = new CoordinatorFragment();
        fragment2 = new CoordinatorFragment();
        fragment3 = new CoordinatorFragment();
        fragment4 = new CoordinatorFragment();
        fragment5 = new CoordinatorFragment();
        fragments = new Fragment[]{fragment1,fragment2,fragment3,fragment4,fragment5};
        lastfragment=0;
        getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment1).show(fragment1).commit();
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_nav_view);

        //设置bottomNavigationView图标为UI本身颜色
//        bottomNavigationView.setItemIconTintList(null);//
        bottomNavigationView.setOnNavigationItemSelectedListener(changeFragment);
    }
    //判断选择的菜单
    private BottomNavigationView.OnNavigationItemSelectedListener changeFragment= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.action_home:
                {
                    if(lastfragment!=0)
                    {
                        switchFragment(lastfragment,0);
                        lastfragment=0;

                    }

                    return true;
                }
                case R.id.action_explore:
                {
                    if(lastfragment!=1)
                    {
                        switchFragment(lastfragment,1);
                        lastfragment=1;

                    }

                    return true;
                }
                case R.id.action_me:
                {
                    if(lastfragment!=2)
                    {
                        switchFragment(lastfragment,2);
                        lastfragment=2;

                    }

                    return true;
                }
                case R.id.action_to:
                {
                    if(lastfragment!=3)
                    {
                        switchFragment(lastfragment,3);
                        lastfragment=3;

                    }

                    return true;
                }
                case R.id.action_th:
                {
                    if(lastfragment!=4)
                    {
                        switchFragment(lastfragment,4);
                        lastfragment=4;

                    }

                    return true;
                }


            }


            return false;
        }
    };
    //切换Fragment
    private void switchFragment(int lastfragment,int index)
    {
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastfragment]);//隐藏上个Fragment
        if(fragments[index].isAdded()==false)
        {
            transaction.add(R.id.content_main,fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

    private void initHttp() {

//        public void testGet() {

            //创建OkHttpClient实例对象
            OkHttpClient okHttpClient = new OkHttpClient();

//            创建Request对象
            Request request = new Request.Builder()
                    .url("https://www.httpbin.org/get?id=111")
                    .addHeader("key","value")
                    .get()
                    .build();

//        Call call = okHttpClient.newCall(request);
        //请求加入调度
//        call.enqueue(new Callback()
//        {
//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(@NonNull Call call,@NonNull Response response) throws IOException {
//                assert response.body() != null;
//                Log.e("TestOkHttp",response.body().string());
//
//            }
//
//            public void onFailure(Request request, IOException e)
//            {
//            }
//
//            public void onResponse(final Response response) throws IOException
//            {
//                //String htmlStr =  response.body().string();
//            }
//        });
//            执行Request请求
            //异步请求
    okHttpClient.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            //请求失败
        }
        @Override
        public void onResponse(Call call, Response response) throws IOException {
            //请求成功
            Log.e        ("TestOkHttp",response.body().string());
        }
    });
            //同步请求
//            try {
//                Response response = okHttpClient.newCall(request).execute();
//                System.out.println(response.body().string());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

}