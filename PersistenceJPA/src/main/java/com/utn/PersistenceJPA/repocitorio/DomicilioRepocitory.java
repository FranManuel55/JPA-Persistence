package com.utn.PersistenceJPA.repocitorio;

import com.utn.PersistenceJPA.entidades.Cliente;
import com.utn.PersistenceJPA.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepocitory extends JpaRepository<Domicilio, Long> {
}
