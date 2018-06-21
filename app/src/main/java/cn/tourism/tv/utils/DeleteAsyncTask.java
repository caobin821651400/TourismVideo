package cn.tourism.tv.utils;

import android.os.AsyncTask;

import com.cb.xlibrary.utils.XFileUtils;

/**
 * Created by caobin on 2018/6/5.
 */

public class DeleteAsyncTask extends AsyncTask<Void, Void, Void> {


    @Override
    protected Void doInBackground(Void... voids) {
        XFileUtils.deleteDir(Constants.FilePath);
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
