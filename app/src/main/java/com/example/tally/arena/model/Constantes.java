package com.example.tally.arena.model;

import java.io.Serializable;

public class Constantes  implements Serializable {

    public int id;
    public int presencaArena;
    public int presencaImersao;
    public int pontualidade;
    public int anotArena;
    public int anotDomin;
    public int meditacao;
    public int versiculo;

    public Constantes(int id, int presencaArena, int presencaImersao, int pontualidade, int anotArena, int anotDomin, int meditacao, int versiculo) {
        this.id = id;
        this.presencaArena = presencaArena;
        this.presencaImersao = presencaImersao;
        this.pontualidade = pontualidade;
        this.anotArena = anotArena;
        this.anotDomin = anotDomin;
        this.meditacao = meditacao;
        this.versiculo = versiculo;
    }
}
