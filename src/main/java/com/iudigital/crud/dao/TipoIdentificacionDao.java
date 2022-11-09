package com.iudigital.crud.dao;

import com.iudigital.crud.dominio.TipoIdentificacion;
import static com.iudigital.crud.util.Conexion.getConnection;
import java.sql.*;
import java.util.*;

public class TipoIdentificacionDao {

    private static final String GET_TIPO_IDENTIFICACION = "SELECT id_tp_identificacion, tipo_identificacion FROM tipos_identificacion;";

    public List<TipoIdentificacion> obtenerTipoIdentificacion() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;//traemos el resultado de la conslta

        List<TipoIdentificacion> tiposIdentificaciones = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(GET_TIPO_IDENTIFICACION);
            rs = stmt.executeQuery();
            //con el ciclo while y el metodo next() itereamos para ver si tenemos registros
            while (rs.next()) {
                //posteriormente vamos recuperando cada varible
                TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();
                tipoIdentificacion.setId(rs.getInt("id_tp_identificacion"));
                tipoIdentificacion.setTipoIdentificacion(rs.getString("tipo_identificacion"));
                tiposIdentificaciones.add(tipoIdentificacion);
            }
            return tiposIdentificaciones;
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
