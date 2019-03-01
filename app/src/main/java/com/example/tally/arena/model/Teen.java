package com.example.tally.arena.model;

import com.example.tally.arena.model.Enum.UserType;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedList;
import java.util.Objects;

public class Teen extends Usuario implements Serializable {

	private int idGA;
	private GA ga;
	private LinkedList<UsuarioChamada> usoCha;
	private int pontuacao;
	
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public GA getGa() {
		return ga;
	}
	public void setGa(GA ga) {
		this.ga = ga;
	}

	public LinkedList<UsuarioChamada> getChamada() {
		return usoCha;
	}
	public void setChamada(LinkedList<UsuarioChamada> usoCha) {
		this.usoCha = usoCha;
	}

	public int getIdGA() {
		return idGA;
	}

	public void setIdGA(int idGA) {
		this.idGA = idGA;
	}


	public Teen(int id, String nome, String login, String senha, String email, Date dataNasc, String telefone, Arena arena, GA ga, LinkedList<UsuarioChamada> userCha, int pontuacao) {
		super(id, nome, login, senha, email, dataNasc, telefone, arena, UserType.Teen);
		this.ga = ga;
		this.idGA = ga!=null?ga.getId():-1;
		this.usoCha = userCha;
		this.pontuacao = pontuacao;
	}

	public Teen(int id, String nome, String login, String senha, String email, Date dataNasc, String telefone, Arena arena,  int ga, LinkedList<UsuarioChamada> userCha, int pontuacao) {
		super(id, nome, login, senha, email, dataNasc, telefone, arena, UserType.Teen);
		this.ga = null;
		this.idGA = ga;
		this.usoCha = userCha;
		this.pontuacao = pontuacao;
	}

	public Teen(int id, String nome, String login, String senha, String email, Date dataNasc, String telefone, int arena, GA ga, LinkedList<UsuarioChamada> userCha, int pontuacao) {
		super(id, nome, login, senha, email, dataNasc, telefone, arena, UserType.Teen);
		this.ga = ga;
		this.idGA = ga!=null?ga.getId():-1;
		this.usoCha = userCha;
		this.pontuacao = pontuacao;
	}

	public Teen(int id, String nome, String login, String senha, String email, Date dataNasc, String telefone, int arena,  int ga, LinkedList<UsuarioChamada> userCha, int pontuacao) {
		super(id, nome, login, senha, email, dataNasc, telefone, arena, UserType.Teen);
		this.ga = null;
		this.idGA = ga;
		this.usoCha = userCha;
		this.pontuacao = pontuacao;
	}

	public Teen() {
		super();
	}

}
