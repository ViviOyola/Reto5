package utp.misiontic2022.c2.p47.reto4.controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import utp.misiontic2022.c2.p47.reto4.modelo.dao.LiderDao;
import utp.misiontic2022.c2.p47.reto4.modelo.vo.LiderVo;

public class ControladorRequerimientos {
    
    
    public ArrayList<LiderVo> consultarRequerimiento1() throws SQLException {
        LiderDao liderDao = new LiderDao();
        return liderDao.requerimiento1();

    }

    public ArrayList<LiderVo> consultarRequerimiento2() throws SQLException {
        LiderDao liderDao = new LiderDao();
        return liderDao.requerimiento2();
    }

    public ArrayList<LiderVo> consultarRequerimiento3() throws SQLException {
        LiderDao liderDao = new LiderDao();
        return liderDao.requerimiento3();
    }
}
