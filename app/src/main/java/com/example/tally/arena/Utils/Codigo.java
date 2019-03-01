package com.example.tally.arena.Utils;

import com.example.tally.arena.model.Usuario;

import java.io.Serializable;

public class Codigo implements Serializable {
    private int id;
    private String nome;
    private String igreja;
    private String codigo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIgreja() {
        return igreja;
    }

    public void setIgreja(String igreja) {
        this.igreja = igreja;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Codigo(int id, String nome, String igreja, String codigo) {
        this.id = id;
        this.nome = nome;
        this.igreja = igreja;
        this.codigo = codigo;
    }

    public Codigo() {
    }

    public Codigo(String nome, String igreja) {
        this.nome = nome;
        this.igreja = igreja;
        this.codigo = generateCodigo();
    }

    public String generateCodigo(){
        String result = Usuario.encrypt(this.nome, this.igreja);
        char res[] = new char[5];
        if(result.length() > 5){
            result.getChars(0, 4, res, 0);
        }
        result = ""+res[0] + res[1] + res[2] + res[3] + res[4];
        return result;
    }
}
