package cn.tourism.tv.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cb.xlibrary.view.flow.FlowLayout;
import com.cb.xlibrary.view.flow.TagAdapter;
import com.cb.xlibrary.view.flow.TagFlowLayout;

import java.util.List;

import cn.tourism.tv.R;


/**
 * 流式布局适配器
 * Created by caobin on 2017/7/27.
 */
public class FlowLayoutAdapter extends TagAdapter<String> {

    private Context mContext;
    private TagFlowLayout mFlowLayout;
    private List<String> mList;

    public FlowLayoutAdapter(Context context, TagFlowLayout flowLayout, List<String> list) {
        super(list);
        this.mList = list;
        this.mContext = context;
        this.mFlowLayout = flowLayout;
    }

    /**
     *
     */
    public void setList(List<String> list) {
        this.mList = list;
        notifyDataChanged();
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }


    @Override
    public View getView(FlowLayout parent, int position, final String s) {
        //添加布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_search_history, mFlowLayout, false);
        TextView textView = view.findViewById(R.id.tv_flow_item);
        ImageView imageView = view.findViewById(R.id.iv_remove);
        textView.setText(getItem(position));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (removeCallBack != null) {
                    removeCallBack.removeBack(s);
                }
            }
        });
        return view;
    }

    private RemoveCallBack removeCallBack;

    public void setRemoveListener(RemoveCallBack removeCallBack) {
        this.removeCallBack = removeCallBack;
    }

    public interface RemoveCallBack {
        void removeBack(String s);
    }
}
