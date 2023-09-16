package com.utn.PersistenceJPA.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido extends BaseEntidad {
    private String fecha;
    private double total;
    private Estado estado;
    public enum Estado{
        Iniciado,
        Preparacion,
        Entregado
    }
    private TipoEnvio tipoEnvio;
    public enum TipoEnvio{
        Retiro,
        Delivery
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();
    public void agregardetallePedidos(DetallePedido detped) {
        detallePedidos.add(detped);
    }

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    private Factura factura;

}