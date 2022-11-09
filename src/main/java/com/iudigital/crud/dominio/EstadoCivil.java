
package com.iudigital.crud.dominio;

public class EstadoCivil {
    private int id;
    private String descripcion;
    
    public EstadoCivil(){
        
    }

    public int getIdEstadoCivil() {
        return id;
    }

    public void setIdEstadoCivil(int IdEstadoCivil) {
        this.id = IdEstadoCivil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return  descripcion;
    }
    
}
