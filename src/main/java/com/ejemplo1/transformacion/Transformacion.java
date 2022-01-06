package com.ejemplo1.transformacion;

import com.ejemplo1.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Transformacion {

    public static final Logger log = LoggerFactory.getLogger(Transformacion.class);

    public void groupBy(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"pedro",15));
        personas.add(new Persona(1,"juan",12));
        personas.add(new Persona(2,"andres",26));
        personas.add(new Persona(3,"maria",33));

        Flux.fromIterable(personas)
                .groupBy(Persona::getIdPersona)
                .flatMap(idFlux->idFlux.collectList())
                .subscribe(x->log.info(x.toString()));

    }
}
