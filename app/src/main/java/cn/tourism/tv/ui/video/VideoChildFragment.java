package cn.tourism.tv.ui.video;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
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
import cn.tourism.tv.base.BaseViewPagerFragment;
import cn.tourism.tv.ui.zhibo.ZhiBoDetailsActivity;

/**
 * 描述：视频分类子界面
 * 作者：曹斌
 * date:2018/6/8 09:36
 */
public class VideoChildFragment extends BaseViewPagerFragment {

    private SwipeRefreshLayout swipeLayout;
    private RecyclerView mRecyclerView;
    private VideoChildAdapter mAdapter;

    private List<String> listDatas = new ArrayList<>();
    //
    private int mImageSize = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhi_bo_child, container, false);
        initView(view);
        return view;
    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {
        XLogUtils.d("lan");
    }

    public void initView(View v) {
        swipeLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_layout);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        mImageSize = XDensityUtils.getImageItemWidth(getActivity(), 2);

        /*******************************/

        for (int i = 0; i < 10; i++) {
            listDatas.add("");
        }
        /*******************************/

        mAdapter = new VideoChildAdapter(mRecyclerView);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        XGridItemDecoration decoration = new XGridItemDecoration
                .Builder(getActivity())
                .setColor(getResources().getColor(R.color.transparent))
                .setHorizontal(18f)
                .build();
        addHeadView();
        mRecyclerView.addItemDecoration(decoration);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setDataLists(listDatas);

        mAdapter.setOnItemClickListener(new XRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                launchActivity(ZhiBoDetailsActivity.class, null);

            }
        });
    }

    /**
     *
     */
    private void addHeadView() {
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_video_top, null);
        mAdapter.addHeaderView(headView);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /**
     *
     */
    class VideoChildAdapter extends XRecyclerViewAdapter<String> {

        private ImageView ivImage;
        private TextView tvClassify;
        private TextView tvTitle;

        public VideoChildAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_video_child);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {
            View itemView = holder.getConvertView();
            itemView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (mImageSize * 0.8)));
            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);
            tvClassify = (TextView) itemView.findViewById(R.id.tv_classify);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
