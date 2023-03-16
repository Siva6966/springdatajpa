DROP TABLE IF EXISTS product; 

CREATE TABLE product (
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL,
 description TEXT NOT NULL,
 price DECIMAL(10,2) NOT NULL,
 quantity INT NOT NULL,
 PRIMARY KEY (id)
);