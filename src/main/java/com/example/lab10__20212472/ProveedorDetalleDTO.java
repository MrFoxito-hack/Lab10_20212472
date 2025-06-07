package com.example.lab10__20212472;
import lombok.Data;

@Data
public class ProveedorDetalleDTO {

    private Long id;
    private String razonSocial;
    private String nombreComercial;
    private String ruc;
    private String telefono;
    private String correoElectronico;
    private String sitioWeb;
    private String direccionFisica;
    private String pais;
    private String representanteLegal;
    private String dniRepresentanteLegal;
    private String tipoProveedor;
    private String categoria;
    private Double facturacionAnualDolares;
    private String estado;



    public ProveedorDetalleDTO(Proveedor p) {
        this.id = p.getId();
        this.razonSocial = p.getRazonSocial();
        this.nombreComercial = p.getNombreComercial();
        this.ruc = p.getRuc();
        this.telefono = p.getTelefono();
        this.correoElectronico = p.getCorreoElectronico();
        this.sitioWeb = p.getSitioWeb();
        this.direccionFisica = p.getDireccionFisica();
        this.pais = p.getPais();
        this.representanteLegal = p.getRepresentanteLegal();
        this.dniRepresentanteLegal = p.getDniRepresentanteLegal();
        this.tipoProveedor = p.getTipoProveedor().name();
        this.categoria = p.getCategoria().name();
        this.facturacionAnualDolares = p.getFacturacionAnualDolares();
        this.estado = p.getEstado() ? "Activo" : "Inactivo";


    }
}
