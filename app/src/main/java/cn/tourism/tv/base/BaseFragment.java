package cn.tourism.tv.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.cb.xlibrary.dialog.XLoadingDialog;
import com.cb.xlibrary.utils.XLogUtils;
import com.cb.xlibrary.widget.XToast;

import cn.tourism.tv.R;

/**
 *
 */
public abstract class BaseFragment extends Fragment {

    private View mRootView;
    // 标记已加载完成，保证懒加载只能加载一次
    private boolean hasLoaded = false;
    // 标记Fragment是否已经onCreate
    private boolean isCreated = false;
    // 界面对于用户是否可见
    private boolean isVisibleToUser = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isCreated = true;//注：关键步骤
        lazyLoad(savedInstanceState);
    }

    /**
     * 监听界面是否展示给用户，实现懒加载
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.isVisibleToUser = isVisibleToUser;//注：关键步骤
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad(null);
    }

    /**
     * 懒加载方法，获取数据什么的放到这边来使用，在切换到这个界面时才进行网络请求
     */
    private void lazyLoad(Bundle savedInstanceState) {
        //如果该界面不对用户显示、已经加载、fragment还没有创建，
        //三种情况任意一种，不获取数据
        if (!isVisibleToUser || hasLoaded || !isCreated) {
            return;
        }
        lazyInit(savedInstanceState);
        hasLoaded = true;//注：关键步骤，确保数据只加载一次
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getRootViewId(), container, false);
        }
        //缓存的rootView需要判断是否已经被加过parent， 如果有parent则从parent删除，防止发生这个rootview已经有parent的错误。
        ViewGroup mViewGroup = (ViewGroup) mRootView.getParent();
        if (mViewGroup != null) {
            mViewGroup.removeView(mRootView);
        }
        initUI(mRootView);
        return mRootView;
    }

    /**
     * 跳转activity
     *
     * @param cls
     * @param bundle
     */
    protected void launchActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(getActivity(), cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 跳转activity传参
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    protected void launchActivityByCode(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(getActivity(), cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 关闭键盘
     */
    public void closeInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && getActivity().getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    /**
     * 弹出AlertDialog
     *
     * @param msg
     */
    protected void showAlert(String msg) {

    }

    @Override
    public void onDestroy() {
        closeInput();
        super.onDestroy();
    }


    /**
     * 信息错误提示框
     *
     * @param object
     */
    public void toastError(Object object) {
        XToast.error(object.toString());
    }

    /**
     * 信息提示框
     *
     * @param object
     */
    public void toastSuccess(Object object) {
        XToast.success(object.toString());
    }

    /**
     * 信息提示框
     *
     * @param object
     */
    public void toast(Object object) {
        XToast.normal(object.toString());
    }

    /**
     * 显示进度提示
     */
    protected void showDLG() {
        XLoadingDialog.with(getActivity())
                .setBackgroundColor(Color.parseColor("#aa000000"))
                .setMessageColor(Color.WHITE)
                .setMessage(getString(R.string.title_wait))
                .setCanceled(true)
                .show();
    }

    /**
     * 显示进度提示
     *
     * @param msg
     */
    protected void showDlgWithMsg(String msg) {
        XLoadingDialog.with(getActivity())
                .setBackgroundColor(Color.parseColor("#aa000000"))
                .setMessageColor(Color.WHITE)
                .setMessage(TextUtils.isEmpty(msg) ? getString(R.string.title_wait) : msg)
                .setCanceled(true)
                .show();
    }

    /**
     * 关闭进度提示
     */
    protected void disMissDLG() {
        try {
            XLoadingDialog.with(getActivity()).dismiss();
        } catch (Exception e) {
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isCreated = false;
        hasLoaded = false;
    }

    public abstract int getRootViewId();

    public abstract void initUI(View v);

    /**
     * 子类必须实现的方法，这个方法里面的操作都是需要懒加载的
     */
    public abstract void lazyInit(Bundle savedInstanceState);
}
