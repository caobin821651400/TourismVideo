package cn.tourism.tv.ui.zhibo;

import android.os.Bundle;
import android.view.View;

import com.cb.xlibrary.utils.XLogUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;

/**
 * 描述：直播界面
 * 作者：曹斌
 * date:2018/6/7 15:47
 */
public class ZhiBoFragment extends BaseFragment {

    @Override
    public int getRootViewId() {
        return R.layout.fragment_zhi_bo;
    }

    @Override
    public void initUI(View v) {

    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {

        XLogUtils.d("2222222");
    }
}
