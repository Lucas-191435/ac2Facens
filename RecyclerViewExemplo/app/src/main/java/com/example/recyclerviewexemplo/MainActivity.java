package com.example.recyclerviewexemplo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import adapters.PessoaAdapter;
import fakedataset.PessoaDataSetFake;
import models.PessoaModel;

public class MainActivity extends AppCompatActivity {
    private PessoaAdapter pessoaAdapter;
    private RecyclerView recyclerViewPessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewPessoa = (RecyclerView)findViewById(R.id.lstPessoa);
        setupRecyclerPessoa();
    }

    public void setupRecyclerPessoa(){
        //Configurando o layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewPessoa.setLayoutManager(layoutManager);

        // add adapter
        pessoaAdapter = new PessoaAdapter(PessoaDataSetFake.getItens());
        recyclerViewPessoa.setAdapter(pessoaAdapter);

        //divisor entre linhas
       // recyclerViewPessoa.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    public void btnAddPessoaClick(View view){
        pessoaAdapter.adicionarItem(new PessoaModel(4,"Pessoa Add..."));
    }
    public void btnMudarLayoutRecycler(View view){
        if(recyclerViewPessoa.getLayoutManager().getClass().getName().contains("Linear")) {
            GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
            recyclerViewPessoa.setLayoutManager(layoutManager);
        }else if(recyclerViewPessoa.getLayoutManager().getClass().getName().contains("Grid")){
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
            recyclerViewPessoa.setLayoutManager(layoutManager);
        }

    }
}