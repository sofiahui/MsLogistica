package com.donaton.mslogistica.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoTransporte;  // camion, furgon, moto
    private String origen;
    private String destino;
    private LocalDate fechaEnvio;
    private String estado;          // pendiente, en_camino, entregado
    private Long centroAcopioId;    // referencia al centro
}