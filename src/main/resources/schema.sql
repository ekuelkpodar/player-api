CREATE DATABASE playerdb;

USE playerdb;

CREATE TABLE players (
                         id INT PRIMARY KEY,
                         first_name VARCHAR(50),
                         last_name VARCHAR(50),
                         team VARCHAR(50),
                         position VARCHAR(50)
);