SHOW DATABASES;
DROP DATABASE IF EXISTS forth;
CREATE DATABASE forth;
USE forth;

-- admin
DROP TABLE IF EXISTS admin;
CREATE TABLE forth.admin (
  id       INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255),
  password VARCHAR(255)
);

INSERT INTO forth.admin VALUES (NULL ,'admin','123');
SELECT *
FROM forth.;

-- Supplier 供应商
DROP TABLE IF EXISTS supplier;
CREATE TABLE forth.supplier (
  id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(1024),
  address VARCHAR(2048),
  people VARCHAR(255),
  goods VARCHAR(255),
  tel INT(11) UNSIGNED
);

DESC admin;
DESC supplier;

SELECT *
FROM admin;

SELECT *
FROM supplier;

