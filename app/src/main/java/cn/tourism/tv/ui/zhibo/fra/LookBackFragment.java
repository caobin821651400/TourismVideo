package cn.tourism.tv.ui.zhibo.fra;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.cb.xlibrary.adapter.XRecyclerViewAdapter;
import com.cb.xlibrary.adapter.XViewHolder;
import com.cb.xlibrary.recycler.ItemDecoration.XGridItemDecoration;
import com.cb.xlibrary.utils.XDensityUtils;
import com.cb.xlibrary.utils.XLogUtils;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;

/**
 * 描述：往期回看
 * 作者：曹斌
 * date:2018/6/7 15:47
 */
public class LookBackFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private LookBackAdapter mAdapter;
    private int mImageSize = 0;
    //
    private List<String> listDatas = new ArrayList<>();

    @Override
    public int getRootViewId() {
        return R.layout.fragment_look_back;
    }

    @Override
    public void initUI(View v) {
        mImageSize = XDensityUtils.getImageItemWidth(getActivity(), 2);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        /*******************************/

        for (int i = 0; i < 10; i++) {
            listDatas.add("");
        }
        /*******************************/


        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        XGridItemDecoration decoration = new XGridItemDecoration
                .Builder(getActivity())
                .setColor(getResources().getColor(R.color.transparent))
                .setHorizontal(18f)
                .setVertical(18f)
                .build();
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new LookBackAdapter(mRecyclerView);
        addHeaderView();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setDataLists(listDatas);
    }

    /**
     *
     */
    private void addHeaderView() {
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.view_recycler_view_header_12dp, null);
        mAdapter.addHeaderView(headerView);
//        mAdapter.addFooterView(headerView);
    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {

        XLogUtils.d("555555");
    }

    /**
     *
     */
    class LookBackAdapter extends XRecyclerViewAdapter<String> {

        private ImageView ivImage;
        private TextView tvClassify;
        private TextView tvTitle;

        public LookBackAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_zhi_bo_look_back);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {
            View itemView = holder.getConvertView();
            itemView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (mImageSize * 0.85)));
            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);
            tvClassify = (TextView) itemView.findViewById(R.id.tv_classify);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
