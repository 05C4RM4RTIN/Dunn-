/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dunn;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;





/**
 *
 * @author 05C4R
 */
public class Preprocesado {

    /**
     * @param args the command line arguments
     */
    public void buscar_remplazar(ArrayList <String>array,String valorbuscado,int num_de_atributo,int numPorAtributo,String nuevovalor)
    {
            for (int i = num_de_atributo; i < array.size(); i+=numPorAtributo) {
             //System.out.println(array.get(i)+"ad"+valorbuscado);
                if(array.get(i).equals(valorbuscado)){                    
                    array.set(i,nuevovalor);
                    
                }
            }
        
    }
    public void eliminarPosicion(ArrayList<Objeto> al,int pos) {
       
        
        for(int i=0; i<al.size(); i++) {
           al.get(i).eliminarAtributo(pos);
        }
        
        
    }
    
     public int buscar(ArrayList<String> al,String valor) {
      int index = 0;
        
        for(int i=0; i<al.size(); i++) {
            if (al.get(i).equals(valor)) {
                index=i;
            }

        }
        return index;
        
        
    }
    /**
     * Metodo que permite conocer si un valor se puede convertir a double
     * @param val String el valor a convertir
     * @param text - opcional texto en caso de una exception
     * @return false
     */
    public boolean conviertirADouble(String val,String text){
    boolean parse = false;
        try{
        Double.parseDouble(val);
        parse=true;
                    }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null,val+ text);
                        parse=false;
                    }
    return parse;
    }
    
        
    
    // 
    /**
     * Metodo que permite conocer que datos concuerden con el tipo de atributo o variable que es
     * @param array ArrayList String datos a verificar
     * @param a i a es verdadero es numerico de lo contrario es categorico
     * @param num_de_atributo int  posicion del datos
     * @param numPorAtributo int numero de atributos 
     * @return false si hay errores
     */
    public boolean confirma(ArrayList <String>array,boolean a,int num_de_atributo,int numPorAtributo)
    {//System.out.println(numPorAtributo+"fsd"+num_de_atributo);
        boolean convertir=false; 
            for (int i = num_de_atributo; i < array.size(); i+=numPorAtributo) {
                
                if (a) {
                    convertir=conviertirADouble(array.get(i), " no es un variable numerica");                    
                } else {
                    convertir=conviertirADouble(array.get(i), " no existe en el rango");
                }
                
                if (!convertir) {
                    break;
                    
                }
            }
        return convertir;
        
    }
    /**
     *  Metodo que convierte una lista de String a una lista tipo Double 
     * @param dataset ArrayList tipo String, lista a convetir
     * @param numObjetos int numero de objetos para divir
     * @param numAtributos numero de objeto por atributo
     * @return ArrayList tipo Double
     */
    public  ArrayList <Objeto> genera(ArrayList <String>dataset,int numObjetos,int numAtributos)
    {int k = 0;
        ArrayList <Objeto>array = new ArrayList();
        for (int i = 0; i < numObjetos; i ++) {
            ///for (int j = num_de_atributo; j < array.size(); j+=numPorAtributo) {
            array.add(new Objeto());
            for (int j = 0; j < numAtributos; j ++ ) {
                //System.out.println(dataset.get(k));
                array.get(i).agregarAtributo(Double.parseDouble(dataset.get(k)));
                k++;
            }
            
        }
        return array;
        
    }
    /**
     * Metodo que permite imprimir los valores de una lista
     * @param array ArrayList Tipo String
     */
    public void imprime(ArrayList <String>array){
        for (String array1 : array) {
            System.out.println(array1);
        }
        
    }
    public void imprimed(ArrayList <Double>array){
        for (Double array1 : array) {
            System.out.print(array1);
        }
        
    }
     public boolean busca_indices(ArrayList<Objeto> objetos, int posicionatributo) {
        boolean val = true;
        algoritmo a = new algoritmo();
        
        double minimo;
        ArrayList<Double> array = new ArrayList();
        
        for (int i = 0; i < objetos.size(); i++) {
            array.add(objetos.get(i).getAtributo(posicionatributo));
        }
        
        minimo = a.minimo(array);
         Collections.sort(array);
       int k=(int) minimo;
         for (int i = 0; i < array.size(); i++) {
             
                 if ((k != array.get(i))) {
                    
                     val = false;
                     break;
                 }
             k++;
         }

        return val;

    }
     
     public ArrayList<String> rango_clusternum(ArrayList<Objeto> objetos, int posicionatributo) {
        boolean val = true;
        algoritmo a = new algoritmo();
        
        double minimo;
        TreeSet<Double> array = new TreeSet();
        Double inicio;
        ArrayList<String> array1 = new ArrayList();
        
        for (int i = 0; i < objetos.size(); i++) {
            array.add(objetos.get(i).getAtributo(posicionatributo));
        }
         
          inicio=array.first();
          
         for (int i = 0; i < array.size(); i++) {
             
             array1.add(""+inicio+"");
             inicio++;
         }

        return array1;

    }
     
     public ArrayList<Objeto> busca(ArrayList<Objeto> objetos,ArrayList <String>rango, int posicionatributo) {
        boolean val = true;
        algoritmo a = new algoritmo();
        
        double m;
         
        ArrayList<Objeto> array = objetos;
         for (int i = 0; i < rango.size(); i++) {
             m=i;
             for (int j = 0; j < objetos.size(); j++) {
                 if (objetos.get(j).getAtributo(posicionatributo)==Double.parseDouble(rango.get(i))) {
                     
                     objetos.get(j).getAtributos().set(posicionatributo,m);
                 }
             
         }
         }
         

        return array;

    }
    
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        String path = "C:/Users/05C4R/Documents/NetBeansProjects/Dunn/src/dunn/Lexer.flex";
        FileReader file=new FileReader("C:/Users/05C4R/Documents/NetBeansProjects/Dunn/src/dunn/ejemplo.arff");
        
        Sintactico asin=new Sintactico((new Lexer(file))) ;
         
 generarLexer(path);
      
          
    }
    
    
    /**
     * Sirve para generar una analizador lexico y sintactico
     * @param path la ubicacion del archivo a analizar
     */
    
public static void generarLexer(String path){
        File file=new File(path);
        jflex.Main.generate(file);
        String[] argv = new String[1] ;
        //argv[0]="-parser Sintactico -symbols Simbolo";
        argv[0]="C:/Users/05C4R/Documents/NetBeansProjects/Dunn/src/dunn/parse.cup";
        
        try {
            java_cup.Main.main(argv);
        } catch (IOException ex) {
            Logger.getLogger(Preprocesado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Preprocesado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
    
}
