CREATE DATABASE IF NOT EXISTS gestion_proveedores;
USE gestion_proveedores;

CREATE TABLE proveedores (

    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    razon_social VARCHAR(100) NOT NULL,
    nombre_comercial VARCHAR(100) NOT NULL,
    ruc VARCHAR(11) NOT NULL UNIQUE,
    telefono VARCHAR(20) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL,
    sitio_web VARCHAR(255),
    direccion_fisica VARCHAR(150),
    pais VARCHAR(50) NOT NULL,
    representante_legal VARCHAR(100) NOT NULL,
    dni_representante_legal VARCHAR(20) NOT NULL,
    tipo_proveedor ENUM('Nacional', 'Internacional') NOT NULL,
    categoria ENUM('Servicios', 'Productos', 'Tecnología', 'Otros') NOT NULL,
    facturacion_anual DECIMAL(15, 2),
    fecha_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ultima_actualizacion DATETIME ON UPDATE CURRENT_TIMESTAMP,
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    
    
    INDEX idx_ruc (ruc),
    INDEX idx_estado (estado),
    INDEX idx_tipo_proveedor (tipo_proveedor),
    INDEX idx_categoria (categoria)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

ALTER TABLE proveedores COMMENT 'Tabla para almacenar información de proveedores de la empresa';

ALTER TABLE proveedores MODIFY COLUMN ruc VARCHAR(11) 
    COMMENT 'RUC debe ser exacactamente 11 dígitos, único';
ALTER TABLE proveedores MODIFY COLUMN estado BOOLEAN 
    COMMENT 'Porvedores 1=Activo, 0=Inactivo';
ALTER TABLE proveedores MODIFY COLUMN ultima_actualizacion DATETIME 
    COMMENT 'la fecha se actualiza automáticamente al modificar el registro';