package com.example.tally.arena.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Factory implements Runnable{

    private Connection conn;
//    private String host = "192.168.0.16";
    private String host = "191.52.64.69";
    private int port = 3306;
    private String db = "Arena";
    private String user = "arena";
    private String pass = "arena123";
    private String url = "jdbc:postgre://%s:%d/%s";
    public Exception e;

    public Factory() {
        super();
        this.url = String.format(this.url,this.host, this.port, this.db);

        this.conecta();
        this.desconecta();
    }

    public Connection getConnection(){
        this.conecta();
        return  this.conn;
    }

    @Override
    public void run() {
        try{
            Class.forName("org.postgre.Driver");
            this.conn = DriverManager.getConnection(this.url,this.user,this.pass);
        }catch (Exception e){
            this.e = e;
        }
    }

    private void conecta(){
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        }catch (Exception e){
            this.e = e;
        }
    }

    public void desconecta(){
        if (this.conn!= null){
            try{
                this.conn.close();
            }catch (Exception e){

            }finally {
                this.conn = null;
            }
        }
    }

    public ResultSet select(String query){
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDB(this.conn, query).execute().get();
        }catch (Exception e){
            this.e = e;
        }
        return resultSet;
    }

    public ResultSet execute(String query){
        this.conecta();
        ResultSet resultSet = null;
        try {
            resultSet = new ExecuteDB(this.conn, query).execute().get();
        }catch (Exception e){
            this.e = e;
        }
        return resultSet;
    }

}