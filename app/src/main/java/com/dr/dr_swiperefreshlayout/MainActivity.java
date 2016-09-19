package com.dr.dr_swiperefreshlayout;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> array;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        listView = (ListView) findViewById(R.id.listView);

        array = new ArrayList<>();
        for(int i = 0; i<20; i++){
            array.add("i---------------->>"+i);
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,array);
        listView.setAdapter(adapter);
        Log.d("aaaa","-------onCreate------");


        //设置为正在刷新状态
        swipeRefreshLayout.setRefreshing(true);
        //触发监听的onRefresh()方法
        onRefreshListener.onRefresh();


        swipeRefreshLayout.setOnRefreshListener(onRefreshListener);


        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {//正在刷新

            }
        });


    }

    SwipeRefreshLayout.OnRefreshListener  onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            new CountDownTimer(3000, 500) {
                @Override
                public void onTick(long millisUntilFinished) {


                }

                @Override
                public void onFinish() {
                    //刷新结束
                    swipeRefreshLayout.setRefreshing(false);
                }
            }.start();
        }
    };
}
