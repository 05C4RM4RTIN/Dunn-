/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dunn;

/**
 *
 * @author 05C4R
 */
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class CargandoThread implements Runnable{

    private JProgressBar jProgressBar;
    private int i = 1;
    private int value = 50;//retardo en 

    /**
 * Constructor de clase
 */
    public CargandoThread( JProgressBar jProgressBar)
    {
        this.jProgressBar = jProgressBar;
    }

    @Override
    public void run() {
        i=1;        
         jProgressBar.setVisible(true);
        //mientra el trabajo en paralelo no finalice el jProgressBar continuara su animacion una y otra vez
        while( !DunnHilo.band)
        {
            //si llega al limite 100 comienza otra vez desde 1, sino incrementa i en +1
            i = (i > 100) ? 1 : i+1;
            jProgressBar.setValue(i);
            jProgressBar.repaint(); 
            //retardo en milisegundos
            try{Thread.sleep( this.value );}            
            catch (InterruptedException e){ System.err.println( e.getMessage() ); }            
            //si el trabajo en paralelo a terminado
            if( DunnHilo.band )
            {
                jProgressBar.setValue(100);
                jProgressBar.setVisible(false);
                break;//rompe ciclo 
            }            
        }
    }

}
