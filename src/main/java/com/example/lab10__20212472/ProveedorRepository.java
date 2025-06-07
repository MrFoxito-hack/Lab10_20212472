package com.example.lab10__20212472;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    boolean existsByRuc(String ruc);

}
