package com.example.lab10__20212472;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class ProveedorRegistroDTO {

    @NotBlank
    @Size(max = 100)
    private String razonSocial;
    @NotBlank
    @Size(max = 100)
    private String nombreComercial;
    @Pattern(regexp = "\\d{11}")
    private String ruc;
    @Pattern(regexp = "\\d+")
    private String telefono;
    @Email
    private String correoElectronico;
    private String sitioWeb;
    @Size(max = 150)
    private String direccionFisica;
    @NotBlank
    private String pais;
    @NotBlank
    private String representanteLegal;
    @Pattern(regexp = "\\d+")
    private String dniRepresentanteLegal;
    @NotNull
    private Proveedor.TipoProveedor tipoProveedor;
    @NotNull
    private Proveedor.CategoriaProveedor categoria;
    private Double facturacionAnualDolares;

    public Proveedor toEntity() {
        Proveedor p = new Proveedor();
        p.setRazonSocial(razonSocial);
        p.setNombreComercial(nombreComercial);
        p.setRuc(ruc);
        p.setTelefono(telefono);
        p.setCorreoElectronico(correoElectronico);
        p.setSitioWeb(sitioWeb);
        p.setDireccionFisica(direccionFisica);
        p.setPais(pais);
        p.setRepresentanteLegal(representanteLegal);
        p.setDniRepresentanteLegal(dniRepresentanteLegal);
        p.setTipoProveedor(tipoProveedor);
        p.setCategoria(categoria);
        p.setFacturacionAnualDolares(facturacionAnualDolares);
        return p;
    }

}