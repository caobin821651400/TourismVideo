package cn.tourism.tv.ui.video;

import android.os.Bundle;
import android.view.View;

import com.cb.xlibrary.utils.XLogUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;

/**
 * 描述：视频界面
 * 作者：曹斌
 * date:2018/6/7 15:47
 */
public class VideoFragment extends BaseFragment {

    @Override
    public int getRootViewId() {
        return R.layout.fragment_video;
    }

    @Override
    public void initUI(View v) {

    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {
        XLogUtils.d("3333");
    }
}
