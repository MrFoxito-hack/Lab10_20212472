package com.example.lab10__20212472;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class ProveedorEdicionDTO {
    @Size(max = 100)
    private String razonSocial;
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
    private String pais;
    private String representanteLegal;
    @Pattern(regexp = "\\d+")
    private String dniRepresentanteLegal;
    private Proveedor.TipoProveedor tipoProveedor;
    private Proveedor.CategoriaProveedor categoria;
    private Double facturacionAnualDolares;


    public void actualizarEntidad(Proveedor p) {
        if (razonSocial != null) p.setRazonSocial(razonSocial);
        if (nombreComercial != null) p.setNombreComercial(nombreComercial);
        if (ruc != null) p.setRuc(ruc);
        if (telefono != null) p.setTelefono(telefono);
        if (correoElectronico != null) p.setCorreoElectronico(correoElectronico);
        if (sitioWeb != null) p.setSitioWeb(sitioWeb);
        if (direccionFisica != null) p.setDireccionFisica(direccionFisica);
        if (pais != null) p.setPais(pais);
        if (representanteLegal != null) p.setRepresentanteLegal(representanteLegal);
        if (dniRepresentanteLegal != null) p.setDniRepresentanteLegal(dniRepresentanteLegal);
        if (tipoProveedor != null) p.setTipoProveedor(tipoProveedor);
        if (categoria != null) p.setCategoria(categoria);
        if (facturacionAnualDolares != null) p.setFacturacionAnualDolares(facturacionAnualDolares);
    }
}
