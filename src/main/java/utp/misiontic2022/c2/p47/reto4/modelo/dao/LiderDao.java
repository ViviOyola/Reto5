package utp.misiontic2022.c2.p47.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.vo.LiderVo;
import utp.misiontic2022.c2.p47.reto4.util.JDBCUtilities;

public class LiderDao {

    Connection conexion;

    public LiderDao(){
        try {
            conexion = JDBCUtilities.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<LiderVo> requerimiento1() throws SQLException {
        
        String sql = "SELECT Nombre, Primer_Apellido, Segundo_Apellido, Salario FROM Lider WHERE Segundo_Apellido = 'Ortiz'";
        Statement psmt = conexion.createStatement();
        ResultSet resultados = psmt.executeQuery(sql);
        
        ArrayList<LiderVo> listaResultado = new ArrayList<LiderVo>();

        while(resultados.next()){

            LiderVo lider = new LiderVo();
            
            lider.setNombre(resultados.getString(1));
            lider.setPrimer_Apellido(resultados.getString(2));
            lider.setSegundo_Apellido(resultados.getString(3));
            lider.setSalario(resultados.getDouble(4));

            listaResultado.add(lider);
        }

        return listaResultado;
    }

    public ArrayList<LiderVo> requerimiento2() throws SQLException {
        
        String sql = "SELECT Nombre FROM Lider";
        Statement psmt = conexion.createStatement();
        ResultSet resultados = psmt.executeQuery(sql);
        
        ArrayList<LiderVo> listaResultado = new ArrayList<LiderVo>();

        while(resultados.next()){

            LiderVo lider = new LiderVo();
            
            lider.setNombre(resultados.getString(1));

            String primeraLetra = lider.getNombre().substring(0,1);
            String demasLetras = lider.getNombre().substring(1);
            
            primeraLetra = primeraLetra.toLowerCase();
            demasLetras = demasLetras.toUpperCase();
            
            lider.setNombre(primeraLetra+demasLetras);
            
            listaResultado.add(lider);
        }

        return listaResultado;
    }

    public ArrayList<LiderVo> requerimiento3() throws SQLException {
        
        String sql = "SELECT cargo, avg(Salario) FROM Lider l GROUP BY l.Cargo HAVING avg(l.Salario)>500000 ORDER BY l.Cargo";
        Statement psmt = conexion.createStatement();
        ResultSet resultados = psmt.executeQuery(sql);
        
        ArrayList<LiderVo> listaResultado = new ArrayList<LiderVo>();

        while(resultados.next()){

            LiderVo lider = new LiderVo();
            
            lider.setCargo(resultados.getString(1));
            lider.setSalario(resultados.getDouble(2));

            listaResultado.add(lider);
        }

        return listaResultado;
    }
}