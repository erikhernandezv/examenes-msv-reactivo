package mcsv.reactivo.examenesmsvreactivo.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcsv.reactivo.examenesmsvreactivo.models.Examen;
import mcsv.reactivo.examenesmsvreactivo.models.Pregunta;
import mcsv.reactivo.examenesmsvreactivo.repositories.ExamenRepository;
import mcsv.reactivo.examenesmsvreactivo.repositories.PreguntaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class PreguntaService {

    private final PreguntaRepository preguntaRepository;

    public Mono<Pregunta> save(Pregunta pregunta){
        return preguntaRepository.save(pregunta);
    }

    public Mono<Pregunta> findById(Integer id){
        return preguntaRepository.findById(id)
                .onErrorResume(throwable -> {
                    log.error("Error al consultar la pregunta con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pregunta con id= " + id + " no encontrada").getMostSpecificCause()));
    }

    public Flux<Pregunta> findAll(){
        return preguntaRepository.findAll()
                .onErrorResume(throwable -> {
                    log.error("Error al consultar todos la preguntas", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ninguna pregunta encontrada").getMostSpecificCause()));
    }

    public Mono<Void> deleteAll(){
        return preguntaRepository.deleteAll()
                .onErrorResume(throwable -> {
                    log.error("Error al borrar todas las preguntas", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Preguntas no borradas").getMostSpecificCause()));
    }

    public Mono<Pregunta> deleteById(Integer id){
        return preguntaRepository.findById(id)
                .flatMap(pregunta -> preguntaRepository.deleteById(pregunta.getId()).thenReturn(pregunta))
                .onErrorResume(throwable -> {
                    log.error("Error al borrar una pregunta con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pregunta con id= " + id + " no borrada").getMostSpecificCause()));
    }

    public Flux<Pregunta> findPreguntaByExamen(Examen examen){
        return preguntaRepository.findPreguntaByExamen(examen)
                .onErrorResume(throwable -> {
                    log.error("Error al consultar una pregunta para el examen con nombre= " + examen.getNombre(), throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Pregunta asociada el examen con nombre= " + examen.getNombre() + " no encontrada").getMostSpecificCause()));
    }
}
