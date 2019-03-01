package com.example.tally.arena.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;

import com.example.tally.arena.model.Enum.Semana;

public class Arena  implements Serializable {

	private int id;
	private String nome;
	private String endereco;
	private String igrejaMae;
	private Semana diaSemana;
	private int[] horario;
	private LinkedList<Lider> lideres;
	private LinkedList<GA> gas;
	private LinkedList<Fechamento> fechamentos;
	private Constantes constantes;
	private String codigo;

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

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
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getIgrejaMae() {
		return igrejaMae;
	}
	public void setIgrejaMae(String igrejaMae) {
		this.igrejaMae = igrejaMae;
	}
	
	public Semana getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(Semana diaSemana) {
		this.diaSemana = diaSemana;
	}
	
	public int[] getHorario() {
		return horario;
	}
	public void setHorario(int[] horario) {
		this.horario = horario;
	}
	
	public LinkedList<Lider> getLideres() {
		return lideres;
	}
	public void setLideres(LinkedList<Lider> lideres) {
		this.lideres = lideres;
	}
	
	public LinkedList<GA> getGas() {
		return gas;
	}
	public void setGas(LinkedList<GA> gas) {
		this.gas = gas;
	}
	
	public LinkedList<Fechamento> getFechamentos() {
		return fechamentos;
	}
	public void setFechamentos(LinkedList<Fechamento> fechamentos) {
		this.fechamentos = fechamentos;
	}

	public Constantes getConstantes() {
		return constantes;
	}

	public void setConstantes(Constantes constantes) {
		this.constantes = constantes;
	}

	public Arena(int id, String nome, String endereco, String igrejaMae, Semana diaSemana, int[] horario,
			LinkedList<Lider> lideres, LinkedList<GA> gas, LinkedList<Fechamento> fechamentos, Constantes constantes, String codigo) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.igrejaMae = igrejaMae;
		this.diaSemana = diaSemana;
		this.horario = horario;
		this.lideres = lideres;
		this.gas = gas;
		this.fechamentos = fechamentos;
		this.constantes = constantes;
		this.codigo = codigo;
	}
	
	public Arena() {
		super();
	}
	
	
}
