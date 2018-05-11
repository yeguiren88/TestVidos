package video.com.myvideo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import java.util.ArrayList;
import java.util.HashMap;

import video.com.myvideo.R;
import video.com.myvideo.adapter.MyForumAdapter;
import video.com.myvideo.bean.MyThreeBeanInfo;
import video.com.myvideo.util.RecyclerViewSpacesItemDecoration;

/**
 * Created by win7 on 2018/4/23.
 */

public class ViewThreeFragment  extends Fragment{
    private View view;
    private RecyclerView mRecyclerView;
    private RefreshLayout refreshLayout;
    private MyForumAdapter  myForumAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.viewthree_fragment, container, false);
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
        ArrayList<MyThreeBeanInfo> mylist = new ArrayList<>();
            mylist.add(new MyThreeBeanInfo("s","我们都很努力的干活，希望有个好结果，我们今天得付出，明天就回有收获的！加油小伙伴们！","22"));
//            mylist.add(new MyThreeBeanInfo("s","今天成功源于明天的努力，加油小伙伴！","22"));
//            mylist.add(new MyThreeBeanInfo("s","今天成功源于明天的努力，加油小伙伴！","22"));
//            mylist.add(new MyThreeBeanInfo("s","今天成功源于明天的努力，加油小伙伴！","22"));
        myForumAdapter = new MyForumAdapter(getActivity(),mylist);
        mRecyclerView.setAdapter(myForumAdapter);
        myForumAdapter.notifyDataSetChanged();
    }

    private void initview() {
        refreshLayout = view.findViewById(R.id.refreshLayout_three);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }

    private void init() {
        mRecyclerView =view.findViewById(R.id.recycler_view_three);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        mRecyclerView.setHasFixedSize(true);
    }
}
