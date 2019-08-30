package com.bawei.day20190830;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.bwei.xlistview.XlistView;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XlistView xl;
    private String path = "http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page=";
    private int page = 1;
    private String count = "&count=1";
    private List<ListBean.ResultInfo> list = new ArrayList<>();
    private Handler handler = new Handler();
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xl = findViewById(R.id.rv);

        getData(page);

        xl.setPullRefreshEnable(true);
        xl.setPullLoadEnable(true);

        xl.setXListViewListener(new XlistView.IXListViewListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        list.clear();
                        page = 1;
                        getData(page);
                        adapter.notifyDataSetChanged();
                        xl.stopRefresh();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page ++;
                        getData(page);
                        adapter.notifyDataSetChanged();
                        xl.stopLoadMore();
                    }
                },2000);
            }
        });


    }

    private void getData(int page) {
        HttpUtils.getInstance().getData(path + page + count, new HttpUtils.CallBackT() {

            @Override
            public void onSuccess(Object obj) {
                Gson gson = new Gson();
                ListBean listBean = gson.fromJson(obj.toString(), ListBean.class);
                List<ListBean.ResultInfo> result = listBean.getResult();

                list.addAll(result);
                adapter = new ListAdapter(list, MainActivity.this);
                xl.setAdapter(adapter);
            }

            @Override
            public void onError(String msg) {

            }
        });
    }
}
