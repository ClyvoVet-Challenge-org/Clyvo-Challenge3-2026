-- ============================================================================
-- ORDEM: entidades fortes (independentes) -> entidades fracas (dependentes)
-- Nível 0: não dependem de ninguém (PK própria, sem FK)
-- Nível 1: dependem só do Nível 0
-- Nível 2: dependem do Nível 0 e/ou 1
-- Nível 3+: dependem em cadeia (dependem de quem já depende de outro)
-- ============================================================================
SET MODE Oracle;
-- ============================================================================
-- NÍVEL 0 — ENTIDADES FORTES (sem FK, existem por si só)
-- ============================================================================

-- ----------------------------------------------------------------------------
-- 1. T_CLYVO_RESPONSAVEL
-- ----------------------------------------------------------------------------
-- Responsável 1
INSERT INTO T_CLYVO_RESPONSAVEL (nm_responsavel, cpf_responsavel, nr_telefone_responsavel, ds_email) VALUES ('Marina Duarte', '321.654.987-11', '(41) 98888-1234', 'marina.duarte@email.com');

-- Responsável 2
INSERT INTO T_CLYVO_RESPONSAVEL (nm_responsavel, cpf_responsavel, nr_telefone_responsavel, ds_email) VALUES ('Rafael Nunes', '654.321.098-22', '(51) 97777-2345', 'rafael.nunes@email.com');

-- Responsável 3
INSERT INTO T_CLYVO_RESPONSAVEL (nm_responsavel, cpf_responsavel, nr_telefone_responsavel, ds_email) VALUES ('Larissa Prado', '789.123.456-33', '(61) 96666-3456', 'larissa.prado@email.com');

-- ----------------------------------------------------------------------------
-- 2. T_CLYVO_VET
-- ----------------------------------------------------------------------------
INSERT INTO T_CLYVO_VET (nm_vet, cpf_vet, crmv_vet, email, senha) VALUES ('Dra. Camila Torres', '222.333.444-55', 'CRMV-PR 11223', 'camila@email.com', 'senhaForte1');

INSERT INTO T_CLYVO_VET (nm_vet, cpf_vet, crmv_vet, email, senha) VALUES ('Dr. Bruno Farias', '333.444.555-66', 'CRMV-RS 44556', 'bruno@email.com', 'senhaForte2');

-- Vet 3 sem nenhum vínculo em CLINICA_VET, atende só via encaixe avulso
INSERT INTO T_CLYVO_VET (nm_vet, cpf_vet, crmv_vet, email, senha) VALUES ('Dra. Patricia Gomes', '444.555.666-77', 'CRMV-SC 77889', 'patricia@email.com', 'senhaForte3');

-- ----------------------------------------------------------------------------
-- 3. T_CLYVO_CLINICA
-- ----------------------------------------------------------------------------
INSERT INTO T_CLYVO_CLINICA (cnpj_clinica, nm_clinica) VALUES ('23.456.789/0001-01', 'Clinica Amigo Fiel');

INSERT INTO T_CLYVO_CLINICA (cnpj_clinica, nm_clinica) VALUES ('34.567.890/0001-12', 'PetSaude 24 Horas');

-- ============================================================================
-- NÍVEL 1 — dependem de UMA entidade forte (1 FK)
-- ============================================================================

-- ----------------------------------------------------------------------------
-- 4. T_CLYVO_ANIMAL (depende de RESPONSAVEL)
-- ----------------------------------------------------------------------------
-- Animal 1 (Responsável 1 - Marina Duarte), com RG e microchip completos
INSERT INTO T_CLYVO_ANIMAL (nm_animal, dt_nascimento_animal, peso_animal, especie_animal, raca_animal, rg_animal, nr_microchip_animal, id_responsavel) VALUES ('Nina',PARSEDATETIME('2021-02-10', 'yyyy-MM-dd'), 9.40, 'Canina', 'Poodle', 'RG-334455', 'MC-1029384756', 1);

-- Animal 2 (Responsável 1), SEM RG nem microchip -- valida a opcionalidade confirmada na revisão
INSERT INTO T_CLYVO_ANIMAL (nm_animal, dt_nascimento_animal, peso_animal, especie_animal, raca_animal, rg_animal, nr_microchip_animal, id_responsavel) VALUES ('Fred', TO_DATE('2023-09-05', 'YYYY-MM-DD'), 4.10, 'Felina', 'Persa', NULL, NULL, 1);

