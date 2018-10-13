package com.antelope.android.tablayout;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp {

    public static void sendOkHttpRequest(){
        OkHttpClient okHttpClient = new OkHttpClient();

        Request mRequest = new Request.Builder()
                .url("http://v.juhe.cn/toutiao/index?type=tiyu&key=e791d5a8c68fb0c0ed616950e7c40f54")
                .get()
                .build();
        Call call = okHttpClient.newCall(mRequest);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.body() != null) {
                    Log.d("OkHttp3", "onResponse:" + response.body().string());
                }
            }
        });
    }

}
