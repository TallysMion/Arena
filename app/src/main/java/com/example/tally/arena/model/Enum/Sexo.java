package com.example.tally.arena.model.Enum;

import java.io.Serializable;

public enum Sexo implements Serializable {
	Masc, Fem, Mix;
	
	public String toString() {
		switch(this) {
		case Masc:	return "Masculino";
		case Fem:	return "Feminino";
		case Mix:	return "Misto";
		}
		return null;
	}

	public static Sexo byInt(int i){
		switch(i){
			case 0: return Sexo.Masc;
			case 1: return Sexo.Fem;
			case 2: return Sexo.Mix;
		}
		return null;
	}
}
