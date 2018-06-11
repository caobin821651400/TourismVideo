package cn.tourism.tv.ui.zhibo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cb.xlibrary.adapter.XRecyclerViewAdapter;
import com.cb.xlibrary.adapter.XViewHolder;
import com.cb.xlibrary.statusbar.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

/**
 * 直播分类
 */
public class ZhiBoClassifyActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private ZhiBoClassifyAdapter mAdapter;
    private List<String> listDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, Color.parseColor("#01999d"), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_zhi_bo_classify;
    }

    @Override
    public void initUI() {
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mRecyclerView = findViewById(R.id.recycler_view);

        for (int i = 0; i < 12; i++) {
            listDatas.add("");
        }

        GridLayoutManager manager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new ZhiBoClassifyAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setDataLists(listDatas);

        mAdapter.setOnItemClickListener(new XRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                String s = listDatas.get(position);
                listDatas.set(position, s + "哈哈");
                mAdapter.setDataLists(listDatas);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     *
     */
    class ZhiBoClassifyAdapter extends XRecyclerViewAdapter<String> {

        private TextView tvContent;

        public ZhiBoClassifyAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_zhibo_classify);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {
            View itemView = holder.getConvertView();
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);

            if (data.contains("哈哈")) {
                tvContent.setSelected(true);
            } else {
                tvContent.setSelected(false);
            }

        }
    }
}
