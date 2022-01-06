package com.example1.ejemplo;

import com.ejemplo1.combinacion.Combinacion;
import com.ejemplo1.creacion.Creacion;
import com.ejemplo1.filtrado.Filtrado;
import com.ejemplo1.matematico.Matematico;
import com.ejemplo1.model.Persona;
import com.ejemplo1.transformacion.Transformacion;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EjemploApplication implements CommandLineRunner {

	private static final Logger log =  LoggerFactory.getLogger(EjemploApplication.class);

	public void reactor(){
		Mono.just(new Persona(1,"juan",29)).
				subscribe(persona -> log.info("[REACTOR]: "+persona));
	}

	public void rxjava2(){
		Observable.just(new Persona(1,"oscar",25))
				.subscribe(persona -> log.info("[RXJAVA2: ]"+persona));
	}

	public void mono(){
		Mono.just(new Persona(2,"javier",30))
				.subscribe(persona -> log.info("Mono: ".concat(persona.toString())));
	}

	public void flux(){
		List<Persona> personasList = new ArrayList<>();
		personasList.add(new Persona(1,"juan",40));
		personasList.add(new Persona(2,"edith",40));
		personasList.add(new Persona(3,"oscar",28));

		Flux.fromIterable(personasList).subscribe(p->log.info("Flux: ".concat(p.toString())));
	}

	public void fluxMono(){
		List<Persona> personasList = new ArrayList<>();
		personasList.add(new Persona(1,"juan",40));
		personasList.add(new Persona(2,"edith",40));
		personasList.add(new Persona(3,"oscar",28));

		Flux<Persona> p = Flux.fromIterable(personasList);
		p.collectList().subscribe(personas -> log.info(personas.toString()));
	}

	public static void main(String[] args) {
		SpringApplication.run(EjemploApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//reactor();
		//rxjava2();
		//mono();
		//flux();
		//fluxMono();

		Matematico app = new Matematico();
		//Transformacion app2 = new Transformacion();


		//app.range();

		//app.repeat();

		//app2.groupBy();
		app.suma();

	}
}
