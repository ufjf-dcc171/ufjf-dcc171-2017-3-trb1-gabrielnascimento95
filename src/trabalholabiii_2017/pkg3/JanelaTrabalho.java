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
import javax.swing.JLabel;
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
    private String[] listaMesa = new String[]{"1", "2", "3","4", "5","6","7", "8", "9","10", "11", "12","13", "14", "15","16", "17", "18"};
    private String[] listaBebida = new String[]{" ", "Skol", "Bhama", "Proibida", "Bavaria"};
    private String[] listaComida = new String[]{" ", "Porção de Batata", "Porção de Torresmo", "Porção de Linguiça"};
    private String[] listaStatus = new String[]{"Aberto", "Fechado"};
    
    private ArrayList<Pedido> listaPedido = new ArrayList<>();
    
    private JComboBox<String> cmbBoxIdMesa = new JComboBox<>(listaMesa); 
    private JComboBox<String> cmbBoxDescricaoBebida = new JComboBox<>(listaBebida);
    private JComboBox<String> cmbBoxDescricaoComida = new JComboBox<>(listaComida);
    private JComboBox<String> cmbBoxstatus = new JComboBox<>(listaStatus);
    
    private JLabel idMesa = new JLabel("Mesa");
    private JLabel idBebida = new JLabel("Bebidas");
    private JLabel idComida = new JLabel("Comida");
    
    private JButton btnAdicionarPedido = new JButton("Adicionar");
    private JButton btnRemoverPedido = new JButton("Remover");
    private JButton btnAlterarPedido = new JButton("Alterar");
    private JButton btnFecharPedido = new JButton("Fechar Mesa");
    private JButton btnRelatorioPedido = new JButton("Gerar Relatório p/ Cliente");
    private JButton btnAddBebida = new JButton("Adicionar Bebida ao Cardápio");
    private JButton btnAddComida = new JButton("Adicionar Comidas ao Cardápio");
    private JButton btnCoringa = new JButton("");
  
    private JTable relacaoPedidos;
    
    private Long horarioInicial = new Long(System.currentTimeMillis());
    private Long horarioFinal;
    private Date dataInicial = new Date(horarioInicial);
    private Date dataFinal;

    public JanelaTrabalho() throws HeadlessException{
        super("Gerenciador de Pedidos");
        Object[][] dados = new Object[][]{};
        Object[] titulos = new Object[]{"Mesa", "Horário de Abertura", "Horário de Fechamento", "Bebidas", "Comida", "Status"};
        relacaoPedidos = new JTable(new DefaultTableModel(dados, titulos));
        btnRemoverPedido.setEnabled(false);
        btnAlterarPedido.setEnabled(false);
        btnFecharPedido.setEnabled(false);
        btnRelatorioPedido.setEnabled(false);
        btnRelatorioPedido.setEnabled(false);
        btnCoringa.setEnabled(false);
        btnRemoverPedido.setBackground(Color.red);
        btnAdicionarPedido.setBackground(Color.green);
        btnAlterarPedido.setBackground(Color.yellow);
        btnFecharPedido.setBackground(Color.lightGray);
        btnRelatorioPedido.setBackground(Color.cyan);
      
        
        JPanel entradaDados = new JPanel();
        entradaDados.setLayout(new GridLayout(5, 3));
        entradaDados.add(btnAddBebida);
        entradaDados.add(btnAddComida);
        entradaDados.add(btnCoringa);
        entradaDados.add(idMesa);
        entradaDados.add(idBebida);
        entradaDados.add(idComida);
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
                cmbBoxstatus.setSelectedItem((String) modelo.getValueAt(linha, 5));
                }
            }   
        });
        
        btnAdicionarPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = Integer.parseInt((String)cmbBoxIdMesa.getSelectedItem());
                Pedido aux = new Pedido(pos);
                aux.adicionaBebida((String)cmbBoxDescricaoBebida.getSelectedItem());
                aux.adicionaComida((String)cmbBoxDescricaoComida.getSelectedItem());

                listaPedido.add(pos-1, aux);
                DefaultTableModel modelo = (DefaultTableModel)relacaoPedidos.getModel();
                
                modelo.addRow(new Object[]{
                    cmbBoxIdMesa.getSelectedItem(),
                    dataInicial,
                    " ",
                    listaPedido.get(pos-1).imprimeDescricaoBebida(),
                    listaPedido.get(pos-1).imprimeDescricaoComida(),
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
                        int pos = Integer.parseInt((String)cmbBoxIdMesa.getSelectedItem());
                        DefaultTableModel modelo = (DefaultTableModel)relacaoPedidos.getModel();
                        int linha = relacaoPedidos.getSelectedRow();
                        listaPedido.get(pos-1).adicionaBebida((String)cmbBoxDescricaoBebida.getSelectedItem());
                        listaPedido.get(pos-1).adicionaComida((String)cmbBoxDescricaoComida.getSelectedItem());
                        
                        modelo.setValueAt(listaPedido.get(pos-1).imprimeDescricaoBebida(), linha, 3);
                        modelo.setValueAt(listaPedido.get(pos-1).imprimeDescricaoComida(), linha, 4);
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
                        modelo.setValueAt(cmbBoxstatus.getItemAt(1), linha, 5); 
                        relacaoPedidos.clearSelection();
                    }else{
                        JOptionPane.showMessageDialog(null, "Pedido já está fechado.");
                    }
               }
            }
        });
    
        btnRelatorioPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelo = (DefaultTableModel) relacaoPedidos.getModel();
                int linha = relacaoPedidos.getSelectedRow();
                String auxMesa =  (String) modelo.getValueAt(linha, 0);
                String auxDescricaoBebida= (String) modelo.getValueAt(linha, 3);
                String auxDescricaoComida = (String) modelo.getValueAt(linha, 4);
                
                JOptionPane.showMessageDialog(null,"Mesa " + auxMesa + "\n\n" + auxDescricaoBebida + "\n\n" + auxDescricaoComida);
            }
        });
        
        btnAddBebida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String novaBebida = new String();
                novaBebida = JOptionPane.showInputDialog("Nova Bebida: ");
                cmbBoxDescricaoBebida.addItem(novaBebida);
            }
        });
        
        btnAddComida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String novaComida = new String();
                novaComida = JOptionPane.showInputDialog("Nova Comida: ");
                cmbBoxDescricaoComida.addItem(novaComida);
            }
        });
    
    }
}
