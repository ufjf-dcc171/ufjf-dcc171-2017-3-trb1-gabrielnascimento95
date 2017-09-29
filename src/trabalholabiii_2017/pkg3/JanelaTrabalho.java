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
    private JTextField txtId = new JTextField(2);
    private JTextField txtDataInicio = new JTextField(20);
    private JTextField txtDataFim = new JTextField(20);
    private JTextField txtDescricao = new JTextField(200);
    private JButton btnAdicionarPedido = new JButton("Adicionar");
    private JButton btnRemoverPedido = new JButton("Remover");
    private JButton btnSalvarPedido = new JButton("Salvar");
    private JButton btnFecharPedido = new JButton("Alterar Status");
    private JTable relacaoPedidos;
    private Long horarioInicial = new Long(System.currentTimeMillis());
    private Long horarioFinal = new Long(System.currentTimeMillis() + 20000000);
    private Date dataInicial = new Date(horarioInicial);
    private Date dataFinal = new Date(horarioFinal);

    public JanelaTrabalho() throws HeadlessException{
        super("Gerenciador de Pedidos");
        Object[][] dados = new Object[][]{
            {"Maria", dataInicial, dataFinal, "Skol, Porção de Batata", "Aberto"},
            {"João", dataInicial, dataFinal, "Bhama, Porção de Linguiça", "Aberto"},
            {"José", dataInicial, dataFinal, "Proibida, Porção de Torresmo", "Aberto"},
        };
        Object[] titulos = new Object[]{"Nome", "Horário de Abertura", "Horário de Fechamento", "Descrição", "Status"};
        relacaoPedidos = new JTable(new DefaultTableModel(dados, titulos));
        btnRemoverPedido.setEnabled(false);
        btnFecharPedido.setEnabled(false);
        btnSalvarPedido.setEnabled(false);
        
        JPanel entradaDados = new JPanel();
        entradaDados.setLayout(new GridLayout(2, 5));
        entradaDados.add(txtId);
        entradaDados.add(txtDataInicio);
        entradaDados.add(txtDataFim);
        entradaDados.add(txtDescricao);
        entradaDados.add(btnSalvarPedido);
        entradaDados.add(btnAdicionarPedido);
        entradaDados.add(btnRemoverPedido);
        entradaDados.add(btnFecharPedido);
        
        add(entradaDados, BorderLayout.NORTH); 
        add(new JScrollPane(relacaoPedidos), BorderLayout.CENTER);
    }

    
    
    
}
