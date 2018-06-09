package cn.tourism.tv.ui.me.account;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cb.xlibrary.statusbar.StatusBarUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

/**
 * 身份验证
 */
public class IdentityProveActivity extends BaseActivity implements View.OnClickListener {

    private EditText editName;
    private EditText editIdCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, Color.parseColor("#3D3D3D"), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_identity_prove;
    }

    @Override
    public void initUI() {
        ((TextView) findViewById(R.id.title)).setText("身份认证");
        findViewById(R.id.iv_back).setOnClickListener(this);
        editName = (EditText) findViewById(R.id.edit_name);
        editIdCard = (EditText) findViewById(R.id.edit_id_card);
        findViewById(R.id.iv_front).setOnClickListener(this);
        findViewById(R.id.iv_behind).setOnClickListener(this);
        findViewById(R.id.btn_commit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_front://正面
                break;
            case R.id.iv_behind://背面
                break;
            case R.id.btn_commit:
                break;
        }
    }
}
