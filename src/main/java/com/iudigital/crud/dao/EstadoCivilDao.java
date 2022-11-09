package com.iudigital.crud.dao;

import com.iudigital.crud.dominio.*;
import static com.iudigital.crud.util.Conexion.getConnection;
import java.sql.*;
import java.util.*;

public class EstadoCivilDao {

    private static final String GET_ESTADO_CIVIL = "SELECT *FROM estados_civiles;";

    public List<EstadoCivil> obtenerEstadoCivil() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;//traemos el resultado de la conslta

        List<EstadoCivil> estadosCiviles = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(GET_ESTADO_CIVIL);
            rs = stmt.executeQuery();
            //con el ciclo while y el metodo next() iteramos para ver si tenemos registros
            while (rs.next()) {
                //posteriormente vamos recuperando cada varible
                EstadoCivil estadoCivil = new EstadoCivil();
                estadoCivil.setIdEstadoCivil(rs.getInt("id_estadocivil"));
                estadoCivil.setDescripcion(rs.getString("descripcion"));
                estadosCiviles.add(estadoCivil);
            }
            return estadosCiviles;
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
    }

}
