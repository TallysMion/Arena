package com.example.tally.arena.model.Enum;

import java.io.Serializable;

public enum UsuChaType  implements Serializable {
    arena, imersao;

    public static UsuChaType byInt(int i){
        switch (i){
            case 0: return UsuChaType.arena;
            case 1: return UsuChaType.imersao;
        }
        return null;
    }
}
