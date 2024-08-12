package com.exercise.customer.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Cliente extends Persona{

    private Long clienteId;
    private String contrasena;
    private boolean estado;

}
