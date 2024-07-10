package ar.edu.davinci.parcial.repository;

import ar.edu.davinci.parcial.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findByPoderBetween(Float minPoder, Float maxPoder);
}