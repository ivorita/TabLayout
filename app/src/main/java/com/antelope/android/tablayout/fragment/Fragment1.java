package com.antelope.android.tablayout.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.antelope.android.tablayout.OkHttp;
import com.antelope.android.tablayout.R;
import com.antelope.android.tablayout.adapter.RecAdapter;
import com.antelope.android.tablayout.json.JSON;
import com.antelope.android.tablayout.json.data_item;
import com.antelope.android.tablayout.json.result;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_1,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView rec = view.findViewById(R.id.rec);
        /*load(rec);*/
        /*OkHttp.sendOkHttpRequest();*/
        OkHttp(rec);
    }

    public void load(RecyclerView recyclerView,List<data_item> data_itemList){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RecAdapter(data_itemList));
    }

    public void OkHttp(final RecyclerView recyclerView){
        OkHttpClient mOkHttpClient = new OkHttpClient();
        Request mRequest = new Request.Builder()
                .url("http://v.juhe.cn/toutiao/index?type=tiyu&key=e791d5a8c68fb0c0ed616950e7c40f54")
                .get()
                .build();
        Call call = mOkHttpClient.newCall(mRequest);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("OkHttp3", "onFailure: " + e.getLocalizedMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.body() != null) {
                    /*Log.d("OkHttp3", "onResponse:" + response.body().string());*/
                    String responseData = response.body().string();
                    showResponse(recyclerView,responseData);
                    /*parseJSONWithGSON(response.body().string());*/
                }
            }
        });
    }

    private void showResponse(final RecyclerView recyclerView, final String jsonData) {
        Gson gson = new Gson();
        JSON json = gson.fromJson(jsonData,JSON.class);
        result result = json.getResult();
        final List<data_item> data_items = result.getData();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                load(recyclerView,data_items);
            }
        });
    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        JSON json = gson.fromJson(jsonData,JSON.class);
        Log.d("JSON", "parseJSONWithGSON: " + json.getResult());
        Log.d("JSON", "parseJSONWithGSON: " + json.getError_code());
        Log.d("JSON", "parseJSONWithGSON: " + json.getReason());
        result result = json.getResult();
        Log.d("result", "parseJSONWithGSON: " + result.getData());
        List<data_item> data_items = result.getData();
        Log.d("item data", "parseJSONWithGSON: " + data_items.get(0).getTitle());
    }

}
