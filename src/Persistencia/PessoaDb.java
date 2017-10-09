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
public class PessoaDb {
    private PreparedStatement select;
    private PreparedStatement update;
    private ResultSet rs;
    private final Conexao con;
    
    public PessoaDb(){
        con = new Conexao();
   }
    
    public int Incluir(String nome, String end, String telefone, String cpf, String ra){
      int res = 0;
      
      try{
          if (con.getConn() != null){
                 String SQL = "Insert into aluno (nome,end,cpf,ra,telefone)  ";
                SQL = SQL + "Values (?,?,?,?,?)";
                update = con.getConn().prepareStatement(SQL);
                update.setString(1, nome);
                update.setString(2, end);
                update.setString(3, cpf);
                update.setString(4, ra);
                update.setString(5, telefone);
                
                update.executeUpdate();
                update.close();
                res = 1;
                
                
            }else{
              res = 3;
          }   
      }
      catch( SQLException cnfe ){
            System.out.println("EROR");
            res=2;
      }
        return res;
    }
    
    public ResultSet  Consulta(String ra) throws SQLException{
        ResultSet rs1; 
        rs1 = null;
        Statement stm = con.conn.createStatement();
        rs1 = stm.executeQuery("Select * from aluno Where ra =" + ra);
         
        return rs1;
    }
    
    public ResultSet ConsultaAlunos() throws SQLException{
        ResultSet rs1; 
        rs1 = null;
        Statement stm = con.conn.createStatement();
        rs1 = stm.executeQuery("Select * from aluno");
         
        return rs1;
        
    }
    
    public int editar(String ra, String nome, String end, String cpf, String telefone) throws SQLException{
        int res = 0;
        if (con.getConn() != null){
            String SQL = "Update aluno set nome = ?, end = ?, cpf = ?,telefone = ? Where ra = "+ra;
                
                update = con.getConn().prepareStatement(SQL);
                update.setString(1, nome);
                update.setString(2, end);
                update.setString(3, cpf);
                update.setString(4, telefone);
                
                update.executeUpdate();
                update.close();
                res = 1;
        }
        return res;
    }
    
    public int excluir(String ra) throws SQLException{
        int res = 0;
        if (con.getConn() != null){
            String SQL = "Delete from aluno Where ra = "+ra;
            update = con.getConn().prepareStatement(SQL);
            update.executeUpdate();
            update.close();
        }
        
        res = 1;
        return res;
    }
}
