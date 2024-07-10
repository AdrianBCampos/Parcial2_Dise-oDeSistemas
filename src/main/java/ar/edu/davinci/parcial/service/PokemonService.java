package ar.edu.davinci.parcial.service;



import ar.edu.davinci.parcial.model.Pokemon;
import ar.edu.davinci.parcial.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public Pokemon crearPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon obtenerPokemonPorId(Long id) {
        return pokemonRepository.findById(id).orElseThrow(() -> new RuntimeException("Pokemon no encontrado"));
    }

    public List<Pokemon> buscarPokemonsPorPoder(Float minPoder, Float maxPoder) {
        return pokemonRepository.findByPoderBetween(minPoder, maxPoder);
    }
}
