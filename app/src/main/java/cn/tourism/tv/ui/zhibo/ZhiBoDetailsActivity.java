package cn.tourism.tv.ui.zhibo;

import android.os.Bundle;

import com.cb.xlibrary.utils.XLogUtils;
import com.pili.pldroid.player.PLMediaPlayer;
import com.pili.pldroid.player.widget.PLVideoTextureView;
import com.pili.pldroid.player.widget.PLVideoView;

import cn.tourism.tv.R;
import cn.tourism.tv.base.BaseActivity;

public class ZhiBoDetailsActivity extends BaseActivity {

    PLVideoTextureView vtv;
    private int mRotation;
    private String url="http://liveal.quanmin.tv/live/7137767.flv";
    private boolean isFull;

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
        vtv = findViewById(R.id.vtv);

        vtv.setVideoPath(url);
        if(isFull){
            vtv.setDisplayOrientation(PLVideoView.ASPECT_RATIO_PAVED_PARENT);
        }else{
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
                if(i>0)
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

    private void start(){
        if(vtv!=null)
            vtv.start();
    }
    public void pause(){
        if(vtv!=null)
            vtv.pause();
    }

    public void stopPlayback(){
        if(vtv!=null)
            vtv.stopPlayback();

    }

    public void seekTo(long i){
        vtv.seekTo(i);
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

    public int getDisplayAspectRatio(){
        return vtv.getDisplayAspectRatio();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopPlayback();
    }
}
