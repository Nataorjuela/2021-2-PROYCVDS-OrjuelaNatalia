/*TABLAS*/
drop table usuario;
drop table rol;
drop table categoria;
drop table necesidad;
drop table oferta;


create TABLE IF not exists usuario (
	idUsuario varchar(10) primary key, 
	idRol integer,
	tipoRol varchar(20) not null,
	estado boolean,
	correo varchar(50) not null,
	contraseña varchar(80)not null
);

create TABLE IF NOT exists rol (
	idRol serial primary key,
	tipoRol varchar(20) not null
);

create TABLE IF NOT exists categoria (
	idCategoria serial primary key,
	nombreCateg varchar(40) not null,
	descripcion varchar (200)not null,
	fechaCreacion date not null,
	fechaModif date not null
);

create TABLE IF NOT EXISTS necesidad (
	idNecesidad serial primary key,
	idCategoria integer,
	nombreNec varchar(40)not null,
	descripcion varchar(200) not null,
	urgencia varchar(1) not null,
	fechaCreacion date not null,
	estado varchar(40) not null,
	fechaModif date not null
);

create TABLE IF NOT EXISTS  oferta(
	idOferta serial primary key,
	idCategoria integer,
	nombreOferta varchar(40) not null,
	descripcion varchar(200) not null,
	estado varchar(40) not null,
	fechaCreacion date not null,
	fechaModif date not null
);

/*llaves foraneas*/

alter table usuario
add constraint fk_usuario_rol 
foreign key(idRol)
references rol(idRol)on delete cascade;


alter table necesidad
add constraint fk_necesidad_categ 
foreign key(idCategoria)
references categoria(idCategoria)on delete cascade;

alter table oferta
add constraint fk_oferta_categ 
foreign key(idCategoria)
references categoria(idCategoria)on delete cascade;

/*poblar*/
INSERT INTO rol (tipoRol) VALUES ('Administrador');
insert INTO rol (tipoRol) VALUES ('Estudiante');
insert INTO rol (tipoRol) VALUES ('Profesor');
insert INTO rol (tipoRol) VALUES ('Egresado');
insert INTO rol (tipoRol) VALUES ('Administrativo');

INSERT INTO usuario (idUsuario,idRol,tipoRol,estado,correo,contraseña) VALUES ('admin1','1','Administrador',TRUE,'admin1@gmail.com','admin1');
INSERT INTO usuario (idUsuario,idRol,tipoRol,estado,correo,contraseña) VALUES ('est1','2','Estudiante',TRUE,'est1@gmail.com','est1');
INSERT INTO usuario (idUsuario,idRol,tipoRol,estado,correo,contraseña) VALUES ('prof1','3','Profesor',TRUE,'prof1@gmail.com','prof1');
INSERT INTO usuario (idUsuario,idRol,tipoRol,estado,correo,contraseña) VALUES ('egre1','4','Egresado',TRUE,'egre1@gmail.com','egre1');
INSERT INTO usuario (idUsuario,idRol,tipoRol,estado,correo,contraseña) VALUES ('admt1','5','Administrativo',TRUE,'admint1@gmail.com','admt1');
insert into usuario (idUsuario,idRol,tipoRol,estado,correo,contraseña) values('admin2','1','Administrador',TRUE,'admin2@gmail.com','admin2');

INSERT INTO categoria (nombreCateg,descripcion,fechaCreacion,fechaModif) values ('academica','en esta categoria se encuentran todas las necesidades y ofertas referentes al area academica','2021-11-01','2021-11-02');

INSERT INTO necesidad(idCategoria,nombreNec,descripcion,urgencia,fechaCreacion,estado,fechaModif)  VALUES (2,'escasez de libros','en el area de sistemas hay escasez de libros fisicos','B','2021-02-15','sin resolverr','2021-03-20');

insert into oferta(c,nombreOferta,descripcion,estado ,fechaCreacion,fechaModif) values (2,'donacion de libros sobre bases de datos','la biblioteca la Giralda tiene 50 libros sobre bases de datos para donar','en proceso','2021-03-19','2021-03-20');

select * from usuario;
select * from necesidad;
select * from oferta;
select * from categoria;

/*entidades*/
/*DAO*/
/*MAPPER,MYBATIES(3)*/
/*BIND PARA CONECTARLOS EN GUICE*/
/*FACTORY BIND*/