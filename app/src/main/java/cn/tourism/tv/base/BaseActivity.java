package cn.tourism.tv.base;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cb.xlibrary.dialog.XLoadingDialog;
import com.cb.xlibrary.utils.XPermission;
import com.cb.xlibrary.widget.XToast;

import cn.tourism.tv.R;

/**
 * 描述：基类
 * 作者：曹斌
 * date:2018/6/7 09:56
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getRootViewId());

        initUI();

    }

    /**
     * Glide展示图片
     *
     * @param path
     * @param mImageView
     */
    public void showImg(String path, ImageView mImageView) {
        Glide.with(getApplicationContext()).load(path)
                .placeholder(R.drawable.ic_default_image)
                .into(mImageView);
    }


    /**
     * 跳转activity
     *
     * @param cls    跳转的类
     * @param bundle 携带的数据
     */
    public void launchActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * Toast任何类型的数据
     *
     * @param object
     */
    public void toast(Object object) {
        Toast.makeText(BaseActivity.this, object.toString(), Toast.LENGTH_SHORT).show();
    }

    /**
     * 弹出AlertDialog
     *
     * @param msg
     */

    protected void showAlert(String msg) {
        new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("温馨提示").setMessage(msg)
                .setPositiveButton("确定", null).create().show();
    }

    /****
     * 信息提示框
     * @param object
     */
    public void toastError(Object object) {
        XToast.error(object.toString());
    }

    /****
     * 信息提示框
     * @param object
     */
    public void toastSuccess(Object object) {
        XToast.success(object.toString());
    }

    /**
     * 显示进度提示
     */
    protected void showDLG() {
        XLoadingDialog.with(this)
                .setBackgroundColor(Color.parseColor("#aa000000"))
                .setMessageColor(Color.WHITE)
                .setMessage(getString(R.string.title_wait))
                .setCanceled(true)
                .show();
    }

    protected void showDlgWithMsg(String msg) {
        XLoadingDialog.with(this)
                .setBackgroundColor(Color.parseColor("#aa000000"))
                .setMessageColor(Color.WHITE)
                .setMessage(TextUtils.isEmpty(msg) ? getString(R.string.title_wait) : msg)
                .setCanceled(true)
                .show();
    }

    protected void disMissDLG() {
        try {
            XLoadingDialog.with(this).dismiss();
        } catch (Exception e) {
        }
    }

    @Override
    protected void onDestroy() {
        closeInput();
        try {
            if (XLoadingDialog.with(this) != null) {
                XLoadingDialog.with(this).dismiss();
            }
        } catch (Exception e) {
        }
        super.onDestroy();
    }

    /**
     * 关闭键盘
     */
    public void closeInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * Android M 全局权限申请回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        XPermission.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public abstract int getRootViewId();

    public abstract void initUI();
}
