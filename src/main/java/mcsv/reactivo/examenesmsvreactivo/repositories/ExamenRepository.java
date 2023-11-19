package mcsv.reactivo.examenesmsvreactivo.repositories;

import mcsv.reactivo.examenesmsvreactivo.models.Examen;
import mcsv.reactivo.examenesmsvreactivo.models.Opcionrespuesta;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ExamenRepository extends R2dbcRepository<Examen, Integer> {
    Mono<Examen> findExamenByNombreContainingIgnoreCase(String nombre);
}
