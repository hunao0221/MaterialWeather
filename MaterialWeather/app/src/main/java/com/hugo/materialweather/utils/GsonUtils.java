package com.hugo.materialweather.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.hugo.materialweather.bean.WeatherDataBean;

import java.io.StringReader;

/**
 * @auther Hugo
 * Created on 2016/4/13 19:55.
 */
public class GsonUtils {
    /**
     * 解析JSON
     *
     * @param result json字符串
     */
    public static WeatherDataBean parseJsonData(String result) {
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd HH:mm");
        Gson gson = builder.create();
        JsonReader jsonReader = new JsonReader(new StringReader(result));
        jsonReader.setLenient(true);
        WeatherDataBean weatherDataBean = gson.fromJson(jsonReader, WeatherDataBean.class);
        return weatherDataBean;
    }
}
