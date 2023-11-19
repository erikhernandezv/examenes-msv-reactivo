package mcsv.reactivo.examenesmsvreactivo.repositories;

import mcsv.reactivo.examenesmsvreactivo.models.Examen;
import mcsv.reactivo.examenesmsvreactivo.models.Pregunta;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PreguntaRepository extends R2dbcRepository<Pregunta, Integer> {
    Flux<Pregunta> findPreguntaByExamen(Examen examen);
}
