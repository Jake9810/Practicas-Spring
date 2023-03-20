package com.jira.practica5v1.entities;

import lombok.*;

//@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductoEntity {
    private int id;
    private float cantidad;
    private String nombre;
    private double precio;


    public int getId() {
        return id;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
