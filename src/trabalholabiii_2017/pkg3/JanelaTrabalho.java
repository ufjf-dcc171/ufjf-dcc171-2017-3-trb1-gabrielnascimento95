/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholabiii_2017.pkg3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel_Nascimento
 */
public class JanelaTrabalho extends JFrame{
    private String[] listaMesa = new String[]{"Mesa 1", "Mesa 2", "Mesa 3","Mesa 4", "Mesa 5", "Mesa 6","Mesa 7", "Mesa 8", "Mesa 9","Mesa 10", "Mesa 11", "Mesa 12","Mesa 13", "Mesa 14", "Mesa 15","Mesa 16", "Mesa 17", "Mesa 18"};
    private String[] listaBebida = new String[]{"Skol", "Bhama", "Proibida", "Bavaria"};
    private String[] listaComida = new String[]{"Porção de Batata", "Porção de Torresmo", "Porção de Linguiça"};
    private String[] listaStatus = new String[]{"Aberto", "Fechado"};
    
    private ArrayList<String> listaPedido = new ArrayList<>();
    
    private JComboBox<String> cmbBoxIdMesa = new JComboBox<>(listaMesa); 
    private JComboBox<String> cmbBoxDescricaoBebida = new JComboBox<>(listaBebida);
    private JComboBox<String> cmbBoxDescricaoComida = new JComboBox<>(listaComida);
    private JComboBox<String> cmbBoxstatus = new JComboBox<>(listaStatus);
    
    private JButton btnAdicionarPedido = new JButton("Adicionar");
    private JButton btnRemoverPedido = new JButton("Remover");
    private JButton btnAlterarPedido = new JButton("Alterar");
    private JButton btnFecharPedido = new JButton("Fechar Mesa");
    private JButton btnRelatorioPedido = new JButton("Gerar Relatório p/ Cliente");
    
    private int qntBebida = 1, qntComida = 1;
    
    private JTable relacaoPedidos;
    
    private Long horarioInicial = new Long(System.currentTimeMillis());
    private Long horarioFinal;
    private Date dataInicial = new Date(horarioInicial);
    private Date dataFinal;

