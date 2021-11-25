package co.edu.unab.micalculadora.model;

import java.io.Serializable;

public class RegistroIMC implements Serializable {
    long altura;
    long peso;
    String fecha;
    String imc;

    public RegistroIMC() {
    }

    public RegistroIMC(long altura, long peso, String fecha, String imc) {
        this.altura = altura;
        this.peso = peso;
        this.fecha = fecha; //Temporal para pruebas
        this.imc = imc;      //Temporal para pruebas
    }

    public long getAltura() {
        return altura;
    }

    public void setAltura(long altura) {
        this.altura = altura;
    }

    public long getPeso() {
        return peso;
    }

    public void setPeso(long peso) {
        this.peso = peso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
        this.imc = imc;
    }
}
