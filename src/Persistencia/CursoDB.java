/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author internet
 */
public class CursoDB {
    
    private PreparedStatement select;
    private PreparedStatement update;
    private ResultSet rs;
    private final Conexao con;
   
    public CursoDB(){
        con = new Conexao();
   }
    
   public int Inserir(String nome, String cargahoraria){
       int res = 0;
       try{
           if (con.getConn() != null){
                String SQL = "Insert into curso (nome,horaria)  ";
                     SQL = SQL + "Values (?,?)";
                     update = con.getConn().prepareStatement(SQL);
                     update.setString(1, nome);
                     update.setString(2, cargahoraria);


                     update.executeUpdate();
                     update.close();
                     res = 1;
            }else{
               res = 3;
           }
       
       }catch( SQLException cnfe ){
           System.out.println(cnfe);
       }
       
       return res;
   }
   
   public ResultSet Consulta(int nome_curso) throws SQLException{
        ResultSet rs1; 
        rs1 = null;
        if (con.getConn() != null){
           Statement stm = con.conn.createStatement();
           rs1 = stm.executeQuery("select * from curso where id ="+nome_curso); 
        }
        
         
        return rs1;
    }
   
   public int atualizaCurso(int id, String nome, String cargahoraria){
       int res = 0;
       try{
           if (con.getConn() != null){
               
                String SQL = "UPDATE curso SET nome = ?, horaria = ? Where id = "+id;
                     update = con.getConn().prepareStatement(SQL);
                     update.setString(1, nome);
                     update.setString(2, cargahoraria);
                     update.executeUpdate();
                     update.close();
                     res = 1;
            }else{
               res = 3;
           }
       
       }catch( SQLException cnfe ){
           System.out.println(cnfe);
       }
       
       return res;
   }
   
   public ResultSet ListaCursos() throws SQLException{
       ResultSet rs1;
       rs1 = null;
       if(con.getConn() != null){
           Statement stm = con.conn.createStatement();
           rs1 = stm.executeQuery("Select * from curso");
       }
       return rs1;
   }
   
   public int excluir(int id) throws SQLException{
        int res = 0;
        if (con.getConn() != null){
            String SQL = "Delete from curso Where id = "+id;
            update = con.getConn().prepareStatement(SQL);
            update.executeUpdate();
            update.close();
        }
        
        res = 1;
        return res;
    }
    
}
