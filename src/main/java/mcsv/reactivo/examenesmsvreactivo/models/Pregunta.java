package mcsv.reactivo.examenesmsvreactivo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pregunta")
public class Pregunta {

    @Id
    private Integer id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idexamen", nullable = false, updatable = false)
    private Examen examen;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questions")
    private List<Opcionrespuesta> opcionRespuesta;
}
