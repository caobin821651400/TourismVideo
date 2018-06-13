package cn.tourism.tv.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cb.xlibrary.adapter.XRecyclerViewAdapter;
import com.cb.xlibrary.adapter.XViewHolder;
import com.cb.xlibrary.recycler.ItemDecoration.XGridItemDecoration;
import com.cb.xlibrary.statusbar.StatusBarUtils;
import com.cb.xlibrary.utils.XLogUtils;
import com.cb.xlibrary.view.flow.FlowLayout;
import com.cb.xlibrary.view.flow.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

/**
 * 搜索
 */
public class SearchActivity extends BaseActivity implements View.OnClickListener {

    private TagFlowLayout mFlowLayout;
    private FlowLayoutAdapter mFlowLayoutAdapter;
    private List<String> mTagLists = new ArrayList<>();
    //
    private YouLikeAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<String> youLikeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.status_bar_color), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_search;
    }

    @Override
    public void initUI() {
        mFlowLayout = (TagFlowLayout) findViewById(R.id.id_flow_layout);
        mRecyclerView = findViewById(R.id.recycler_view);

        findViewById(R.id.iv_back).setOnClickListener(this);

        initFlowLayout();
        initYouLike();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    /**
     * 搜搜历史
     */
    private void initFlowLayout() {
        for (int i = 0; i < 6; i++) {
            mTagLists.add("第" + i);
        }
        mTagLists.add("让我做你的眼睛");

        mFlowLayoutAdapter = new FlowLayoutAdapter(this, mFlowLayout, mTagLists);
        mFlowLayout.setAdapter(mFlowLayoutAdapter);

        //流式布局点击
        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public void onTagClick(View view, int position, FlowLayout parent) {

                XLogUtils.d("++++++++++++++++");
            }
        });
        //八叉 点击
        mFlowLayoutAdapter.setRemoveListener(new FlowLayoutAdapter.RemoveCallBack() {
            @Override
            public void removeBack(String tag) {
                XLogUtils.d("----------------");
                mTagLists.remove(tag);
                mFlowLayoutAdapter.notifyDataChanged();
            }
        });
    }

    /**
     * 猜你喜欢
     */
    private void initYouLike() {
        for (int i = 0; i < 3; i++) {
            youLikeList.add("");
        }
        //adapter
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        XGridItemDecoration decoration = new XGridItemDecoration
                .Builder(this)
                .setHorizontal(18f)
                .setColor(getResources().getColor(R.color.transparent))
                .build();
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new YouLikeAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mAdapter.setDataLists(youLikeList);
    }


    /**
     * 猜你喜欢适配
     */
    class YouLikeAdapter extends XRecyclerViewAdapter<String> {
        public YouLikeAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_hot_video);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {
            View itemView = holder.getConvertView();
        }
    }
}
