package com.example.exemplocriarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EnviarMensagemActivity extends AppCompatActivity {
    TextView txtMensagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_mensagem);
        txtMensagem = findViewById(R.id.txtMensagem);
    }

    public void btnVoltarClick(View view){
        finish();
    }

    public void btnEnviarClick(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,txtMensagem.getText());
        intent.setType("text/plain");
        startActivity(intent);
    }
}