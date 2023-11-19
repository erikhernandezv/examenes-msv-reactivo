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
@Table(name = "examen")
public class Examen {

    @Id
    private Integer id;

    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examen")
    private List<Pregunta> question;

    public Examen(int i, String testDeJava) {
    }
}
