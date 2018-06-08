package cn.tourism.tv.ui.tuijian;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.cb.xlibrary.adapter.XRecyclerViewAdapter;
import com.cb.xlibrary.adapter.XViewHolder;
import com.cb.xlibrary.utils.XDensityUtils;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;

/**
 * 描述：推荐界面列表适配
 * 作者：曹斌
 * date:2018/6/7 17:42
 */
public class TuiJianAdapter extends RecyclerView.Adapter<TuiJianAdapter.ViewHolder> {

    private Context mContext;
    private int mImageSize;//每个图片条目的大小
    private List<String> mImageLists = new ArrayList<>();

    public TuiJianAdapter(Context mContext) {
        this.mContext = mContext;
        mImageSize = XDensityUtils.getImageItemWidth((Activity) mContext, 3);
        for (int i = 0; i < 3; i++) {
            mImageLists.add("我是第 " + i);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_tui_jian, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 2) {
            LinearLayoutManager manager = new LinearLayoutManager(mContext);
            holder.recyclerView.setLayoutManager(manager);
            holder.ziXunAdapter = new ZiXunAdapter(holder.recyclerView);
            holder.recyclerView.setAdapter(holder.ziXunAdapter);
            holder.ziXunAdapter.setDataLists(mImageLists);
            holder.line5.setVisibility(View.GONE);
        } else {
            GridLayoutManager manager = new GridLayoutManager(mContext, 3);
            holder.recyclerView.setLayoutManager(manager);
            holder.recyclerView.addItemDecoration(new Left8DpDecoration(mContext));
            holder.mImageAdapter = new TuiJianImageAdapter(holder.recyclerView);
            holder.recyclerView.setAdapter(holder.mImageAdapter);
            holder.mImageAdapter.setDataLists(mImageLists);
            holder.line5.setVisibility(View.VISIBLE);
        }
        holder.tvCategory.setText("标题" + position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivTop;
        TextView tvCategory;
        ImageView ivMore;
        RecyclerView recyclerView;
        TuiJianImageAdapter mImageAdapter;
        ZiXunAdapter ziXunAdapter;
        View line5;

        public ViewHolder(View itemView) {
            super(itemView);
            ivTop = (ImageView) itemView.findViewById(R.id.iv_top);
            tvCategory = (TextView) itemView.findViewById(R.id.tv_category);
            ivMore = (ImageView) itemView.findViewById(R.id.iv_more);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
            line5 = itemView.findViewById(R.id.line5);
        }
    }

    /**
     * 三张图片的适配器
     */
    class TuiJianImageAdapter extends XRecyclerViewAdapter<String> {

        public TuiJianImageAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_list_tuijian_image);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {
            View itemView = holder.getConvertView();
            itemView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mImageSize));
        }
    }

    /**
     * 资讯的适配器
     */
    class ZiXunAdapter extends XRecyclerViewAdapter<String> {

        public ZiXunAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_list_tuijian_zixun);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {

        }
    }
}