-- Animal 3 (Responsável 2 - Rafael Nunes), peso próximo do limite de NUMBER(5,2)
INSERT INTO T_CLYVO_ANIMAL (nm_animal, dt_nascimento_animal, peso_animal, especie_animal, raca_animal, rg_animal, nr_microchip_animal, id_responsavel) VALUES ('Trovao', TO_DATE('2017-06-22', 'YYYY-MM-DD'), 850.75, 'Equina', 'Quarto de Milha', 'RG-887766', NULL, 2);

-- Animal 4 (Responsável 3 - Larissa Prado), espécie fora do padrão cão/gato
INSERT INTO T_CLYVO_ANIMAL (nm_animal, dt_nascimento_animal, peso_animal, especie_animal, raca_animal, rg_animal, nr_microchip_animal, id_responsavel) VALUES ('Amarelinho', TO_DATE('2024-03-01', 'YYYY-MM-DD'), 0.08, 'Ave', 'Canario Belga', NULL, 'MC-6677889900', 3);


-- ----------------------------------------------------------------------------
-- 5. T_CLYVO_ENDERECO_RESPONSAVEL (depende de RESPONSAVEL, relação 1:1)
-- ----------------------------------------------------------------------------
-- Endereço do Responsável 1
INSERT INTO T_CLYVO_ENDERECO_RESPONSAVEL (pais, estado, cidade, bairro, logradouro, nr_rua, complemento, cep, id_responsavel) VALUES ('Brasil', 'PR', 'Curitiba', 'Batel', 'Rua Comendador Araujo', '500', 'Apto 21', '80420-000', 1);
 
-- Endereço do Responsável 2 (Responsável 3 fica propositalmente sem endereço, simulando cadastro incompleto)
INSERT INTO T_CLYVO_ENDERECO_RESPONSAVEL (pais, estado, cidade, bairro, logradouro, nr_rua, complemento, cep, id_responsavel) VALUES ('Brasil', 'RS', 'Porto Alegre', 'Moinhos de Vento', 'Rua Padre Chagas', '88', 'Casa', '90570-080', 2);
 
-- ----------------------------------------------------------------------------
-- 6. T_CLYVO_ENDERECO_CLINICA (depende de CLINICA, relação 1:N)
-- ----------------------------------------------------------------------------
-- Sede da Clínica 1
INSERT INTO T_CLYVO_ENDERECO_CLINICA (pais, estado, cidade, bairro, logradouro, nr_rua, complemento, cep, id_clinica) VALUES ('Brasil', 'PR', 'Curitiba', 'Centro', 'Rua XV de Novembro', '700', 'Loja 3', '80020-310', 1);
 
-- Filial da MESMA Clínica 1 -- demonstra a cardinalidade 1:N validada
INSERT INTO T_CLYVO_ENDERECO_CLINICA (pais, estado, cidade, bairro, logradouro, nr_rua, complemento, cep, id_clinica) VALUES ('Brasil', 'PR', 'Sao Jose dos Pinhais', 'Centro', 'Av. Rui Barbosa', '1200', 'Sala 5', '83005-100', 1);
 
-- Sede da Clínica 2
INSERT INTO T_CLYVO_ENDERECO_CLINICA (pais, estado, cidade, bairro, logradouro, nr_rua, complemento, cep, id_clinica) VALUES ('Brasil', 'RS', 'Porto Alegre', 'Cidade Baixa', 'Av. Joao Pessoa', '250', 'Terreo', '90040-000', 2);
 
-- ============================================================================
-- NÍVEL 2 — dependem de DUAS entidades fortes, ou de uma entidade de Nível 1
-- ============================================================================
 
-- ----------------------------------------------------------------------------
-- 7. T_CLYVO_CLINICA_VET (depende de VET e CLINICA, vínculo opcional)
-- ----------------------------------------------------------------------------
-- Clínica 1 (Amigo Fiel) possui 2 veterinários
INSERT INTO T_CLYVO_CLINICA_VET (id_veterinario, id_clinica) VALUES (1, 1);
INSERT INTO T_CLYVO_CLINICA_VET (id_veterinario, id_clinica) VALUES (2, 1);
 
