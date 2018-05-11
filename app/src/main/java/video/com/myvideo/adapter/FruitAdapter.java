package video.com.myvideo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import video.com.myvideo.R;
import video.com.myvideo.activity.PhotoViewActivity;
import video.com.myvideo.bean.Fruit;
import video.com.myvideo.bean.GlideApp;

/**
 * Created by win7 on 2018/4/23.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private ArrayList<Fruit> list;
    private Context mcontent;
    private List<Integer> heightList;


    public FruitAdapter(Context context, ArrayList<Fruit> list) {
        this.mcontent = context;
        this.list = list;
        heightList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mcontent, R.layout.fruit_item_staggered, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        ViewHolder myHolder = (ViewHolder) viewHolder;
        // 随机高度, 模拟瀑布效果.
        if (heightList.size() <= position) {
            heightList.add((int) (400 + Math.random() * 400));
        }

        ViewGroup.LayoutParams lp = myHolder.ivImage.getLayoutParams();
        lp.height = heightList.get(position);
        myHolder.ivImage.setLayoutParams(lp);
        Fruit ivId = list.get(position);
        GlideApp.with(mcontent)
                .load(list.get(position).getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .into(myHolder.ivImage);

        myHolder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontent, PhotoViewActivity.class);
                intent.putParcelableArrayListExtra("dataBean", list);
                mcontent.startActivity(intent);


            }
        });

        //设置标记
        myHolder.itemView.setTag(position);
        myHolder.itemView.setOnClickListener(listener);
        myHolder.itemView.setOnLongClickListener(longListener);
    }

    //点击事件
    private View.OnClickListener listener;

    public void setOnMyItemClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    //长按事件
    private View.OnLongClickListener longListener;

    public void setOnMyItemLongClickListener(View.OnLongClickListener longListener) {
        this.longListener = longListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivImage;

        public ViewHolder(View itemView) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.iv_item_icon);
        }
    }
    //向集合中添加数据
//    public void addList(int position) {
//        list.add(position, "","11","我的所有");
//        notifyItemInserted(position);
//    }
//    //移除集合中的数据
    public void removeList(int position) {
        list.remove(position-1);
        notifyItemRemoved(position-1);
    }
}
