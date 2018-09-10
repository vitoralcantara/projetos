create table
if not exists ARVORE.pessoas
(
    id INT not null AUTO_INCREMENT,
    nome VARCHAR
(255) not null,
    pai INT,
    mae INT,
    PRIMARY KEY
(id),
    
    FOREIGN KEY MAE
(mae)
    REFERENCES pessoas
(id)
    ON
DELETE
SET NULL
ON
UPDATE CASCADE,
    
    FOREIGN KEY PAI (pai)
REFERENCES pessoas
(id)
    ON
DELETE
SET NULL
ON
UPDATE CASCADE
)