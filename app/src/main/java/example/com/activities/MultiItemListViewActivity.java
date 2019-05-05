package example.com.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.zhy.adapter.abslistview.CommonAdapter;

import example.com.adapter.lv.ChatAdapter;
import example.com.cloud.R;
import example.com.dataitems.ChatMessage;


public class MultiItemListViewActivity extends AppCompatActivity
{

    private ListView mListView;
    private CommonAdapter mAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mListView = (ListView) findViewById(R.id.id_listview_list);
        mListView.setDivider(null);
        mListView.setAdapter(new ChatAdapter(this, ChatMessage.MOCK_DATAS));

    }

}
