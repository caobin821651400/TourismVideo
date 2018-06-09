package cn.tourism.tv.ui.me.setting;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cb.xlibrary.adapter.XRecyclerViewAdapter;
import com.cb.xlibrary.adapter.XViewHolder;
import com.cb.xlibrary.recycler.ItemDecoration.XPaddingDividerDecoration;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

/**
 * 我的消息
 */
public class MyMsgActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private MsgAdapter mAdapter;
    private List<String> msgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_my_msg;
    }

    @Override
    public void initUI() {
        ((TextView) findViewById(R.id.title)).setText("我的消息");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        findViewById(R.id.iv_back).setOnClickListener(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
//        XPaddingDividerDecoration decoration = new XPaddingDividerDecoration(1,0,0, Color.parseColor("#E5E5E5"));
        XPaddingDividerDecoration decoration = new XPaddingDividerDecoration
                .Builder(this)
                .setColor(Color.parseColor("#e5e5e5"))
                .setHeight(1f)
                .build();
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(decoration);
        mAdapter = new MsgAdapter(recyclerView);
        recyclerView.setAdapter(mAdapter);

        for (int i = 0; i < 10; i++) {
            msgList.add("");
        }

        mAdapter.setDataLists(msgList);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }


    class MsgAdapter extends XRecyclerViewAdapter<String> {

        public MsgAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_my_msg);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {

        }
    }
}
