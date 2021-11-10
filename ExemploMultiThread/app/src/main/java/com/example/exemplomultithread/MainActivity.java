package com.example.exemplomultithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnIncNum1;
    TextView txtNum1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIncNum1 = (Button)findViewById(R.id.btnIncNum1);
        txtNum1 = findViewById(R.id.txtNum1);
    }

    public void btnIncNum1Click(View view){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10; i++){
                    try {
                        final int num = i;
                        Thread.sleep(2000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                txtNum1.setText("" + num);
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}