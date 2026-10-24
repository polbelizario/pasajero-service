
package pe.edu.cibertec.pasajeroservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import pe.edu.cibertec.pasajeroservice.dto.PasajeroRequest;
import pe.edu.cibertec.pasajeroservice.model.Pasajero;
import pe.edu.cibertec.pasajeroservice.service.PasajeroService;

import java.util.List;

@RestController
@RequestMapping("/api/pasajeros")
public class PasajeroController {

    private final PasajeroService service;

    public PasajeroController(PasajeroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pasajero> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Pasajero buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pasajero registrar(
            @Valid @RequestBody PasajeroRequest request) {

        Pasajero pasajero = convertir(request);
        return service.registrar(pasajero);
    }

    @PutMapping("/{id}")
    public Pasajero actualizar(
            @PathVariable Long id,
            @Valid @RequestBody PasajeroRequest request) {

        return service.actualizar(id, convertir(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    private Pasajero convertir(PasajeroRequest request) {
        Pasajero pasajero = new Pasajero();

        pasajero.setDni(request.dni());
        pasajero.setNombres(request.nombres());
        pasajero.setApellidos(request.apellidos());
        pasajero.setCorreo(request.correo());
        pasajero.setTelefono(request.telefono());

        return pasajero;
    }
}
