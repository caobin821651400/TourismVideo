package cn.tourism.tv.signin;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cb.xlibrary.statusbar.StatusBarUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;
import cn.tourism.tv.utils.MyUtils;

/**
 * 忘记密码
 */
public class ForgetPswActivity extends BaseActivity implements View.OnClickListener {

    private EditText editPhone;
    private EditText editMsgCode;
    private Button btnSendMsgCode;
    private EditText editPsw;
    private EditText editAgainPsw;
    //
    private TimeCount time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.immersive(this);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_forget_psw;
    }

    @Override
    public void initUI() {
        editPhone = (EditText) findViewById(R.id.edit_phone);
        editMsgCode = (EditText) findViewById(R.id.edit_msg_code);
        btnSendMsgCode = (Button) findViewById(R.id.btn_send_msg_code);
        editPsw = (EditText) findViewById(R.id.edit_psw);
        editAgainPsw = (EditText) findViewById(R.id.edit_again_psw);

        btnSendMsgCode.setOnClickListener(this);
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.btn_modify_psw).setOnClickListener(this);

        // 构造CountDownTimer对象
        time = new TimeCount(1000 * 60, 1000);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back://返回
                finish();
                break;
            case R.id.btn_modify_psw://修改密码
                if (dataCheck())
                    toastSuccess("成功");
                break;
            case R.id.btn_send_msg_code://验证码
                time.start();
                break;
        }
    }


    /**
     * 数据校验
     */
    private boolean dataCheck() {
        if (MyUtils.edIsEmpty(editPhone)) {
            toastError("请输入手机号码");
            return false;
        }
        if (MyUtils.edIsEmpty(editMsgCode)) {
            toastError("请输入验证码");
            return false;
        }
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


    /**
     * 验证码倒计时
     */
    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);// 参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish() {// 计时完毕时触发
            btnSendMsgCode.setText("重新获取");
            btnSendMsgCode.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {// 计时过程显示
            btnSendMsgCode.setClickable(false);
            btnSendMsgCode.setText((millisUntilFinished / 1000) + "秒");
        }
    }

    @Override
    protected void onDestroy() {
        if (time != null) {
            time.cancel();
            time = null;
        }
        super.onDestroy();
    }
}
