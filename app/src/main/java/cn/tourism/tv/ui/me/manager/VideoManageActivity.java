package cn.tourism.tv.ui.me.manager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.cb.xlibrary.adapter.XRecyclerViewAdapter;
import com.cb.xlibrary.adapter.XViewHolder;
import com.cb.xlibrary.recycler.ItemDecoration.XPaddingDividerDecoration;
import com.cb.xlibrary.statusbar.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;
import cn.tourism.tv.utils.MyUtils;

/**
 * 视频管理
 */
public class VideoManageActivity extends BaseActivity {

    private CheckBox checkboxAll;
    private RecyclerView mRecyclerView;
    private VideoAdapter mAdapter;
    private TextView tvDelete;
    private List<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, Color.parseColor("#3D3D3D"), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_video_manage;
    }

    @Override
    public void initUI() {
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        checkboxAll = (CheckBox) findViewById(R.id.checkbox_all);
        tvDelete = findViewById(R.id.tv_delete);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        XPaddingDividerDecoration decoration = new XPaddingDividerDecoration
                .Builder(this)
                .setColor(Color.parseColor("#e1e1e1"))
                .setLeftPadding((float) MyUtils.dp2px(this, 8))
                .setHeight(1f)
                .build();
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new VideoAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);

        for (int i = 0; i < 10; i++) {
            dataList.add("我是第 " + i);
        }
        mAdapter.setDataLists(dataList);


        checkboxAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkboxAll.isChecked()) {
                    for (String s : dataList) {
                        if (!mAdapter.getSelectList().contains(s))
                            mAdapter.getSelectList().add(s);
                    }
                    mAdapter.notifyDataSetChanged();
                } else {
                    mAdapter.getSelectList().clear();
                    mAdapter.notifyDataSetChanged();
                }
                tvDelete.setText("删除(" + mAdapter.getSelectList().size() + ")");
            }
        });
    }

    /**
     * 适配器
     */
    class VideoAdapter extends XRecyclerViewAdapter<String> {
        private CheckBox checkbox;
        private ImageView ivImage;
        private TextView tvTitle;
        private TextView tvTime;
        private TextView tvWatch;

        private List<String> selectList;


        public VideoAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_video_manege);
        }

        @Override
        protected void bindData(XViewHolder holder, final String data, int position) {
            View itemView = holder.getConvertView();
            checkbox = (CheckBox) itemView.findViewById(R.id.checkbox);
            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvWatch = (TextView) itemView.findViewById(R.id.tv_watch);

            //防止复用机制造成的滑动乱勾选
            if (getSelectList().contains(data)) {
                checkbox.setChecked(true);
            } else {
                checkbox.setChecked(false);
            }
            //点击事件
            checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getSelectList().contains(data)) {
                        if (checkboxAll.isChecked()) checkboxAll.setChecked(false);
                        getSelectList().remove(data);
                    } else {
                        getSelectList().add(data);
                        if (getSelectList().size() == getDataLists().size())
                            checkboxAll.setChecked(true);
                    }
                    tvDelete.setText("删除(" + getSelectList().size() + ")");
                }
            });
        }

        /**
         * 勾选中的列表
         *
         * @return
         */
        public List<String> getSelectList() {
            if (selectList == null) {
                selectList = new ArrayList<>();
            }
            return selectList;
        }
    }
}
