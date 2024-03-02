DROP TABLE IF EXISTS CATEGORIAS;
CREATE TABLE CATEGORIAS
(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    TITULO VARCHAR(200) NOT NULL
);


DROP TABLE IF EXISTS PRODUCTOS;
CREATE TABLE PRODUCTOS (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(100) NOT NULL,
    DESCRIPCION VARCHAR(200) NOT NULL,
    CATEGORIA_ID INT,
    FOREIGN KEY (CATEGORIA_ID) REFERENCES CATEGORIAS(ID)
);

DROP TABLE IF EXISTS IMAGENES;
CREATE TABLE IMAGENES (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    TITULO VARCHAR(200) NOT NULL,
    URLIMG VARCHAR(200) NOT NULL,
    PRODUCTO_ID INT,
    FOREIGN KEY (PRODUCTO_ID) REFERENCES PRODUCTOS(ID)
);


 INSERT INTO CATEGORIAS(TITULO)
    VALUES ('Urbana'),
           ('Plegable'),
           ('Montaña'),
           ('Carretera'),
           ('Carga');


INSERT INTO IMAGENES(TITULO, URLIMG) VALUES ('BICI DE MONTAÑA', 'https://www.elconfidencial.com/decompras/2020-05-11/mejores-bicicletas-montana-hombre-mujer_2588003/');
INSERT INTO PRODUCTOS(NOMBRE, DESCRIPCION, CATEGORIA_ID) VALUES ('LA SUPER PODEROSA','ESCALA HASTA EL ALPE',1);
