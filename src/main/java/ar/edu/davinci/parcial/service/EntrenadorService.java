package ar.edu.davinci.parcial.service;


import ar.edu.davinci.parcial.model.Entrenador;
import ar.edu.davinci.parcial.model.Pokemon;
import ar.edu.davinci.parcial.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public Entrenador crearEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador obtenerEntrenadorPorId(Long id) {
        return entrenadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));
    }

    public void capturarPokemon(Long entrenadorId, Pokemon pokemon) {
        Entrenador entrenador = obtenerEntrenadorPorId(entrenadorId);
        entrenador.capturarPokemon(pokemon);
        entrenadorRepository.save(entrenador);
    }

    public Entrenador enfrentarse(Long entrenadorId, Long otroEntrenadorId) {
        Entrenador entrenador = obtenerEntrenadorPorId(entrenadorId);
        Entrenador otroEntrenador = obtenerEntrenadorPorId(otroEntrenadorId);
        return entrenador.enfrentarseA(otroEntrenador);
    }

    public List<Entrenador> buscarEntrenadoresPorNombre(String nombre) {
        return entrenadorRepository.findByNombreIgnoreCaseContaining(nombre);
    }
}