
package pe.edu.cibertec.pasajeroservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PasajeroRequest(

        @NotBlank(message = "El DNI es obligatorio")
        @Pattern(
                regexp = "\\d{8}",
                message = "El DNI debe tener 8 dígitos"
        )
        String dni,

        @NotBlank(message = "Los nombres son obligatorios")
        @Size(max = 100)
        String nombres,

        @NotBlank(message = "Los apellidos son obligatorios")
        @Size(max = 100)
        String apellidos,

        @Email(message = "El correo no es válido")
        String correo,

        @Pattern(
                regexp = "^$|\\d{9}",
                message = "El teléfono debe tener 9 dígitos"
        )
        String telefono
) {
}
