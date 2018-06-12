package cn.tourism.tv.ui.video;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.cb.xlibrary.utils.XLogUtils;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;

/**
 * 描述：视频界面
 * 作者：曹斌
 * date:2018/6/7 15:47
 */
public class VideoFragment extends BaseFragment {

    private TabLayout mTabLayout;
    private TabLayout mTabLayout2;
    //
    private ViewPager mViewPager;
    private List<Fragment> listFragment;
    private List<String> listTitle;
    private VideoPagerAdapter mFragmentAdapter;

    @Override
    public int getRootViewId() {
        return R.layout.fragment_video;
    }

    @Override
    public void initUI(View v) {
        mTabLayout = v.findViewById(R.id.tabLayout);
        mTabLayout2 = v.findViewById(R.id.tabLayout2);
        mViewPager = (ViewPager) v.findViewById(R.id.view_pager);

        listFragment = new ArrayList<>();
        listTitle = new ArrayList<>();

        mTabLayout.addTab(mTabLayout.newTab().setText("分类"));
        mTabLayout.addTab(mTabLayout.newTab().setText("游中国"));
        mTabLayout.addTab(mTabLayout.newTab().setText("看世界"));
        mTabLayout.addTab(mTabLayout.newTab().setText("拍客"));
        mTabLayout.addTab(mTabLayout.newTab().setText("活动"));
        mTabLayout.addTab(mTabLayout.newTab().setText("商城"));

        //刷新数据
        listTitle.add("旅游");
        listTitle.add("时尚");
        listTitle.add("艺文");
        listTitle.add("体育");
        listTitle.add("美食");
        listTitle.add("音乐");
        listFragment.add(new VideoChildFragment());
        listFragment.add(new VideoChildFragment());
        listFragment.add(new VideoChildFragment());
        listFragment.add(new VideoChildFragment());
        listFragment.add(new VideoChildFragment());
        listFragment.add(new VideoChildFragment());

        mViewPager.setOffscreenPageLimit(5);
        mFragmentAdapter = new VideoPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mFragmentAdapter);
        mTabLayout2.setupWithViewPager(mViewPager);


    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {
        XLogUtils.d("3333");
    }

    /**
     *
     */
    class VideoPagerAdapter extends FragmentPagerAdapter {

        public VideoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listFragment.get(position);
        }

        @Override
        public int getCount() {
            return listFragment.size();
        }

//        @Override
//        public int getItemPosition(Object object) {
//            return super.getItemPosition(object);
//        }

        @Override
        public String getPageTitle(int position) {
            if (listTitle != null && listTitle.size() != 0) {
                return listTitle.get(position);
            }
            return (String) super.getPageTitle(position);
        }
    }
}
