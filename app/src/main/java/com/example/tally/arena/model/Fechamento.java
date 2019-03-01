package com.example.tally.arena.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedList;

public class Fechamento implements Serializable {

	private int id;
	private java.sql.Date inic;
	private java.sql.Date fim;
	private Arena arena;
	private LinkedList<Chamada> chamadas;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public java.sql.Date getInic() {
		return inic;
	}
	public void setInic(java.sql.Date inic) {
		this.inic = inic;
	}
	
	public java.sql.Date getFim() {
		return fim;
	}
	public void setFim(java.sql.Date fim) {
		this.fim = fim;
	}
	
	public Arena getArena() {
		return arena;
	}
	public void setArena(Arena arena) {
		this.arena = arena;
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
		result = prime * result + ((arena == null) ? 0 : arena.hashCode());
		result = prime * result + ((chamadas == null) ? 0 : chamadas.hashCode());
		result = prime * result + ((fim == null) ? 0 : fim.hashCode());
		result = prime * result + id;
		result = prime * result + ((inic == null) ? 0 : inic.hashCode());
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
		Fechamento other = (Fechamento) obj;
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
		if (fim == null) {
			if (other.fim != null)
				return false;
		} else if (!fim.equals(other.fim))
			return false;
		if (id != other.id)
			return false;
		if (inic == null) {
			if (other.inic != null)
				return false;
		} else if (!inic.equals(other.inic))
			return false;
		return true;
	}
	
	public Fechamento(int id, Date inic, Date fim, Arena arena, LinkedList<Chamada> chamadas) {
		super();
		this.id = id;
		this.inic = inic;
		this.fim = fim;
		this.arena = arena;
		this.chamadas = chamadas;
	}
	
	public Fechamento() {
		super();
	}


}
