package com.iudigital.crud.dao;

import com.iudigital.crud.dominio.Funcionario;
import com.iudigital.crud.util.Conexion;
import static com.iudigital.crud.util.Conexion.close;
import static com.iudigital.crud.util.Conexion.getConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

    private static final String GET_FUNCIONARIO = "select id_funcionarios, nombre, apellido, sexo, direccion, telefono, fecha_nacimiento,"
            + " tipos_identificacion.tipo_identificacion, estados_civiles.descripcion_estado "
            + "from funcionarios "
            + "join tipos_identificacion on funcionarios.cod_tipoidentificacion = tipos_identificacion.id_tp_identificacion "
            + "join estados_civiles  on	funcionarios.cod_estadocivil = estados_civiles.id_estadocivil;";
    private static final String CREATE_FUNCIONARIO = "INSERT INTO funcionarios (nombre, apellido, sexo, direccion, telefono, fecha_nacimiento, cod_tipoidentificacion, cod_estadocivil)"
            + "VALUES(?,?,?,?,?,?,?,?);";
    private static final String GET_FUNCIONARIO_BY_ID = "SELECT * FROM funcionarios WHERE id_funcionarios = ?";
    private static final String UPDATE_FUNCIONARIO = "UPDATE funcionarios SET nombre = ?, apellido = ?,"
            + "sexo = ?, cod_tipoidentificacion = ?, cod_estadocivil =?,  direccion =?, telefono = ?, fecha_nacimiento = ? WHERE id_funcionarios = ?;";
    private static final String DELETE_FUNCIONARIO = "DELETE  FROM  funcionarios WHERE id_funcionarios = ?";

    public List<Funcionario> obtenerFuncionario() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;//traemos el resultado de la conslta

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(GET_FUNCIONARIO);
            rs = stmt.executeQuery();
            //con el ciclo while y el metodo next() itereamos para ver si tenemos registros
            while (rs.next()) {
                //posteriormente vamos recuperando cada varible
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("id_funcionarios"));
                funcionario.setNombre(rs.getString("nombre"));
                funcionario.setApellido(rs.getString("apellido"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setIdentificacion(rs.getString("tipo_identificacion"));
                funcionario.setEstadoCivil(rs.getString("descripcion_estado"));
                funcionario.setDireccion(rs.getString("direccion"));
                funcionario.setTelefono(rs.getString("telefono"));
                funcionario.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                funcionarios.add(funcionario);
            }
            return funcionarios;
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

    public void crear(Funcionario funcionario) throws SQLException {
        Connection conn = null;//Instancia para la conexion
        PreparedStatement stmt = null;//preparemos la consulta
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(CREATE_FUNCIONARIO);
            stmt.setString(1, funcionario.getNombre());
            stmt.setString(2, funcionario.getApellido());
            stmt.setString(3, funcionario.getSexo());
            stmt.setString(4, funcionario.getDireccion());
            stmt.setString(5, funcionario.getTelefono());
            stmt.setString(6, funcionario.getFechaNacimiento());
            stmt.setInt(7, funcionario.getIdentificacionId());
            stmt.setInt(8, funcionario.getEstadoCivilId());
            //con executeupdate decimos que se está modificando el estado de la bd
            stmt.executeUpdate();

        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public Funcionario obtenerFuncionario(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funcionario funcionario = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(GET_FUNCIONARIO_BY_ID);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("id_funcionarios"));
                funcionario.setNombre(rs.getString("nombre"));
                funcionario.setApellido(rs.getString("apellido"));
                funcionario.setSexo(rs.getString("sexo"));
                funcionario.setDireccion(rs.getString("direccion"));
                funcionario.setTelefono(rs.getString("telefono"));
                funcionario.setFechaNacimiento(rs.getString("fecha_nacimiento"));

            }
            return funcionario;
        } finally {
            close(rs);
            close(stmt);
            close(conn);
        }
    }

    public void actualizarFuncionario(int id, Funcionario funcionario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE_FUNCIONARIO);
            stmt.setString(1, funcionario.getNombre());
            stmt.setString(2, funcionario.getApellido());
            stmt.setString(3, funcionario.getSexo());
            stmt.setInt(4, funcionario.getIdentificacionId());
            stmt.setInt(5, funcionario.getEstadoCivilId());
            stmt.setString(6, funcionario.getDireccion());
            stmt.setString(7, funcionario.getTelefono());
            stmt.setString(8, funcionario.getFechaNacimiento());
            stmt.setInt(9, id);
            stmt.executeUpdate();

        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }

    }

    public void eliminarFuncionario(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE_FUNCIONARIO);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
