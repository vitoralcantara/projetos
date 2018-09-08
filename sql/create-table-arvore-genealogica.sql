create table if not exists pessoas (
    id INT not null AUTO_INCREMENT,
    nome VARCHAR(255) not null,
    pai INT,
    mae INT,
    PRIMARY KEY (id),
    
    FOREIGN KEY MAE (mae)
    REFERENCES arvore(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
    
    FOREIGN KEY PAI (pai)
    REFERENCES arvore(id)
    ON DELETE SET NULL
    ON UPDATE CASCADE
)