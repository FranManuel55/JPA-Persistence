package com.utn.PersistenceJPA.repocitorio;

import com.utn.PersistenceJPA.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepocitory extends JpaRepository <DetallePedido, Long> {
}
