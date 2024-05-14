
CREATE DATABASE db_movimientos;
-- Creación de la tabla Persona
CREATE TABLE Persona (
                         identificacion VARCHAR(10) PRIMARY KEY,
                         nombre VARCHAR(100),
                         genero VARCHAR(10),
                         edad INT,
                         direccion VARCHAR(255),
                         telefono VARCHAR(50)
);

-- Creación de la tabla Cliente, heredando de Persona
CREATE TABLE Cliente (
                         clienteid SERIAL PRIMARY KEY,
                         identificacion VARCHAR(10) UNIQUE REFERENCES Persona(identificacion),
                         contrasena VARCHAR(255),
                         estado BOOLEAN
);

-- Creación de la tabla Cuenta
CREATE TABLE Cuenta (
                        numero_cuenta SERIAL PRIMARY KEY,
                        tipo_cuenta VARCHAR(50),
                        saldo_inicial DECIMAL(10, 2),
                        estado BOOLEAN,
                        clienteid INT REFERENCES Cliente(clienteid)
);

-- Creación de la tabla Movimientos
CREATE TABLE Movimientos (
                             movimiento_id SERIAL PRIMARY KEY,
                             fecha TIMESTAMP,
                             tipo_movimiento VARCHAR(50),
                             valor DECIMAL(10, 2),
                             saldo DECIMAL(10, 2),
                             numero_cuenta INT REFERENCES Cuenta(numero_cuenta)
);

