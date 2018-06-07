package cn.tourism.tv.ui.tuijian;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import cn.tourism.tv.utils.MyUtils;

/**
 * Created by caobin on 2018/6/7.
 */

public class Left8DpDecoration extends RecyclerView.ItemDecoration {

    private Context mContext;

    public Left8DpDecoration(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int childCount = (parent.getAdapter().getItemCount());
        int itemPosition = parent.getChildAdapterPosition(view);
        if (itemPosition == 2) {
            outRect.set(MyUtils.dp2px(mContext, 8), 0, MyUtils.dp2px(mContext, 8), 0);
        } else {
            outRect.set(MyUtils.dp2px(mContext, 8), 0, 0, 0);
        }
    }
}
