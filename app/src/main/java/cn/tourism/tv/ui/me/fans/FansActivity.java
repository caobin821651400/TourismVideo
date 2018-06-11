package cn.tourism.tv.ui.me.fans;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.cb.xlibrary.adapter.ViewPagerFragmentAdapter;
import com.cb.xlibrary.statusbar.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

/**
 * 关注粉丝
 */
public class FansActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager mViewPager;
    private ViewPagerFragmentAdapter mFragmentAdapter;

    private List<Fragment> listData;
    private List<String> listTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.status_bar_color), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_fans;
    }

    @Override
    public void initUI() {
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        listData = new ArrayList<>();
        listTitle = new ArrayList<>();
        mFragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), listData, listTitle);
        mViewPager.setAdapter(mFragmentAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        //刷新数据
        listTitle.add("关注");
        listTitle.add("粉丝");
        listData.add(new CareFragment());
        listData.add(new FansFragment());

        mFragmentAdapter.setListData(listData);
        mFragmentAdapter.setListTitle(listTitle);
        mFragmentAdapter.notifyDataSetChanged();
    }
}
