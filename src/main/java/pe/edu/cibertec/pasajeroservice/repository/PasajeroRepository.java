
package pe.edu.cibertec.pasajeroservice.repository;

import pe.edu.cibertec.pasajeroservice.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {

    Optional<Pasajero> findByDni(String dni);

    boolean existsByDni(String dni);
}
