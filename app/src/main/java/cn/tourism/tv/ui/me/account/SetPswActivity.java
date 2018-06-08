package cn.tourism.tv.ui.me.account;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cb.xlibrary.statusbar.StatusBarUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;
import cn.tourism.tv.utils.MyUtils;

/**
 * 设置密码
 */
public class SetPswActivity extends BaseActivity implements View.OnClickListener {

    private EditText editPsw;
    private EditText editAgainPsw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, Color.parseColor("#3D3D3D"), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_set_psw;
    }

    @Override
    public void initUI() {
        ((TextView) findViewById(R.id.title)).setText("设置密码");
        editPsw = (EditText) findViewById(R.id.edit_psw);
        editAgainPsw = (EditText) findViewById(R.id.edit_again_psw);

        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.btn_next_step).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_next_step://下一步
                if (dataCheck()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("msg", "密码修改成功");
                    bundle.putString("btnTxt", "返回");
                    bundle.putString("title", "修改成功");
                    launchActivity(SetSuccActivity.class, bundle);
                    finish();
                }
                break;
        }
    }

    /**
     * 数据校验
     */
    private boolean dataCheck() {
        if (MyUtils.edIsEmpty(editPsw)) {
            toastError("请输入新密码");
            return false;
        }
        if (MyUtils.edIsEmpty(editAgainPsw)) {
            toastError("请再次输入新密码");
            return false;
        }
        if (!editPsw.getText().toString().trim().
                equals(editAgainPsw.getText().toString().trim())) {
            toastError("两次输入的密码不一致");
            return false;
        }
        return true;
    }
}
