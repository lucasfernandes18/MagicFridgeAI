CREATE TABLE food_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(100),
    quantidade INT NOT NULL,
    validade DATE
);
