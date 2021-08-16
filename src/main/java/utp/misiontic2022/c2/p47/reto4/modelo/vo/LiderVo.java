package utp.misiontic2022.c2.p47.reto4.modelo.vo;

import java.text.DecimalFormat;

public class LiderVo {

    private String Nombre;
    private String Primer_Apellido;
    private String Segundo_Apellido;
    private double Salario;
    private String Cargo;

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPrimer_Apellido() {
        return Primer_Apellido;
    }

    public void setPrimer_Apellido(String primer_Apellido) {
        Primer_Apellido = primer_Apellido;
    }

    public String getSegundo_Apellido() {
        return Segundo_Apellido;
    }

    public void setSegundo_Apellido(String segundo_Apellido) {
        Segundo_Apellido = segundo_Apellido;
    }

    public double getSalario() {
        
        return Salario;
    }

    public void setSalario(double salario) {
        
        Salario = salario;
    }

    public String getNombreCompleto(){
        return Nombre + " " + Primer_Apellido + " " + Segundo_Apellido + " " + String.valueOf(Salario);
    } 

    public String getCargo() {  
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }
}
