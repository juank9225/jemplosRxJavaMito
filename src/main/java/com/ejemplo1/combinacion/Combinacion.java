package com.ejemplo1.combinacion;

import com.ejemplo1.model.Persona;
import com.ejemplo1.model.Venta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Combinacion {

    public static final Logger log = LoggerFactory.getLogger(Combinacion.class);

    public void merge(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"juan",25));
        personas.add(new Persona(2,"jose",23));
        personas.add(new Persona(3,"laura",15));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(001, LocalDate.now()));
        ventas.add(new Venta(002,LocalDate.now()));
        ventas.add(new Venta(003,LocalDate.now()));

        Flux<Persona> flujo1 = Flux.fromIterable(personas);
        Flux<Venta> flujo2 = Flux.fromIterable(ventas);

        Flux.merge(flujo1,flujo2)
                .subscribe(p->log.info(p.toString()));
    }

    public void zip(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"juan",25));
        personas.add(new Persona(2,"jose",23));
        personas.add(new Persona(3,"laura",15));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(001, LocalDate.now()));
        ventas.add(new Venta(002,LocalDate.now()));
        ventas.add(new Venta(003,LocalDate.now()));

        Flux<Persona> flujo1 = Flux.fromIterable(personas);
        Flux<Venta> flujo2 = Flux.fromIterable(ventas);

        Flux.zip(flujo1,flujo2,(p1,p2)->String.format("FLUX1: %s, FLUX2: %s ",p1,p2))
                .subscribe(x->log.info(x));
    }
}
