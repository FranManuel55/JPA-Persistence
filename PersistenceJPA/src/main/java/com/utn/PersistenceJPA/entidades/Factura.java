package com.utn.PersistenceJPA.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad {

    private int numero;
    private String fecha;
    private double descuento;
    private int total;
    private FormaDePago formaDePago;
    public enum FormaDePago {
        Efectivo,
        Tarjeta
    }
}
