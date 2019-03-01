package com.example.tally.arena.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedList;

import com.example.tally.arena.model.Enum.Estado;

public class Chamada  implements Serializable {

	private int id;
	private Estado estado;
	private java.sql.Date data;
	private Fechamento fechamento;
	private int fechamentoId;
	private GA ga;
	private LinkedList<UsuarioChamada> teens;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	public java.sql.Date getData() {
		return data;
	}
	public void setData(java.sql.Date data) {
		this.data = data;
	}
	
	public Fechamento getFechamento() {
		return fechamento;
	}
	public void setFechamento(Fechamento fechamento) {
		this.fechamento = fechamento;
	}
	
	public GA getGa() {
		return ga;
	}
	public void setGa(GA ga) {
		this.ga = ga;
	}
	
	public LinkedList<UsuarioChamada> getTeens() {
		return teens;
	}
	public void setTeens(LinkedList<UsuarioChamada> teens) {
		this.teens = teens;
	}

	public int getFechamentoId() {
		return fechamentoId;
	}
	public void setFechamentoId(int fechamentoId) {
		this.fechamentoId = fechamentoId;
	}


	public Chamada(int id, Estado estado, Date data, Fechamento fechamento, GA ga, LinkedList<UsuarioChamada> teens) {
		super();
		this.id = id;
		this.estado = estado;
		this.data = data;
		this.fechamento = fechamento;
		this.fechamentoId = fechamento.getId();
		this.ga = ga;
		this.teens = teens;
	}

	public Chamada(int id, Estado estado, Date data, int fechamento, GA ga, LinkedList<UsuarioChamada> teens) {
		super();
		this.id = id;
		this.estado = estado;
		this.data = data;
		this.fechamentoId = fechamento;
		this.fechamento = null;
		this.ga = ga;
		this.teens = teens;
	}

	public Chamada() {
		super();
	}
	
	

	
	
}
