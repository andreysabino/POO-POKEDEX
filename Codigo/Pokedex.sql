CREATE TABLE Treinador (
    id SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    nivel INTEGER
);

CREATE TABLE Pokemon  (
    id SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    tipo TEXT,
    nivel INTEGER,
    treinador_id INTEGER REFERENCES Treinador(id)
);

CREATE TABLE Batalha (
    id serial PRIMARY KEY,
    data DATE,
    pokemon1_id INTEGER,
    pokemon2_id INTEGER,
    resultado TEXT,
    FOREIGN KEY (pokemon1_id) REFERENCES Pokemon(id),
    FOREIGN KEY (pokemon2_id) REFERENCES Pokemon(id)
);
