package video.com.myvideo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import java.util.ArrayList;
import java.util.List;

import video.com.myvideo.R;
import video.com.myvideo.activity.PhotoViewActivity;
import video.com.myvideo.adapter.FruitAdapter;
import video.com.myvideo.bean.Fruit;
import video.com.myvideo.util.SpacesItemDecoration;

/**
 * Created by win7 on 2018/4/23.
 */

public class ViewTwoFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerView;
    private RefreshLayout refreshLayout;
    private  FruitAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewtwo_fragment, null);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initview();
        init();
        initData();
    }

    private void initData() {
            final ArrayList<Fruit> photos = new ArrayList<>();
            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524547581328&di=b2de615d780152e4d18d90e1ceeec3d0&imgtype=0&src=http%3A%2F%2Fs20.mogucdn.com%2Fb7%2Fpic%2F140625%2F54463_kq2f63smkrbdowkugfjeg5sckzsew_600x800.jpg", "1","最爱风格1"));
            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544779398&di=669ce73b7c10059aa73c8780e041a4e7&imgtype=0&src=http%3A%2F%2Fimg4q.duitang.com%2Fuploads%2Fitem%2F201407%2F12%2F20140712143552_tY4j8.jpeg", "2","最爱风格2"));
            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524547508304&di=8d4148718f6ddfc4e968168b41deace7&imgtype=0&src=http%3A%2F%2Fp0.qhimgs4.com%2Ft016ea5ee7ee7a2ba2e.jpg", "3","最爱风格3"));
            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544814214&di=3536f1024a8da8b1d3c2ed7d8a863c92&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3Db91227707df40ad115b1cfe7621c3de9%2Fb7fd5266d01609241871b253d20735fae6cd3425.jpg", "4","最爱风格4"));
            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544831546&di=06a0e650bfbe95ad793855abb5d8e3dc&imgtype=0&src=http%3A%2F%2Fimage9.huangye88.com%2F2015%2F03%2F18%2F305a04064482a402.jpg", "5","最爱风格5"));
            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544866556&di=0e5bc29e8cc4f26fa0d837093b243889&imgtype=0&src=http%3A%2F%2Fs6.mogucdn.com%2Fb7%2Fpic%2F141023%2F8mux_ieydqmtemzswmmrrmqytambqmmyde_2141x3213.jpg", "6","最爱风格6"));
            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544896792&di=c54fd9368f4ea89afef775e461086584&imgtype=0&src=http%3A%2F%2Fs6.mogucdn.com%2Fb7%2Fpic%2F150123%2F11juse_ie2wkm3fgvrdqzlfmuytambqhayde_640x960.jpg_468x468.jpg", "7","最爱风格7"));
            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544928988&di=b3cdf38aaf96fb9f33a36ab960a4fdbd&imgtype=0&src=http%3A%2F%2Fimg10.360buyimg.com%2Fimgzone%2Fjfs%2Ft2563%2F40%2F617785781%2F246001%2Fe055284f%2F565a8e79N7d25853d.jpg", "8","最爱风格8"));
            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544945354&di=92c75d605c627ed7c874f4ec547c325d&imgtype=0&src=http%3A%2F%2Fimgx.wadongxi.net%2Fitem%2Fi1%2FTB1SmTVFVXXXXcxXpXXXXXXXXXX_%2521%25210-item_pic.jpg_400x400Q90.jpg", "9","最爱风格9"));

            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524549764730&di=508a35f5d034e0870f19538e5bb267c7&imgtype=0&src=http%3A%2F%2Fimg.11665.com%2Fimg1_p3%2Fi4%2F1681072832%2FTB2utHDqpXXXXXKXXXXXXXXXXXX_%2521%25211681072832.jpg", "9","最爱风格9"));
            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524549785142&di=4b2b908438e39e2c18be08e73ee412b9&imgtype=0&src=http%3A%2F%2Fimg10.360buyimg.com%2Fn0%2Fjfs%2Ft430%2F43%2F60248035%2F174964%2Fb37c2d6e%2F5407ee80Ncf52b177.jpg", "9","最爱风格9"));
            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544945354&di=92c75d605c627ed7c874f4ec547c325d&imgtype=0&src=http%3A%2F%2Fimgx.wadongxi.net%2Fitem%2Fi1%2FTB1SmTVFVXXXXcxXpXXXXXXXXXX_%2521%25210-item_pic.jpg_400x400Q90.jpg", "9","最爱风格9"));
            photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524549866246&di=74338635e659c5abcde9c79dd1136bab&imgtype=0&src=http%3A%2F%2Fimg003.hc360.cn%2Fm8%2FM0D%2F0E%2F15%2FwKhQplUPpi2EY6A8AAAAABD00Fg367.jpg", "9","最爱风格9"));


        photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524547581328&di=b2de615d780152e4d18d90e1ceeec3d0&imgtype=0&src=http%3A%2F%2Fs20.mogucdn.com%2Fb7%2Fpic%2F140625%2F54463_kq2f63smkrbdowkugfjeg5sckzsew_600x800.jpg", "1","最爱风格1"));
        photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544779398&di=669ce73b7c10059aa73c8780e041a4e7&imgtype=0&src=http%3A%2F%2Fimg4q.duitang.com%2Fuploads%2Fitem%2F201407%2F12%2F20140712143552_tY4j8.jpeg", "2","最爱风格2"));
        photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524547508304&di=8d4148718f6ddfc4e968168b41deace7&imgtype=0&src=http%3A%2F%2Fp0.qhimgs4.com%2Ft016ea5ee7ee7a2ba2e.jpg", "3","最爱风格3"));
        photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544814214&di=3536f1024a8da8b1d3c2ed7d8a863c92&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3Db91227707df40ad115b1cfe7621c3de9%2Fb7fd5266d01609241871b253d20735fae6cd3425.jpg", "4","最爱风格4"));
        photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544831546&di=06a0e650bfbe95ad793855abb5d8e3dc&imgtype=0&src=http%3A%2F%2Fimage9.huangye88.com%2F2015%2F03%2F18%2F305a04064482a402.jpg", "5","最爱风格5"));
        photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544866556&di=0e5bc29e8cc4f26fa0d837093b243889&imgtype=0&src=http%3A%2F%2Fs6.mogucdn.com%2Fb7%2Fpic%2F141023%2F8mux_ieydqmtemzswmmrrmqytambqmmyde_2141x3213.jpg", "6","最爱风格6"));
        photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544896792&di=c54fd9368f4ea89afef775e461086584&imgtype=0&src=http%3A%2F%2Fs6.mogucdn.com%2Fb7%2Fpic%2F150123%2F11juse_ie2wkm3fgvrdqzlfmuytambqhayde_640x960.jpg_468x468.jpg", "7","最爱风格7"));
        photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544928988&di=b3cdf38aaf96fb9f33a36ab960a4fdbd&imgtype=0&src=http%3A%2F%2Fimg10.360buyimg.com%2Fimgzone%2Fjfs%2Ft2563%2F40%2F617785781%2F246001%2Fe055284f%2F565a8e79N7d25853d.jpg", "8","最爱风格8"));
        photos.add(new Fruit("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524544945354&di=92c75d605c627ed7c874f4ec547c325d&imgtype=0&src=http%3A%2F%2Fimgx.wadongxi.net%2Fitem%2Fi1%2FTB1SmTVFVXXXXcxXpXXXXXXXXXX_%2521%25210-item_pic.jpg_400x400Q90.jpg", "9","最爱风格9"));


             adapter = new FruitAdapter(getActivity(),photos);
            mRecyclerView.setAdapter(adapter);

        //点击事件
//        adapter.setOnMyItemClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent  = new Intent(getActivity(),BigPictureActivity.class);
////                getActivity().startActivity(intent);
//                Toast.makeText(getActivity(), "您点击咯"+v.getTag(), Toast.LENGTH_SHORT).show();
//            }
//        });
        //长按事件(删除)
        adapter.setOnMyItemLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                adapter.removeList(1);
                Toast.makeText(getActivity(), "您删除咯一张图片"+v.getTag(), Toast.LENGTH_SHORT).show();
                //不返回true,松手还会去执行单击事件
                return true;
            }
        });
    }

    private void init() {
        mRecyclerView = (RecyclerView)getActivity().findViewById(R.id.recycler_viewtwo);
        //瀑布流
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration = new SpacesItemDecoration(8);
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initview() {
    }

    @Override
    public void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

}
