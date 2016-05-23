CREATE TABLE Produto (
id SERIAL PRIMARY KEY,
descricao VARCHAR (100),
preco DECIMAL
);

CREATE TABLE Especificacoes (
id SERIAL PRIMARY KEY,
produtos_id int REFERENCES Produto (id),
marca VARCHAR (50),
cor VARCHAR (50),
dimensoes VARCHAR (50)
);

SELECT * FROM Produto

DROP TABLE produtos

DROP TABLE especificacoes