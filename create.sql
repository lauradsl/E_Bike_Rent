DROP TABLE IF EXISTS CATEGORIAS;
CREATE TABLE CATEGORIAS
(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    TITULO VARCHAR(200) NOT NULL,
    DESCRIPCION TEXT NOT NULL,
    IMAGEN TEXT NOT NULL
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

DROP TABLE IF EXISTS USUARIOS;
CREATE TABLE USUARIOS(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(255) NOT NULL,
    APELLIDO VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    TELEFONO INT NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
);


INSERT INTO CATEGORIAS(TITULO, DESCRIPCION, IMAGEN)
    VALUES ('Urbana', 'Son ideal para movilizarse en la ciudad con diferentes niveles de asistencia', 'www.categoria_urbana.com'),
           ('Montaña', 'Son diseñadas para acompañarte en tus aventuras por terrenos irregulares.', 'www.categoria_montaña.com'),
           ('Carga','Están diseñadas para transportar mercancías y carga.','www.categoria_carga.com');


INSERT INTO IMAGENES(TITULO, URLIMG) VALUES ('BICI DE MONTAÑA', 'https://www.elconfidencial.com/decompras/2020-05-11/mejores-bicicletas-montana-hombre-mujer_2588003/');
INSERT INTO PRODUCTOS(NOMBRE, DESCRIPCION, CATEGORIA_ID) VALUES ('LA SUPER PODEROSA','ESCALA HASTA EL ALPE',1);

