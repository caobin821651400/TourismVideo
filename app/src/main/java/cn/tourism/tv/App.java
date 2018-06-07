package cn.tourism.tv;

import android.app.Application;

import com.cb.xlibrary.XLibrary;

/**
 * 描述：
 * 作者：曹斌
 * date:2018/6/7 12:55
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        XLibrary.init(this);
    }
}
