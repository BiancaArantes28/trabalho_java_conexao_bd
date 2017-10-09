/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Persistencia.CursoDB;
import Persistencia.PessoaDb;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.text.TableView;
public class DetalheCurso extends JFrame{
    private JTextField nome, carga_horaria;
    private JButton editar;
    private int id;
    public DetalheCurso(int id) throws SQLException{
       
        super("JTextField - Caixas de texto");
        this.id = id;
	setLayout(new FlowLayout());
        //JFrame janela1 = new JFrame();
        super.setSize(400, 183);
        super.setLocation(420, 290);
        CursoDB cursoCon = new CursoDB();
        ResultSet rs1 = null;
        rs1 = cursoCon.Consulta(id);
        this.nome = new JTextField();
        this.carga_horaria = new JTextField();
        editar = new JButton("Editar");
        JLabel curso = new JLabel("Nome do Curso");
        add(curso);
        String no = "", car = "";
        while(rs1.next()){
           no = rs1.getString("nome");
           car = rs1.getString("horaria");
        }
        this.nome.setText(no);
        this.carga_horaria.setText(car);
        add(this.nome);
        JLabel carga = new JLabel("Carga horária");
        add(carga);
        this.carga_horaria.setText(car);
        add(this.carga_horaria);
        add(editar);
        editar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento){
                    if(evento.getSource() == editar){
                        
                        String nome_curso = nome.getText();
                        String horaria = carga_horaria.getText();
                        int resposta = cursoCon.atualizaCurso(id, nome_curso, horaria);
                        if(resposta == 1){
                            System.out.println("Sucesso!");
                        }
                        
                    }
                            
            }
         }
        );
    }
    
    public void recebeInfo(String nome, String carga_horaria){
        
    }
    
}
