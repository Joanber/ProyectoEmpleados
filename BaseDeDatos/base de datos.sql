CREATE TABLE "Persona"(

    identificacion VARCHAR(30) PRIMARY KEY,
    primer_nombre VARCHAR(30),
    segundo_nombre VARCHAR(30),
    primer_apellido VARCHAR(30),
    segundo_apellido VARCHAR(30),
    correo VARCHAR(30),
    telefono VARCHAR(30),
    direccion VARCHAR(30)
);

CREATE TABLE "Usuario"(
    username VARCHAR(30) PRIMARY KEY,
    password VARCHAR(40),
    persona_id VARCHAR(30)
);


CREATE TABLE "DetalleRegistros"(
    id SERIAL NOT NULL PRIMARY KEY,
    fecha_hora TIMESTAMP DEFAULT NOW(),
    tipo SMALLINT,
    persona_id VARCHAR(30)
);


CREATE TABLE "Cargo"(
    id SERIAL NOT NULL PRIMARY KEY,
    nombre VARCHAR(30)
);

CREATE TABLE "Horario"(
    id SERIAL NOT NULL PRIMARY KEY,
    hora_inicio TIME,
    hora_fin TIME,
    jornada VARCHAR(30)
);

CREATE TABLE "HistorialTrabajo"(
    id SERIAL NOT NULL PRIMARY KEY,
    fecha_inicio DATE,
    fecha_finalizo DATE,
    estado VARCHAR(30),
    persona_id VARCHAR(30),
    cargo_id INTEGER,
    horario_id INTEGER

);

CREATE TABLE "TipoPermiso"(
    id SERIAL NOT NULL PRIMARY KEY,
    nombre VARCHAR(30)
);

CREATE TABLE "DetallePermisos"(
    id SERIAL NOT NULL PRIMARY KEY,
    fecha_inicio TIMESTAMP,
    fecha_fin TIMESTAMP,
    observaciones VARCHAR(150),
    persona_id VARCHAR(30),
    tipo_permiso_id INTEGER
);


/*
    UNION DE LAS TABLAS
*/

/*
    UNIMOS LA TABLA PERSONA CON LA TABLA USUARIO
*/
ALTER TABLE "Usuario" ADD CONSTRAINT "fk_persona__to__usuario"
    FOREIGN KEY("persona_id") REFERENCES "Persona"("identificacion")
        ON UPDATE CASCADE ON DELETE CASCADE; 


/*
    UNIMOS LA TABLA "HISTORIAL DE TRABAJO" CON "CARGO" 
*/
ALTER TABLE "HistorialTrabajo" ADD CONSTRAINT "fk_cargo__to__historial"
    FOREIGN KEY("cargo_id") REFERENCES "Cargo"("id")
        ON UPDATE CASCADE ON DELETE CASCADE; 


/*
    UNIMOS LA TABLA "HISTORIAL DE TRABAJO" CON "HORARIO"
*/
ALTER TABLE "HistorialTrabajo" ADD CONSTRAINT "fk_horario__to__historial"
    FOREIGN KEY("horario_id") REFERENCES "Horario"("id")
        ON UPDATE CASCADE ON DELETE CASCADE; 


/*
    UNIMOS LA TABLA "HISTORIAL DE TRABAJO" CON "PERSONA"
*/
ALTER TABLE "HistorialTrabajo" ADD CONSTRAINT "fk_persona__to__historial"
    FOREIGN KEY("persona_id") REFERENCES "Persona"("identificacion")
        ON UPDATE CASCADE ON DELETE CASCADE; 


/*
    UNIMOS LA TABLA "DETALLE REGISTROS" CON "PERSONA"
*/
ALTER TABLE "DetalleRegistros" ADD CONSTRAINT "fk_persona__to__detalle_registros"
    FOREIGN KEY("persona_id") REFERENCES "Persona"("identificacion")
        ON UPDATE CASCADE ON DELETE CASCADE; 


/*
    UNIMOS LA TABLA "DETALLE PERMISOS" CON "PERSONA"
*/
ALTER TABLE "DetallePermisos" ADD CONSTRAINT "fk_persona__to__detalle_permisos"
    FOREIGN KEY("persona_id") REFERENCES "Persona"("identificacion")
        ON UPDATE CASCADE ON DELETE CASCADE; 


/*
    UNIMOS LA TABLA "DETALLE PERMISOS" CON "TIPO PERMISO"
*/
ALTER TABLE "DetallePermisos" ADD CONSTRAINT "fk_tipo_permiso__to__detalle_permisos"
    FOREIGN KEY("tipo_permiso_id") REFERENCES "TipoPermiso"("id")
        ON UPDATE CASCADE ON DELETE CASCADE; 






