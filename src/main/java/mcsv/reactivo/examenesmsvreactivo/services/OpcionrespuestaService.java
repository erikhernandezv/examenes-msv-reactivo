package mcsv.reactivo.examenesmsvreactivo.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcsv.reactivo.examenesmsvreactivo.models.Examen;
import mcsv.reactivo.examenesmsvreactivo.models.Opcionrespuesta;
import mcsv.reactivo.examenesmsvreactivo.models.Pregunta;
import mcsv.reactivo.examenesmsvreactivo.repositories.OpcionrespuestaRepository;
import mcsv.reactivo.examenesmsvreactivo.repositories.PreguntaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class OpcionrespuestaService {

    private final OpcionrespuestaRepository opcionrespuestaRepository;

    public Mono<Opcionrespuesta> save(Opcionrespuesta opcionrespuesta){
        return opcionrespuestaRepository.save(opcionrespuesta);
    }

    public Mono<Opcionrespuesta> findById(Integer id){
        return opcionrespuestaRepository.findById(id)
                .onErrorResume(throwable -> {
                    log.error("Error al consultar la opcion de respuesta con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Opcion de respuesta con id= " + id + " no encontrada").getMostSpecificCause()));
    }

    public Flux<Opcionrespuesta> findAll(){
        return opcionrespuestaRepository.findAll()
                .onErrorResume(throwable -> {
                    log.error("Error al consultar todos la Opciones de respuesta", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ninguna Opcion de respuesta encontrada").getMostSpecificCause()));
    }

    public Mono<Void> deleteAll(){
        return opcionrespuestaRepository.deleteAll()
                .onErrorResume(throwable -> {
                    log.error("Error al borrar todas las opciones de respuesta", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Opcion de respuesta no borradas").getMostSpecificCause()));
    }

    public Mono<Opcionrespuesta> deleteById(Integer id){
        return opcionrespuestaRepository.findById(id)
                .flatMap(opcionrespuesta -> opcionrespuestaRepository.deleteById(opcionrespuesta.getId()).thenReturn(opcionrespuesta))
                .onErrorResume(throwable -> {
                    log.error("Error al borrar una opcion de respuesta con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Opcion de respuesta con id= " + id + " no borrada").getMostSpecificCause()));
    }

    public Flux<Opcionrespuesta> findOpcionrespuestaByPregunta(Pregunta pregunta){
        return opcionrespuestaRepository.findOpcionrespuestaByPregunta(pregunta)
                .onErrorResume(throwable -> {
                    log.error("Error al consultar una opcion de respuesta para la pregunta con nombre= " + pregunta.getNombre(), throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Opcion de respuesta asociada el examen con nombre= " + pregunta.getNombre() + " no encontrada").getMostSpecificCause()));
    }
}
