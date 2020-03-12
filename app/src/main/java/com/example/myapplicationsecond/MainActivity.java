package com.example.myapplicationsecond;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private View img_1;
    private View img_2;
    private View img_3;
    private Button button;
    private boolean start_stop = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_1 = findViewById(R.id.imageView);
        img_2 = findViewById(R.id.imageView2);
        img_3 = findViewById(R.id.imageView3);
        button = findViewById(R.id.button);
        button.setText("start");
    }

    public void onClickStart(View view) {
        if (!start_stop) {
            button.setText("stop");
            new Thread(new Runnable() {
                public void run() {
                    while (start_stop) {
                        try {
                            img_3.setBackgroundColor(Color.GRAY);
                            img_1.setBackgroundColor(Color.GREEN);
                            Thread.sleep(5000);
                            img_1.setBackgroundColor(Color.GRAY);
                            img_2.setBackgroundColor(Color.GREEN);
                            Thread.sleep(5000);
                            img_2.setBackgroundColor(Color.GRAY);
                            img_3.setBackgroundColor(Color.GREEN);
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }
                }
            }).start();
        }
        else {
            img_3.setBackgroundColor(Color.GRAY);
            img_1.setBackgroundColor(Color.GRAY);
            img_2.setBackgroundColor(Color.GRAY);
            button.setText("start");
            start_stop = false;
        }


    }

    protected void onDestroy() {
        super.onDestroy();
        start_stop = false;
    }
}
