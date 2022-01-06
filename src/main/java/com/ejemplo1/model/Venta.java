package com.ejemplo1.model;

import java.time.LocalDate;

public class Venta {

    private Integer idVenta;
    private LocalDate fechaVenta;

    public Venta(Integer idVenta, LocalDate fechaVenta) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
