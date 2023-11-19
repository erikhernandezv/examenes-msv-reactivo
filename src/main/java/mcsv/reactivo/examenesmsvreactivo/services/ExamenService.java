package mcsv.reactivo.examenesmsvreactivo.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcsv.reactivo.examenesmsvreactivo.models.Examen;
import mcsv.reactivo.examenesmsvreactivo.repositories.ExamenRepository;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Slf4j
@Service
@AllArgsConstructor
public class ExamenService {

    private final ExamenRepository examenRepository;

    public Mono<Examen> save(Examen examen){
        return examenRepository.save(examen);
    }

    public Mono<Examen> findById(Integer id){
        return examenRepository.findById(id)
                .onErrorResume(throwable -> {
                    log.error("Error al consultar un examen con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Examen con id= " + id + " no encontrado").getMostSpecificCause()));
    }

    public Flux<Examen> findAll(){
        return examenRepository.findAll()
                .onErrorResume(throwable -> {
                    log.error("Error al consultar todos los examenes", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Ningun examen encontrado").getMostSpecificCause()));
    }

    public Mono<Void> deleteAll(){
        return examenRepository.deleteAll()
                .onErrorResume(throwable -> {
                    log.error("Error al borrar todos los examenes", throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Examenes no borrados").getMostSpecificCause()));
    }

    public Mono<Examen> deleteById(Integer id){
        return examenRepository.findById(id)
                .flatMap(examen -> examenRepository.deleteById(examen.getId()).thenReturn(examen))
                .onErrorResume(throwable -> {
                    log.error("Error al borrar un examen con id= " + id, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Examen con id= " + id + " no borrado").getMostSpecificCause()));
    }

    public Mono<Examen> findExamenByNombre(String nombre){
        return examenRepository.findExamenByNombreContainingIgnoreCase(nombre)
                .onErrorResume(throwable -> {
                    log.error("Error al consultar un examen con nombre= " + nombre, throwable);
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Examen con nombre= " + nombre + " no encontrado").getMostSpecificCause()));
    }
}
