#INSERT TIPO DE VEHICULOS
-- Insertando productos en la tabla tb_tipo_vehiculo
INSERT INTO autoparkdb.tb_tipo_vehiculo (id_tipo_vehiculo, des_tipo_vehiculo) VALUES 
(null, 'auto'),
(null, 'camioneta'),
(null, 'custer'),
(null, 'trailer'),
(null, 'moto');

-- Insertando productos en la tabla tb_tipo_vehiculo
INSERT INTO autoparkdb.tb_marca (id_marca, des_marca) VALUES 
(null, 'nissan'),
(null, 'toyota'),
(null, 'ford'),
(null, 'chevrolet'),
(null, 'honda');

#INSERT VEHICULO
INSERT INTO autoparkdb.tb_vehiculo(id, placa, color, id_tipo_vehiculo, id_marca)
VALUES (null, 'ABC123', 'Rojo', '1', '2');
INSERT INTO autoparkdb.tb_vehiculo (id, placa, color, id_tipo_vehiculo, id_marca) 
VALUES (null, 'DEF456', 'Azul', '1', '1');
INSERT INTO autoparkdb.tb_vehiculo (id, placa, color, id_tipo_vehiculo, id_marca) 
VALUES (null, 'GHI789', 'Blanco', '2', '2');
INSERT INTO autoparkdb.tb_vehiculo (id, placa, color, id_tipo_vehiculo, id_marca) 
VALUES (null, 'JKL012', 'Negro', '3', '3');
INSERT INTO autoparkdb.tb_vehiculo (id, placa, color, id_tipo_vehiculo, id_marca) 
VALUES (null, 'MNO345', 'Gris', '1', '1');
INSERT INTO autoparkdb.tb_vehiculo (id, placa, color, id_tipo_vehiculo, id_marca) 
VALUES (null, 'PQR678', 'Rojo', '2', '2');
INSERT INTO autoparkdb.tb_vehiculo (id, placa, color, id_tipo_vehiculo, id_marca) 
VALUES (null, 'STU901', 'Verde', '3', '3');
INSERT INTO autoparkdb.tb_vehiculo (id, placa, color, id_tipo_vehiculo, id_marca) 
VALUES (null, 'VWX234', 'Azul', '1', '1');
INSERT INTO autoparkdb.tb_vehiculo (id, placa, color, id_tipo_vehiculo, id_marca) 
VALUES (null, 'YZA567', 'Blanco', '2', '2');
INSERT INTO autoparkdb.tb_vehiculo (id, placa, color, id_tipo_vehiculo, id_marca) 
VALUES (null, 'BCD890', 'Negro', '3', '3');
INSERT INTO autoparkdb.tb_vehiculo (id, placa, color, id_tipo_vehiculo, id_marca) 
VALUES (null, 'EFG123', 'Gris', '1', '1');

#INSERT CLIENTE
INSERT INTO autoparkdb.tb_cliente(id, ape_paterno, ape_materno, nombres, dni, email, fecha_nacimiento)
VALUES (null, 'López', 'García', 'Juan', '12345678', 'juanlopez@example.com', '1980-01-10');
INSERT INTO autoparkdb.tb_cliente(id, ape_paterno, ape_materno, nombres, dni, email, fecha_nacimiento)
VALUES (null, 'Gómez', 'Fernández', 'María', '87654321', 'mariagomez@example.com', '1981-02-11');
INSERT INTO autoparkdb.tb_cliente(id, ape_paterno, ape_materno, nombres, dni, email, fecha_nacimiento)
VALUES (null, 'Rodríguez', 'Pérez', 'Luis', '56789012', 'luisrodriguez@example.com', '1982-03-12');
INSERT INTO autoparkdb.tb_cliente(id, ape_paterno, ape_materno, nombres, dni, email, fecha_nacimiento)
VALUES (null, 'Martínez', 'López', 'Ana', '90123456', 'anamartinez@example.com', '1983-04-13');
INSERT INTO autoparkdb.tb_cliente(id, ape_paterno, ape_materno, nombres, dni, email, fecha_nacimiento)
VALUES (null, 'Hernández', 'Gómez', 'Pedro', '65432109', 'pedrohernandez@example.com', '1984-05-14');
INSERT INTO autoparkdb.tb_cliente(id, ape_paterno, ape_materno, nombres, dni, email, fecha_nacimiento)
VALUES (null, 'Pérez', 'Rodríguez', 'Carolina', '89012345', 'carolinaperez@example.com', '1985-06-15');
INSERT INTO autoparkdb.tb_cliente(id, ape_paterno, ape_materno, nombres, dni, email, fecha_nacimiento)
VALUES (null, 'López', 'González', 'Manuel', '54321098', 'manuellopez@example.com', '1986-07-16');
INSERT INTO autoparkdb.tb_cliente(id, ape_paterno, ape_materno, nombres, dni, email, fecha_nacimiento)
VALUES (null, 'Fernández', 'Hernández', 'Sara', '01234567', 'sarafernandez@example.com', '1987-08-17');
INSERT INTO autoparkdb.tb_cliente(id, ape_paterno, ape_materno, nombres, dni, email, fecha_nacimiento)
VALUES (null, 'González', 'Martínez', 'Ricardo', '78901234', 'ricardogonzalez@example.com', '1988-09-18');

