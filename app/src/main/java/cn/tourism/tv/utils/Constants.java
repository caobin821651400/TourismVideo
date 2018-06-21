package cn.tourism.tv.utils;

import android.os.Environment;

import java.io.File;

/**
 * 常量
 *
 * @author bin
 * @date 2018/2/9 11:29
 */
public class Constants {
    public static final String BASE_URL = "http://110.190.90.237:9091/api/contents/search";//正式正式

    public static String FilePath;

    static {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            FilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "data"
                    + File.separator + "tourismtv" + File.separator;
        } else {
            FilePath = "/data/data/cn.com.tourismtv/";
        }

        File file = new File(FilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
