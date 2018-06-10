package cn.tourism.tv.ui.me.wallet;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cb.xlibrary.statusbar.StatusBarUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

/**
 * 我的钱包
 */
public class MeWalletActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvIncome;
    private TextView tvBalance;
    private TextView tvRecharge;
    private TextView tvTiXian;
    private TextView tvWeiChat;
    private TextView tvZfb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, Color.parseColor("#3D3D3D"), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_me_wallet;
    }

    @Override
    public void initUI() {
        ((TextView) findViewById(R.id.title)).setText("我的钱包");
        tvIncome = (TextView) findViewById(R.id.tv_income);
        tvBalance = (TextView) findViewById(R.id.tv_balance);
        tvWeiChat = (TextView) findViewById(R.id.tv_wei_chat);
        tvZfb = (TextView) findViewById(R.id.tv_zfb);

        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.tv_recharge).setOnClickListener(this);
        findViewById(R.id.tv_ti_xian).setOnClickListener(this);
        tvWeiChat.setOnClickListener(this);
        tvZfb.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_recharge://充值
                finish();
                break;
            case R.id.tv_ti_xian://提现
                finish();
                break;
            case R.id.tv_wei_chat://微信
                finish();
                break;
            case R.id.tv_zfb://支付宝
                finish();
                break;
        }
    }
}
