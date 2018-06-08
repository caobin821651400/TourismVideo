package cn.tourism.tv.ui.me;

import android.os.Bundle;
import android.view.View;

import com.cb.xlibrary.statusbar.StatusBarUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

/**
 * 个人中心
 */
public class MeActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.immersive(this);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_me;
    }

    @Override
    public void initUI() {
        findViewById(R.id.ll_video).setOnClickListener(this);
        findViewById(R.id.ll_collection).setOnClickListener(this);
        findViewById(R.id.ll_wallet).setOnClickListener(this);
        findViewById(R.id.ll_comment).setOnClickListener(this);
        findViewById(R.id.ll_about_me).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_video://视频管理
                break;
            case R.id.ll_collection://我的收藏
                break;
            case R.id.ll_wallet://我的钱包
                break;
            case R.id.ll_comment://评论管理
                break;
            case R.id.ll_about_me://关于我们
                break;
        }
    }
}
