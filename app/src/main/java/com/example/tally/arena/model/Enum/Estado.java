package com.example.tally.arena.model.Enum;

import java.io.Serializable;

public enum Estado implements Serializable {
	open, close;

    public static Estado byInt(int estado) {
    	switch (estado){
			case 0: return Estado.open;
			case 1: return Estado.close;
		}
		return null;
    }

    public String toString() {
		switch(this) {
		case open: 	return "Em Aberto";
		case close:	return "Fechado";
		}
		return null;
	}
}
