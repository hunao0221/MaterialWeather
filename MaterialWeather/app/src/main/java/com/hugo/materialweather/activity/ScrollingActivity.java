package com.hugo.materialweather.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hugo.materialweather.Dao.CityInfoDao;
import com.hugo.materialweather.R;
import com.hugo.materialweather.bean.CityInfoBean;
import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    private List<CityInfoBean> cityInfoList;
    private RecyclerView cityListRecyler;
    private MyAdapter adapter;
    private CityInfoDao dao;
    private ArrayList<String> tempName;
    private String currentId;
    private CoordinatorLayout coordinatorLayout;
    private FloatingActionButton fab;
    private View view;
    private MyAdapter.ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        StatusBarUtil.setTranslucent(this, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("城市管理");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cityListRecyler = (RecyclerView) findViewById(R.id.city_list_recyler);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        currentId = getIntent().getStringExtra("currentId");
        System.out.println("currentId :" + currentId);
        dao = new CityInfoDao(this);
        tempName = new ArrayList<>();
        initData();
        initView();
        initListener();
    }

    private void initListener() {
        fab.setOnClickListener(new View.OnClickListener() {
            boolean flag = true;

            @Override
            public void onClick(View view) {
                if (flag) {
                    fab.setImageResource(R.drawable.ic_action_cb_delete);
                } else {
                    fab.setImageResource(R.drawable.ic_action_city_edit);
                }
                flag = !flag;
            }

        });
    }


    private void initView() {
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        cityListRecyler.setLayoutManager(manager);
    }

    private void initData() {
        cityInfoList = dao.queryAll();
        System.out.println("cityInfoBean size :" + cityInfoList.size());
        initUI();
    }

    private void initUI() {
        adapter = new MyAdapter();
        cityListRecyler.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mCallback);
        itemTouchHelper.attachToRecyclerView(cityListRecyler);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_list_item, parent, false);
            vh = new ViewHolder(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            CityInfoBean info = cityInfoList.get(position);
            String cityName = info.getCityName();
            String cityId = info.getCityId();
            System.out.println(cityId + "---------" + cityName);
            if (cityId.equals(currentId)) {
                holder.rb.setVisibility(View.VISIBLE);
                holder.rb.setChecked(true);
            }
            holder.tv_city_name.setText(cityName);
        }

        @Override
        public int getItemCount() {
            return cityInfoList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView tv_city_name;
            RadioButton rb;
            CheckBox cb_delete;

            public ViewHolder(View itemView) {
                super(itemView);
                tv_city_name = (TextView) itemView.findViewById(R.id.tv_city_name);
                tv_city_name.setOnClickListener(this);
                rb = (RadioButton) itemView.findViewById(R.id.cb);
                cb_delete = (CheckBox) itemView.findViewById(R.id.cb_delete);
            }

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollingActivity.this, MainActivity.class);
                String cityId = cityInfoList.get(getAdapterPosition()).getCityId();
                intent.putExtra("cityId", cityId);
                startActivity(intent);
                deleteInfoFromDB();
                finish();
            }
        }
    }

    /**
     * 监听上下移动，和向右滑动
     */
    ItemTouchHelper.Callback mCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();
            if (fromPosition < toPosition) {
                //分别把中间所有的item的位置重新交换
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(cityInfoList, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(cityInfoList, i, i - 1);
                }
            }
            adapter.notifyItemMoved(fromPosition, toPosition);

            //返回true表示执行拖动
            return true;
        }

        /**
         * 滑动监听
         * @param viewHolder
         * @param direction
         */
        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            String cityName = cityInfoList.get(position).getCityName();
            String cityId = cityInfoList.get(position).getCityId();
            if (cityId.equals(currentId)) {
                return;
            }
            tempName.add(cityName);
            System.out.println("cityName :" + cityName);
            System.out.println("position " + position);
            deleteItem(position);
        }
    };

    public void deleteItem(int position) {
        //将要被移除的对象
        CityInfoBean deleteCity = cityInfoList.get(position);
        //该对象在集合中的位置
        int location = cityInfoList.indexOf(deleteCity);
        //从集合中删除
        cityInfoList.remove(position);
        //更新
        adapter.notifyItemRemoved(position);
        //添加到临时集合
        tempName.add(deleteCity.getCityName());
        //撤销删除
        revocationDelete(deleteCity, position, location);
    }

    /**
     * 显示撤销的sanckBar
     *
     * @param deleteCityInfo 删除的对象
     * @param position       adapter的position
     * @param location       删除对象在源集合中位置
     */
    public void revocationDelete(final CityInfoBean deleteCityInfo, final int position, final int location) {
        Snackbar.make(coordinatorLayout, "已暂时隐藏", Snackbar.LENGTH_LONG).setAction("撤销", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityInfoList.add(location, deleteCityInfo);
                adapter.notifyItemInserted(position);
                String deleteName = deleteCityInfo.getCityName();
                System.out.println("deleteName :" + deleteName);
                System.out.println("deletePosition " + position);
                tempName.add(deleteName);
            }
        }).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //按返回键的时候删除要被移除的数据
        deleteInfoFromDB();
    }

    /**
     * 遍历临时城市名数组，并从数据库中删除
     */
    public void deleteInfoFromDB() {
        if (tempName.size() > 0) {
            for (String name : tempName) {
                dao.delete(name);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}
