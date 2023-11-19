package mcsv.reactivo.examenesmsvreactivo.repositories;

import mcsv.reactivo.examenesmsvreactivo.models.Opcionrespuesta;
import mcsv.reactivo.examenesmsvreactivo.models.Pregunta;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface OpcionrespuestaRepository extends R2dbcRepository<Opcionrespuesta, Integer> {
    Flux<Opcionrespuesta> findOpcionrespuestaByPregunta(Pregunta pregunta);
}
