DROP DATABASE IF EXISTS spring;
CREATE DATABASE IF NOT EXISTS spring;

USE spring;

CREATE TABLE IF NOT EXISTS users
(
    id       INT         NOT NULL AUTO_INCREMENT,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    enabled  INT         NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS authorities
(
    id        INT         NOT NULL AUTO_INCREMENT,
    username  VARCHAR(45) NOT NULL,
    authority VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);

INSERT IGNORE INTO authorities VALUES (NULL, 'Vladimir', 'write');
INSERT IGNORE INTO users VALUES (NULL, 'Vladimir', '123', '1');

SELECT * FROM users;
SELECT * FROM authorities;



