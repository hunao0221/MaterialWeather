package com.hugo.materialweather.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @auther Hugo
 * Created on 2016/4/14 10:50.
 */
public class CityHelper extends SQLiteOpenHelper {
    public CityHelper(Context context) {
        super(context, "city.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table cityinfo(_id integer primary key autoincrement,cityid varchar(50),cityname varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
