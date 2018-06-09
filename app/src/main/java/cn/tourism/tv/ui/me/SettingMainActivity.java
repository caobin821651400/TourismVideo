package cn.tourism.tv.ui.me;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.cb.xlibrary.statusbar.StatusBarUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;
import cn.tourism.tv.ui.me.account.AccountSafeActivity;
import cn.tourism.tv.ui.me.setting.ContactUsActivity;
import cn.tourism.tv.ui.me.setting.MyMsgActivity;
import cn.tourism.tv.ui.me.setting.OpinionActivity;

public class SettingMainActivity extends BaseActivity implements View.OnClickListener {

    private CheckBox checkboxIsWifi;
    private CheckBox checkboxAutoVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, Color.parseColor("#3D3D3D"), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_setting_main;
    }

    @Override
    public void initUI() {
        ((TextView) findViewById(R.id.title)).setText("设置");
        checkboxIsWifi = (CheckBox) findViewById(R.id.checkbox_is_wifi);
        checkboxAutoVideo = (CheckBox) findViewById(R.id.checkbox_auto_video);
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.tv_my_msg).setOnClickListener(this);
        findViewById(R.id.tv_check_version).setOnClickListener(this);
        findViewById(R.id.tv_share).setOnClickListener(this);
        findViewById(R.id.tv_version).setOnClickListener(this);
        findViewById(R.id.tv_opinion).setOnClickListener(this);
        findViewById(R.id.tv_clear_cache).setOnClickListener(this);
        findViewById(R.id.tv_account_safe).setOnClickListener(this);
        findViewById(R.id.tv_contact_us).setOnClickListener(this);
        findViewById(R.id.btn_sign_out).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_my_msg://我的消息
                launchActivity(MyMsgActivity.class, null);
                break;
            case R.id.tv_check_version://检查更新
                break;
            case R.id.tv_share://分享
                break;
            case R.id.tv_version://版本检查
                break;
            case R.id.tv_opinion://意见反馈
                launchActivity(OpinionActivity.class, null);
                break;
            case R.id.tv_clear_cache://清缓存
                break;
            case R.id.tv_account_safe://账号安全
                launchActivity(AccountSafeActivity.class, null);
                break;
            case R.id.tv_contact_us://联系我们
                launchActivity(ContactUsActivity.class, null);
                break;
            case R.id.btn_sign_out://退出
                break;
        }
    }
}
