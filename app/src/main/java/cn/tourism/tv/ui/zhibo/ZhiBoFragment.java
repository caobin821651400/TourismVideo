package cn.tourism.tv.ui.zhibo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cb.xlibrary.utils.XLogUtils;
import com.cb.xlibrary.view.XCircleImageView;
import com.cb.xlibrary.widget.tab.XTabLayout;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;
import cn.tourism.tv.ui.zhibo.fra.ZhiBoChildFragment;

/**
 * 描述：直播界面
 * 作者：曹斌
 * date:2018/6/7 15:47
 */
public class ZhiBoFragment extends BaseFragment {

    private XCircleImageView ivHead;
    private TextView tvSearch;
    private ImageView ivCamera;
    private XTabLayout tabLayout;
    private ImageView btnMore;
    private ViewPager mViewPager;

    private List<Fragment> listFragment;
    private List<String> listTitle;
    private MyViewPagerAdapter mFragmentAdapter;

    @Override
    public int getRootViewId() {
        return R.layout.fragment_zhi_bo;
    }

    @Override
    public void initUI(View v) {
        ivHead = v.findViewById(R.id.iv_head);
        tvSearch = v.findViewById(R.id.tv_search);
        ivCamera = v.findViewById(R.id.iv_camera);
        tabLayout = v.findViewById(R.id.tabLayout);
        btnMore = v.findViewById(R.id.btnMore);
        mViewPager = v.findViewById(R.id.view_pager);

        listFragment = new ArrayList<>();
        listTitle = new ArrayList<>();

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity(ZhiBoClassifyActivity.class, null);
            }
        });


        //刷新数据
        listTitle.add("旅游");
        listTitle.add("时尚");
        listTitle.add("艺文");
        listTitle.add("体育");
        listTitle.add("美食");
        listTitle.add("音乐");
        listFragment.add(new ZhiBoChildFragment());
        listFragment.add(new ZhiBoChildFragment());
        listFragment.add(new ZhiBoChildFragment());
        listFragment.add(new ZhiBoChildFragment());
        listFragment.add(new ZhiBoChildFragment());
        listFragment.add(new ZhiBoChildFragment());

        mViewPager.setOffscreenPageLimit(5);
        mFragmentAdapter = new MyViewPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mFragmentAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {

        XLogUtils.d("2222222");
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
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
