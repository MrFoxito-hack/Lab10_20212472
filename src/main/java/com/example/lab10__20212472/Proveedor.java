package com.example.lab10__20212472;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


//usamos loombok para mejor limpieza de codigo
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @Size(max = 100)
    @NotBlank
    private String razonSocial;

    @Column(length = 100, nullable = false)
    @Size(max = 100)
    @NotBlank
    private String nombreComercial;

    @Column(length = 11, unique = true, nullable = false)
    @Pattern(regexp = "\\d{11}")
    private String ruc;

    @Column(nullable = false)
    @Pattern(regexp = "\\d+")
    private String telefono;

    @Column(nullable = false)
    @Email
    private String correoElectronico;

    @Column
    private String sitioWeb;

    @Column(length = 150)
    @Size(max = 150)
    private String direccionFisica;

    @Column(nullable = false)
    @NotBlank
    private String pais;

    @Column(nullable = false)
    @NotBlank
    private String representanteLegal;

    @Column(nullable = false)
    @Pattern(regexp = "\\d+")
    private String dniRepresentanteLegal;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoProveedor tipoProveedor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaProveedor categoria;

    @Column
    private Double facturacionAnualDolares;

    @Column(nullable = false)
    private LocalDateTime fechaRegistro;

    @Column
    private LocalDateTime ultimaActualizacion;

    @Column(nullable = false)
    private Boolean estado;

    public enum TipoProveedor {
        Nacional, Internacional
    }

    public enum CategoriaProveedor {
        Servicios, Productos, Tecnologia, Otros
    }
}

