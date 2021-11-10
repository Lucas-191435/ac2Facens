package com.example.exemplointentfilter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtMensagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMensagem = findViewById(R.id.txtMensagem);

        if(getIntent().getExtras() != null){
            txtMensagem.setText(getIntent().getExtras().get(Intent.EXTRA_TEXT).toString());
        }
    }
}