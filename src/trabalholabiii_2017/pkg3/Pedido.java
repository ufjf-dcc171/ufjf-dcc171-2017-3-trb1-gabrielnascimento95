/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholabiii_2017.pkg3;

import java.util.Date;

/**
 *
 * @author Gabriel_Nascimento
 */
public class Pedido {
    private int mesa;
    private Date dataInicio;
    private Date dataFim;
    private String descrição;

    public Pedido(int id, Date dataInicio, Date dataFim, String descrição) {
        this.mesa = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descrição = descrição;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int id) {
        this.mesa = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }
    
    
    
}
