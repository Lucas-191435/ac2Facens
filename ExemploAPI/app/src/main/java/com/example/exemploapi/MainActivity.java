package com.example.exemploapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import adapters.CursoAdapter;
import models.Curso;
import services.ServiceApi;

public class MainActivity extends AppCompatActivity {
    ProgressDialog dialog;
    ArrayList<Curso> listaUsuarios;
    RecyclerView recyclerUsuario;
    CursoAdapter usuarioAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerUsuario = (RecyclerView)findViewById(R.id.recyclerUsuario);
        listaUsuarios = new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        buscarUsuarios();
    }

    private void buscarUsuarios(){
        new CursoAPI("GET").execute("Curso","");
    }
    public void excluirUsuario(int id){
        new CursoAPI("DELETE").execute("Curso/" + id,"");
    }

    public void btnAddUsuarioClick(View view){
        Intent i = new Intent(MainActivity.this, CadCursoActivity.class);
        startActivity(i);
    }

    public void setupRecyclerUsuario(){
        //Configurando o layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerUsuario.setLayoutManager(layoutManager);

        // add adapter
        usuarioAdapter = new CursoAdapter(listaUsuarios);
        recyclerUsuario.setAdapter(usuarioAdapter);

        //divisor entre linhas
        recyclerUsuario.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    public class CursoAPI extends AsyncTask<String,String,String>{
        private String metodo;
        public CursoAPI(String metodo){
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(MainActivity.this,"Aguarde","Por favor aguarde...");
        }

        @Override
        protected String doInBackground(String... strings) {
            String data = ServiceApi.getService(strings[0],metodo,strings[1]);
            return data;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(metodo == "GET") {
                listaUsuarios = Curso.parseObject(s);
                setupRecyclerUsuario();
                dialog.dismiss();
            }
            else if(s == "OK"){
                Toast.makeText(MainActivity.this,"Operação realizada com sucesso",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                buscarUsuarios();
            }
        }
    }
}