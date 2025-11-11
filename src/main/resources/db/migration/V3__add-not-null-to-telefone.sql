UPDATE medicos SET telefone = '000000000' WHERE telefone IS NULL;

ALTER TABLE medicos ALTER COLUMN telefone SET NOT NULL;