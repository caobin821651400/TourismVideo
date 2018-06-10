package cn.tourism.tv.ui.me.wallet;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cb.xlibrary.statusbar.StatusBarUtils;
import com.cb.xlibrary.utils.XRegexUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;
import cn.tourism.tv.utils.MyUtils;

/**
 * 设置支付密码
 */
public class SetPayPswActivity extends BaseActivity implements View.OnClickListener {

    private EditText editPhone;
    private EditText editMsgCode;
    private Button btnSendMsgCode;
    private EditText editPsw;
    private EditText editAgainPsw;

    private TimeCount time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.status_bar_color), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_set_pay_psw;
    }

    @Override
    public void initUI() {
        ((TextView) findViewById(R.id.title)).setText("设置支付密码");
        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.btn_complete).setOnClickListener(this);
        editPhone = (EditText) findViewById(R.id.edit_phone);
        editMsgCode = (EditText) findViewById(R.id.edit_msg_code);
        btnSendMsgCode = (Button) findViewById(R.id.btn_send_msg_code);
        editPsw = (EditText) findViewById(R.id.edit_psw);
        editAgainPsw = (EditText) findViewById(R.id.edit_again_psw);
        btnSendMsgCode.setOnClickListener(this);
        // 构造CountDownTimer对象
        time = new TimeCount(1000 * 60, 1000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_send_msg_code://验证码
                if (MyUtils.edIsEmpty(editPhone) ||
                        !XRegexUtils.checkMobile(editPhone.getText().toString().trim())) {
                    toastError("请输入正确的手机号码");
                    return;
                }
                time.start();
                break;
            case R.id.btn_complete://完成
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
