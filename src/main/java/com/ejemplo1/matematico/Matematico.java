package com.ejemplo1.matematico;

import com.ejemplo1.combinacion.Combinacion;
import com.ejemplo1.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Matematico {

    public static final Logger log = LoggerFactory.getLogger(Matematico.class);

    public void average(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"juan",25));
        personas.add(new Persona(2,"jose",23));
        personas.add(new Persona(3,"laura",15));

        Flux.fromIterable(personas)
                .collect(Collectors.averagingInt(Persona::getEdad))
                .subscribe(p->log.info(p.toString()));
    }

    public void count(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"juan",25));
        personas.add(new Persona(2,"jose",23));
        personas.add(new Persona(3,"laura",15));

        Flux.fromIterable(personas)
                .count()
                .subscribe(x->log.info("Cantidad: "+x));
    }

    public void suma(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"juan",25));
        personas.add(new Persona(2,"jose",23));
        personas.add(new Persona(3,"laura",15));

        Flux.fromIterable(personas)
                .collect(Collectors.summingInt(Persona::getEdad))
                .subscribe(x->log.info("la suma de las edades es: "+x));
    }
}
