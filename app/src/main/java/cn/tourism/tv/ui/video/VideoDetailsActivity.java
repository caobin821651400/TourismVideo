package cn.tourism.tv.ui.video;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cb.xlibrary.adapter.XRecyclerViewAdapter;
import com.cb.xlibrary.adapter.XViewHolder;
import com.cb.xlibrary.recycler.ItemDecoration.XGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;
import cn.tourism.tv.view.VideoCommentDialog;

/**
 * 视频播放详情界面
 */
public class VideoDetailsActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvVideoDetails;
    private TextView tvExpand;
    private LinearLayout popLayout;
    private RecyclerView mRecyclerView;
    private HotVideoAdapter mAdapter;
    boolean isExpand = true;
    private List<String> hotVideoList = new ArrayList<>();
    //
    private VideoCommentDialog commentDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_video_details;
    }

    @Override
    public void initUI() {
        tvVideoDetails = (TextView) findViewById(R.id.tv_video_details);
        tvExpand = (TextView) findViewById(R.id.tv_expand);
        mRecyclerView = findViewById(R.id.recycler_view);
        popLayout = findViewById(R.id.ll_second_layout);

        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.tv_comment).setOnClickListener(this);
        tvExpand.setOnClickListener(this);

        for (int i = 0; i < 3; i++) {
            hotVideoList.add("");
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
        mAdapter = new HotVideoAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setNestedScrollingEnabled(false);
        mAdapter.setDataLists(hotVideoList);

        commentDialog = new VideoCommentDialog(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_expand://展开收起
                if (isExpand) {
                    tvExpand.setText("全文");
                    tvVideoDetails.setMaxLines(3);
                    tvVideoDetails.setEllipsize(TextUtils.TruncateAt.END); // 收缩
                } else {
                    tvExpand.setText("收起");
                    tvVideoDetails.setMaxLines(100);
                    tvVideoDetails.setEllipsize(null);
                }
                isExpand = !isExpand;
                break;
            case R.id.tv_comment://底部评论数量
                commentDialog.showDialog(popLayout);
                break;
        }
    }

    /**
     * 热门视频适配
     */
    class HotVideoAdapter extends XRecyclerViewAdapter<String> {
        public HotVideoAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_hot_video);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {
            View itemView = holder.getConvertView();
        }
    }
}
