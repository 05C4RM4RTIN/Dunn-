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
public class Elementos {
    private ArrayList <String> valores;// guarda el rango {a,b,...}
    private String nombre;

    public Elementos() {
        valores=new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
     public void agregarValor(String a){
     this.valores.add(a);
     }
     
     public String getValor(int index)
     {
     
     return valores.get(index);
     }

    public ArrayList<String> getValores() {
        return valores;
    }

    public void setValores(ArrayList<String> valores) {
        this.valores = valores;
    }
     
     public boolean buscar(String val,int valor){
         boolean igual=false;
         for (int i = 0; i < valores.size(); i++) {    
             if (valores.get(i).equalsIgnoreCase(val)) {
                 igual =true;
                 break;
             }
            
         }
        return igual;
     
     }
    
    

    
}
