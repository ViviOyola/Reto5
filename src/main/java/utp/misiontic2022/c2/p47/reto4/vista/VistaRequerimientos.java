package utp.misiontic2022.c2.p47.reto4.vista;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utp.misiontic2022.c2.p47.reto4.controlador.ControladorRequerimientos;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.LiderVo;

public class VistaRequerimientos extends JFrame {
    
    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    static String resultadoRequerimientoBtn;
    BotoneraPnl bp = new BotoneraPnl();
    JScrollPane sp;
    JTextArea ta = new JTextArea();

    public VistaRequerimientos(){   
        
        setSize(800,600);
        
        sp = new JScrollPane(ta);
        sp.setBounds(100, 100, 600, 300);
        add(sp);

        bp.setBackground(Color.pink);
        add(bp);
        
    }

    class BotoneraPnl extends JPanel implements ActionListener {

        JButton btn1 = new JButton("Requerimiento 1");
        JButton btn2 = new JButton("Requerimiento 2");
        JButton btn3 = new JButton("Requerimiento 3");

        public BotoneraPnl(){

            btn1.addActionListener(this);
            btn2.addActionListener(this);
            btn3.addActionListener(this);
            
            add(btn1);
            add(btn2);
            add(btn3);
        }

        public void actionPerformed(ActionEvent e) {

            resultadoRequerimientoBtn = "";
            if("Requerimiento 1".equals(e.getActionCommand())) {
                VistaRequerimientos.requerimiento1();
                ta.setText(resultadoRequerimientoBtn);
            } else if("Requerimiento 2".equals(e.getActionCommand())) {
                VistaRequerimientos.requerimiento2();
                ta.setText(resultadoRequerimientoBtn);
            } else  if("Requerimiento 3".equals(e.getActionCommand())) {
                VistaRequerimientos.requerimiento3();
                ta.setText(resultadoRequerimientoBtn);
            }
        }
    }
 
    public static void requerimiento1(){
        try {

            System.out.println("Conocer el nombre, apellidos y salarios de los lideres cuyo segundo apellido sea 'Ortiz'");
            System.out.println("Nombre Primer_apellido Segundo_apellido Salario");
            ArrayList<LiderVo> lideres = controlador.consultarRequerimiento1();

            for (LiderVo lider : lideres) {
                resultadoRequerimientoBtn += lider.getNombreCompleto() + "\n";

                System.out.println(lider.getNombreCompleto());    
            }
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento2(){
        try {
            System.out.println("Transformar y obtener el nombre de los lideres donde la primera letra sea en minúscula y las demás en mayúscula");
            System.out.println("Nombre");
            ArrayList<LiderVo> lideres = controlador.consultarRequerimiento2();

            for (LiderVo lider : lideres) {
                resultadoRequerimientoBtn += lider.getNombre() + "\n";
                System.out.println(lider.getNombre());    
            }
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento3(){
        try {

            System.out.println("Saber la suma de los salarios de todos los lideres por su ciudad de residencia");
            System.out.println("Cargo Salario");
            ArrayList<LiderVo> lideres = controlador.consultarRequerimiento3();
            DecimalFormat formatter = new DecimalFormat("#.000000");
            
            for (LiderVo lider : lideres) {
                resultadoRequerimientoBtn += lider.getCargo() + " " + formatter.format(lider.getSalario()) + "\n";
                System.out.println(lider.getCargo() + " " + formatter.format(lider.getSalario()));      
            }
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
