create SCHEMA `consultorio_familiar`;
use consultorio_familiar;
CREATE TABLE Paciente(
	id_paciente INT NOT NULL AUTO_INCREMENT,
    numero_documento INT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATETIME NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    foto BLOB,
    correo VARCHAR(100),
    celular VARCHAR(100),
    telefono VARCHAR(100),
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    creado_por VARCHAR(50),
    fecha_actualizacion DATETIME,
    actualizado_por VARCHAR(50),
    PRIMARY KEY (id_paciente)
);
CREATE TABLE Doctor(
	id_doctor INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATETIME NOT NULL,
    especialidad VARCHAR(100) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    foto BLOB,
    registro_medico  VARCHAR(50),
    correo VARCHAR(100),
    celular VARCHAR(100),
    telefono VARCHAR(100),
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    creado_por VARCHAR(50),
    fecha_actualizacion DATETIME,
    actualizado_por VARCHAR(50),
    PRIMARY KEY (id_doctor)
);

CREATE TABLE Historial(
	id_historial INT NOT NULL AUTO_INCREMENT,
    historal BLOB,
    id_paciente INT NOT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    creado_por VARCHAR(50),
    fecha_actualizacion DATETIME,
    actualizado_por VARCHAR(50),
    PRIMARY KEY (id_historial),
    FOREIGN KEY (id_paciente) references Paciente(id_paciente)
);

CREATE TABLE Consulta(
	id_consulta  INT NOT NULL AUTO_INCREMENT,
    fecha DATETIME NOT NULL,
    id_doctor INT NOT NULL ,
    id_paciente INT NOT NULL,
	fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    creado_por VARCHAR(50),
    fecha_actualizacion DATETIME,
    actualizado_por VARCHAR(50),
	PRIMARY KEY (id_consulta),
    FOREIGN KEY (id_doctor) references Doctor(id_doctor),
    FOREIGN KEY (id_paciente) references Paciente(id_paciente)
);
CREATE TABLE Receta(
	id_receta  INT NOT NULL AUTO_INCREMENT,
    id_consulta  INT NOT NULL,
    dosis VARCHAR(200) NOT NULL,
	fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    creado_por VARCHAR(50),
    fecha_actualizacion DATETIME,
    actualizado_por VARCHAR(50),
	PRIMARY KEY (id_receta),
    FOREIGN KEY (id_consulta) references Consulta(id_consulta)
);

CREATE TABLE Especialidad(
	id_especialidad int not null auto_increment,
    cod_especialidad VARCHAR(20),
    nombre VARCHAR(20),
    descripcion VARCHAR(300),
    primary key (id_especialidad)
);


#Doctores
INSERT INTO `consultorio_familiar`.`doctor`
(`nombre`,`apellido`,`fecha_nacimiento`,`especialidad`,`direccion`,`foto`,`registroMedico`,`correo`,`celular`,`telefono`)
VALUES ('JUAN JOSE', 'MAMANI MAMANI', '1991-11-05 00:00:00', 'PEDIATRA', 'ZONA VILLA TUNARI', NULL, '0000001', 'jose@gmail.com', 77707321, 591+22222222);

INSERT INTO `consultorio_familiar`.`doctor`
(`nombre`,`apellido`,`fecha_nacimiento`,`especialidad`,`direccion`,`foto`,`registroMedico`,`correo`,`celular`,`telefono`)
VALUES ('PEDRO', 'MAMANI CORTEZ', '1985-01-06 00:00:00', 'GENERAL', 'ZONA ACHACHICALA', NULL, '0000002', 'pedro@gmail.com', 77707321, 591+22222222);
#pacientes

INSERT INTO `consultorio_familiar`.`paciente`
(`numero_documento`,`nombre`,`apellido`,`fecha_nacimiento`,`direccion`,`foto`,`correo`,`celular`,`telefono`)
VALUES('6787435','LUIS','CONDORI CONDORI','1991-11-05 00:00:00','Zona Achachicala',NULL,'luis@correo.com','78444512',NULL);

INSERT INTO `consultorio_familiar`.`paciente`
(`numero_documento`,`nombre`,`apellido`,`fecha_nacimiento`,`direccion`,`foto`,`correo`,`celular`,`telefono`)
VALUES('6787435','CELIA','MAMANI YUJRA','1989-06-05 00:00:00','Zona Achachicala',NULL,'celia@correo.com','65412388',NULL);

#consulta
INSERT INTO `consultorio_familiar`.`consulta` (`fecha`,`id_doctor`,`id_paciente`) VALUES ( CURRENT_TIMESTAMP, 1, 1);

#Historial
INSERT INTO `consultorio_familiar`.`historial` (`historal`,`id_paciente`) VALUES ( 'bla bla bla bla', 1);
