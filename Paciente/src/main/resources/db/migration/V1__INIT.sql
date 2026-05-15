CREATE TABLE paciente
(
    id_paciente      INT(10)    PRIMARY KEY AUTO_INCREMENT,
    run              VARCHAR(9)   NOT NULL UNIQUE,
    nombres          VARCHAR(100) NOT NULL,
    apellidos        VARCHAR(100) NOT NULL,
    fecha_nacimiento DATETIME NOT NULL,
    correo           VARCHAR(100)
);