package ar.edu.davinci.parcial.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private String especie;
    private Float vida;
    private Float poder;

    public void atacar(Pokemon otroPokemon) {
        otroPokemon.restarVida(this.poder);
    }

    public void restarVida(Float cant) {
        this.vida -= cant;
    }

    public void aumentarVida(Float vida) {
        this.vida += vida;
    }
}

enum Tipo {
    ELECTRICO, AGUA, FUEGO, VEGETAL, PIEDRA
}