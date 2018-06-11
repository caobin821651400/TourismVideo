package cn.tourism.tv.ui.me.fans;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cb.xlibrary.adapter.XRecyclerViewAdapter;
import com.cb.xlibrary.adapter.XViewHolder;
import com.cb.xlibrary.recycler.ItemDecoration.XPaddingDividerDecoration;
import com.cb.xlibrary.widget.XSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;

/**
 * 描述：
 * 作者：曹斌
 * date:2018/6/8 09:36
 */
public class CareFragment extends BaseFragment {
    private XSwipeRefreshLayout swipeLayout;
    private RecyclerView mRecyclerView;
    private CareAdapter mAdapter;

    private List<String> listDatas = new ArrayList<>();

    @Override
    public int getRootViewId() {
        return R.layout.fragment_zi_xun_child;
    }

    @Override
    public void initUI(View v) {
        swipeLayout = (XSwipeRefreshLayout) v.findViewById(R.id.swipe_layout);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        /*******************************/

        for (int i = 0; i < 10; i++) {
            listDatas.add("");
        }
        /*******************************/

        mAdapter = new CareAdapter(mRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        XPaddingDividerDecoration decoration = new XPaddingDividerDecoration
                .Builder(getActivity())
                .setColor(Color.parseColor("#ececec"))
                .setHeight(1f)
                .build();
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setDataLists(listDatas);
    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    class CareAdapter extends XRecyclerViewAdapter<String> {

        public CareAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_care);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {

        }
    }
}