-- Clínica 2 (PetSaude 24h) possui 1 veterinário, que também atende na Clínica 1
INSERT INTO T_CLYVO_CLINICA_VET (id_veterinario, id_clinica) VALUES (1, 2);
 
-- Veterinária 3 (Dra. Patricia Gomes) atende de forma autônoma/domiciliar, sem clínica fixa
INSERT INTO T_CLYVO_CLINICA_VET (id_veterinario, id_clinica) VALUES (3, NULL);
 
-- ----------------------------------------------------------------------------
-- 8. T_CLYVO_ENDERECO_ANIMAL (depende de ANIMAL, relação 1:1 opcional)
-- ----------------------------------------------------------------------------
-- Endereço do Animal 1 (mesmo endereço do tutor, cadastrado separadamente)
INSERT INTO T_CLYVO_ENDERECO_ANIMAL (pais, estado, cidade, bairro, logradouro, nr_rua, complemento, cep, id_animal) VALUES ('Brasil', 'PR', 'Curitiba', 'Batel', 'Rua Comendador Araujo', '500', 'Apto 21', '80420-000', 1);
 
-- Endereço do Animal 3 (propriedade rural, nr_rua alfanumérico)
INSERT INTO T_CLYVO_ENDERECO_ANIMAL (pais, estado, cidade, bairro, logradouro, nr_rua, complemento, cep, id_animal) VALUES ('Brasil', 'GO', 'Rio Verde', 'Zona Rural', 'Estrada da Fazenda Sao Jose', 'S/N KM 8', 'Sitio', '75901-970', 3);
 
-- ----------------------------------------------------------------------------
-- 9. T_CLYVO_VACINACAO (depende de ANIMAL)
-- ----------------------------------------------------------------------------
-- Vacina Anti-rábica efetuada no prazo para o Animal 1 (Nina)
INSERT INTO T_CLYVO_VACINACAO (nm_vacina, dt_vacinacao_prevista, dt_vacinacao_efetuada, st_vacinacao, id_animal) VALUES ('Raiva', TO_DATE('2026-02-01', 'YYYY-MM-DD'), TO_DATE('2026-02-01', 'YYYY-MM-DD'), 'EFETUADA', 1);
 
-- Vacina V8 ainda pendente (data efetuada nula) para o Animal 1 (Nina)
INSERT INTO T_CLYVO_VACINACAO (nm_vacina, dt_vacinacao_prevista, dt_vacinacao_efetuada, st_vacinacao, id_animal) VALUES ('V8', TO_DATE('2026-10-15', 'YYYY-MM-DD'), NULL, 'PENDENTE', 1);
 
-- Vacina Giardia atrasada (data prevista já passou, ainda não efetuada) para o Animal 2 (Fred)
INSERT INTO T_CLYVO_VACINACAO (nm_vacina, dt_vacinacao_prevista, dt_vacinacao_efetuada, st_vacinacao, id_animal) VALUES ('Giardia', TO_DATE('2026-05-01', 'YYYY-MM-DD'), NULL, 'ATRASADA', 2);
 
-- Vacina Influenza Equina efetuada para o Animal 3 (Trovao)
INSERT INTO T_CLYVO_VACINACAO (nm_vacina, dt_vacinacao_prevista, dt_vacinacao_efetuada, st_vacinacao, id_animal) VALUES ('Influenza Equina', TO_DATE('2026-01-20', 'YYYY-MM-DD'), TO_DATE('2026-01-22', 'YYYY-MM-DD'), 'EFETUADA', 3);
 
-- Vacina cancelada por contraindicacao clinica para o Animal 4 (Amarelinho)
INSERT INTO T_CLYVO_VACINACAO (nm_vacina, dt_vacinacao_prevista, dt_vacinacao_efetuada, st_vacinacao, id_animal) VALUES ('Poliomavirus Aviario', TO_DATE('2026-04-05', 'YYYY-MM-DD'), NULL, 'CANCELADA', 4);
 
-- ----------------------------------------------------------------------------
-- 10. T_CLYVO_CONSULTA (depende de VET e ANIMAL)
-- ----------------------------------------------------------------------------
-- Consulta já realizada para o Animal 1 (Nina), atendida pelo Vet 1
INSERT INTO T_CLYVO_CONSULTA (historico_consulta, st_consulta, dt_consulta, id_vet, id_animal) VALUES ('Avaliacao de rotina, animal saudavel', 'PASSADA', TO_DATE('2026-04-12', 'YYYY-MM-DD'), 1, 1);
 
