package com.iudigital.crud.dominio;

public class Funcionario {

    private int idFuncionario;
    private String nombre;
    private String apellido;
    private String sexo;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;
    private int IdentificacionId; 
    private String identificacion;//atributo tipo de identificacion
    private int estadoCivilId;
    private String estadoCivil; 

    public Funcionario() {

    }

    public Funcionario(int idFuncionario, String nombre, String apellido, String sexo, int IdentificacionId, String identificacion, int estadoCivilId, String estadoCivil, String direccion, String telefono, String fechaNacimiento) {
        this.idFuncionario = idFuncionario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.IdentificacionId = IdentificacionId;
        this.identificacion = identificacion;
        this.estadoCivilId = estadoCivilId;
        this.estadoCivil = estadoCivil;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdentificacionId() {
        return IdentificacionId;
    }

    public void setIdentificacionId(int IdentificacionId) {
        this.IdentificacionId = IdentificacionId;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getEstadoCivilId() {
        return estadoCivilId;
    }

    public void setEstadoCivilId(int estadoCivilId) {
        this.estadoCivilId = estadoCivilId;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
