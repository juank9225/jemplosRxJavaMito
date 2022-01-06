package com.ejemplo1.filtrado;

import com.ejemplo1.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtrado {

    public static final Logger log = LoggerFactory.getLogger(Filtrado.class);

    public void distinct(){
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"JUAN",25));
        personas.add(new Persona(1,"JUAN",25));
        personas.add(new Persona(2,"PEDRO",24));

        Flux.fromIterable(personas).distinct().subscribe(p->log.info(p.toString()));
    }
}
