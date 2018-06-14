package cn.tourism.tv.ui.me;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cb.xlibrary.dialog.XInputDialog;
import com.cb.xlibrary.dialog.XInputDialog.InputDialogBtnClickListener;
import com.cb.xlibrary.dialog.XUserHeadDialog;
import com.cb.xlibrary.imagepicker.ImagePicker;
import com.cb.xlibrary.imagepicker.bean.ImageItem;
import com.cb.xlibrary.statusbar.StatusBarUtils;
import com.cb.xlibrary.view.XCircleImageView;

import java.util.ArrayList;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;
import cn.tourism.tv.utils.GlideImagePickerLoader;

/**
 * 修改资料
 */
public class ModifyInfoActivity extends BaseActivity implements View.OnClickListener {

    private XCircleImageView ivHead;
    private TextView tvName, tvAge, tvAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setColor(this, Color.parseColor("#3D3D3D"), 0);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_modify_info;
    }

    @Override
    public void initUI() {
        ((TextView) findViewById(R.id.title)).setText("修改资料");

        ivHead = (XCircleImageView) findViewById(R.id.iv_head);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvAge = (TextView) findViewById(R.id.tv_age);
        tvAddress = (TextView) findViewById(R.id.tv_address);

        findViewById(R.id.iv_back).setOnClickListener(this);
        findViewById(R.id.ll_age).setOnClickListener(this);
        findViewById(R.id.ll_address).setOnClickListener(this);
        findViewById(R.id.btn_save).setOnClickListener(this);
        ivHead.setOnClickListener(this);
        tvName.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_age:
                showInputDialog("请输入年龄", InputType.TYPE_CLASS_NUMBER);
                break;
            case R.id.ll_address:
                break;
            case R.id.btn_save:
                break;
            case R.id.tv_name:
                showInputDialog("请输入昵称", InputType.TYPE_CLASS_TEXT);
                break;
            case R.id.iv_head:
                XUserHeadDialog xUserHeadDialog = new XUserHeadDialog(ModifyInfoActivity.this);
                xUserHeadDialog.setImageLoader(new GlideImagePickerLoader());
                xUserHeadDialog.show();
                break;
        }
    }

    /**
     * 弹出输入框
     *
     * @param title
     */
    private void showInputDialog(final String title, int type) {
        new XInputDialog
                .Builder(ModifyInfoActivity.this)
                .title(title)
                .leftBtnTxt("取消")
                .rightBtnTxt("确定")
                .setCancelable(false)
                .setEditInputType(type)
                .rightBtnTxtColor(Color.parseColor("#01999D"))
                .setSureClickListener(new InputDialogBtnClickListener() {
                    @Override
                    public void onClick(String content) {
                        if (title.equals("请输入昵称")) {
                            tvName.setText(content);
                        } else {
                            tvAge.setText(content + "");
                        }
                    }
                })
                .create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == XUserHeadDialog.CHANGE_HEAD_REQUEST_CODE) {
            if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
                ArrayList<ImageItem> list = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                Glide.with(ModifyInfoActivity.this).load(list.get(0).path).into(ivHead);
            }
        }
    }
}
