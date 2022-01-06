package com.ejemplo1.creacion;

import com.ejemplo1.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Creacion {

    private static final Logger log = LoggerFactory.getLogger(Creacion.class);

    public void range(){
        Flux.range(0,3).doOnNext(i -> log.info("i: "+i))
                .subscribe();
    }

    public void repeat(){
        Mono.just(new Persona(1,"juan",18))
                .repeat(3)
                .subscribe(x->log.info(x.toString()));
    }
}
