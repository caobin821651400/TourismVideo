package cn.tourism.tv.ui.tuijian;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cb.xlibrary.view.XCircleImageView;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;

/**
 * 描述：推荐界面
 * 作者：曹斌
 * date:2018/6/7 15:47
 */
public class TuiJianFragment extends BaseFragment {

    private XCircleImageView ivHead;
    private TextView tvSearch;
    private ImageView ivCamera;
    private RecyclerView mRecyclerView;
    private TuiJianAdapter mAdapter;

    @Override
    public int getRootViewId() {
        return R.layout.fragment_tui_jian;
    }

    @Override
    public void initUI(View v) {
        ivHead = (XCircleImageView) v.findViewById(R.id.iv_head);
        tvSearch = (TextView) v.findViewById(R.id.tv_search);
        ivCamera = (ImageView) v.findViewById(R.id.iv_camera);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new TuiJianAdapter();
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {
    }
}
