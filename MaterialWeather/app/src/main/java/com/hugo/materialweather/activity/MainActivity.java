package com.hugo.materialweather.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.hugo.materialweather.Dao.CityIdDao;
import com.hugo.materialweather.Dao.CityInfoDao;
import com.hugo.materialweather.R;
import com.hugo.materialweather.bean.VersionBean;
import com.hugo.materialweather.bean.WeatherDataBean;
import com.hugo.materialweather.utils.WeekUtils;
import com.jaeger.library.StatusBarUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_week_1)
    TextView tvWeek1;
    @Bind(R.id.iv_week_1)
    ImageView ivWeek1;
    @Bind(R.id.week1_start_tmp)
    TextView week1StartTmp;
    @Bind(R.id.week1_end_tmp)
    TextView week1EndTmp;
    @Bind(R.id.tv_week_2)
    TextView tvWeek2;
    @Bind(R.id.iv_week_2)
    ImageView ivWeek2;
    @Bind(R.id.week2_start_tmp)
    TextView week2StartTmp;
    @Bind(R.id.week2_end_tmp)
    TextView week2EndTmp;
    @Bind(R.id.tv_week_3)
    TextView tvWeek3;
    @Bind(R.id.iv_week_3)
    ImageView ivWeek3;
    @Bind(R.id.week3_start_tmp)
    TextView week3StartTmp;
    @Bind(R.id.week3_end_tmp)
    TextView week3EndTmp;
    @Bind(R.id.tv_week_4)
    TextView tvWeek4;
    @Bind(R.id.iv_week_4)
    ImageView ivWeek4;
    @Bind(R.id.wwek4_start_tmp)
    TextView week4StartTmp;
    @Bind(R.id.week4_end_tmp)
    TextView week4EndTmp;
    @Bind(R.id.tv_week_5)
    TextView tvWeek5;
    @Bind(R.id.iv_week_5)
    ImageView ivWeek5;
    @Bind(R.id.week5_start_tmp)
    TextView week5StartTmp;
    @Bind(R.id.week5_end_tmp)
    TextView week5EndTmp;
    @Bind(R.id.tv_wind_detail)
    TextView tvWindDetail;
    @Bind(R.id.tv_pm_title)
    TextView tvPmTitle;
    @Bind(R.id.tv_pm_detail)
    TextView tvPmDetail;
    @Bind(R.id.tv_humidity_title)
    TextView tvHumidityTitle;
    @Bind(R.id.tv_humidity_detail)
    TextView tvHumidityDetail;
    @Bind(R.id.tv_sun_title)
    TextView tvSunTitle;
    @Bind(R.id.tv_sun_detail)
    TextView tvSunDetail;
    @Bind(R.id.tv_clothes_title)
    TextView tvClothesTitle;
    @Bind(R.id.tv_clothes_detail)
    TextView tvClothesDetail;
    @Bind(R.id.tv_washcar_title)
    TextView tvWashcarTitle;
    @Bind(R.id.tv_washcar_detail)
    TextView tvWashcarDetail;
    @Bind(R.id.tv_sport_title)
    TextView tvSportTitle;
    @Bind(R.id.tv_sport_detail)
    TextView tvSportDetail;
    @Bind(R.id.tv_wind_title)
    TextView tvWindTitle;
    @Bind(R.id.tv_tmp)
    TextView tv_tmp;
    @Bind(R.id.main_navigation)
    NavigationView mainNavigation;
    @Bind(R.id.drawer)
    DrawerLayout drawer;
    @Bind(R.id.tv_city)
    TextView tv_city;
    @Bind(R.id.tv_statu)
    TextView tv_statu;
    @Bind(R.id.iv_title_icon)
    ImageView iv_title_icon;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.main_scrollView)
    ScrollView mainScrollView;
    @Bind(R.id.root_view)
    LinearLayout rootView;
    private Toolbar mToolbar;
    private EditText et_city_name;
    private String cityId;
    private String currentID = null;
    private String currentName = null;
    private WeatherDataBean weatherDataBean;
    private String cityName;
    private String weatherUri;
    private SharedPreferences spConfig;
    private CityInfoDao cityInfoDao;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private boolean auto_update;
    private String mVersionName;
    private int mVersionCode;
    private VersionBean versionInfo;
    private boolean isShowUpdateDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //拷贝数据库
        copyDB("CityId.db");
        initView();
        spConfig = getSharedPreferences("config", MODE_PRIVATE);
        isShowUpdateDialog = spConfig.getBoolean("isShowUpdateDialog", true);
        auto_update = spConfig.getBoolean("auto_update", true);
        initData();
        initListener();
        handNavigationView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cityId = spConfig.getString("cityId", null);
        currentID = cityId;
        String cityIdFromIntent = getIntent().getStringExtra("cityId");
        if (cityIdFromIntent != null) {
            currentID = cityIdFromIntent;
        }
        if (currentID != null) {
            requestJson(currentID);
        } else {
            showSearchCityDialog(true);
        }
    }

    private void initListener() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestJson(currentID);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSearchCityDialog(false);
            }
        });

        mainScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // fab.setVisibility(View.INVISIBLE);
                return false;
            }
        });
    }

    private void initData() {
        cityInfoDao = new CityInfoDao(this);
        getVersionCode();
        if (auto_update) {
            requestUpdateFromServer();
        }
    }

    private void initView() {
        DrawerLayout mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        //设置DrawerLayout的颜色
        StatusBarUtil.setColorForDrawerLayout(MainActivity.this, mDrawer, 0xD32F2F);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar的标题
        mToolbar.setTitle("天气");
        setSupportActionBar(mToolbar);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.home_swipe_refresh);
        //SwipeRefreshLayout的刷新图标颜色
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.white);
        setWeek();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 从数据库获取城市id
     */
    private void getCityId(String cityName) {
        //查询数据库，获取城市id
        cityId = CityIdDao.getCityId(cityName);
        currentID = cityId;
        if (currentID != null) {
            requestJson(currentID);
        } else {
            Toast.makeText(MainActivity.this, "没有找到此城市", Toast.LENGTH_SHORT);
        }
    }


    /**
     * 像服务器请求json
     *
     * @param cityId 城市的id
     */
    private void requestJson(String cityId) {
        //显示progress
        mSwipeRefreshLayout.setRefreshing(true);
        weatherUri = "http://weatherapi.market.xiaomi.com/wtr-v2/weather?cityId=" + cityId;
        System.out.println(weatherUri);
        currentID = cityId;
        //请求服务器
        RequestParams params = new RequestParams(weatherUri);
        params.setCharset("utf-8");
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("onSuccess");
                GsonBuilder builder = new GsonBuilder();
                builder.setDateFormat("yyyy-MM-dd HH:mm");
                Gson gson = builder.create();
                JsonReader jsonReader = new JsonReader(new StringReader(result));
                jsonReader.setLenient(true);
                weatherDataBean = gson.fromJson(jsonReader, WeatherDataBean.class);
                initUI();
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
        });
    }

    /**
     * 解析JSON
     *
     * @param result json字符串
     */
    public void parseJsonData(String result) {
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd HH:mm");
        Gson gson = builder.create();
        JsonReader jsonReader = new JsonReader(new StringReader(result));
        jsonReader.setLenient(true);
        weatherDataBean = gson.fromJson(jsonReader, WeatherDataBean.class);
        if (weatherDataBean != null) {
            initUI();
        }
    }

    /**
     * 更新界面
     */
    private void initUI() {
        mSwipeRefreshLayout.setRefreshing(false);
        initTitleInfo();
        initForecast();
        setTemp();
        getLifeIndex();
        initParameter();
        startAnim();
    }

    private void startAnim() {
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim);
        rootView.startAnimation(animation);
    }


    private void initTitleInfo() {
        String temp = weatherDataBean.getRealtime().getTemp();
        tv_tmp.setText(temp + "°");
        String city = weatherDataBean.getForecast().getCity();
        tv_city.setText(city);
        currentName = city;
        String weather = weatherDataBean.getRealtime().getWeather();
        tv_statu.setText(weather);
        setWeatherIcon(iv_title_icon, weather);
    }

    private void initParameter() {
        tvWindTitle.setText(weatherDataBean.getRealtime().getWD());
        tvWindDetail.setText("实时" + weatherDataBean.getRealtime().getWS());
        tvPmTitle.setText("PM2.5: " + weatherDataBean.getAqi().getPm25());
        tvPmDetail.setText("PM10: " + weatherDataBean.getAqi().getPm10());
        tvHumidityTitle.setText("湿度");
        tvHumidityDetail.setText(weatherDataBean.getRealtime().getSD());
    }

    private void initForecast() {
        String weather1 = weatherDataBean.getForecast().getWeather1();
        setWeatherIcon(ivWeek1, weather1);
        String weather2 = weatherDataBean.getForecast().getWeather2();
        setWeatherIcon(ivWeek2, weather2);
        String weather3 = weatherDataBean.getForecast().getWeather3();
        setWeatherIcon(ivWeek3, weather3);
        String weather4 = weatherDataBean.getForecast().getWeather4();
        setWeatherIcon(ivWeek4, weather4);
        String weather5 = weatherDataBean.getForecast().getWeather5();
        setWeatherIcon(ivWeek5, weather5);
    }

    private void getLifeIndex() {
        List<WeatherDataBean.IndexBean> indexBean = weatherDataBean.getIndex();
        for (WeatherDataBean.IndexBean index : indexBean) {
            String code = index.getCode();
            if (code.equals("fs")) {
                //防晒指数
                initLifeUi(index, tvSunTitle, tvSunDetail);
            } else if (code.equals("ct")) {
                //穿衣指数
                initLifeUi(index, tvClothesTitle, tvClothesDetail);
            } else if (code.equals("yd")) {
                //运动指数
                initLifeUi(index, tvSportTitle, tvSportDetail);
            } else if (code.equals("xc")) {
                //洗车指数
                initLifeUi(index, tvWashcarTitle, tvWashcarDetail);
            } else if (code.equals("ls")) {
                //晾晒指数
            }
        }
    }

    public void initLifeUi(WeatherDataBean.IndexBean indexBean, TextView title, TextView detail) {
        String name = indexBean.getName();
        String details = indexBean.getDetails();
        String index = indexBean.getIndex();
        title.setText(name + " -" + index);
        detail.setText(details);
    }


    private void setTemp() {
        getTemp(week1StartTmp, week1EndTmp, weatherDataBean.getForecast().getTemp1());
        getTemp(week2StartTmp, week2EndTmp, weatherDataBean.getForecast().getTemp2());
        getTemp(week3StartTmp, week3EndTmp, weatherDataBean.getForecast().getTemp3());
        getTemp(week4StartTmp, week4EndTmp, weatherDataBean.getForecast().getTemp4());
        getTemp(week5StartTmp, week5EndTmp, weatherDataBean.getForecast().getTemp5());
    }


    /**
     * 设置天气预报的星期数
     */
    private void setWeek() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        int mWay = c.get(Calendar.DAY_OF_WEEK);
        tvWeek1.setText(WeekUtils.getWeek((mWay + 0) % 7));
        tvWeek2.setText(WeekUtils.getWeek((mWay + 1) % 7));
        tvWeek3.setText(WeekUtils.getWeek((mWay + 2) % 7));
        tvWeek4.setText(WeekUtils.getWeek((mWay + 3) % 7));
        tvWeek5.setText(WeekUtils.getWeek((mWay + 4) % 7));
    }

    private void setWeatherIcon(ImageView iv_icon, String weather) {
        /**
         * 如果天气中含有转折，取转折后天气
         */

        if (weather.contains("转")) {
            int indexOf = weather.indexOf("转");
            weather = weather.substring(indexOf + 1, weather.length());
        }
        if (weather.equals("晴")) {
            iv_icon.setImageResource(R.drawable.clear);
        } else if (weather.equals("多云")) {
            iv_icon.setImageResource(R.drawable.partly_cloudy);
        } else if (weather.equals("阴")) {
            iv_icon.setImageResource(R.drawable.cloudy);
        } else if (weather.equals("雷阵雨")) {
            iv_icon.setImageResource(R.drawable.thunderstorm);
        } else if (weather.contains("雪")) {
            iv_icon.setImageResource(R.drawable.snow);
        } else if (weather.equals("阵雨")) {
            iv_icon.setImageResource(R.drawable.sleet);
        } else if (weather.equals("大雨")) {
            iv_icon.setImageResource(R.drawable.dayu);
        } else if (weather.contains("暴雨")) {
            iv_icon.setImageResource(R.drawable.dayu);
        } else if (weather.contains("雨")) {
            iv_icon.setImageResource(R.drawable.rain);
        } else if (weather.contains("风")) {
            iv_icon.setImageResource(R.drawable.windy);
        }
    }

    public void getTemp(TextView tv_startTemp, TextView tv_endTemp, String temp) {
        temp = temp.replace("℃", "");
        int indexOf = temp.indexOf("~");
        String startTemp = temp.substring(0, indexOf);
        String endTemp = temp.substring(indexOf + 1, temp.length());
        tv_startTemp.setText(startTemp + "°");
        tv_endTemp.setText(endTemp + "°");
    }

    /**
     * 菜单的点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.action_collect:
                addCityToDB();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void handNavigationView() {
        mainNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            MenuItem preMenuItem;

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                if (preMenuItem != null) {
                    preMenuItem.setChecked(false);
                }
                item.setChecked(true);
                drawer.closeDrawers();
                preMenuItem = item;
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.nav_city_manager:

                        new Thread() {
                            @Override
                            public void run() {
                                try {
                                    sleep(200);
                                    Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
                                    intent.putExtra("currentId", currentID);
                                    startActivity(intent);
//                                    finish();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                        //isDrawClose(itemId);
                        break;
                    case R.id.nav_weather:
                        break;
                    case R.id.nav_setting:
                        Intent settingIntent = new Intent(MainActivity.this, SettingActivity.class);
                        startActivity(settingIntent);
                        break;
                }
                return true;
            }
        });
    }


    private void showSearchCityDialog(final boolean isFirstIn) {
        final AlertDialog.Builder builger = new AlertDialog.Builder(this);
        View view = View.inflate(this, R.layout.search_dialog, null);
        final TextInputLayout inputLayout = (TextInputLayout) view.findViewById(R.id.TextInputLayout);
        inputLayout.setHint("在这里搜索城市吧");
        et_city_name = inputLayout.getEditText();
        builger.setView(view);
        builger.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builger.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cityName = et_city_name.getText().toString().trim();
                System.out.println("cityName----------------" + cityName);
                if (!TextUtils.isEmpty(cityName)) {
                    getCityId(cityName);
                    dialog.dismiss();
                } else {
                    inputLayout.setError("城市不能为空");
                }
            }
        });
        builger.show();
    }


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

    public void addCityToDB() {
        boolean isExist = cityInfoDao.query(currentName);
        System.out.println("isExist :" + isExist);
        if (!isExist) {
            boolean addSccess = cityInfoDao.addCity(currentID, currentName);
            if (addSccess) {
                Toast.makeText(MainActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Toast.makeText(MainActivity.this, "出错了,收藏失败，请稍后再试", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**
         * 销毁的时候保存当前的城市id
         */
        System.out.println("销毁=====");
//        spConfig.edit().putString("cityId", currentID).commit();
    }

    private long exitTime = 0;

    @Override
    public void onBackPressed() {
        System.out.println("finish");
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            spConfig.edit().putString("cityId", currentID).commit();
            finish();
            System.exit(0);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    private void requestUpdateFromServer() {
        RequestParams updateParms = new RequestParams("http://hunao0221.github.io/update.json");
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
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

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
     * 检测到更新后下载更新；
     */
    private void showUpdateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("检测到新版本:"+versionInfo.getVersionName());
        builder.setMessage(versionInfo.getDescription());
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("好的，我下载");
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("以后再说", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    /*
   * 获得本地版本号*/
    public int getVersionCode() {
        //首先拿到packageManager对象
        PackageManager packageManager = getPackageManager();
        try {
            //获取PackageInfo
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
            //获得版本号
            mVersionName = packageInfo.versionName;
            mVersionCode = packageInfo.versionCode;
            return mVersionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
