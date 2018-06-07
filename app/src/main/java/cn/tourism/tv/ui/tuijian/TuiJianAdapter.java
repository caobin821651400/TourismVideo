package cn.tourism.tv.ui.tuijian;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cn.tourism.tv.R;

/**
 * 描述：推荐界面列表适配
 * 作者：曹斌
 * date:2018/6/7 17:42
 */
public class TuiJianAdapter extends RecyclerView.Adapter<TuiJianAdapter.ViewHolder> {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_tui_jian, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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

        public ViewHolder(View itemView) {
            super(itemView);
            ivTop = (ImageView) itemView.findViewById(R.id.iv_top);
            tvCategory = (TextView) itemView.findViewById(R.id.tv_category);
            ivMore = (ImageView) itemView.findViewById(R.id.iv_more);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }
}