package example.com.cloud;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class TitleBarHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_bar_home);
//        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mToolbar);
//        ActionBar ab = getSupportActionBar();
//        assert ab != null;
//        ab.setHomeAsUpIndicator(R.drawable.ic_launcher);
//        //设置home图标是否显示
//        ab.setDisplayHomeAsUpEnabled(true);
    }

}
