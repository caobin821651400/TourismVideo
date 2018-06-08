package cn.tourism.tv.ui.me.setting;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cb.xlibrary.statusbar.StatusBarUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

public class AccountSafeActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, Color.parseColor("#3D3D3D"), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_account_safe;
    }

    @Override
    public void initUI() {
        ((TextView) findViewById(R.id.title)).setText("账号安全");
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.ll_psw).setOnClickListener(this);
        findViewById(R.id.tv_phone).setOnClickListener(this);
        findViewById(R.id.tv_real_name).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_psw://重置密码
                finish();
                break;
            case R.id.tv_phone://手机绑定
                finish();
                break;
            case R.id.tv_real_name://实名
                finish();
                break;
        }
    }
}
