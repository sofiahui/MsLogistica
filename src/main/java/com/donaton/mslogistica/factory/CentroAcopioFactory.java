package com.donaton.mslogistica.factory;


import org.springframework.stereotype.Component;
import com.donaton.mslogistica.model.CentroAcopio;

@Component
public class CentroAcopioFactory {
    public CentroAcopio crear(String nombre, String direccion, 
                              String region, int capacidadMaxima) {
        CentroAcopio c = new CentroAcopio();
        c.setNombre(nombre);
        c.setDireccion(direccion);
        c.setRegion(region);
        c.setCapacidadMaxima(capacidadMaxima);
        c.setCapacidadActual(0);
        c.setEstado("activo");
        return c;
    }
}
