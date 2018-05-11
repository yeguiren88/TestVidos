package video.com.myvideo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import java.util.ArrayList;
import java.util.List;

import video.com.myvideo.R;
import video.com.myvideo.fragment.ViewOneFragemnt;
import video.com.myvideo.fragment.ViewThreeFragment;
import video.com.myvideo.fragment.ViewTwoFragment;

/**
 * Created by win7 on 2018/4/23.
 */

public class HomeActivity  extends AppCompatActivity implements View.OnClickListener{
    private Button but1,but2,but3;
    private ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initview();
        initData();
    }

    private void initData() {
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new ViewOneFragemnt());
        fragments.add(new  ViewTwoFragment());
        fragments.add(new ViewThreeFragment());
        vp.setAdapter(new MyFragmentStateAdapter(getSupportFragmentManager(),fragments));
        vp.setCurrentItem(0);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        switchBut(1);
                        vp.setCurrentItem(0);
                        break;
                    case 1:
                        switchBut(2);
                        vp.setCurrentItem(1);
                        break;
                    case 2:
                        switchBut(3);
                        vp.setCurrentItem(2);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    class MyFragmentStateAdapter extends FragmentStatePagerAdapter{
        List<Fragment> list;

        public MyFragmentStateAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list=list;
        }

        /**
         * 返回需要展示的fragment
         * @param position
         * @return
         */
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
        /**
         * 返回需要展示的fangment数量
         * @return
         */
        @Override
        public int getCount() {
            return list.size();
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but1:
                switchBut(1);
                vp.setCurrentItem(0);
                break;
            case R.id.but2:
                switchBut(2);
                vp.setCurrentItem(1);
                break;
            case R.id.but3:
                switchBut(3);
                vp.setCurrentItem(2);
                break;
        }
    }
    //初始化页面组件
    private void initview() {
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        but3 = findViewById(R.id.but3);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        vp = findViewById(R.id.vp);
    }
    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }
    private void switchBut(int i) {
        switch (i){
            case 1:
                but1.setBackgroundColor(Color.YELLOW);
                but2.setBackgroundColor(Color.WHITE);
                but3.setBackgroundColor(Color.WHITE);
                break;
            case 2:
                but1.setBackgroundColor(Color.WHITE);
                but2.setBackgroundColor(Color.YELLOW);
                but3.setBackgroundColor(Color.WHITE);
                break;
            case 3:
                but1.setBackgroundColor(Color.WHITE);
                but2.setBackgroundColor(Color.WHITE);
                but3.setBackgroundColor(Color.YELLOW);
                break;
        }
    }



}
