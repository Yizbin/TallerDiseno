
INSERT INTO empleado (nombre, apellidoP, apellidoM, rol, usuario, contrasenia, activo) VALUES ('Pepe', 'Admin', 'Sistema', 'ADMINISTRADOR', 'pepe', '123', 1);

INSERT INTO cliente (nombre, apellidoP, apellidoM, telefono, correo, calle, colonia, numExt, activo) VALUES ('Juan', 'Pérez', 'López', '6441999999', 'cliente@test.com', 'Calle Falsa', 'Centro', '123', 1);

INSERT INTO vehiculo (tipo, marca, modelo, anio, placas, km, color, id_cliente) VALUES ('Sedan', 'Nissan', 'Sentra', '2018', 'SON-999', '80000', 'Gris', 1);

INSERT INTO refaccion (nombre, descripcion, precioUnitario, stock, estado) VALUES ('Aceite Sintético 5W-30', 'Garrafa de 5 litros', 450.00, 20, 'Disponible');

INSERT INTO refaccion (nombre, descripcion, precioUnitario, stock, estado) VALUES ('Filtro de Aceite', 'Filtro estándar para sedán', 150.00, 50, 'Disponible');

INSERT INTO orden (fechaIngreso, fallaReportada, servicioSolicitado, estado, id_cliente, id_vehiculo) VALUES ('2023-11-01', 'Requiere servicio de rutina', 'Afinación y cambio de aceite', 0, 1, 1);

INSERT INTO presupuesto (fechaCreacion, costoTotal, estado, id_orden) VALUES ('2023-11-02', 1000.00, 0, 1);

INSERT INTO tarea (descripcion, costo, estado, id_presupuesto, id_empleado) VALUES ('Mano de obra por afinación', '400.00', 'Por realizar', 1, 1);

INSERT INTO tarea_refaccion (id_tarea, id_refaccion, cantidadUsada) VALUES (1, 1, 1);
INSERT INTO tarea_refaccion (id_tarea, id_refaccion, cantidadUsada) VALUES (1, 2, 1);


INSERT INTO orden (fechaIngreso, fallaReportada, servicioSolicitado, estado, id_cliente, id_vehiculo) VALUES ('2023-12-01', 'Ruido al frenar', 'Cambio de balatas y rectificación', 0, 1, 1);

INSERT INTO presupuesto (fechaCreacion, costoTotal, estado, id_orden) VALUES ('2023-12-02', 1500.00, 0, 2);

INSERT INTO tarea (descripcion, costo, estado, id_presupuesto, id_empleado) VALUES ('Mano de obra frenos', '500.00', 'Por realizar', 2, 1);