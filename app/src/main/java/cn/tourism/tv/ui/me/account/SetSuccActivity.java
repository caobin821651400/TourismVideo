package cn.tourism.tv.ui.me.account;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cb.xlibrary.statusbar.StatusBarUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

/**
 * 成功界面
 */
public class SetSuccActivity extends BaseActivity implements View.OnClickListener {

    private String msg;//成功提示文字
    private String btnTxt;//按钮文字
    private String title;//按钮文字
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, Color.parseColor("#3D3D3D"), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_set_succ;
    }

    @Override
    public void initUI() {
        msg = getIntent().getStringExtra("msg");
        btnTxt = getIntent().getStringExtra("btnTxt");
        title = getIntent().getStringExtra("title");

        ((TextView) findViewById(R.id.title)).setText(title);
        ((TextView) findViewById(R.id.tv_info_msg)).setText(msg);
        mButton = findViewById(R.id.btn_next);
        mButton.setText(btnTxt);

        findViewById(R.id.iv_back).setOnClickListener(this);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_next://开始修改密码
                if (mButton.getText().equals("开始修改密码")) {
                    launchActivity(SetPswActivity.class, null);
                    finish();
                } else if (mButton.getText().equals("返回")) {
                    finish();
                }
                break;

        }
    }
}
