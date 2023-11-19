package mcsv.reactivo.examenesmsvreactivo.controller;

import lombok.AllArgsConstructor;
import mcsv.reactivo.examenesmsvreactivo.models.Examen;
import mcsv.reactivo.examenesmsvreactivo.services.ExamenService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/examenes")
@AllArgsConstructor
public class ExamenController {
    private ExamenService examenService;

    @PostMapping("/")
    public Mono<Examen> createExam(@RequestBody Examen producto){
        return examenService.save(producto);
    }

    @GetMapping("/")
    public Flux<Examen> queryAllExams(){
        return examenService.findAll();
    }
}
