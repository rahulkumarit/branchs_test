package com.dailogexample;

import android.app.Application;

import com.google.firebase.messaging.FirebaseMessaging;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseMessaging.getInstance().subscribeToTopic("news");

    }


}
