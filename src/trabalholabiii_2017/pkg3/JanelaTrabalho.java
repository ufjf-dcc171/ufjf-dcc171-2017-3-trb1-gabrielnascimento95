/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholabiii_2017.pkg3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel_Nascimento
 */
public class JanelaTrabalho extends JFrame{
    private JComboBox<String> cmbBoxIdMesa = new JComboBox<>(new String[]{"1", "2", "3","4", "5", "6","7", "8", "9","10", "11", "12","13", "14", "15","16", "17", "18"});
    private JComboBox<String> cmbBoxDescricaoBebida = new JComboBox<>(new String[]{"Skol", "Bhama", "Proibida", "Bavaria", " Porção de Batata", "Porção de Torresmo", "Porção de Linguiça"});
    private JComboBox<String> cmbBoxDescricaoComida = new JComboBox<>(new String[]{" Porção de Batata", "Porção de Torresmo", "Porção de Linguiça"});
    private JComboBox<String> status = new JComboBox<>(new String[]{"Aberto", "Fechado"});
    
    private JButton btnAdicionarPedido = new JButton("Adicionar");
    private JButton btnRemoverPedido = new JButton("Remover");
    private JButton btnSalvarPedido = new JButton("Salvar");
    
    
    private JTable relacaoPedidos;
    
    private Long horarioInicial = new Long(System.currentTimeMillis());
    private Long horarioFinal = new Long(System.currentTimeMillis() + 20000000);
    private Date dataInicial = new Date(horarioInicial);
    private Date dataFinal = new Date(horarioFinal);

    public JanelaTrabalho() throws HeadlessException{
        super("Gerenciador de Pedidos");
        Object[][] dados = new Object[][]{
            {cmbBoxIdMesa.getItemAt(0), dataInicial, dataFinal, cmbBoxDescricaoBebida.getItemAt(0) + ", " + cmbBoxDescricaoComida.getItemAt(2) , status.getItemAt(0)},
            {cmbBoxIdMesa.getItemAt(1), dataInicial, dataFinal, cmbBoxDescricaoBebida.getItemAt(1) + ", " + cmbBoxDescricaoComida.getItemAt(0), status.getItemAt(0)},
            {cmbBoxIdMesa.getItemAt(2), dataInicial, dataFinal, cmbBoxDescricaoBebida.getItemAt(2) + ", " + cmbBoxDescricaoComida.getItemAt(1), status.getItemAt(0)},
        };
        Object[] titulos = new Object[]{"Mesa", "Horário de Abertura", "Horário de Fechamento", "Descrição", "Status"};
        relacaoPedidos = new JTable(new DefaultTableModel(dados, titulos));
        btnRemoverPedido.setEnabled(false);
        btnSalvarPedido.setEnabled(false);
        
        
        JPanel entradaDados = new JPanel();
        entradaDados.setLayout(new GridLayout(2, 5));
        entradaDados.add(cmbBoxIdMesa);
        entradaDados.add(cmbBoxDescricaoBebida);
        entradaDados.add(cmbBoxDescricaoComida);
        entradaDados.add(status);
        entradaDados.add(btnSalvarPedido);
        entradaDados.add(btnAdicionarPedido);
        entradaDados.add(btnRemoverPedido);
        
        
        add(entradaDados, BorderLayout.NORTH); 
        add(new JScrollPane(relacaoPedidos), BorderLayout.CENTER);
    }

    
    
    
}
