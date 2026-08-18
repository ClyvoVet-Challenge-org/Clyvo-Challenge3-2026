-- ============================================================================
-- 1. T_CLYVO_RESPONSAVEL
-- ============================================================================
-- Responsável 1
INSERT INTO T_CLYVO_RESPONSAVEL (nm_responsavel, cpf_responsavel, nr_telefone_responsavel, ds_email) 
VALUES ('Ana Maria Silva', '123.456.789-01', '(11) 98765-4321', 'ana.silva@email.com');

-- Responsável 2 (Com e-mail preenchido, respeitando nullable = false)
INSERT INTO T_CLYVO_RESPONSAVEL (nm_responsavel, cpf_responsavel, nr_telefone_responsavel, ds_email) 
VALUES ('Carlos Eduardo Souza', '987.654.321-09', '(21) 99999-8888', 'carlos.souza@email.com');

-- Responsável 3
INSERT INTO T_CLYVO_RESPONSAVEL (nm_responsavel, cpf_responsavel, nr_telefone_responsavel, ds_email) 
VALUES ('Beatriz Lima', '456.789.123-45', '(31) 97777-6666', 'beatriz.lima@email.com');

-- ============================================================================
-- 2. T_CLYVO_ANIMAL (RG e Microchip agora são OBRIGATÓRIOS e ÚNICOS)
-- ============================================================================
-- Animal 1 (Responsável 1 - Ana Maria Silva)
INSERT INTO T_CLYVO_ANIMAL (nm_animal, dt_nascimento_animal, peso_animal, especie_animal, raca_animal, rg_animal, nr_microchip_animal, id_responsavel) 
VALUES ('Rex', '2020-05-15', 14.50, 'Canina', 'Beagle', 'RG-123456', 'MC-9876543210', 1);

-- Animal 2 (Responsável 1 - Ana Maria Silva)
INSERT INTO T_CLYVO_ANIMAL (nm_animal, dt_nascimento_animal, peso_animal, especie_animal, raca_animal, rg_animal, nr_microchip_animal, id_responsavel) 
VALUES ('Mimi', '2022-01-10', 3.80, 'Felina', 'Siamês', 'RG-789012', 'MC-1122334455', 1);

-- Animal 3 (Responsável 2 - Carlos Eduardo)
INSERT INTO T_CLYVO_ANIMAL (nm_animal, dt_nascimento_animal, peso_animal, especie_animal, raca_animal, rg_animal, nr_microchip_animal, id_responsavel) 
VALUES ('Thor', '2019-08-20', 32.00, 'Canina', 'Golden Retriever', 'RG-654321', 'MC-5566778899', 2);

-- Animal 4 (Responsável 3 - Beatriz Lima)
INSERT INTO T_CLYVO_ANIMAL (nm_animal, dt_nascimento_animal, peso_animal, especie_animal, raca_animal, rg_animal, nr_microchip_animal, id_responsavel) 
VALUES ('Pipoca', '2021-11-03', 1.20, 'Roedor', 'Hamster', 'RG-998877', 'MC-3344556677', 3);


-- ============================================================================
-- 3. T_CLYVO_VETERINARIO
-- ============================================================================
INSERT INTO T_CLYVO_VETERINARIO (nm_vet, cpf_vet, crmv_vet, email, senha) 
VALUES ('Dr. Roberto Alves', '111.222.333-44', 'CRMV-SP 12345', 'roberto@email.com', 'senha123');

INSERT INTO T_CLYVO_VETERINARIO (nm_vet, cpf_vet, crmv_vet, email, senha) 
VALUES ('Dra. Juliana Mendes', '555.666.777-88', 'CRMV-RJ 67890', 'juliana@email.com', 'senha123');

INSERT INTO T_CLYVO_VETERINARIO (nm_vet, cpf_vet, crmv_vet, email, senha) 
VALUES ('Dr. Lucas Prado', '999.888.777-66', 'CRMV-MG 54321', 'lucas@email.com', 'senha123');

-- ============================================================================
-- 4. T_CLYVO_CLINICA
-- ============================================================================
INSERT INTO T_CLYVO_CLINICA (cnpj_clinica, nm_clinica) 
VALUES ('12.345.678/0001-90', 'Clínica Vet Care Center');

INSERT INTO T_CLYVO_CLINICA (cnpj_clinica, nm_clinica) 
VALUES ('98.765.432/0001-10', 'Hospital Veterinário 24h');


-- ============================================================================
-- 5. T_CLYVO_CLINICA_VET (Toda clínica possui pelo menos 1 veterinário)
-- ============================================================================
-- Clínica 1 (Vet Care Center) possui 2 veterinários
INSERT INTO T_CLYVO_CLINICA_VET (id_veterinario, id_clinica) VALUES (1, 1);
INSERT INTO T_CLYVO_CLINICA_VET (id_veterinario, id_clinica) VALUES (2, 1);

-- Clínica 2 (Hospital 24h) possui 2 veterinários
INSERT INTO T_CLYVO_CLINICA_VET (id_veterinario, id_clinica) VALUES (1, 2);
INSERT INTO T_CLYVO_CLINICA_VET (id_veterinario, id_clinica) VALUES (3, 2);

-- Veterinário 3 (Dr. Lucas Prado) atende de forma autônoma/domiciliar
INSERT INTO T_CLYVO_CLINICA_VET (id_veterinario, id_clinica) VALUES (3, NULL);
