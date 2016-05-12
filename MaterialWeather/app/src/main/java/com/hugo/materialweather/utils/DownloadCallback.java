package com.hugo.materialweather.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ProgressBar;

import com.hugo.materialweather.R;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.app.RequestInterceptListener;
import org.xutils.http.request.UriRequest;

import java.io.File;

/**
 * @auther Hugo
 * Created on 2016/4/18 21:15.
 */
public class DownloadCallback implements Callback.ProgressCallback<File>, RequestInterceptListener {

    private Context mContext;
    private AlertDialog.Builder builder;
    private ProgressBar progressBar;
    private AlertDialog alertDialog;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    public DownloadCallback(Context context) {
        mContext = context;
    }

    @Override
    public void onSuccess(File result) {
        System.out.println("onSuccess");
        if (alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        //下载完成后跳转到安装界面
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setDataAndType(Uri.fromFile(result),
                "application/vnd.android.package-archive");
        mContext.startActivity(intent);

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        System.out.println("onError");
        HttpException exception = (HttpException) ex;
        int code = exception.getCode();
        System.out.println("code :" + code);
    }

    @Override
    public void onCancelled(CancelledException cex) {
        System.out.println("onCancelled");

    }

    @Override
    public void onFinished() {
        System.out.println("onFinished");

    }

    @Override
    public void onWaiting() {
        System.out.println("onWaiting");
    }

    @Override
    public void onStarted() {

        System.out.println("onStarted");
        builder = new AlertDialog.Builder(mContext);
        builder.setTitle("正在下载...");
        View view = View.inflate(mContext, R.layout.download_progress, null);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        builder.setView(view);
        alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void onLoading(long total, long current, boolean isDownloading) {
        System.out.println("total :" + total);
        System.out.println("current :" + current);
        System.out.println("current :" + isDownloading);
        progressBar.setMax((int) total);
        progressBar.setProgress((int) current);
    }

    @Override
    public void beforeRequest(UriRequest request) throws Throwable {
        System.out.println("beforeRequest");
        System.out.println("request :" + request.getResponseCode());
    }

    @Override
    public void afterRequest(UriRequest request) throws Throwable {
        System.out.println("afterRequest");
        System.out.println("request :" + request.getResponseCode());
    }
}



