package org.example.gestormagia.model.entidades;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class EventoMagico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String lugar;

    @Column(nullable = false)
    private String hechizo;

    @Column(nullable = false)
    private String mago;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private boolean grave;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHechizo() {
        return hechizo;
    }

    public void setHechizo(String hechizo) {
        this.hechizo = hechizo;
    }

    public String getMago() {
        return mago;
    }

    public void setMago(String mago) {
        this.mago = mago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isGrave() {
        return grave;
    }

    public void setGrave(boolean grave) {
        this.grave = grave;
    }

}
