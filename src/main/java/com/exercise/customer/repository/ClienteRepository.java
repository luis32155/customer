package com.exercise.customer.repository;

import com.exercise.customer.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  ClienteRepository extends JpaRepository<Cliente,Long> {

    Optional<Cliente> findByClienteId(String clienteId);
}
