package cn.tourism.tv.ui.me.manager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cb.xlibrary.adapter.XRecyclerViewAdapter;
import com.cb.xlibrary.adapter.XViewHolder;
import com.cb.xlibrary.statusbar.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

/**
 * 评论管理
 */
public class CommentManageActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private CommentAdapter mAdapter;
    private List<String> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.status_bar_color), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_conment_manage;
    }

    @Override
    public void initUI() {
        findViewById(R.id.iv_back).setOnClickListener(this);
        mRecyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new CommentAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        for (int i = 0; i < 10; i++) {
            mList.add("");
        }
        mAdapter.setDataLists(mList);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    class CommentAdapter extends XRecyclerViewAdapter<String> {

        public CommentAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_comment_manage);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {

        }
    }
}
