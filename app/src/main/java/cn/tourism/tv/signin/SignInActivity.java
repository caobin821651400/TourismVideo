package cn.tourism.tv.signin;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.cb.xlibrary.statusbar.StatusBarUtils;
import com.cb.xlibrary.view.XCircleImageView;

import cn.tourism.tv.MainActivity;
import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

/**
 * 登录
 */
public class SignInActivity extends BaseActivity implements View.OnClickListener {

    private XCircleImageView ivHead;
    private EditText editPhone;
    private EditText editPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.immersive(this);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_sign_in;
    }

    @Override
    public void initUI() {
        ivHead = findViewById(R.id.iv_head);
        editPhone = findViewById(R.id.edit_phone);
        editPsw = findViewById(R.id.edit_psw);

        findViewById(R.id.btn_sign_in).setOnClickListener(this);
        findViewById(R.id.tv_forget_psw).setOnClickListener(this);
        findViewById(R.id.tv_sign_up).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_in://登录
                launchActivity(MainActivity.class, null);
                finish();
                break;
            case R.id.tv_forget_psw://忘记密码
                launchActivity(ForgetPswActivity.class, null);
                break;
            case R.id.tv_sign_up://注册
                launchActivity(SignUpActivity.class, null);
                break;
        }
    }
}
