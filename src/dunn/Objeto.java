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
public class Objeto {//un objeto p
    private ArrayList <Double> atributos;// guarda sus atributos a,b,.....

    public Objeto() {
        this.atributos=new ArrayList();
    }
    /**
     * Metodo que permite agragar un atributo a un objeto
     * @param a - tipo double, el valor del atributo
     */
    public void agregarAtributo(double a){
     this.atributos.add(a);
     }
    /**
     * Método que elimina un atributo de un objeto
     * int index es posicion que queremos elimniar
     * @param index la posicion del atributo
     */
    public void eliminarAtributo(int index){
     this.atributos.remove(index);
     }
     /**
     * Método que regresa un atributo en la posicion del objeto 
     * @param index - posicion del objeto
     * @return double el atributo
     */
     public double getAtributo(int index)
     {
     
     return atributos.get(index);
     }
    
     /**
     * Método que devuelve los atributos de un objeto
     * @return Arraylist de tipo Double
     */
    public ArrayList<Double> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<Double> valores) {
        this.atributos = valores;
    }
    /**
     * Método que devuelve cuantos atributos tiene un objeto
     * @return int numero de atributos
     */
    public int getNumAtributos(){
    return atributos.size();
    }

    
    
    
}
