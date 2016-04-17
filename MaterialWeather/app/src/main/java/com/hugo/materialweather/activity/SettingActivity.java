package com.hugo.materialweather.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.hugo.materialweather.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SettingActivity extends AppCompatActivity {

    @Bind(R.id.cb_update)
    CheckBox cbUpdate;
    private SharedPreferences config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        config = getSharedPreferences("config", MODE_PRIVATE);
        updateStatus();
    }


    /**
     * 检测自动更新开关状态
     */
    private void updateStatus() {
        //读取自动检测更新的状态
        boolean autoUpdate = config.getBoolean("auto_update", true);
        if (autoUpdate) {
            cbUpdate.setChecked(true);
        } else {
            cbUpdate.setChecked(false);
        }

        cbUpdate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    config.edit().putBoolean("auto_update", true).commit();
                } else {
                    config.edit().putBoolean("auto_update", false).commit();
                }
            }
        });
    }


}