    public JanelaTrabalho() throws HeadlessException{
        super("Gerenciador de Pedidos");
        Object[][] dados = new Object[][]{};
        Object[] titulos = new Object[]{"Mesa", "Horário de Abertura", "Horário de Fechamento","Quantidade -->", "Bebidas", "Quantidade -->", "Comida", "Status"};
        relacaoPedidos = new JTable(new DefaultTableModel(dados, titulos));
        btnRemoverPedido.setEnabled(false);
        btnAlterarPedido.setEnabled(false);
        btnFecharPedido.setEnabled(false);
        btnRelatorioPedido.setEnabled(false);
        btnRemoverPedido.setBackground(Color.red);
        btnAdicionarPedido.setBackground(Color.green);
        btnAlterarPedido.setBackground(Color.yellow);
        btnFecharPedido.setBackground(Color.lightGray);
        btnRelatorioPedido.setBackground(Color.cyan);
        
        JPanel entradaDados = new JPanel();
        entradaDados.setLayout(new GridLayout(3, 4));
        entradaDados.add(cmbBoxIdMesa);
        entradaDados.add(cmbBoxDescricaoBebida);
        entradaDados.add(cmbBoxDescricaoComida);
        entradaDados.add(btnAlterarPedido);
        entradaDados.add(btnAdicionarPedido);
        entradaDados.add(btnRemoverPedido);
        entradaDados.add(btnFecharPedido);
        entradaDados.add(btnRelatorioPedido);
        
        
        add(entradaDados, BorderLayout.NORTH); 
        add(new JScrollPane(relacaoPedidos), BorderLayout.CENTER);
        
        relacaoPedidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        relacaoPedidos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (relacaoPedidos.getSelectedRowCount() == 0) {
                btnRemoverPedido.setEnabled(false);
                btnAlterarPedido.setEnabled(false);
                btnAdicionarPedido.setEnabled(false);
                btnFecharPedido.setEnabled(false);
                btnRelatorioPedido.setEnabled(false);
            } else {
                btnRemoverPedido.setEnabled(true);
                btnAlterarPedido.setEnabled(true);
                btnFecharPedido.setEnabled(true);
                btnRelatorioPedido.setEnabled(true);
                DefaultTableModel modelo = (DefaultTableModel) relacaoPedidos.getModel();
                int linha = relacaoPedidos.getSelectedRow();
                cmbBoxIdMesa.setSelectedItem((String) modelo.getValueAt(linha, 0));
                qntBebida = (int) modelo.getValueAt(linha, 3);
                cmbBoxDescricaoBebida.setSelectedItem((String) modelo.getValueAt(linha, 4));
                qntComida = (int) modelo.getValueAt(linha, 5);
                cmbBoxDescricaoComida.setSelectedItem((String) modelo.getValueAt(linha, 6));
                cmbBoxstatus.setSelectedItem((String) modelo.getValueAt(linha, 7));
                }
            }   
        });
        
        btnAdicionarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelo = (DefaultTableModel)relacaoPedidos.getModel();
                qntBebida = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Bebida: "));
                qntComida = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Comida: "));
           
                modelo.addRow(new Object[]{
                    cmbBoxIdMesa.getSelectedItem(),
                    dataInicial,
                    " ",
                    qntBebida,
                    cmbBoxDescricaoBebida.getSelectedItem(),
                    qntComida,
                    cmbBoxDescricaoComida.getSelectedItem(),
                    cmbBoxstatus.getItemAt(0)
                });
                
                cmbBoxIdMesa.setSelectedItem(0);
                cmbBoxDescricaoBebida.setSelectedItem(0);
                cmbBoxDescricaoComida.setSelectedItem(0);
                cmbBoxstatus.setSelectedItem(0);       
            }
        });
        
        btnRemoverPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(relacaoPedidos.getSelectedRowCount()== 0){
                    return;
                }
                DefaultTableModel modelo = (DefaultTableModel)relacaoPedidos.getModel();
                modelo.removeRow(relacaoPedidos.getSelectedRow());
            }
        });
        
        btnAlterarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(relacaoPedidos.getSelectedRowCount()!= 0){
                    if(cmbBoxstatus.getSelectedItem() == "Aberto"){
                        DefaultTableModel modelo = (DefaultTableModel)relacaoPedidos.getModel();
                        int linha = relacaoPedidos.getSelectedRow();
                        modelo.setValueAt(cmbBoxDescricaoBebida.getSelectedItem(), linha, 4);
                        modelo.setValueAt(cmbBoxDescricaoComida.getSelectedItem(), linha, 6);
                        modelo.setValueAt(qntBebida = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Bebida: ")), linha, 3);
                        modelo.setValueAt(qntComida = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Comida: ")), linha, 5);
                        relacaoPedidos.clearSelection();
                    }else{
                        JOptionPane.showMessageDialog(null, "Pedido Fechado");
                    }
               }
            }
        });
    
        btnFecharPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(relacaoPedidos.getSelectedRowCount()!= 0){
                    if(cmbBoxstatus.getSelectedItem() == "Aberto"){
                        DefaultTableModel modelo = (DefaultTableModel)relacaoPedidos.getModel();
                        int linha = relacaoPedidos.getSelectedRow();
                        horarioFinal = new Long(System.currentTimeMillis());
                        dataFinal = new Date(horarioFinal);
                        modelo.setValueAt(dataFinal, linha, 2);
                        modelo.setValueAt(cmbBoxstatus.getItemAt(1), linha, 7); 
                        relacaoPedidos.clearSelection();
                    }else{
                        JOptionPane.showMessageDialog(null, "Pedido já está fechado.");
                    }
               }
            }
        });
    
    
    
    
    }

    
    
    
}
