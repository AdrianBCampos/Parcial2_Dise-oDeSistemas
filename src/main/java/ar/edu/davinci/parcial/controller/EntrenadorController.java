package ar.edu.davinci.parcial.controller;

import ar.edu.davinci.parcial.model.Entrenador;
import ar.edu.davinci.parcial.model.Pokemon;
import ar.edu.davinci.parcial.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @PostMapping
    public Entrenador crearEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorService.crearEntrenador(entrenador);
    }

    @GetMapping("/{id}")
    public Entrenador obtenerEntrenadorPorId(@PathVariable Long id) {
        return entrenadorService.obtenerEntrenadorPorId(id);
    }

    @PostMapping("/{entrenadorId}/capturar")
    public void capturarPokemon(@PathVariable Long entrenadorId, @RequestBody Pokemon pokemon) {
        entrenadorService.capturarPokemon(entrenadorId, pokemon);
    }

    @GetMapping("/{entrenadorId}/enfrentarse/{otroEntrenadorId}")
    public Entrenador enfrentarse(@PathVariable Long entrenadorId, @PathVariable Long otroEntrenadorId) {
        return entrenadorService.enfrentarse(entrenadorId, otroEntrenadorId);
    }

    @GetMapping("/buscar")
    public List<Entrenador> buscarEntrenadoresPorNombre(@RequestParam String nombre) {
        return entrenadorService.buscarEntrenadoresPorNombre(nombre);
    }
}