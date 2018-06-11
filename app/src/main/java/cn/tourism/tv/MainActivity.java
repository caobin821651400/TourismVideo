package cn.tourism.tv;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.cb.xlibrary.utils.XLogUtils;

import cn.tourism.tv.base.BaseActivity;
import cn.tourism.tv.ui.info.InfoFragment;
import cn.tourism.tv.ui.tuijian.TuiJianFragment;
import cn.tourism.tv.ui.video.VideoFragment;
import cn.tourism.tv.ui.zhibo.ZhiBoFragment;
import cn.tourism.tv.ui.zhly.ZhlyFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TuiJianFragment tuiJianFragment;
    private ZhiBoFragment zhiBoFragment;
    private VideoFragment videoFragment;
    private InfoFragment infoFragment;
    private ZhlyFragment zhlyFragment;
    // 切换控制
    private FragmentManager fragmentManager;
    private int currentTabIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initUI() {
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        findViewById(R.id.rbTj).setOnClickListener(this);
        findViewById(R.id.rbLive).setOnClickListener(this);
        findViewById(R.id.rbVideo).setOnClickListener(this);
        findViewById(R.id.rbZx).setOnClickListener(this);
        findViewById(R.id.rbZhly).setOnClickListener(this);

        setTabSelection(currentTabIndex);

        //XLogUtils.d(TokenUtil.getSafeStr("zl6"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rbTj://推荐
                if (currentTabIndex == 0)
                    return;
                setTabSelection(0);
                break;
            case R.id.rbLive://直播
                if (currentTabIndex == 1)
                    return;
                setTabSelection(1);
                break;
            case R.id.rbVideo://视频
                if (currentTabIndex == 2)
                    return;
                setTabSelection(2);
                break;
            case R.id.rbZx://资讯
                if (currentTabIndex == 3)
                    return;
                setTabSelection(3);
                break;
            case R.id.rbZhly://智慧旅游
                if (currentTabIndex == 4)
                    return;
                setTabSelection(4);
                break;
        }
    }

    /**
     * 切换fragment
     *
     * @param index
     */
    private void setTabSelection(int index) {
        currentTabIndex = index;
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                if (tuiJianFragment == null) {
                    tuiJianFragment = new TuiJianFragment();
                    transaction.add(R.id.fragmentContent, tuiJianFragment, "tuiJianFragment");
                } else {
                    transaction.show(tuiJianFragment);
                }
                break;
            case 1:
                if (zhiBoFragment == null) {
                    zhiBoFragment = new ZhiBoFragment();
                    transaction.add(R.id.fragmentContent, zhiBoFragment, "zhiBoFragment");
                } else {
                    transaction.show(zhiBoFragment);
                }
                break;
            case 2:
                if (videoFragment == null) {
                    videoFragment = new VideoFragment();
                    transaction.add(R.id.fragmentContent, videoFragment, "videoFragment");
                } else {
                    transaction.show(videoFragment);
                }
                break;
            case 3:
                if (infoFragment == null) {
                    infoFragment = new InfoFragment();
                    transaction.add(R.id.fragmentContent, infoFragment, "infoFragment");
                } else {
                    transaction.show(infoFragment);
                }
                break;
            case 4:
                if (zhlyFragment == null) {
                    zhlyFragment = new ZhlyFragment();
                    transaction.add(R.id.fragmentContent, zhlyFragment, "zhlyFragment");
                } else {
                    transaction.show(zhlyFragment);
                }
                break;
            default:
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 将所有的fragment隐藏
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (tuiJianFragment != null) {
            transaction.hide(tuiJianFragment);
        }
        if (zhiBoFragment != null) {
            transaction.hide(zhiBoFragment);
        }
        if (videoFragment != null) {
            transaction.hide(videoFragment);
        }
        if (infoFragment != null) {
            transaction.hide(infoFragment);
        }
        if (zhlyFragment != null) {
            transaction.hide(zhlyFragment);
        }
    }
}
