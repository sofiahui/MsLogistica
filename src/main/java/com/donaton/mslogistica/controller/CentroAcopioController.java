package com.donaton.mslogistica.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.donaton.mslogistica.model.CentroAcopio;
import com.donaton.mslogistica.service.CentroAcopioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/centros")
@RequiredArgsConstructor
public class CentroAcopioController {

    private final CentroAcopioService service;

    @GetMapping
    public List<CentroAcopio> listar() {
        return service.listar();
    }

    @PostMapping
    public CentroAcopio crear(@RequestBody CentroAcopio centro) {
        return service.crear(
            centro.getNombre(),
            centro.getDireccion(),
            centro.getRegion(),
            centro.getCapacidadMaxima()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CentroAcopio> obtener(@PathVariable Long id) {
        return service.listar().stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
