package com.iudigital.crud.dominio;

public class TipoIdentificacion {

    private int id;
    private String tipoIdentificacion;

    public TipoIdentificacion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }


    @Override
    public String toString() {
        return tipoIdentificacion;
    }

}
