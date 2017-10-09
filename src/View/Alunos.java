/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Persistencia.PessoaDb;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView;
public class Alunos extends JFrame{
    
    public Alunos() throws SQLException{
        PessoaDb alunos = new PessoaDb();
        DefaultTableModel dtm = new DefaultTableModel();
        
        //String[] colunas = {"Nome","Ra"};
        dtm.addColumn("Nome");
        dtm.addColumn("Ra");
        Object [][] dados;
        ResultSet rs1 = alunos.ConsultaAlunos();
        
        if(rs1 != null){
            while(rs1.next()){
                //dados = {{rs1.getString("nome"),rs1.getString("ra")}};
               
            }
        }
        //JTable tabela = new JTable(dados, colunas);
    }
}
