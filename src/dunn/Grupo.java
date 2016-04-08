/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dunn;

import java.util.ArrayList;

/**
 *
 * @author 05C4R
 */
public class Grupo {
    private ArrayList <Objeto> objeto;

    public Grupo() {
        objeto=new ArrayList();
    }
    
    /**
     * Metodo que permite agragar un objeto al grupo
     * @param a - tipo Objeto 
     */
    public void agregarObjeto(Objeto a){
     this.objeto.add(a);
     }
     
    /**
     * Método que regresa el objeto en la posicion del grupo
     * @param index - posicion del objeto
     * @return objeto tipo Objeto
     */
     public Objeto getObjeto(int index)
     {
     
     return objeto.get(index);
     }

     /**
     * Método que devuelve los objetos de un grupo
     * @return Arraylist de tipo Objeto
     */
    public ArrayList<Objeto> getObjetos() {
        return objeto;
    }

    public void setObjetos(ArrayList<Objeto> objeto) {
        this.objeto = objeto;
    }

}
