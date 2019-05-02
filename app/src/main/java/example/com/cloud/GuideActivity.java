package example.com.cloud;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity {


    private ViewPager view_page;

    //滑动页面的数量
    private List<View> tabViews;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        tabViews = new ArrayList<>();
        //初始化数据
        initData();

        view_page = (ViewPager) findViewById(R.id.view_page);
        //设置适配器
        view_page.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return tabViews.size();//
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(tabViews.get(position));
                //滑到最后一个页面，显示button
                if(position == tabViews.size()-1)
                {
                    Button button= (Button) tabViews.get(position).findViewById(R.id.button);
                    button.setVisibility(View.VISIBLE);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(GuideActivity.this,"你要的操作",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                return tabViews.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(tabViews.get(position));
            }
        });




    }

    private void initData() {
        //引入一个布局，三个共用，设置不同的背景图片
        LayoutInflater tabs = LayoutInflater.from(GuideActivity.this);
        View tab1 = tabs.inflate(R.layout.guide2, null);
        tab1.setBackgroundResource(R.drawable.ic_image3);

        View tab2 = tabs.inflate(R.layout.guide2, null);
        tab2.setBackgroundResource(R.drawable.ic_image3);
        View tab3 = tabs.inflate(R.layout.guide2, null);

        tab3.setBackgroundResource(R.drawable.ic_image3);

        //添加到列表里
        tabViews.add(tab1);
        tabViews.add(tab2);
        tabViews.add(tab3);

    }




}