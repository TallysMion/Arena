package com.example.tally.arena.model.Enum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public enum Semana implements Serializable {
	dom, seg, ter, qua, qui, sex, sab;
	
	
	public String toString() {
		switch(this) {
		case dom:	return "Domingo";
		case seg:	return "Segunda-Feira";
		case ter:	return "Ter�a-Feira";
		case qua:	return "Quarta-Feira";
		case qui:	return "Quinta-Feira";
		case sex:	return "Sexta-Feira";
		case sab:	return "Sabado";
		}
		return null;
	}

	public static Semana byInt(int i){
		switch(i){
			case 0: return Semana.dom;
			case 1: return Semana.seg;
			case 2: return Semana.ter;
			case 3: return Semana.qua;
			case 4: return Semana.qui;
			case 5: return Semana.sex;
			case 6: return Semana.sab;
		}
		return null;
	}

	public static List<String> getList(){
		List<String> result = new ArrayList<>();
		result.add(dom.toString());
		result.add(seg.toString());
		result.add(ter.toString());
		result.add(qua.toString());
		result.add(qui.toString());
		result.add(sex.toString());
		result.add(sab.toString());
		return result;
	}

	public static Semana byString(String s){
		if(s.equals(dom.toString())) return dom;
		if(s.equals(seg.toString())) return seg;
		if(s.equals(ter.toString())) return ter;
		if(s.equals(qua.toString())) return qua;
		if(s.equals(qui.toString())) return qui;
		if(s.equals(sex.toString())) return sex;
		if(s.equals(sab.toString())) return sab;

		return null;
	}

}
