package com.dailogexample;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.os.ResultReceiver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SampleIntentService extends IntentService {


    public static final int DOWNLOAD_ERROR = 10;
    public static final int DOWNLOAD_SUCCESS = 11;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */

    public SampleIntentService(String name) {
        super(name);
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String url = intent.getStringExtra("url");
        final ResultReceiver receiver = intent.getParcelableExtra("receiver");
        Bundle bundle = new Bundle();

        File downloadFile = new File("/sdcard/IntentService_Example.png");
        if (downloadFile.exists())
            downloadFile.delete();
        try {
            downloadFile.createNewFile();
            URL downloadURL = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) downloadURL
                    .openConnection();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200)
                throw new Exception("Error in connection");
            InputStream is = conn.getInputStream();
            FileOutputStream os = new FileOutputStream(downloadFile);
            byte buffer[] = new byte[1024];
            int byteCount;
            while ((byteCount = is.read(buffer)) != -1) {
                os.write(buffer, 0, byteCount);
            }
            os.close();
            is.close();

            String filePath = downloadFile.getPath();
            bundle.putString("filePath", filePath);
            receiver.send(DOWNLOAD_SUCCESS, bundle);

        } catch (Exception e) {
            receiver.send(DOWNLOAD_ERROR, Bundle.EMPTY);
            e.printStackTrace();
        }


    }



 }
