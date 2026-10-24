
package pe.edu.cibertec.pasajeroservice.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.pasajeroservice.model.Pasajero;
import pe.edu.cibertec.pasajeroservice.repository.PasajeroRepository;
import pe.edu.cibertec.pasajeroservice.service.PasajeroService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PasajeroServiceImpl implements PasajeroService {

    private final PasajeroRepository repository;

    public PasajeroServiceImpl(PasajeroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Pasajero> listar() {
        return repository.findAll();
    }

    @Override
    public Pasajero buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Pasajero no encontrado: " + id));
    }

    @Override
    public Pasajero registrar(Pasajero pasajero) {
        if (repository.existsByDni(pasajero.getDni())) {
            throw new IllegalArgumentException("El DNI ya está registrado");
        }
        return repository.save(pasajero);
    }

    @Override
    public Pasajero actualizar(Long id, Pasajero datos) {
        Pasajero pasajero = buscarPorId(id);

        if (!pasajero.getDni().equals(datos.getDni())
                && repository.existsByDni(datos.getDni())) {
            throw new IllegalArgumentException("El DNI ya está registrado");
        }

        pasajero.setDni(datos.getDni());
        pasajero.setNombres(datos.getNombres());
        pasajero.setApellidos(datos.getApellidos());
        pasajero.setCorreo(datos.getCorreo());
        pasajero.setTelefono(datos.getTelefono());

        return repository.save(pasajero);
    }

    @Override
    public void eliminar(Long id) {
        Pasajero pasajero = buscarPorId(id);
        repository.delete(pasajero);
    }
}
