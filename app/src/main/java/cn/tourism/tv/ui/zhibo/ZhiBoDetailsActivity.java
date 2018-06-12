package cn.tourism.tv.ui.zhibo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cb.xlibrary.utils.XLogUtils;
import com.pili.pldroid.player.PLMediaPlayer;
import com.pili.pldroid.player.widget.PLVideoTextureView;
import com.pili.pldroid.player.widget.PLVideoView;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;
import cn.tourism.tv.ui.zhibo.fra.AudienceFragment;
import cn.tourism.tv.ui.zhibo.fra.ChatFragment;
import cn.tourism.tv.ui.zhibo.fra.LookBackFragment;
import cn.tourism.tv.ui.zhibo.fra.ZhiBoHintFragment;

public class ZhiBoDetailsActivity extends BaseActivity implements View.OnClickListener {

    PLVideoTextureView vtv;
    private int mRotation;
    private String url = "http://liveal.quanmin.tv/live/7137767.flv";
    private boolean isFull;
    //
    private View view1, view2, view3, view4;
    private TextView tab1, tab2, tab3, tab4;
    private LinearLayout llFollow;
    private TextView tvFollowCount;
    //
    private ChatFragment chatFragment;
    private ZhiBoHintFragment hintFragment;
    private AudienceFragment audienceFragment;
    private LookBackFragment lookBackFragment;
    private FragmentManager fragmentManager;
    private int currentIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_zhi_bo_details;
    }

    @Override
    public void initUI() {
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        vtv = findViewById(R.id.vtv);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        tab1 = findViewById(R.id.tv_tab1);
        tab2 = findViewById(R.id.tv_tab2);
        tab3 = findViewById(R.id.tv_tab3);
        tab4 = findViewById(R.id.tv_tab4);
        llFollow = findViewById(R.id.ll_follow);
        tvFollowCount = findViewById(R.id.tv_follow_count);

        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
        tab4.setOnClickListener(this);

        initZhiBo();
        setTabSelection(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_tab1:
                if (currentIndex == 0) return;
                setTabSelection(0);
                break;
            case R.id.tv_tab2:
                if (currentIndex == 1) return;
                setTabSelection(1);
                break;
            case R.id.tv_tab3:
                if (currentIndex == 2) return;
                setTabSelection(2);
                break;
            case R.id.tv_tab4:
                if (currentIndex == 3) return;
                setTabSelection(3);
                break;
        }
    }

    /**
     * 切换fragment
     *
     * @param index
     */
    private void setTabSelection(int index) {
        currentIndex = index;
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        clearTab();
        hideFragments(transaction);
        switch (index) {
            case 0:
                tab1.setSelected(true);
                view1.setVisibility(View.VISIBLE);
                if (chatFragment == null) {
                    chatFragment = new ChatFragment();
                    transaction.add(R.id.content, chatFragment, "chatFragment");
                } else {
                    transaction.show(chatFragment);
                }
                break;
            case 1:
                tab2.setSelected(true);
                view2.setVisibility(View.VISIBLE);
                if (audienceFragment == null) {
                    audienceFragment = new AudienceFragment();
                    transaction.add(R.id.content, audienceFragment, "audienceFragment");
                } else {
                    transaction.show(audienceFragment);
                }
                break;
            case 2:
                tab3.setSelected(true);
                view3.setVisibility(View.VISIBLE);
                if (hintFragment == null) {
                    hintFragment = new ZhiBoHintFragment();
                    transaction.add(R.id.content, hintFragment, "hintFragment");
                } else {
                    transaction.show(hintFragment);
                }
                break;
            case 3:
                tab4.setSelected(true);
                view4.setVisibility(View.VISIBLE);
                if (lookBackFragment == null) {
                    lookBackFragment = new LookBackFragment();
                    transaction.add(R.id.content, lookBackFragment, "lookBackFragment");
                } else {
                    transaction.show(lookBackFragment);
                }
                break;
            default:
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * 将所有的fragment隐藏
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (chatFragment != null) {
            transaction.hide(chatFragment);
        }
        if (audienceFragment != null) {
            transaction.hide(audienceFragment);
        }
        if (hintFragment != null) {
            transaction.hide(hintFragment);
        }
        if (lookBackFragment != null) {
            transaction.hide(lookBackFragment);
        }
    }

    /**
     * 将所有的tab设置为默认状态
     */
    private void clearTab() {
        view1.setVisibility(View.INVISIBLE);
        view2.setVisibility(View.INVISIBLE);
        view3.setVisibility(View.INVISIBLE);
        view4.setVisibility(View.INVISIBLE);
        tab1.setSelected(false);
        tab2.setSelected(false);
        tab3.setSelected(false);
        tab4.setSelected(false);

    }

    /**
     * 直播相关设置
     */
    private void initZhiBo() {
        vtv.setVideoPath(url);
        if (isFull) {
            vtv.setDisplayOrientation(PLVideoView.ASPECT_RATIO_PAVED_PARENT);
        } else {
            vtv.setDisplayOrientation(PLVideoView.ASPECT_RATIO_16_9);
        }
        vtv.setOnPreparedListener(new PLMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(PLMediaPlayer plMediaPlayer) {
                XLogUtils.d("onPrepared:" + url);
                start();
            }
        });
        vtv.setOnBufferingUpdateListener(new PLMediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(PLMediaPlayer plMediaPlayer, int i) {
                if (i > 0)
                    XLogUtils.d("onBufferingUpdate|" + i);
            }
        });
        vtv.setOnCompletionListener(new PLMediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(PLMediaPlayer plMediaPlayer) {
                XLogUtils.d("onCompletion");
            }
        });
        vtv.setOnInfoListener(new PLMediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(PLMediaPlayer plMediaPlayer, int i, int i1) {
                XLogUtils.d("onInfo|i:" + i + "--i1:" + i1);
                return false;
            }
        });

        vtv.setOnErrorListener(new PLMediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(PLMediaPlayer plMediaPlayer, int i) {
                XLogUtils.w("onError:i:" + i);

                return false;
            }
        });
    }

    private void start() {
        if (vtv != null)
            vtv.start();
    }

    public void pause() {
        if (vtv != null)
            vtv.pause();
    }

    public void stopPlayback() {
        if (vtv != null)
            vtv.stopPlayback();

    }

    @Override
    public void onResume() {
        super.onResume();
        start();
    }

    @Override
    public void onPause() {
        super.onPause();
        pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopPlayback();
    }
}
