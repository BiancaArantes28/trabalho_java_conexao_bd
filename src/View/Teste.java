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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.text.TableView;
/**
 *
 * @author Bianca Arantes
 */
public class Teste extends JFrame{
    private JTextField nome, end, cpf, ra;
    private JButton exibe;
    
    public Teste() throws SQLException{
        
	super("JTextField - Caixas de texto");
	setLayout(new FlowLayout());
        //JFrame janela1 = new JFrame();
        super.setSize(400, 183);
        super.setLocation(420, 290);
        //janela1.setSize(400, 183);
        //janela1.setLocation(420, 290);
	nome = new JTextField();
        end = new JTextField();
        cpf = new JTextField();
        ra = new JTextField();
        exibe = new JButton("Editar");
        
	add(nome);
        add(end);
        add(cpf);
        add(ra);
        //exibe.addActionListener((ActionListener) this);
	//janela1.add(fixa);
        //janela1.setVisible(true);
        CursoDB curso = new CursoDB();
        ResultSet test = null;
        test = curso.Consulta(1);
        System.out.println(test);
        JTable tabela = new JTable();
        if(test != null){
            while(test.next()){
                //System.out.println(test.getString("ra"));
                ra.setText(test.getString("ra"));
                nome.setText(test.getString("nome"));
            }
            //System.out.println("Aqui if");
        }else{
            //System.out.println("Nullo");
        }
        //System.out.println("Aqui");
        exibe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento){
                    if(evento.getSource() == exibe){
                        PessoaDb aluno = new PessoaDb();
                        String valorRa = ra.getText();
                        //rs1 = aluno.Consulta(ra);
                        //nome.setText();
                        System.out.println(valorRa);
                    }
                            
            }
         }
        );
        add(exibe);
        
    }
    
    public static void main(String args[]) throws SQLException{
        
        
        new Teste();
    }
    private void exibeActionPerformed(java.awt.event.ActionEvent evt){
        System.out.println("Cheguei aqui uhuuu!");
    }

    
    
}
