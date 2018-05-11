package video.com.myvideo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.Mac;

import video.com.myvideo.R;
import video.com.myvideo.bean.DianZanBean;
import video.com.myvideo.bean.MyThreeBeanInfo;

/**
 * Created by win7 on 2018/4/24.
 */

public class MyForumAdapter extends RecyclerView.Adapter<MyForumAdapter.MyHolder>{
    private Context mcontent;
    private ArrayList<MyThreeBeanInfo> mylist = new ArrayList<>();
    private static int i=0;
    DianZanBean zan  = new DianZanBean() ;
    private List<String> zlist = new ArrayList<>();
    public MyForumAdapter(Context context, ArrayList<MyThreeBeanInfo> mylist) {
        this.mcontent = context;
        this.mylist = mylist;
    }

    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontent).inflate(R.layout.fragmentthree_item,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    //给缓存控件设置数据
    public void onBindViewHolder(final MyHolder holder, int position) {

        String item = mylist.get(position).getTitile();
        holder.textView.setText(item);
        //点赞的时间
        holder.im_zan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.im_zan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    holder.add_image.setVisibility(View.VISIBLE);
                    zlist.add("夜归人");
                    addView(holder.tv_addView);
                }else {
                    if (zlist.size()!=0){
                        zlist.remove("夜归人");
                    }else {
                        holder.add_image.setVisibility(View.GONE);
                    }
                    delView(holder.tv_addView,holder.add_image);
                }
            }
        });

        //评论的事假
        holder.im_ping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pingLun(holder.et_ping);
                holder.ry_two.setVisibility(View.VISIBLE);
            }
        });
    }
    private void pingLun(View view) {
        view.setVisibility(View.VISIBLE);
        InputMethodManager imm = (InputMethodManager) mcontent.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {
        public ImageView icon;
        public TextView textView;
        public CheckBox im_zan;
        public ImageView im_ping;
        public LinearLayout ly_all;
        public ImageView add_image;
        public TextView tv_addView;
        public EditText et_ping;
        private RelativeLayout ry_two;

        //实现的方法
        public MyHolder(View itemView) {
            super(itemView);
            textView= (TextView) itemView.findViewById(R.id.tv_miaoshu);
            et_ping= (EditText) itemView.findViewById(R.id.et_ping);
            tv_addView= (TextView) itemView.findViewById(R.id.tv_addView);
            ly_all = (LinearLayout) itemView.findViewById(R.id.ly_all);
            add_image = (ImageView) itemView.findViewById(R.id.add_image);
            im_zan =  itemView.findViewById(R.id.im_zan);
            im_ping =  itemView.findViewById(R.id.im_ping);
            ry_two = itemView.findViewById(R.id.ry_two);
        }
    }


    //动态添加布局
    private void addView(TextView view) {
        String  cont = "" ;
        for (int i = 0; i < zlist.size(); i++) {
            cont  += zlist.get(i);
        }
        view.setText(cont);
           }
    //动态删除布局
    private void delView(TextView view,ImageView im) {
        if (zlist.size()==0){
            im.setVisibility(View.GONE);
        }
        String  cont ="";
        for (int i = 0; i < zlist.size(); i++) {
              cont  += zlist.get(i);
        }
          view.setText(cont);
           }
}
