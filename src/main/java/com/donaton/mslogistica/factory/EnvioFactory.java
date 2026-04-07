package com.donaton.mslogistica.factory;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import com.donaton.mslogistica.model.Envio;
@Component
public class EnvioFactory {
    public Envio crear(String tipoTransporte, String origen, 
                       String destino, Long centroAcopioId) {
        Envio e = new Envio();
        e.setTipoTransporte(tipoTransporte);
        e.setOrigen(origen);
        e.setDestino(destino);
        e.setFechaEnvio(LocalDate.now());
        e.setEstado("pendiente");
        e.setCentroAcopioId(centroAcopioId);
        return e;
    }
}
