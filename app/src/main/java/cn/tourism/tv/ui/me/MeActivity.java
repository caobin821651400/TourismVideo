package cn.tourism.tv.ui.me;

import android.os.Bundle;
import android.view.View;

import com.cb.xlibrary.statusbar.StatusBarUtils;
import com.cb.xlibrary.utils.XActivityStack;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;
import cn.tourism.tv.ui.me.fans.FansActivity;
import cn.tourism.tv.ui.me.manager.CommentManageActivity;
import cn.tourism.tv.ui.me.manager.MeCollectionActivity;
import cn.tourism.tv.ui.me.manager.VideoManageActivity;
import cn.tourism.tv.ui.me.wallet.MeWalletActivity;

/**
 * 个人中心
 */
public class MeActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XActivityStack.getInstance().addActivity(this);
        StatusBarUtils.immersive(this);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_me;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        XActivityStack.getInstance().findActivity(MeActivity.class).finish();
    }

    @Override
    public void initUI() {
        findViewById(R.id.ll_video).setOnClickListener(this);
        findViewById(R.id.ll_collection).setOnClickListener(this);
        findViewById(R.id.ll_wallet).setOnClickListener(this);
        findViewById(R.id.ll_comment).setOnClickListener(this);
        findViewById(R.id.ll_about_me).setOnClickListener(this);
        findViewById(R.id.iv_setting).setOnClickListener(this);
        findViewById(R.id.iv_head).setOnClickListener(this);

        findViewById(R.id.ll_care).setOnClickListener(this);
        findViewById(R.id.ll_dynamic).setOnClickListener(this);
        findViewById(R.id.ll_fans).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_video://视频管理
                launchActivity(VideoManageActivity.class, null);
                break;
            case R.id.ll_collection://我的收藏
                launchActivity(MeCollectionActivity.class, null);
                break;
            case R.id.ll_wallet://我的钱包
                launchActivity(MeWalletActivity.class, null);
                break;
            case R.id.ll_comment://评论管理
                launchActivity(CommentManageActivity.class, null);
                break;
            case R.id.ll_about_me://关于我们
                break;
            case R.id.iv_setting://设置
                launchActivity(SettingMainActivity.class, null);
                break;
            case R.id.iv_head:
                launchActivity(ModifyInfoActivity.class, null);
                break;
            case R.id.ll_fans://粉丝
                launchActivity(FansActivity.class, null);
                break;
            case R.id.ll_dynamic://动态
                break;
            case R.id.ll_care://关注
                launchActivity(FansActivity.class, null);
                break;
        }
    }
}
