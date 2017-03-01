create database tienda;
use tienda;
create table Producto(
	idProducto int auto_increment primary key,
	nombreProducto VARCHAR(50),
	precioProducto double,
	existenciaProducto INT
	);

DROP PROCEDURE IF EXISTS `insertar_producto`;
DROP PROCEDURE IF EXISTS `eliminar_producto`;
DROP PROCEDURE IF EXISTS `modificar_producto`;
DROP PROCEDURE IF EXISTS `mostrar_producto`;

DELIMITER //
CREATE PROCEDURE insertar_producto
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
CREATE PROCEDURE eliminar_producto
(IN idPro INTEGER)
BEGIN
  DELETE FROM Producto WHERE idProducto=idProd;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE modificar_producto
(IN idProd INTEGER, IN nomProducto VARCHAR(50),IN preProducto DOUBLE,IN existencia INT)
BEGIN
	UPDATE Producto SET nombreProducto=nomProducto, precioProducto=preProducto,existenciaProducto=existencia WHERE idProducto=idProd;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE mostrar_producto
(IN id INT)
BEGIN
  SELECT * FROM Producto WHERE idProducto=id;
END //
DELIMITER ;
