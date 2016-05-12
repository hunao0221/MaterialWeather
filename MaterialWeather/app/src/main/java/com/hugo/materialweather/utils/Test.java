package com.hugo.materialweather.utils;

import org.xutils.common.Callback;
import org.xutils.http.app.RequestInterceptListener;

import java.io.File;

/**
 * @auther Hugo
 * Created on 2016/4/18 21:53.
 */
public interface Test<F> extends Callback.ProgressCallback<File>,RequestInterceptListener{

}
