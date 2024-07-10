package ar.edu.davinci.parcial.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String genero;
    private Integer edad;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pokemon> pokemons = new ArrayList<>();

    public void capturarPokemon(Pokemon pokemon) {
        if (this.pokemons.size() < 5) {
            this.pokemons.add(pokemon);
        } else {
            throw new IllegalStateException("Un entrenador no puede tener más de 5 pokemons.");
        }
    }

    public Entrenador enfrentarseA(Entrenador otroEntrenador) {
        // Aquí puedes implementar la lógica de enfrentamiento entre entrenadores.
        // Por simplicidad, retornaremos el entrenador con más pokemons vivos.
        return this.pokemons.size() > otroEntrenador.getPokemons().size() ? this : otroEntrenador;
    }
}
