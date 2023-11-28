package com.example.adstask_java;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.rad.RXError;
import com.rad.RXSDK;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RXSDK.INSTANCE.init("261", new RXSDK.RXSDKInitListener() {
            @Override
            public void onSDKInitFailure(@NonNull RXError error) {
                Log.d("onSDKInitFailure ", error.getMsg());
            }

            @Override
            public void onSDKInitSuccess() {
                Log.d("onSDKInitSuccess", "success");
            }
        });


    }
}
