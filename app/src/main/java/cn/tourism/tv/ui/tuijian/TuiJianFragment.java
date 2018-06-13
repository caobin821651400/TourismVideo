package cn.tourism.tv.ui.tuijian;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;
import cn.tourism.tv.ui.SearchActivity;
import cn.tourism.tv.ui.me.MeActivity;

/**
 * 描述：推荐界面
 * 作者：曹斌
 * date:2018/6/7 15:47
 */
public class TuiJianFragment extends BaseFragment implements View.OnClickListener {

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
        v.findViewById(R.id.iv_head).setOnClickListener(this);
        v.findViewById(R.id.tv_search).setOnClickListener(this);
        tvSearch = (TextView) v.findViewById(R.id.tv_search);
        ivCamera = (ImageView) v.findViewById(R.id.iv_camera);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new TuiJianAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_head:
                launchActivity(MeActivity.class, null);
                break;
            case R.id.tv_search:
                launchActivity(SearchActivity.class, null);
                break;
        }
    }
}
