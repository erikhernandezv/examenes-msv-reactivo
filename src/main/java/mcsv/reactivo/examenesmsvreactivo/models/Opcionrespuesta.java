package mcsv.reactivo.examenesmsvreactivo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "opcionrespuesta")
public class Opcionrespuesta {

    @Id
    private Integer id;

    private String opcion;

    @ManyToOne
    @JoinColumn(name = "idpregunta", nullable = false, updatable = false)
    private Pregunta questions;
}
