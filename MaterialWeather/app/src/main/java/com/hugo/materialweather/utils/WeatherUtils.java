package com.hugo.materialweather.utils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * @auther Hugo
 * Created on 2016/4/13 19:20.
 */
public class WeatherUtils {
    private static String weatherUri;
    private static String resultData = null;

    public static String requestJson(String cityId) {
        //向服务器请求数据时显示progressBar
        weatherUri = "http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=" + cityId;
        RequestParams params = new RequestParams(weatherUri);
        params.setCharset("utf-8");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("result:"+result);
                resultData = result;
                System.out.println("onSuccess");
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                System.out.println("onError");
                ex.printStackTrace();
            }

            @Override
            public void onCancelled(CancelledException cex) {
                System.out.println("onCancelled");
            }

            @Override
            public void onFinished() {
                System.out.println("onFinished");
            }
        });
        return resultData;
    }
}
