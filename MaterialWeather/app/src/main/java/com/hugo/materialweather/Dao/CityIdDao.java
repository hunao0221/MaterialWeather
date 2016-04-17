package com.hugo.materialweather.Dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * 查询数据库
 *
 * @auther Hugo
 * Created on 2016/4/9 16:59.
 */

public class CityIdDao {
    public static String PATH = "data/data/com.hugo.materialweather/files/CityId.db";
    private static Cursor cursor;

    public static String getCityId(String name) {
        String id = null;
        SQLiteDatabase database = SQLiteDatabase.openDatabase(PATH, null, SQLiteDatabase.OPEN_READONLY);
        cursor = database.rawQuery("select city_id from city_id where city_area = ?", new String[]{name});
        if (cursor.moveToNext()) {
            id = cursor.getString(0);

            StringBuffer stringBuffer = new StringBuffer(id);
            stringBuffer.delete(0, 2);
            id = stringBuffer.toString();
            cursor.close();
        }
        if (id == null) {
            name = name.toLowerCase();
            cursor = database.rawQuery("select city_id ,city_area from city_id where city_spell_zh = ?", new String[]{name});
            if (cursor.moveToNext()) {
                id = cursor.getString(0);
                StringBuffer stringBuffer = new StringBuffer(id);
                stringBuffer.delete(0, 2);
                id = stringBuffer.toString();
                cursor.close();
            }
        }
        return id;
    }
}
