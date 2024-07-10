package ar.edu.davinci.parcial.repository;

import ar.edu.davinci.parcial.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
    List<Entrenador> findByNombreIgnoreCaseContaining(String nombre);
}
