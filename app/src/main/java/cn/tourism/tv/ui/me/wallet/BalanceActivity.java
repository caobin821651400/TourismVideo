package cn.tourism.tv.ui.me.wallet;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cb.xlibrary.statusbar.StatusBarUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

/**
 * 账户余额
 */
public class BalanceActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, Color.parseColor("#3D3D3D"), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_balance;
    }

    @Override
    public void initUI() {
        ((TextView) findViewById(R.id.title)).setText("账户余额");
        tvMoney = (TextView) findViewById(R.id.tv_money);
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.btn_ti_xian).setOnClickListener(this);
        findViewById(R.id.btn_setting_psw).setOnClickListener(this);
        findViewById(R.id.btn_recharge).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_ti_xian://提现
                launchActivity(TiXianActivity.class,null);
                break;
            case R.id.btn_setting_psw://设置密码
                break;
            case R.id.btn_recharge://充值
                break;
        }
    }
}
