package com.example.tally.arena.model;

import com.example.tally.arena.model.Enum.UsuChaType;

import java.io.Serializable;

public class UsuarioChamada implements Serializable {
    private int idTeen;
    private int idChamada;
    private Teen teen;
    private Chamada chamada;
    private UsuChaType tipo;
    private int pontoExtra;
    private boolean presenca;
    private boolean pontualidade;
    private boolean anotDomingo;
    private boolean anotArena;
    private boolean meditacao;
    private int versiculo;

    public int getIdTeen() {
        return idTeen;
    }

    public void setIdTeen(int idTeen) {
        this.idTeen = idTeen;
    }

    public int getIdChamada() {
        return idChamada;
    }

    public void setIdChamada(int idChamada) {
        this.idChamada = idChamada;
    }

    public Teen getTeen() {
        return teen;
    }

    public void setTeen(Teen teen) {
        this.teen = teen;
    }

    public Chamada getChamada() {
        return chamada;
    }

    public void setChamada(Chamada chamada) {
        this.chamada = chamada;
    }

    public UsuChaType getTipo() {
        return tipo;
    }

    public void setTipo(UsuChaType tipo) {
        this.tipo = tipo;
    }

    public int getPontoExtra() {
        return pontoExtra;
    }

    public void setPontoExtra(int pontoExtra) {
        this.pontoExtra = pontoExtra;
    }

    public boolean isPresenca() {
        return presenca;
    }

    public void setPresenca(boolean presenca) {
        this.presenca = presenca;
    }

    public boolean isPontualidade() {
        return pontualidade;
    }

    public void setPontualidade(boolean pontualidade) {
        this.pontualidade = pontualidade;
    }

    public boolean isAnotDomingo() {
        return anotDomingo;
    }

    public void setAnotDomingo(boolean anotDomingo) {
        this.anotDomingo = anotDomingo;
    }

    public boolean isAnotArena() {
        return anotArena;
    }

    public void setAnotArena(boolean anotArena) {
        this.anotArena = anotArena;
    }

    public boolean isMeditacao() {
        return meditacao;
    }

    public void setMeditacao(boolean meditacao) {
        this.meditacao = meditacao;
    }

    public int getVersiculo() {
        return versiculo;
    }

    public void setVersiculo(int versiculo) {
        this.versiculo = versiculo;
    }

    public UsuarioChamada(int idTeen, int idChamada, Teen teen, Chamada chamada, UsuChaType tipo, int pontoExtra, boolean presenca, boolean pontualidade, boolean anotDomingo, boolean anotArena, boolean meditacao, int versiculo) {
        this.idTeen = idTeen;
        this.idChamada = idChamada;
        this.teen = teen;
        this.chamada = chamada;
        this.tipo = tipo;
        this.pontoExtra = pontoExtra;
        this.presenca = presenca;
        this.pontualidade = pontualidade;
        this.anotDomingo = anotDomingo;
        this.anotArena = anotArena;
        this.meditacao = meditacao;
        this.versiculo = versiculo;
    }
}
