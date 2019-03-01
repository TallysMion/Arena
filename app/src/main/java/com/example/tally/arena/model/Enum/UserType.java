package com.example.tally.arena.model.Enum;

import java.io.Serializable;

public enum UserType  implements Serializable {
	Lider, Teen;

	public static UserType byInt(int i){
		switch (i){
			case 0: return Lider;
			case 1: return Teen;
		}
		return null;
	}

}