#INSERT PARQUEO DETALLE
INSERT INTO autoparkdb.tb_parqueo_detalle(id, id_vehiculo, cantidad, preciovta, importe, horaingreso, horasalida)
VALUES (null, '1', '2', '5', '5.2', '10:25', '10:45');
INSERT INTO autoparkdb.tb_parqueo_detalle (id, id_vehiculo, cantidad, preciovta, importe, horaingreso, horasalida) 
VALUES (null, '1', '2', '5', '10.0', '10:25', '10:45');
INSERT INTO autoparkdb.tb_parqueo_detalle (id, id_vehiculo, cantidad, preciovta, importe, horaingreso, horasalida) 
VALUES (null, '2', '1', '7', '7.0', '09:30', '10:15');
INSERT INTO autoparkdb.tb_parqueo_detalle (id, id_vehiculo, cantidad, preciovta, importe, horaingreso, horasalida) 
VALUES (null, '3', '3', '6', '18.0', '08:45', '09:30');
INSERT INTO autoparkdb.tb_parqueo_detalle (id, id_vehiculo, cantidad, preciovta, importe, horaingreso, horasalida) 
VALUES (null, '4', '1', '5', '5.0', '11:00', '11:45');
INSERT INTO autoparkdb.tb_parqueo_detalle (id, id_vehiculo, cantidad, preciovta, importe, horaingreso, horasalida)
VALUES (null, '5', '2', '8', '16.0', '12:30', '13:00');
INSERT INTO autoparkdb.tb_parqueo_detalle (id, id_vehiculo, cantidad, preciovta, importe, horaingreso, horasalida) 
VALUES (null, '6', '1', '6', '6.0', '15:00', '15:30');
INSERT INTO autoparkdb.tb_parqueo_detalle (id, id_vehiculo, cantidad, preciovta, importe, horaingreso, horasalida) 
VALUES (null, '7', '3', '4', '12.0', '14:20', '15:10');
INSERT INTO autoparkdb.tb_parqueo_detalle (id, id_vehiculo, cantidad, preciovta, importe, horaingreso, horasalida) 
VALUES (null, '8', '1', '9', '9.0', '17:00', '17:45');
INSERT INTO autoparkdb.tb_parqueo_detalle (id, id_vehiculo, cantidad, preciovta, importe, horaingreso, horasalida) 
VALUES (null, '9', '2', '5', '10.0', '16:15', '16:45');
INSERT INTO autoparkdb.tb_parqueo_detalle (id, id_vehiculo, cantidad, preciovta, importe, horaingreso, horasalida) 
VALUES (null, '10', '1', '7', '7.0', '18:30', '19:00');

#INSERT PARQUEO
INSERT INTO autoparkdb.tb_parqueo(id, fecha_parqueo, id_cliente)
VALUES (null,'2024-04-29', '1');
INSERT INTO autoparkdb.tb_parqueo (id, fecha_parqueo, id_cliente) 
VALUES (null, '2024-04-29', '1');
INSERT INTO autoparkdb.tb_parqueo (id, fecha_parqueo, id_cliente) 
VALUES (null, '2024-04-29', '2');
INSERT INTO autoparkdb.tb_parqueo (id, fecha_parqueo, id_cliente) 
VALUES (null, '2024-04-29', '3');
INSERT INTO autoparkdb.tb_parqueo (id, fecha_parqueo, id_cliente) 
VALUES (null, '2024-04-29', '4');
INSERT INTO autoparkdb.tb_parqueo (id, fecha_parqueo, id_cliente) 
VALUES (null, '2024-04-29', '5');
INSERT INTO autoparkdb.tb_parqueo (id, fecha_parqueo, id_cliente) 
VALUES (null, '2024-04-29', '6');
INSERT INTO autoparkdb.tb_parqueo (id, fecha_parqueo, id_cliente) 
VALUES (null, '2024-04-29', '7');
INSERT INTO autoparkdb.tb_parqueo (id, fecha_parqueo, id_cliente) 
VALUES (null, '2024-04-29', '8');
INSERT INTO autoparkdb.tb_parqueo (id, fecha_parqueo, id_cliente) 
VALUES (null, '2024-04-29', '9');

select * from tb_parqueo_detalle;
select * from tb_parqueo;

