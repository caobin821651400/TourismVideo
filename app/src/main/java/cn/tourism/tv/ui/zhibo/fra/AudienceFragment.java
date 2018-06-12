package cn.tourism.tv.ui.zhibo.fra;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cb.xlibrary.adapter.XRecyclerViewAdapter;
import com.cb.xlibrary.adapter.XViewHolder;
import com.cb.xlibrary.recycler.ItemDecoration.XPaddingDividerDecoration;
import com.cb.xlibrary.utils.XLogUtils;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;

/**
 * 描述：直播-观众
 * 作者：曹斌
 * date:2018/6/7 15:47
 */
public class AudienceFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private AudienceAdapter mAdapter;
    private List<String> msgList = new ArrayList<>();

    @Override
    public int getRootViewId() {
        return R.layout.fragment_zhibo_audience;
    }

    @Override
    public void initUI(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
//        XPaddingDividerDecoration decoration = new XPaddingDividerDecoration(1,0,0, Color.parseColor("#E5E5E5"));
        XPaddingDividerDecoration decoration = new XPaddingDividerDecoration
                .Builder(getActivity())
                .setColor(Color.parseColor("#e5e5e5"))
                .setHeight(1f)
                .build();
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(decoration);
        mAdapter = new AudienceAdapter(recyclerView);
        recyclerView.setAdapter(mAdapter);

        for (int i = 0; i < 10; i++) {
            msgList.add("");
        }

        mAdapter.setDataLists(msgList);
    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {

        XLogUtils.d("555555");
    }

    /**
     *
     */
    class AudienceAdapter extends XRecyclerViewAdapter<String> {

        public AudienceAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_zhibo_audience);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {

        }
    }
}
