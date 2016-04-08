/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dunn;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author PC
 */
public class algoritmo {
    //px son los atributos 
    //q son los objetos
    //
     /**
     * Método que devuelve el minimo de las combinaciones de px con q's
     * @param px Arraylist Double -- los atributos 6,5,......
     * @param q  Arraylist Tipo Objeto con los q's 
     * @return min double - el minimo
     */
    public double minPxQ(ArrayList<Double> px, ArrayList<Objeto> q) {
        double min;
            ArrayList<Double> pxq = new ArrayList<>();
                for (int i = 0; i < q.size(); i++) {
                    pxq.add(euclidiana(px, q.get(i).getAtributos()));//se agrega a un lista  
                }
           // min = minimo(pxq);//calcula el minimo de la lista pxq
        min=Collections.min(pxq);
                return min;
    }
    //devuelve el minimo de las combninaciones de p's con q's
    /**
     * Método que devuelve el minimo de las combinaciones de p's con q's
     * @param p Arraylist Tipo objeto -- objeto p´s
     * @param q  Arraylist Tipo Objeto con los q's 
     * @return min double - el minimo
     */
    public double minPQ(ArrayList<Objeto> p, ArrayList<Objeto> q) {
        double min;
            ArrayList<Double> aux = new ArrayList<>();   
                for(int i=0; i<p.size(); i++) {
                    aux.add(minPxQ(p.get(i).getAtributos(), q) );
                }
          min=Collections.min(aux);
        return min;
    }
     
    /**
     * Método que devuelve el minimo de las combinaciones de p's con los otros grupos, 
     * x asegura que no realicen con sigo mismo
     * @param Cx Arraylist Tipo objeto -- objeto p´s
     * @param Ck Arraylist Tipo grupo de q's, r's, ....
     * @param x int -- el numero de objeto
     * @return min double - el minimo
     */
     public double minCxCk(ArrayList<Objeto> Cx, ArrayList<Grupo> Ck, int x) {
        double min;
        ArrayList<Double> aux = new ArrayList<>();   
        for(int i=0; i<Ck.size(); i++) {
            if(i != x) {
                aux.add(minPQ(Cx, Ck.get(i).getObjetos()) );
            }
        }
        //min = minimo(aux);
        min=Collections.min(aux);
        return min;
    }
     
     /**
     * Método que devuelve el minimo de las combinaciones entre el grupo
     * bp,bq,br,..........
     * @param Ck Arraylist Tipo grupo de p'r,q's, r's, ....
     * @return min double - el minimo
     */
    public double minCkC(ArrayList<Grupo> Ck) {
        double min;
        ArrayList<Double> aux = new ArrayList<>();
        for (int i = 0; i < Ck.size(); i++) {
            aux.add(minCxCk(Ck.get(i).getObjetos(), Ck, i));
        }
        //min = minimo(aux);
        min=Collections.min(aux);
        return min;
    }
     /**
     * Método que devuelve el minimo de las combinaciones de P con su grupo
     * Delta P={(P1,P2),.....(P-j,Pn)} j=n-1 n=nuemro de objetos de la lista
     * @param Cx Arraylist Tipo objeto -- objeto p´s
     * @return min double - el minimo
     */
     public double maxCxCk(ArrayList<Objeto> Cx) {
        double max = 0;
        int salto=0;
        ArrayList<Double> aux = new ArrayList<>();   
        for(int i=0; i<Cx.size(); i++) {
           ++salto;// asegura que no re realice el mismo proceso 2 veces P1,P2 =P2,P1
            for(int j=0; j<Cx.size(); j++) {
                aux.add(euclidiana(Cx.get(i).getAtributos(), Cx.get(j).getAtributos() ) );
            }
        }
        max=Collections.max(aux);
        //max = maximo(aux);
        //System.out.println(max + "\n");
        return max;
    }
    
     /**
     * Método que devuelve el minimo de las combinaciones de los grupo
     * Maximo de Maximos 
     * @param Ck Arrylist Tipo grupo- contiene los grupos
     * @return min double - el minimo
     */
    public double maxCkC(ArrayList<Grupo> Ck){
        double max;
        ArrayList<Double> aux = new ArrayList<>();   
        for(int i=0; i<Ck.size(); i++) {
            aux.add(maxCxCk(Ck.get(i).getObjetos()) );
        }
        max=Collections.max(aux);
        //max = maximo(aux);
        return max;
    }
    /**
     * Metodo que calcula la distancia Ecuclidiana de 2 puntos
     * @param x Arrylist Tipo Double - los atributos de un objeto 
     * @param y Arrylist Tipo Double - los atributos de otro 
     * @return euc double , la distancia  
     */
    private double euclidiana(ArrayList<Double> x, ArrayList<Double> y) {
        double euc = 0;
        for (int i = 0; i < y.size(); i++) {
           euc+=( Math.pow(x.get(i) - y.get(i), 2));
        }     

        return Math.sqrt(euc);
    }
    /**
     * Metodo que devuelve el minimo valor de una lista 
     * @param al ArrayList Tipo Double con los valores
     * @return double el minimo
     */
    public double minimo(ArrayList<Double> al) {
        double min = al.get(0);// se pasa el valor de la primera posicion
        //System.out.println(al.size());
        for(int i=0; i<al.size(); i++) {
            if(al.get(i) < min) {
                min = al.get(i);
            }
        }
        
        return min;
    }
    
    /**
     * Metodo que devuelve el maximo valor de una lista 
     * @param al ArrayList Tipo Double con los valores
     * @return double el maximo valor
     */
    private double maximo(ArrayList<Double> al) {
        double max = al.get(0);
       
        for(int i=0; i<al.size(); i++) {
            if(al.get(i) > max) {
                max = al.get(i);
            }
        }
        
        return max;
    }
    /**
     * Metodo que calcula el indice de validacion Dunn
     * @param C Arraylist Grupo -require los grupos
     * @return double resultado del indice
     */
    public double dunnIndex(ArrayList<Grupo> C) {
        double resultado;
            resultado = (minCkC(C)/maxCkC(C));
        return resultado;
    }
}
