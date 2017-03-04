/*Sentencias CRUD*/

/*Alumno*/

DROP PROCEDURE IF EXISTS `insertar_alumno`;
DROP PROCEDURE IF EXISTS `eliminar_alumno`;
DROP PROCEDURE IF EXISTS `modificar_alumno`;
DROP PROCEDURE IF EXISTS `mostrar_alumno`;

DELIMITER //
CREATE PROCEDURE insertar_alumno
(IN id INT, IN nomProducto VARCHAR(50),IN preProducto DOUBLE,IN existencia INT)
BEGIN
	IF id > 0 THEN
  	INSERT INTO Producto(idProducto, nombreProducto,precioProducto,existenciaProducto) VALUES(id, nomProducto,preProducto,existencia);
	ELSE
		INSERT INTO Producto(nombreProducto,precioProducto,existenciaProducto) VALUES(nomProducto,preProducto,existencia);
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE eliminar_alumno
(IN idPro INTEGER)
BEGIN
  DELETE FROM Producto WHERE idProducto=idProd;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE modificar_alumno
(IN idProd INTEGER, IN nomProducto VARCHAR(50),IN preProducto DOUBLE,IN existencia INT)
BEGIN
	UPDATE Producto SET nombreProducto=nomProducto, precioProducto=preProducto,existenciaProducto=existencia WHERE idProducto=idProd;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE mostrar_alumno
(IN id INT)
BEGIN
  SELECT * FROM Producto WHERE idProducto=id;
END //
DELIMITER ;

/*Asignacion*/

DROP PROCEDURE IF EXISTS `insertar_asignacion`;
DROP PROCEDURE IF EXISTS `eliminar_asignacion`;
DROP PROCEDURE IF EXISTS `modificar_asignacion`;
DROP PROCEDURE IF EXISTS `mostrar_asignacion`;

DELIMITER //
CREATE PROCEDURE insertar_asignacion
(IN id INT, IN nomProducto VARCHAR(50),IN preProducto DOUBLE,IN existencia INT)
BEGIN
	IF id > 0 THEN
  	INSERT INTO Producto(idProducto, nombreProducto,precioProducto,existenciaProducto) VALUES(id, nomProducto,preProducto,existencia);
	ELSE
		INSERT INTO Producto(nombreProducto,precioProducto,existenciaProducto) VALUES(nomProducto,preProducto,existencia);
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE eliminar_asignacion
(IN idPro INTEGER)
BEGIN
  DELETE FROM Producto WHERE idProducto=idProd;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE modificar_asignacion
(IN idProd INTEGER, IN nomProducto VARCHAR(50),IN preProducto DOUBLE,IN existencia INT)
BEGIN
	UPDATE Producto SET nombreProducto=nomProducto, precioProducto=preProducto,existenciaProducto=existencia WHERE idProducto=idProd;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE mostrar_asignacion
(IN id INT)
BEGIN
  SELECT * FROM Producto WHERE idProducto=id;
END //
DELIMITER ;

/*Curso*/

DROP PROCEDURE IF EXISTS `insertar_curso`;
DROP PROCEDURE IF EXISTS `eliminar_curso`;
DROP PROCEDURE IF EXISTS `modificar_curso`;
DROP PROCEDURE IF EXISTS `mostrar_curso`;

DELIMITER //
CREATE PROCEDURE insertar_curso
(IN id INT, IN nomProducto VARCHAR(50),IN preProducto DOUBLE,IN existencia INT)
BEGIN
	IF id > 0 THEN
  	INSERT INTO Producto(idProducto, nombreProducto,precioProducto,existenciaProducto) VALUES(id, nomProducto,preProducto,existencia);
	ELSE
		INSERT INTO Producto(nombreProducto,precioProducto,existenciaProducto) VALUES(nomProducto,preProducto,existencia);
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE eliminar_curso
(IN idPro INTEGER)
BEGIN
  DELETE FROM Producto WHERE idProducto=idProd;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE modificar_curso
(IN idProd INTEGER, IN nomProducto VARCHAR(50),IN preProducto DOUBLE,IN existencia INT)
BEGIN
	UPDATE Producto SET nombreProducto=nomProducto, precioProducto=preProducto,existenciaProducto=existencia WHERE idProducto=idProd;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE mostrar_curso
(IN id INT)
BEGIN
  SELECT * FROM Producto WHERE idProducto=id;
END //
DELIMITER ;
