/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dunn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;



/**
 *
 * @author 05C4R
 */
public class DunnHilo implements Runnable {
    public static boolean band=false;   
    private ArrayList <Grupo> grupos;
    private algoritmo al;
    private JTextField resultado;
    private DecimalFormat decimalFormat;
   // private JButton boton;
    public DunnHilo(ArrayList <Grupo> grupos,JTextField resultado) {
      this.grupos=grupos;
      this.resultado=resultado;
       decimalFormat = new DecimalFormat("0.000000");
       al=new algoritmo();
      // this.boton=boton;
    }

    

    
    
    @Override
    public void run() {
        band = false;
        
       resultado.setText(decimalFormat.format(al.dunnIndex(grupos)));
        band = true;
    }
}
