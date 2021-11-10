package com.example.exemploapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import models.Curso;
import services.ServiceApi;

public class CadCursoActivity extends AppCompatActivity {
    int id = 0;
    Curso usuario;
    TextView textNome, textEmail, textSenha;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_usuario);
        textEmail = findViewById(R.id.textEmail);
        textNome = findViewById(R.id.textNome);
        textSenha = findViewById(R.id.textSenha);

        if(getIntent().hasExtra("id")){
            //editando um usuário
            id = getIntent().getIntExtra("id",0);
            new CursoAPI("GET").execute("Curso/" + id,"");
        }
    }
    public void carregarCampos(){
        textSenha.setText(usuario.getSenha());
        textNome.setText(usuario.getNome());
        textEmail.setText(usuario.getEmail());
    }
    public void btnSalvarClick(View v){
        if(id >0){ //editar
            usuario.setNome(textNome.getText().toString());
            usuario.setEmail(textEmail.getText().toString());
            usuario.setSenha(textSenha.getText().toString());
            new CursoAPI("PUT").execute("Curso/" + id, Curso.parseJson(usuario));
        }
        else{
            //inserir
            usuario = new Curso();
            usuario.setNome(textNome.getText().toString());
            usuario.setEmail(textEmail.getText().toString());
            usuario.setSenha(textSenha.getText().toString());
            usuario.setId(0);
            new CursoAPI("POST").execute("Curso", Curso.parseJson(usuario));

        }
    }

    public class CursoAPI extends AsyncTask<String,String,String> {
        private String metodo;
        public CursoAPI(String metodo){
            this.metodo = metodo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(CadCursoActivity.this,"Aguarde","Por favor aguarde...");
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
                usuario = Curso.parseOneObject(s);
                carregarCampos();
                dialog.dismiss();
            }
            else if(s == "OK"){
                Toast.makeText(CadCursoActivity.this,"Operação realizada com sucesso",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                finish();
            }
        }
    }
}