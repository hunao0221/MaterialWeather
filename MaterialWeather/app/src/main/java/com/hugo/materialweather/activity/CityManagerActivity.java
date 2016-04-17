package com.hugo.materialweather.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hugo.materialweather.Dao.CityInfoDao;
import com.hugo.materialweather.R;
import com.hugo.materialweather.bean.CityInfoBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CityManagerActivity extends AppCompatActivity {


    @Bind(R.id.city_list_recyler)
    RecyclerView cityListRecyler;
    private List<CityInfoBean> cityInfoBeen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_manager);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    private void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        cityListRecyler.setLayoutManager(manager);
    }

    private void initData() {
        CityInfoDao dao = new CityInfoDao(this);
        cityInfoBeen = dao.queryAll();
        initUI();
    }

    private void initUI() {
        MyAdapter adapter = new MyAdapter();
        cityListRecyler.setAdapter(adapter);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_list_item, parent, false);
            ViewHolder vh = new ViewHolder(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String cityName = cityInfoBeen.get(position).getCityName();
            System.out.println("cityName " + cityName);
            holder.tv_city_name.setText(cityName);
        }

        @Override
        public int getItemCount() {
            return cityInfoBeen.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tv_city_name;

            public ViewHolder(View itemView) {
                super(itemView);
                tv_city_name = (TextView) itemView.findViewById(R.id.tv_city_name);
            }
        }
    }
}
