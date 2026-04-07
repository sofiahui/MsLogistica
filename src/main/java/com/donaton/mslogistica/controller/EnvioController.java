package com.donaton.mslogistica.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.donaton.mslogistica.model.Envio;
import com.donaton.mslogistica.service.EnvioService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/envios")
@RequiredArgsConstructor
public class EnvioController {

    private final EnvioService service;

    @GetMapping
    public List<Envio> listar() {
        return service.listar();
    }

    @PostMapping
    public Envio crear(@RequestBody Envio envio) {
        return service.crear(
            envio.getTipoTransporte(),
            envio.getOrigen(),
            envio.getDestino(),
            envio.getCentroAcopioId()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Envio> obtener(@PathVariable Long id) {
        return service.listar().stream()
            .filter(e -> e.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}