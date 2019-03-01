package com.example.tally.arena.model;

import com.example.tally.arena.model.Enum.UserType;

import java.io.Serializable;
import java.sql.Date;

public class Lider extends Usuario implements Serializable {
	

	public Lider() {
		super();
	}

	public Lider(int id, String nome, String login, String senha, String email, Date dataNasc, String telefone, Arena arena) {
		super(id, nome, login, senha, email, dataNasc, telefone, arena, UserType.Lider);
	}

	public Lider(int id, String nome, String login, String senha, String email, Date dataNasc, String telefone, int arena) {
		super(id, nome, login, senha, email, dataNasc, telefone, arena, UserType.Lider);
	}


}
