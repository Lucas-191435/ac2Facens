package fakedataset;

import java.util.ArrayList;

import models.PessoaModel;

public class PessoaDataSetFake {
    private static ArrayList<PessoaModel> pessoas;

    public static ArrayList<PessoaModel> getItens(){
        pessoas = new ArrayList<>();
        pessoas.add(new PessoaModel(1,"Rafael Moreno"));
        pessoas.add(new PessoaModel(2,"José da Silva"));
        pessoas.add(new PessoaModel(3,"Patrícia Ferreira"));

        return pessoas;
    }
    public static void addItem(PessoaModel p){
        pessoas.add(p);
    }
}
