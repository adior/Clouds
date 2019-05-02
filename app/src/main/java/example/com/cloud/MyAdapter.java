package example.com.cloud;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by guwei on 16-7-28.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private LayoutInflater inflater;
    private Context mContext;
    private List<String> mDatas;

    //创建构造参数
    MyAdapter(Context context, List<String> datas){
        this.mContext = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(context);
    }

//    public MyAdapter(CoordinatorFragment coordinatorFragment, List<String> data) {
//    }

    //创建ViewHolder
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycleview_item , parent , false);

        //图片显示方式设置-自定义
        ImageView mImageView = view.findViewById(R.id.imageView);
        ImageViewTool.matchAll(mContext,mImageView,2);
        return new MyViewHolder(view);
    }

    //绑定ViewHolder
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //为textview 赋值
        holder.tv.setText(mDatas.get(position));
    }


    @Override
    public int getItemCount() {
        //Log.i("TAG", "mDatas "+mDatas);

        return mDatas.size();

    }

    //新增item
//    public void addData(int pos){
//        mDatas.add("新增");
//        notifyItemInserted(pos);
//    }

    //移除item
    public void deleateData(int pos){
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{

    TextView tv;

    MyViewHolder(View itemView) {
        super(itemView);

        tv = itemView.findViewById(R.id.recycle_tv);
//        tv.setTextSize(20);

    }
}
