package ar.edu.davinci.parcial.controller;


import ar.edu.davinci.parcial.model.Pokemon;
import ar.edu.davinci.parcial.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemones")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping
    public Pokemon crearPokemon(@RequestBody Pokemon pokemon) {
        return pokemonService.crearPokemon(pokemon);
    }

    @GetMapping("/{id}")
    public Pokemon obtenerPokemonPorId(@PathVariable Long id) {
        return pokemonService.obtenerPokemonPorId(id);
    }

    @GetMapping("/buscar")
    public List<Pokemon> buscarPokemonsPorPoder(@RequestParam Float minPoder, @RequestParam Float maxPoder) {
        return pokemonService.buscarPokemonsPorPoder(minPoder, maxPoder);
    }
}
