package com.example.tally.arena.Utils;

public class PHP_URL {
    //controle
    public static final String URL = "192.168.0.16"; //Casa
//    public static final String URL = "192.168.25.105"; //Firma
//    public static final String URL = ""; //Facul
    public static final String TAG_SUCCESS = "success";
    public static final String TAG_MENSAGEM = "mensage";

    //campos
    public static final String TAG_CODIGO = "codigo";
    public static final String TAG_ID = "id";
    public static final String TAG_NOME = "nome";
    public static final String TAG_IGREJA = "igreja";

    //URLs
    public static final String URL_GET_CODIGO   = "http://"+URL+"/ArenaDao/db_get_codigo.php";
    public static final String URL_DEL_CODIGO   = "http://"+URL+"/ArenaDao/db_del_codigo.php";
    public static final String URL_ADD_ARENA    = "http://"+URL+"/ArenaDao/db_add_arena.php";
    public static final String URL_ADD_USUARIO  = "http://"+URL+"/ArenaDao/db_add_usuario.php";
}
