/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholabiii_2017.pkg3;

import java.util.ArrayList;

/**
 *
 * @author Gabriel_Nascimento
 */
public class Pedido {
    private int idMesa;
    private ArrayList<String> listaBebidas = new ArrayList<>();
    private ArrayList<String> listaComida = new ArrayList<>();

    public Pedido(int id){
        this.idMesa = id;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public ArrayList<String> getListaBebidas() {
        return listaBebidas;
    }

    public void setListaBebidas(ArrayList<String> listaBebidas) {
        this.listaBebidas = listaBebidas;
    }

    public ArrayList<String> getListaComida() {
        return listaComida;
    }

    public void setListaComida(ArrayList<String> listaComida) {
        this.listaComida = listaComida;
    }
    
    public void adicionaBebida(String Bebida){
        listaBebidas.add(Bebida);
    }
    
    public void adicionaComida(String Comida){
        listaComida.add(Comida);
    }
    
    public String imprimeDescricaoBebida(){
        String aux = null;
        for(int i=0; i < listaBebidas.size(); i++){
            aux = listaBebidas.get(i) + ", ";
        }
        return aux;
    }
    
    public String imprimeDescricaoComida(){
        String aux = null;
        for(int i=0; i < listaComida.size(); i++){
            aux = listaComida.get(i) + ", ";
        }
        return aux;
    }
}
