package com.donaton.mslogistica.service;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.donaton.mslogistica.model.Envio;
import com.donaton.mslogistica.respository.EnvioRepository;
import com.donaton.mslogistica.factory.EnvioFactory;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnvioService {

    private final EnvioRepository repository;
    private final EnvioFactory factory;

    public List<Envio> listar() {
        return repository.findAll();
    }

    public Envio crear(String tipoTransporte, String origen,
                       String destino, Long centroAcopioId) {
        Envio e = factory.crear(tipoTransporte, origen, destino, centroAcopioId);
        return repository.save(e);
    }

    @CircuitBreaker(name = "envioService", fallbackMethod = "fallbackListar")
    public List<Envio> listarConCircuitBreaker() {
        return repository.findAll();
    }

    public List<Envio> fallbackListar(Exception e) {
        return new ArrayList<>();
    }
}