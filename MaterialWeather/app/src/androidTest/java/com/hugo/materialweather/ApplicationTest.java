package com.hugo.materialweather;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.hugo.materialweather.Dao.CityInfoDao;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testAdd() {
        CityInfoDao dao = new CityInfoDao(getContext());
        boolean id = dao.addCity("10100100", "济南");
        assert (id = true);
    }
}