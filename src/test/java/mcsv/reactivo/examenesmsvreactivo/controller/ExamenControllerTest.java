package mcsv.reactivo.examenesmsvreactivo.controller;

import mcsv.reactivo.examenesmsvreactivo.models.Examen;
import mcsv.reactivo.examenesmsvreactivo.services.ExamenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamenControllerTest {
    @Mock
    private ExamenService examenService;

    @InjectMocks
    private ExamenController examenController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarProductosExitoso(){
        Examen ExamenEsperado = new Examen(1, "Test de Java");
        Examen ExamenEsperado2 = new Examen(3, "Test de PostgreSQL");

        Flux<Examen> productosEsperados = Flux.just(ExamenEsperado, ExamenEsperado2);
        when(examenService.findAll()).thenReturn(productosEsperados);

        Flux<Examen> resultado = examenController.queryAllExams();
        resultado.subscribe(); //Se debe hacer porque estamos con un flujo
        assertEquals(productosEsperados, resultado);
    }

    @Test
    void testConsultarProductosExitosoStep(){
        Examen productoEsperado = new Examen(1, "Donas");
        Examen productoEsperado2 = new Examen(2, "Cafe con leche");
        Flux<Examen> productosEsperados = Flux.just(productoEsperado, productoEsperado2);
        when(examenService.findAll()).thenReturn(productosEsperados);

        StepVerifier.create(examenController.queryAllExams())
                .expectNext(productoEsperado)
                .expectNext(productoEsperado2)
                .expectComplete()
                .verify();

    }
}
