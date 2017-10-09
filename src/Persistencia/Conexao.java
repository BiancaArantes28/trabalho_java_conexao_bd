package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    protected PreparedStatement stmt;
    protected Connection conn;
   
    public Conexao(){
        this.servidor = "localhost:3306";
        this.banco = "bancopoo";
        this.usuario = "root";
        this.senha = "";
        conectar();
    }

     public void conectar(){
     String url =  "jdbc:mysql://"+servidor+"/"+banco;
     
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = (Connection) DriverManager.getConnection(url,this.usuario,this.senha);
                     
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
             
    }

     public Connection getConn(){
        return conn;
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        
}
