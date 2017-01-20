package com.janvicm.yathzee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Random rand = new Random();
                int[] n = new int[5];
                String[] ns = new String[5];
                TextView tv = (TextView) findViewById(R.id.numbers);
                for (int i = 0; i < 5; ++i) {
                    n[i] = rand.nextInt(6) + 1;
                    ns[i] = String.valueOf(n[i]);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                tv.setText(Arrays.toString(ns).replaceAll("\\[|\\]", ""));

                Thread[] t = new Thread[5];
                for (int i = 0; i < 5; ++i) {
                    t[i] = new Thread(ns[i]);
                    t[i].start();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ImageView iv = (ImageView)findViewById(R.id.imageView3);
                    iv.setImageResource(R.mipmap.dice);


                }
            }

        });

    }
}


