package cn.tourism.tv.ui.info;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.cb.xlibrary.adapter.XRecyclerViewAdapter;
import com.cb.xlibrary.adapter.XViewHolder;
import com.cb.xlibrary.widget.XSwipeRefreshLayout;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseFragment;
import cn.tourism.tv.utils.GlideImageLoader;
import cn.tourism.tv.utils.MyUtils;

/**
 * 描述：
 * 作者：曹斌
 * date:2018/6/8 09:36
 */
public class ZiXunChildFragment extends BaseFragment {
    private XSwipeRefreshLayout swipeLayout;
    private RecyclerView mRecyclerView;
    private ZiXunChildAdapter mAdapter;
    private Banner mBanner;

    private List<String> listDatas = new ArrayList<>();
    private List<String> listBanners = new ArrayList<>();

    @Override
    public int getRootViewId() {
        return R.layout.fragment_zi_xun_child;
    }

    @Override
    public void initUI(View v) {
        swipeLayout = (XSwipeRefreshLayout) v.findViewById(R.id.swipe_layout);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);

        /*******************************/

        for (int i = 0; i < 10; i++) {
            listDatas.add("");
        }
        if (listBanners != null)
            listBanners.clear();
        listBanners.add("http://img.zcool.cn/community/01b72057a7e0790000018c1bf4fce0.png");
        listBanners.add("http://img.zcool.cn/community/01fca557a7f5f90000012e7e9feea8.jpg");
        listBanners.add("http://img.zcool.cn/community/01996b57a7f6020000018c1bedef97.jpg");
        listBanners.add("http://img.zcool.cn/community/01700557a7f42f0000018c1bd6eb23.jpg");

        /*******************************/

        mAdapter = new ZiXunChildAdapter(mRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(manager);
        initBanner();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setDataLists(listDatas);
    }

    @Override
    public void lazyInit(Bundle savedInstanceState) {

    }

    /**
     * 初始化banner
     */
    private void initBanner() {
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_banner, null);
        mBanner = headerView.findViewById(R.id.banner);
        mBanner.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, MyUtils.getScreenHeight(getActivity()) / 5));
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.update(listBanners);
        mBanner.start();
        mAdapter.addHeaderView(headerView);
    }

    @Override
    public void onStart() {
        super.onStart();
        mBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        mBanner.stopAutoPlay();
    }

    class ZiXunChildAdapter extends XRecyclerViewAdapter<String> {

        public ZiXunChildAdapter(@NonNull RecyclerView mRecyclerView) {
            super(mRecyclerView, R.layout.item_list_tuijian_zixun);
        }

        @Override
        protected void bindData(XViewHolder holder, String data, int position) {

        }
    }
}
