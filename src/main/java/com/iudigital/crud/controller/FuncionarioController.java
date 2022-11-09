package com.iudigital.crud.controller;

import com.iudigital.crud.dao.FuncionarioDao;
import com.iudigital.crud.dominio.Funcionario;
import java.sql.*;
import java.util.List;

public class FuncionarioController {

    private FuncionarioDao funcionarioDao;

    public FuncionarioController() {
        funcionarioDao = new FuncionarioDao();
    }

    public void crear(Funcionario funcionario) throws SQLException {
        funcionarioDao.crear(funcionario);
    }

    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        return funcionarioDao.obtenerFuncionario();
    }

    public Funcionario obtenerFuncionario(int id) throws SQLException {
        return funcionarioDao.obtenerFuncionario(id);
    }

    public void actualizarFuncionario(int id, Funcionario funcionario) throws SQLException {
        funcionarioDao.actualizarFuncionario(id, funcionario);
    }

    public void eliminarFuncionario(int id) throws SQLException {
        funcionarioDao.eliminarFuncionario(id);
    }

}
