package com.example.tally.arena.model;

import java.io.Serializable;
import java.util.LinkedList;

import com.example.tally.arena.model.Enum.Sexo;

public class GA implements Serializable {

	private int id;
	private String Nome;
	private Sexo sexo;
	private Arena arena;
	private LinkedList<Teen> teens;
	private LinkedList<Chamada> chamadas;
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
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public Arena getArena() {
		return arena;
	}
	public void setArena(Arena arena) {
		this.arena = arena;
		for(Teen tn:this.teens)
			tn.setArena(arena);
	}
	
	
	public LinkedList<Teen> getTeens() {
		return teens;
	}
	public void setTeens(LinkedList<Teen> teens) {
		this.teens = teens;
	}
	
	public LinkedList<Chamada> getChamadas() {
		return chamadas;
	}
	public void setChamadas(LinkedList<Chamada> chamadas) {
		this.chamadas = chamadas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Nome == null) ? 0 : Nome.hashCode());
		result = prime * result + ((arena == null) ? 0 : arena.hashCode());
		result = prime * result + ((chamadas == null) ? 0 : chamadas.hashCode());
		result = prime * result + id;
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((teens == null) ? 0 : teens.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GA other = (GA) obj;
		if (Nome == null) {
			if (other.Nome != null)
				return false;
		} else if (!Nome.equals(other.Nome))
			return false;
		if (arena == null) {
			if (other.arena != null)
				return false;
		} else if (!arena.equals(other.arena))
			return false;
		if (chamadas == null) {
			if (other.chamadas != null)
				return false;
		} else if (!chamadas.equals(other.chamadas))
			return false;
		if (id != other.id)
			return false;
		if (sexo != other.sexo)
			return false;
		if (teens == null) {
			if (other.teens != null)
				return false;
		} else if (!teens.equals(other.teens))
			return false;
		return true;
	}
	
	public GA(int id, String nome, Sexo sexo, Arena arena, LinkedList<Teen> teens, LinkedList<Chamada> chamadas, String codigo) {
		super();
		this.id = id;
		Nome = nome;
		this.sexo = sexo;
		this.arena = arena;
		this.teens = teens;
		this.chamadas = chamadas;
		this.codigo = codigo;
	}
	
	public GA() {
		super();
	}

	
	
	
}
