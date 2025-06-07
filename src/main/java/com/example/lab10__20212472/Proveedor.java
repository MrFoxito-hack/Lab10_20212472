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
    private Long id;    @Column(name = "razon_social", length = 100, nullable = false)
    @Size(max = 100)
    @NotBlank
    private String razonSocial;

    @Column(name = "nombre_comercial", length = 100, nullable = false)
    @Size(max = 100)
    @NotBlank
    private String nombreComercial;

    @Column(length = 11, unique = true, nullable = false)
    @Pattern(regexp = "\\d{11}")
    private String ruc;

    @Column(nullable = false)
    @Pattern(regexp = "\\d+")
    private String telefono;

    @Column(name = "correo_electronico", nullable = false)
    @Email
    private String correoElectronico;    @Column(name = "sitio_web")
    private String sitioWeb;

    @Column(name = "direccion_fisica", length = 150)
    @Size(max = 150)
    private String direccionFisica;

    @Column(nullable = false)
    @NotBlank
    private String pais;

    @Column(name = "representante_legal", nullable = false)
    @NotBlank
    private String representanteLegal;

    @Column(name = "dni_representante_legal", nullable = false)
    @Pattern(regexp = "\\d+")
    private String dniRepresentanteLegal;

    @Column(name = "tipo_proveedor", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoProveedor tipoProveedor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaProveedor categoria;

    @Column(name = "facturacion_anual")
    private Double facturacionAnualDolares;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;

    @Column(nullable = false)
    private Boolean estado;    public enum TipoProveedor {
        NACIONAL, INTERNACIONAL
    }

    public enum CategoriaProveedor {
        SERVICIOS, PRODUCTOS, TECNOLOGIA, OTROS
    }
}

