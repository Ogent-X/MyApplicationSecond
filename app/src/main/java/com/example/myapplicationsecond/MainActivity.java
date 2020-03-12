package com.example.myapplicationsecond;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private View img_1;
    private View img_2;
    private View img_3;
    private boolean start_stop = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_1 = findViewById(R.id.imageView);
        img_2 = findViewById(R.id.imageView2);
        img_3 = findViewById(R.id.imageView3);
    }

    public void onClickStart(View view) {
        new Thread(new Runnable() {
            public void run() {
                while (start_stop)
                {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {

                    }


                }
            }
        }).start();
        img_1.setBackgroundColor(Color.GREEN);

    }

    protected void onDestroy() {
        super.onDestroy();
        start_stop = false;
    }
}
