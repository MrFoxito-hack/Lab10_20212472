package com.example.lab10__20212472;

import lombok.Data;

@Data

public class ProveedorListadoDTO {
    private Long id;
    private String razonSocial;
    private String nombreComercial;
    private String ruc;
    private String telefono;
    private String correoElectronico;
    private String pais;
    private String representanteLegal;
    private String dniRepresentanteLegal;
    private String tipoProveedor;
    private String categoria;
    private String estado;


    public ProveedorListadoDTO(Proveedor p) {
        this.id = p.getId();
        this.razonSocial = p.getRazonSocial();
        this.nombreComercial = p.getNombreComercial();
        this.ruc = p.getRuc();
        this.telefono = p.getTelefono();
        this.correoElectronico = p.getCorreoElectronico();
        this.pais = p.getPais();
        this.representanteLegal = p.getRepresentanteLegal();
        this.dniRepresentanteLegal = p.getDniRepresentanteLegal();
        this.tipoProveedor = p.getTipoProveedor().name();
        this.categoria = p.getCategoria().name();
        this.estado = p.getEstado() ? "Activo" : "Inactivo";
    }
}
