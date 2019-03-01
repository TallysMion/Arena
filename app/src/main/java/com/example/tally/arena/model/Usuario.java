package com.example.tally.arena.model;

import com.example.tally.arena.model.Enum.UserType;

import java.io.Serializable;
import java.sql.Date;

public abstract class Usuario implements Serializable {
	private int id;
	private String nome;
	private String login;
	private String senha;
	private String email;
	private java.sql.Date dataNasc;
	private String telefone;
	private Arena arena;
	private int idArena;
	private UserType tipo;
	
	
	public Usuario() {
		super();
	}

	public Usuario(int id, String nome, String login, String senha, String email, Date dataNasc, String telefone, Arena arena, UserType tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.arena = arena;
		this.idArena = arena.getId();
		this.tipo = tipo;
	}

	public Usuario(int id, String nome, String login, String senha, String email, Date dataNasc, String telefone, int arena, UserType tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.arena = null;
		this.idArena = arena;
		this.tipo = tipo;
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

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public java.sql.Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(java.sql.Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}

	public int getIdArena() {
		return idArena;
	}

	public void setIdArena(int idArena) {
		this.idArena = idArena;
	}

	public UserType getTipo() {
		return tipo;
	}

	public void setTipo(UserType tipo) {
		this.tipo = tipo;
	}

	public static String encrypt(String user, String password) {
	      String sign = user + password;
	      try {
	         java.security.MessageDigest md =
	            java.security.MessageDigest.getInstance("MD5");
	         md.update(sign.getBytes());
	         byte[] hash = md.digest();
	         StringBuffer hexString = new StringBuffer();
	         for (int i = 0; i < hash.length; i++) {
	            if ((0xff & hash[i]) < 0x10)
	               hexString.append(
	                  "0" + Integer.toHexString((0xFF & hash[i])));
	            else
	               hexString.append(Integer.toHexString(0xFF & hash[i]));
	         }
	         sign = hexString.toString();
	      }
	      catch (Exception nsae) {
	         nsae.printStackTrace();
	      }
	      return sign;  
	}


}
