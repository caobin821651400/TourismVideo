package cn.tourism.tv.ui.info;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cb.xlibrary.adapter.ViewPagerFragmentAdapter;
import com.cb.xlibrary.utils.XLogUtils;
import com.cb.xlibrary.view.XCircleImageView;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;

/**
 * 描述：资讯界面
 * 作者：曹斌
 * date:2018/6/7 15:47
 */
public class InfoFragment extends BaseFragment {

    private XCircleImageView ivHead;
    private TextView tvSearch;
    private ImageView ivCamera;
    private TabLayout tabLayout;
    private ImageView btnMore;
    private ViewPager mViewPager;

    private List<Fragment> listData;
    private List<String> listTitle;
    private ViewPagerFragmentAdapter mFragmentAdapter;

    @Override
    public int getRootViewId() {
        return R.layout.fragment_zi_xun;
    }

    @Override
    public void initUI(View v) {
        ivHead = (XCircleImageView) v.findViewById(R.id.iv_head);
        tvSearch = (TextView) v.findViewById(R.id.tv_search);
        ivCamera = (ImageView) v.findViewById(R.id.iv_camera);
        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);
        btnMore = (ImageView) v.findViewById(R.id.btnMore);
        mViewPager = (ViewPager) v.findViewById(R.id.view_pager);

        listData = new ArrayList<>();
        listTitle = new ArrayList<>();
        mFragmentAdapter = new ViewPagerFragmentAdapter(getChildFragmentManager(), listData, listTitle);
        mViewPager.setAdapter(mFragmentAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        //刷新数据
        listTitle.add("推荐");
        listTitle.add("南充");
        listTitle.add("科技");
        listTitle.add("文化");
        listTitle.add("段子");
        listTitle.add("视频");
        listTitle.add("成都");
        listData.add(new ZiXunChildFragment());
        listData.add(new ZiXunChildFragment());
        listData.add(new ZiXunChildFragment());
        listData.add(new ZiXunChildFragment());
        listData.add(new ZiXunChildFragment());
        listData.add(new ZiXunChildFragment());
        listData.add(new ZiXunChildFragment());

        mFragmentAdapter.setListData(listData);
        mFragmentAdapter.setListTitle(listTitle);
        mFragmentAdapter.notifyDataSetChanged();
    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {

        XLogUtils.d("4444444");
    }
}
