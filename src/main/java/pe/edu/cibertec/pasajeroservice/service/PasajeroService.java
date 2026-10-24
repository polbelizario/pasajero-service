
package pe.edu.cibertec.pasajeroservice.service;

import pe.edu.cibertec.pasajeroservice.model.Pasajero;
import java.util.List;

public interface PasajeroService {

    List<Pasajero> listar();

    Pasajero buscarPorId(Long id);

    Pasajero registrar(Pasajero pasajero);

    Pasajero actualizar(Long id, Pasajero pasajero);

    void eliminar(Long id);
}