-- Consulta em andamento no momento para o Animal 3 (Trovao), atendida pelo Vet 2
INSERT INTO T_CLYVO_CONSULTA (historico_consulta, st_consulta, dt_consulta, id_vet, id_animal) VALUES ('Avaliacao de claudicacao em membro dianteiro', 'EM_ANDAMENTO', TO_DATE('2026-08-20', 'YYYY-MM-DD'), 2, 3);
 
-- Consulta futura agendada para o Animal 2 (Fred), atendida pelo Vet 1
INSERT INTO T_CLYVO_CONSULTA (historico_consulta, st_consulta, dt_consulta, id_vet, id_animal) VALUES ('Retorno para avaliacao dermatologica', 'FUTURA', TO_DATE('2026-09-10', 'YYYY-MM-DD'), 1, 2);
 
-- Consulta cancelada pelo tutor para o Animal 4 (Amarelinho), atendida pela Vet 3 (autonoma)
INSERT INTO T_CLYVO_CONSULTA (historico_consulta, st_consulta, dt_consulta, id_vet, id_animal) VALUES ('Consulta de rotina cancelada pelo tutor', 'CANCELADA', TO_DATE('2026-07-15', 'YYYY-MM-DD'), 3, 4);
 
-- ============================================================================
-- NÍVEL 3 — dependem de uma entidade que já depende de outras (2º grau)
-- ============================================================================
 
-- ----------------------------------------------------------------------------
-- 11. T_CLYVO_PRESCRICAO (depende de CONSULTA, que já depende de VET+ANIMAL)
-- ----------------------------------------------------------------------------
-- Prescrição vinculada à consulta 1 (já realizada), com observações preenchidas
INSERT INTO T_CLYVO_PRESCRICAO (dt_emissao, dt_expiracao, observacoes_gerais, id_consulta) VALUES (TO_DATE('2026-04-12', 'YYYY-MM-DD'), TO_DATE('2026-04-26', 'YYYY-MM-DD'), 'Administrar apos as refeicoes, retornar em 14 dias', 1);
 
-- Prescrição vinculada à consulta 2 (em andamento), SEM observações -- campo opcional
INSERT INTO T_CLYVO_PRESCRICAO (dt_emissao, dt_expiracao, observacoes_gerais, id_consulta) VALUES (TO_DATE('2026-08-20', 'YYYY-MM-DD'), TO_DATE('2026-08-27', 'YYYY-MM-DD'), NULL, 2);
 
-- ============================================================================
-- NÍVEL 4 — a entidade mais fraca da cadeia (depende de PRESCRICAO, que depende
-- de CONSULTA, que depende de VET+ANIMAL, que depende de RESPONSAVEL)
-- ============================================================================
 
-- ----------------------------------------------------------------------------
-- 12. T_CLYVO_MEDICAMENTO (depende de PRESCRICAO)
-- ----------------------------------------------------------------------------
-- Primeiro medicamento da Prescrição 1, forma solida
INSERT INTO T_CLYVO_MEDICAMENTO (nm_medicamento, qt_medicamento, qt_dias, vl_dose, un_dose, qt_frequencia, un_frequencia, forma_farmaceutica, id_prescricao) VALUES ('Amoxicilina', 20, 10, 250.00, 'mg', 12, 'horas', 'SOLIDA', 1);
 
-- Segundo medicamento da MESMA Prescrição 1, forma liquida -- confirma o 1:N
INSERT INTO T_CLYVO_MEDICAMENTO (nm_medicamento, qt_medicamento, qt_dias, vl_dose, un_dose, qt_frequencia, un_frequencia, forma_farmaceutica, id_prescricao) VALUES ('Meloxicam Suspensao Oral', 1, 5, 0.10, 'mg/kg', 24, 'horas', 'LIQUIDA', 1);
 
-- Medicamento da Prescrição 2, forma semi-solida (pomada topica)
INSERT INTO T_CLYVO_MEDICAMENTO (nm_medicamento, qt_medicamento, qt_dias, vl_dose, un_dose, qt_frequencia, un_frequencia, forma_farmaceutica, id_prescricao) VALUES ('Pomada Cicatrizante', 1, 7, 2.00, 'cm', 8, 'horas', 'SEMI_SOLIDA', 2);
 