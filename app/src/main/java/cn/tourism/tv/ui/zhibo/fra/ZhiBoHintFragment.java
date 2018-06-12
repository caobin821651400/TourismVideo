package cn.tourism.tv.ui.zhibo.fra;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.cb.xlibrary.utils.XLogUtils;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;

/**
 * 描述：直播提示
 * 作者：曹斌
 * date:2018/6/7 15:47
 */
public class ZhiBoHintFragment extends BaseFragment {

    private TextView tvContent, tvExpand;

    @Override
    public int getRootViewId() {
        return R.layout.fragment_zhibo_hint;
    }

    @Override
    public void initUI(View v) {
        tvContent = v.findViewById(R.id.tv_content);
        tvExpand = v.findViewById(R.id.tv_expand);
        tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                XLogUtils.d(tvContent.getMaxLines() + "");
            }
        });

        tvExpand.setOnClickListener(new View.OnClickListener() {
            boolean b = true;

            @Override
            public void onClick(View view) {
                if (b) {
                    b = false;
                    tvContent.setEllipsize(null); // 展开
                    tvContent.setMaxLines(100);
                    tvExpand.setText("收起");
                } else {
                    b = true;
                    tvContent.setEllipsize(TextUtils.TruncateAt.END); // 收缩
                    tvContent.setMaxLines(3);
                    tvExpand.setText("全文");
                }
            }
        });


    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {

        XLogUtils.d("555555");
    }
}
