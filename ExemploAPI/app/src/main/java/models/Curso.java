package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Curso {
    private int Id;
    private String Nome;
    private String Email;
    private String Senha;

    public Curso(int id, String nome, String duracao, String senha) {
        Id = id;
        Nome = nome;
        Email = duracao;
        Senha = senha;
    }

    public Curso() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public static String parseJson(Curso usuario){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Nome",usuario.getNome());
            jsonObject.put("Duracao",usuario.getEmail());
            jsonObject.put("Valor",usuario.getSenha());
            return  jsonObject.toString();
        }
        catch (Exception ex){
            return "";
        }
    }

    public static Curso parseOneObject(String json){
        try {
            Curso usuario = new Curso();
            JSONObject obj = new JSONObject(json);
            usuario.setNome(obj.getString("Nome"));
            usuario.setEmail(obj.getString("Duracao"));
            usuario.setSenha(obj.getString("Valor"));
            usuario.setId(obj.getInt("id"));

            return usuario;
        }
        catch (Exception ex){
            return null;
        }
    }

    public static ArrayList<Curso> parseObject(String json){
        ArrayList<Curso> usuarios = new ArrayList<>();
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                Curso usuario = new Curso();
                JSONObject obj = array.getJSONObject(i);
                usuario.setNome(obj.getString("Nome"));
                usuario.setEmail(obj.getString("Duracao"));
                usuario.setSenha(obj.getString("Valor"));
                usuario.setId(obj.getInt("id"));
                usuarios.add(usuario);
            }
            return usuarios;
        }
        catch (Exception ex){
            return usuarios;
        }
    }
}
