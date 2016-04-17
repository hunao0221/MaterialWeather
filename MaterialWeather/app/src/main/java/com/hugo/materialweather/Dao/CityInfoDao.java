package com.hugo.materialweather.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hugo.materialweather.bean.CityInfoBean;
import com.hugo.materialweather.helper.CityHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Hugo
 * Created on 2016/4/14 10:58.
 */
public class CityInfoDao {
    private Context mContext;

    public CityInfoDao(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 添加到数据库
     *
     * @param cityId   城市的id
     * @param cityName 城市名
     * @return
     */
    public boolean addCity(String cityId, String cityName) {
        CityHelper helper = new CityHelper(mContext);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cityid", cityId);
        values.put("cityname", cityName);
        long id = db.insert("cityinfo", null, values);
        return id != -1;
    }

    /**
     * 删除指定的城市
     *
     * @param cityName
     * @return
     */
    public boolean delete(String cityName) {
        CityHelper helper = new CityHelper(mContext);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        int rowNumber = db.delete("cityinfo", "cityname = ?", new String[]{cityName});
        return rowNumber != 0;
    }

    /**
     * 查询当前城市时候已经保存在数据库中
     *
     * @param cityName
     * @return
     */
    public boolean query(String cityName) {
        CityHelper helper = new CityHelper(mContext);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("cityinfo", new String[]{"cityid"}, "cityname = ?", new String[]{cityName}, null, null, null);
        if (cursor.moveToNext()) {
            return true;
        }
        return false;
    }

    /**
     * 查询所有城市
     *
     * @return
     */
    public List<CityInfoBean> queryAll() {
        List<CityInfoBean> cityList = new ArrayList<>();
        CityHelper helper = new CityHelper(mContext);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query("cityinfo", new String[]{"cityid", "cityname"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            CityInfoBean cityInfo = new CityInfoBean();
            String cityId = cursor.getString(0);
            String cityName = cursor.getString(1);
            cityInfo.setCityId(cityId);
            cityInfo.setCityName(cityName);
            cityList.add(cityInfo);
        }
        return cityList;
    }
}
