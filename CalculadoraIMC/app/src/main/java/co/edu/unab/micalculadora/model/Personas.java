package co.edu.unab.micalculadora.model;

import java.io.Serializable;
import java.util.HashMap;

public class Personas implements Serializable { //Le da caracxteristicas para enviar datos de forma serial
    private String identificacion;
    private String nombre;
    private String apellido;
    private long telefono;

    public Personas() {
    }

    public Personas(String identificacion, String nombre, String apellido, long telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;

    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public HashMap<String, Object> getMapa() {
        HashMap<String, Object> mapaResultado = new HashMap<String, Object>();
        mapaResultado.put("identificacion", getIdentificacion());
        mapaResultado.put("nombre", getNombre());
        mapaResultado.put("apellido", getApellido());
        mapaResultado.put("telefono", getTelefono());
        return mapaResultado;
    }
}


