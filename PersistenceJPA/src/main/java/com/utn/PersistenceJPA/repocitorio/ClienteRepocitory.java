package com.utn.PersistenceJPA.repocitorio;

import com.utn.PersistenceJPA.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepocitory extends JpaRepository <Cliente, Long> {

}
