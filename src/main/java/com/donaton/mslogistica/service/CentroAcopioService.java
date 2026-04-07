package com.donaton.mslogistica.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.donaton.mslogistica.model.CentroAcopio;
import com.donaton.mslogistica.respository.CentroAcopioRepository;
import com.donaton.mslogistica.factory.CentroAcopioFactory;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CentroAcopioService {

    private final CentroAcopioRepository repository;
    private final CentroAcopioFactory factory;

    public List<CentroAcopio> listar() {
        return repository.findAll();
    }

    public CentroAcopio crear(String nombre, String direccion,
                               String region, int capacidadMaxima) {
        CentroAcopio c = factory.crear(nombre, direccion, region, capacidadMaxima);
        return repository.save(c);
    }

    @CircuitBreaker(name = "centroAcopioService", fallbackMethod = "fallbackListar")
    public List<CentroAcopio> listarConCircuitBreaker() {
        return repository.findAll();
    }

    public List<CentroAcopio> fallbackListar(Exception e) {
        return new ArrayList<>();
    }
}