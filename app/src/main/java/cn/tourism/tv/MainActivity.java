package cn.tourism.tv;

import android.os.Bundle;

import com.cb.xlibrary.statusbar.StatusBarUtils;

import cn.tourism.tv.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.immersive(this);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initUI() {

    }
}
