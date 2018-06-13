package cn.tourism.tv.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.cb.xlibrary.adapter.XRecyclerViewAdapter;
import com.cb.xlibrary.adapter.XViewHolder;
import com.cb.xlibrary.pop.XBasePopupWindow;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;

/**
 * 描述：
 * 作者：曹斌
 * date:2018/6/13 10:49
 */
public class VideoCommentDialog implements XBasePopupWindow.ViewInterface {

    private XBasePopupWindow popupWindow;
    private Context mContext;
    private RecyclerView mRecyclerView;
    private CommentAdapter mAdapter;
    private List<String> mList = new ArrayList<>();

    public VideoCommentDialog(Context context) {
        this.mContext = context;
    }

    public void showDialog(View view) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        popupWindow = new XBasePopupWindow.Builder(mContext)
                .setView(R.layout.layout_video_comment_pop)
                .setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .setAnimationStyle(R.style.AnimUp)
                .setViewOnclickListener(this)
                .setOutsideTouchable(true)
                .create();
        popupWindow.showAsDropDown(view);
    }

    @Override
    public void getChildView(View view, int layoutResId) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new CommentAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        for (int i = 0; i < 10; i++) {
            mList.add("");
        }
        mAdapter.setDataLists(mList);
    }

    /**
     *
     */
    class CommentAdapter extends XRecyclerViewAdapter<String> {
        public CommentAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_comment_manage);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {

        }
    }
}
