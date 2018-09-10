create table
if not exists ARVORE.relacoes
(
    person_id INT not null,
    child_id INT not null,
    
    FOREIGN KEY PERSON
(person_id)
    REFERENCES pessoas
(id)
    ON
DELETE CASCADE
    ON
UPDATE CASCADE,
    
    FOREIGN KEY CHILD (child_id)
REFERENCES pessoas
(id)
    ON
DELETE CASCADE
    ON
UPDATE CASCADE
)