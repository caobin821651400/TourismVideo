package cn.tourism.tv.signin;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cb.xlibrary.statusbar.StatusBarUtils;
import com.cb.xlibrary.view.XCircleImageView;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;
import cn.tourism.tv.utils.MyUtils;

/**
 * 注册
 */
public class SignUpActivity extends BaseActivity implements View.OnClickListener {

    private XCircleImageView ivHead;
    private EditText editPhone;
    private EditText editMsgCode;
    private TextView tvSendMsgCode;
    private EditText editPsw;
    private EditText editAgainPsw;
    private TextView tvXieYi;
    //
    private TimeCount time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.immersive(this);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_sign_up;
    }

    @Override
    public void initUI() {
        ivHead = (XCircleImageView) findViewById(R.id.iv_head);
        editPhone = (EditText) findViewById(R.id.edit_phone);
        editMsgCode = (EditText) findViewById(R.id.edit_msg_code);
        editPsw = (EditText) findViewById(R.id.edit_psw);
        editAgainPsw = (EditText) findViewById(R.id.edit_again_psw);
        tvSendMsgCode = (TextView) findViewById(R.id.tv_send_msg_code);

        findViewById(R.id.btn_sign_up).setOnClickListener(this);
        findViewById(R.id.tv_xie_yi).setOnClickListener(this);
        tvSendMsgCode.setOnClickListener(this);

        // 构造CountDownTimer对象
        time = new TimeCount(1000 * 60, 1000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sign_up://注册
                if (dataCheck())
                    toastSuccess("成功");
                break;
            case R.id.tv_xie_yi://协议
                break;
            case R.id.tv_send_msg_code://发送验证码
                time.start();
                break;
        }
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
            tvSendMsgCode.setText("重新获取");
            tvSendMsgCode.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {// 计时过程显示
            tvSendMsgCode.setClickable(false);
            tvSendMsgCode.setText((millisUntilFinished / 1000) + "秒");
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

    @Override
    protected void onDestroy() {
        if (time != null) {
            time.cancel();
            time = null;
        }
        super.onDestroy();
    }
}
