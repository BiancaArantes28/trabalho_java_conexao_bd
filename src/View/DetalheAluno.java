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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.text.TableView;

public class DetalheAluno extends JFrame{
    private JTextField nome, cpf, ra_aluno, end, telefone;
    private JButton editar;
    private String teste;
    
    public DetalheAluno(String ra) throws SQLException{
        super("Detalhe Aluno");
        this.teste = ra;
        setLayout(new FlowLayout());
        //JFrame janela1 = new JFrame();
        super.setSize(400, 183);
        super.setLocation(420, 290);
        nome = new JTextField();
        cpf = new JTextField();
        ra_aluno = new JTextField();
        end = new JTextField();
        telefone = new JTextField();
        editar = new JButton("Editar");
        PessoaDb aluno = new PessoaDb();
        ResultSet rs1 = null;
        rs1 = aluno.Consulta(ra);
        String nome_aluno = "",cpf_aluno = "",ra_id = "",end_aluno = "", telefone_aluno = "";
        while(rs1.next()){
            nome_aluno = rs1.getString("nome");
            cpf_aluno = rs1.getString("cpf");
            ra_id = rs1.getString("ra");
            end_aluno = rs1.getString("end");
            telefone_aluno = rs1.getString("telefone");
        }
        JLabel nome_do_aluno = new JLabel("Nome: ");
        JLabel cpf_do_aluno = new JLabel("CPF: ");
        JLabel ra_do_aluno = new JLabel("RA: ");
        JLabel end_do_aluno = new JLabel("End.: ");
        JLabel tel_alu = new JLabel("Telefone: ");
        add(nome_do_aluno);
        nome.setText(nome_aluno);
        add(nome);
        add(cpf_do_aluno);
        cpf.setText(cpf_aluno);
        add(cpf);
        //add(ra_do_aluno);
        //ra_aluno.setText(ra_id);
        //add(ra_aluno);
        add(end_do_aluno);
        end.setText(end_aluno);
        add(end);
        add(tel_alu);
        telefone.setText(telefone_aluno);
        add(telefone);
        add(editar);
        editar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento){
                    if(evento.getSource() == editar){
                        
                        String nome_bd = nome.getText();
                        String cpf_bd = cpf.getText();
                        String end_bd = end.getText();
                        String tel_bd = telefone.getText();
                        int resposta = 0;
                        try {
                            resposta = aluno.editar(teste, nome_bd, end_bd, cpf_bd, tel_bd);
                        } catch (SQLException ex) {
                            Logger.getLogger(DetalheAluno.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if(resposta == 1){
                            System.out.println("Sucesso!");
                        }
                        
                    }
                            
            }
         }
        );
    }
    
}
