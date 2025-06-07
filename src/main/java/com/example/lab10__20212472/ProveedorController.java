package com.example.lab10__20212472;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController


@RequestMapping("/proveedores")

public class ProveedorController {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping
    public List<ProveedorListadoDTO> listarProveedores() {

        return proveedorRepository.findAll().stream()
                .map(ProveedorListadoDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")

    public ResponseEntity<?> obtenerProveedor(@PathVariable Long id) {
        Optional<Proveedor> proveedorOpt = proveedorRepository.findById(id);
        if (proveedorOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado");
        }
        return ResponseEntity.ok(new ProveedorDetalleDTO(proveedorOpt.get()));
    }

    @PostMapping

    public ResponseEntity<?> registrarProveedor(@Valid @RequestBody ProveedorRegistroDTO dto) {
        if (proveedorRepository.existsByRuc(dto.getRuc())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El RUC ya está registrado");
        }

        Proveedor proveedor = dto.toEntity();
        proveedor.setEstado(true);
        proveedor.setFechaRegistro(LocalDateTime.now());
        proveedor.setUltimaActualizacion(null);
        proveedorRepository.save(proveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Proveedor registrado correctamente");
    }

    @PutMapping("/{id}")

    public ResponseEntity<?> editarProveedor(@PathVariable Long id, @Valid @RequestBody ProveedorEdicionDTO dto) {
        Optional<Proveedor> proveedorOpt = proveedorRepository.findById(id);
        if (proveedorOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado");
        }
        Proveedor proveedor = proveedorOpt.get();
        dto.actualizarEntidad(proveedor);
        proveedor.setUltimaActualizacion(LocalDateTime.now());
        proveedorRepository.save(proveedor);
        return ResponseEntity.ok("Proveedor actualizado correctamente");
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<?> eliminarProveedor(@PathVariable Long id) {
        Optional<Proveedor> proveedorOpt = proveedorRepository.findById(id);
        if (proveedorOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado");
        }

        Proveedor proveedor = proveedorOpt.get();
        proveedor.setEstado(false);
        proveedor.setUltimaActualizacion(LocalDateTime.now());
        proveedorRepository.save(proveedor);
        return ResponseEntity.ok("Proveedor eliminado correctamente");
    }
}
