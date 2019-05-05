package example.com.adapter.lv;

import android.content.Context;

import com.zhy.adapter.abslistview.MultiItemTypeAdapter;
import java.util.List;

import example.com.dataitems.ChatMessage;

/**
 * Created by zhy on 15/9/4.
 */
public class ChatAdapter extends MultiItemTypeAdapter<ChatMessage>
{
    public ChatAdapter(Context context, List<ChatMessage> datas)
    {
        super(context, datas);

        addItemViewDelegate(new MsgSendItemDelagate());
        addItemViewDelegate(new MsgComingItemDelagate());
    }

}
