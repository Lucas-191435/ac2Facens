package com.example.exemplocriarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnEnviarMensagemClick(View view){
        Intent intent = new Intent(this,EnviarMensagemActivity.class);
        startActivity(intent);
    }
    public void btnCapturaFotoClick(View view){
        Intent intent = new Intent(this,CapturarFotoActivity.class);
        startActivity(intent);
    }
    public void btnGravarVideoClick(View view){
        Intent intent = new Intent(this,GravarVideoActivity.class);
        startActivity(intent);
    }

    public void btnAbrirMapaClick(View view){
        Uri uri = Uri.parse("geo:0,0?q=Avenida+general+carneiro+1427");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        //intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    public void btnNavegarMapaClick(View view){
        Uri uri = Uri.parse("google.navigation:q=Avenida+general+carneiro+1427");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void btnLigacaoClick(View view){
        Uri uri = Uri.parse("tel:11998434563");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
    public void btnNavegacaoClick(View view){
        Uri uri = Uri.parse("https://www.facens.br");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}