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
    private JComboBox<String> cmbBoxIdMesa = new JComboBox<>(new String[]{"1", "2", "3","4", "5", "6","7", "8", "9","10", "11", "12","13", "14", "15","16", "17", "18"}); 
    private JComboBox<String> cmbBoxDescricaoBebida = new JComboBox<>(new String[]{"Skol", "Bhama", "Proibida", "Bavaria"});
    private JComboBox<String> cmbBoxDescricaoComida = new JComboBox<>(new String[]{"Porção de Batata", "Porção de Torresmo", "Porção de Linguiça"});
    private JComboBox<String> cmbBoxstatus = new JComboBox<>(new String[]{"Aberto", "Fechado"});
    
    private JButton btnAdicionarPedido = new JButton("Adicionar");
    private JButton btnRemoverPedido = new JButton("Remover");
    private JButton btnAlterarPedido = new JButton("Alterar");
    
    private int qntBebida = 1, qntComida = 1;
    
    private JTable relacaoPedidos;
    
    private Long horarioInicial = new Long(System.currentTimeMillis());
    private Long horarioFinal = new Long(System.currentTimeMillis() + 20000000);
    private Date dataInicial = new Date(horarioInicial);
    private Date dataFinal = new Date(horarioFinal);

    public JanelaTrabalho() throws HeadlessException{
        super("Gerenciador de Pedidos");
        Object[][] dados = new Object[][]{
            /*{cmbBoxIdMesa.getItemAt(0), dataInicial, dataFinal, qntBebida, cmbBoxDescricaoBebida.getItemAt(0), qntComida, cmbBoxDescricaoComida.getItemAt(2) , cmbBoxstatus.getItemAt(0)},
            {cmbBoxIdMesa.getItemAt(1), dataInicial, dataFinal, qntBebida, cmbBoxDescricaoBebida.getItemAt(1), qntComida, cmbBoxDescricaoComida.getItemAt(0), cmbBoxstatus.getItemAt(0)},
            {cmbBoxIdMesa.getItemAt(2), dataInicial, dataFinal, qntBebida, cmbBoxDescricaoBebida.getItemAt(2), qntComida, cmbBoxDescricaoComida.getItemAt(1), cmbBoxstatus.getItemAt(1)},
            */
        };
        
        Object[] titulos = new Object[]{"Mesa", "Horário de Abertura", "Horário de Fechamento","Quantidade -->", "Bebidas", "Quantidade -->", "Comida", "Status"};
        relacaoPedidos = new JTable(new DefaultTableModel(dados, titulos));
        btnRemoverPedido.setEnabled(false);
        btnAlterarPedido.setEnabled(false);
        btnRemoverPedido.setBackground(Color.red);
        btnAdicionarPedido.setBackground(Color.green);
        btnAlterarPedido.setBackground(Color.yellow);
        cmbBoxIdMesa.setName("Mesa");
        
        JPanel entradaDados = new JPanel();
        entradaDados.setLayout(new GridLayout(2, 4));
        entradaDados.add(cmbBoxIdMesa);
        entradaDados.add(cmbBoxDescricaoBebida);
        entradaDados.add(cmbBoxDescricaoComida);
        entradaDados.add(cmbBoxstatus);
        entradaDados.add(btnAlterarPedido);
        entradaDados.add(btnAdicionarPedido);
        entradaDados.add(btnRemoverPedido);
        
        
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
            } else {
                btnRemoverPedido.setEnabled(true);
                btnAlterarPedido.setEnabled(true);
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
                    dataFinal,
                    qntBebida,
                    cmbBoxDescricaoBebida.getSelectedItem(),
                    qntComida,
                    cmbBoxDescricaoComida.getSelectedItem(),
                    cmbBoxstatus.getSelectedItem()
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
    
    
    
    
    
    
    }

    
    
    
}
