package cn.tourism.tv.ui.zhly;

import android.os.Bundle;
import android.view.View;

import com.cb.xlibrary.utils.XLogUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;

/**
 * 描述：智慧旅游界面
 * 作者：曹斌
 * date:2018/6/7 15:47
 */
public class ZhlyFragment extends BaseFragment {

    @Override
    public int getRootViewId() {
        return R.layout.fragment_zhly;
    }

    @Override
    public void initUI(View v) {
    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {

        XLogUtils.d("555555");
    }
}
