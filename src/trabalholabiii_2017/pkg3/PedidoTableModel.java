/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholabiii_2017.pkg3;

//import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gabriel_Nascimento
 */
public class PedidoTableModel extends AbstractTableModel{
    private final List<Pedido> pedidos;

    public PedidoTableModel(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int getRowCount() {
        return pedidos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                pedidos.get(rowIndex).getId();
            case 1:
                pedidos.get(rowIndex).getDataInicio();
            case 2:
                pedidos.get(rowIndex).getDataFim();
            case 3:
                pedidos.get(rowIndex).getDescrição();
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    public void adicionaPedido(Pedido p){
        pedidos.add(p);
        this.fireTableRowsInserted(pedidos.size()-1, pedidos.size()-1);
    }
    
    
}
