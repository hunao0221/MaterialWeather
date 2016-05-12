package com.hugo.materialweather.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hugo.materialweather.R;
import com.hugo.materialweather.bean.VersionBean;
import com.hugo.materialweather.utils.Test;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.http.request.UriRequest;
import org.xutils.x;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView textView;
    private String mVersionName;
    private int mVersionCode;
    private VersionBean versionInfo;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            enterHome();
        }
    };
    private SharedPreferences config;
    private boolean auto_update;
    private AlertDialog.Builder builder;
    private ProgressBar progressBar;
    private AlertDialog alertDialog;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        //   handler.sendEmptyMessageDelayed(0, 2000);
        initDate();
        initView();
        if (auto_update) {
            requestUpdateFromServer();
        } else {
            handler.sendEmptyMessageDelayed(0, 2000);
        }
    }


    private void initDate() {
        copyDB("CityId.db");
        getVersionInfo();
        config = getSharedPreferences("config", MODE_PRIVATE);
        auto_update = config.getBoolean("auto_update", true);
    }

    private void initView() {
        textView.setText("Version :" + mVersionName);
    }


    private void enterHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    /**
     * 拷贝数据库
     *
     * @param name
     */
    public void copyDB(String name) {
        File file = new File(getFilesDir(), name);
        if (file.exists()) {
            return;
        }

        InputStream is = null;
        FileOutputStream fos = null;
        try {
            is = getAssets().open(name);
            fos = new FileOutputStream(file);
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = is.read(buff)) != -1) {
                fos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
 * 获得本地版本号*/
    public void getVersionInfo() {
        //首先拿到packageManager对象
        PackageManager packageManager = getPackageManager();
        try {
            //获取PackageInfo
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            //获得版本号
            mVersionName = packageInfo.versionName;
            mVersionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void requestUpdateFromServer() {
        RequestParams updateParms = new RequestParams("http://hunao0221.github.io/update.json");
        updateParms.setConnectTimeout(5000);
        x.http().get(updateParms, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String result) {
                System.out.println(result);
                Gson gson = new Gson();
                versionInfo = gson.fromJson(result, VersionBean.class);
                hasNewVersion();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                System.out.println(ex.getMessage());
                Toast.makeText(SplashActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 时候检测到新版本
     */
    private void hasNewVersion() {
        if (versionInfo != null) {
            int versionCode = versionInfo.getVersionCode();
            if (versionCode > mVersionCode) {
                System.out.println("检测到更新");
                showUpdateDialog();
            } else {
                System.out.println("没有更新哦");
            }
        }
    }

    /**
     * 检测到更新后，显示弹窗提示下载
     */
    private void showUpdateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("检测到新版本:" + versionInfo.getVersionName());
        builder.setMessage(versionInfo.getDescription());
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("好的，我下载");
                dialog.dismiss();
                downLoadUpdateFile();
                //   enterHome();
            }
        });
        builder.setNegativeButton("以后再说", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                handler.sendEmptyMessageDelayed(0, 2000);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
    }

    private void downLoadUpdateFile() {
        final RequestParams fileParsma = new RequestParams("http://hunao0221.github.io/test.apk");
        fileParsma.setSaveFilePath(Environment.getExternalStorageDirectory() + "/test.apk");
        x.http().get(fileParsma, new Test<File>() {
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
                //startActivity(intent);
                startActivityForResult(intent,0);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                System.out.println("onError");
                System.out.println(ex.getMessage());
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
                alertDialog.setCancelable(false);
                alertDialog.show();
                alertDialog.setCanceledOnTouchOutside(false);
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
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        enterHome();
        super.onActivityResult(requestCode, resultCode, data);
    }
}
