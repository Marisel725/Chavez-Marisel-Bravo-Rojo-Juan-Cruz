//al crear la tabla mantener el orden de los atributos.

DROP TABLE IF EXISTS ODONTOLOGOS ;
CREATE TABLE ODONTOLOGOS(ID INT AUTO_INCREMENT PRIMARY KEY, MATRICULA INT NOT NULL, NOMBRE VARCHAR(50) NOT NULL, APELLIDO VARCHAR (50) NOT NULL);


INSERT INTO ODONTOLOGOS (MATRICULA,NOMBRE,APELLIDO) VALUES (456789, 'Marisel',  'Chavez' ) , (678904,  'Juan',  'Bravo') , (90876,  'Denis',  'Bilicki');