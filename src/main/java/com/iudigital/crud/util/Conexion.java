package com.iudigital.crud.util;

import java.sql.*;

public class Conexion {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/tareaDesarrollo";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASWORD = "admin";

    //Creamos metodo para obtener la conexiono hacia la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASWORD);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smt) throws SQLException {
        smt.close();
    }

    public static void close(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
