package com.dailogexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class DownloadActivity extends AppCompatActivity {

    private EditText urlText;
    private ProgressBar pd;
    private ImageView imgView;
    private String defaultUrl = "http://developer.android.com/assets/images/dac_logo.png";
    private SampleResultReceiver sampleResultReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        try {
            initComponents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        sampleResultReceiver = new SampleResultReceiver(new Handler());
        urlText = findViewById(R.id.urlText);
        pd = findViewById(R.id.downloadPD);
        imgView = findViewById(R.id.imgView);
        urlText.setText(defaultUrl);
     }


    private class SampleResultReceiver extends ResultReceiver {

        public SampleResultReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            switch (resultCode) {
                case SampleIntentService.DOWNLOAD_ERROR:
                    Toast.makeText(getApplicationContext(), "error in download", Toast.LENGTH_SHORT).show();
                    pd.setVisibility(View.INVISIBLE);
                    break;

                case SampleIntentService.DOWNLOAD_SUCCESS:
                    String filePath = resultData.getString("filePath");
                    Bitmap bmp = BitmapFactory.decodeFile(filePath);
                    if (imgView != null && bmp != null) {
                        imgView.setImageBitmap(bmp);
                        Toast.makeText(getApplicationContext(), "image download via IntentService is done",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "error in decoding downloaded file",
                                Toast.LENGTH_SHORT).show();
                    }
                    pd.setIndeterminate(false);
                    pd.setVisibility(View.INVISIBLE);
                    break;
            }
            super.onReceiveResult(resultCode, resultData);
        }
    }

}



