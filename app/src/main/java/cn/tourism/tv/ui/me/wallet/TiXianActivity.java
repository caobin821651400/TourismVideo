package cn.tourism.tv.ui.me.wallet;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cb.xlibrary.statusbar.StatusBarUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

/**
 * 提现
 */
public class TiXianActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.status_bar_color), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_ti_xian;
    }

    @Override
    public void initUI() {
        ((TextView) findViewById(R.id.title)).setText("提现");
        findViewById(R.id.iv_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
