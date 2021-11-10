package com.example.aula1ex1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.text1);
        text1.setText("Meu Primeiro App");

        Log.d("Create", "Entrou no OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Start", "Entrou no OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Resume", "Entrou no OnResume");
    }


    public void btn1Click(View view) {
        Toast.makeText(this, "Clicou no botão!!!", Toast.LENGTH_SHORT).show();
    }

    public void btn2Click(View view) {

        new AlertDialog.Builder(this)
                .setTitle("Confirmação")
                .setMessage("Deseja realmente excluir?")
                .setCancelable(false)
                .setIcon(R.mipmap.remove)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Excluiu!!!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }
}