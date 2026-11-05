<div align="center">

# 🐾 Clyvo — Java Advanced ☕

**Sistema de gestão da operação de clínicas e veterinários**
Challenge FIAP 2026 em parceria com a **Clyvo Vet** · Sprint 4

[![Vídeo](https://img.shields.io/badge/▶_Vídeo-YouTube-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](COLOQUE_AQUI_O_LINK_DO_VIDEO)
[![Aplicação](https://img.shields.io/badge/Aplicação_no_ar-Render-46E3B7?style=for-the-badge&logo=render&logoColor=black)](https://clyvo-java.onrender.com)

![Java](https://img.shields.io/badge/Java_21-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_4-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=flat-square&logo=oracle&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=flat-square&logo=thymeleaf&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white)

</div>

---

## 🔗 Links

| Item | Link |
|---|---|
| **Vídeo de apresentação** | [Assistir no Drive](https://drive.google.com/file/d/1rCy8p1GDnpMY0oaZ4v0zU0jqtDg3h5WN/view) |
| **Aplicação publicada (Render)** | [clyvo-java.onrender.com](https://clyvo-java.onrender.com) |

> A aplicação está no plano gratuito do Render. Se ninguém acessar por 15 minutos, ela dorme e o primeiro acesso leva cerca de 1 minuto para carregar.

---

## 🔑 Acesso de teste

| Perfil | E-mail | Senha |
|---|---|---|
| Clínica | `contato@amigofiel.com` | `senha123` |
| Clínica | `contato@petsaude24h.com` | `senha123` |
| Veterinário | `camila@email.com` | `senha123` |
| Veterinário | `bruno@email.com` | `senha123` |
| Veterinário | `patricia@email.com` | `senha123` |

---

## 🐕 Desafio e solução

A falta de recorrência dos responsáveis em consultas de check-up pode agravar casos de determinadas doenças. Sem dados para se basear, os responsáveis têm dificuldade para entender o contexto de saúde do animal.

Nossa plataforma tem uma base de dados unificada que permite a gestão das atividades da clínica e do veterinário, com os principais indicadores de saúde pública e informações de desempenho de cada um. Esses indicadores ajudam veterinários e clínicas a melhorar seus serviços e a personalizar os avisos e lembretes enviados aos responsáveis.

---

## ✨ Funcionalidades

Projeto pensado para clínicas e veterinários associados à Clyvo.

**🏥 Clínica**
- Login próprio
- Edição dos dados do perfil
- Lista dos veterinários contratados
- Associação de um novo veterinário

**🩺 Veterinário**
- Login próprio
- Edição dos dados do perfil
- Lista das consultas
- Detalhes e edição dos responsáveis atendidos
- Cadastro, detalhes e edição dos animais

**🔒 Segurança**
- Cada perfil só acessa as próprias páginas (Spring Security com perfis `CLINICA` e `VETERINARIO`)
- Senhas armazenadas com BCrypt

---

## 🛠️ Tecnologias

| Camada | Tecnologia |
|---|---|
| Linguagem | Java 21 |
| Framework | Spring Boot 4 (Spring MVC, Spring Data JPA, Validation) |
| Segurança | Spring Security |
| Telas | Thymeleaf + Bootstrap |
| Banco de dados | Oracle (FIAP) com Hibernate |
| Migrações | Flyway |
| Build | Maven |
| Deploy | Docker + Render |

---

## 🗄️ Banco de dados

O projeto usa o **Oracle da FIAP**. As tabelas são criadas e populadas automaticamente pelo **Flyway** na primeira execução:

| Migração | O que faz |
|---|---|
| `V1__criacao_tabelas.sql` | Cria as 13 tabelas (prefixo `T_CLYVO4_`) |
| `V2__criacao_constraints.sql` | Cria as chaves únicas e estrangeiras |
| `V3__insercao_dados.sql` | Insere os dados de exemplo (clínicas, veterinários, animais, consultas…) |

O histórico das migrações fica na tabela `FLYWAY_HISTORY_CLYVO4`.

---

## 🚀 Como rodar

### Pré-requisitos

- Java 21
- Acesso ao Oracle da FIAP (usuário e senha)

### 1. Crie o arquivo `.env`

Na raiz do projeto (mesmo nível do `pom.xml`):

```env
SPRING_DATASOURCE_USERNAME=SEU_RM
SPRING_DATASOURCE_PASSWORD=SUA_SENHA
```

O `.env` está no `.gitignore` e não vai para o GitHub. A URL do banco (`oracle.fiap.com.br:1521/ORCL`) já vem configurada no `application.properties`.

### 2. Rode a aplicação

```bash
./mvnw spring-boot:run
```

Acesse http://localhost:8080 e entre com um dos usuários de teste.

### Deploy no Render

O projeto tem um `Dockerfile` de dois estágios (build com Maven e execução com JRE 21). No Render, o serviço é do tipo **Docker**, com as variáveis `SPRING_DATASOURCE_USERNAME` e `SPRING_DATASOURCE_PASSWORD`. A porta é lida da variável `PORT`.

---

## 🧱 Arquitetura

```text
src/main/
├── java/com/example/clyvo_challenge3/
│   ├── config/        # Spring Security (rotas por perfil e login)
│   ├── controller/    # Recebe as requisições e monta as páginas
│   ├── dto/           # Dados dos formulários de edição e login
│   ├── model/         # Entidades JPA
│   ├── repository/    # Acesso ao banco (Spring Data JPA)
│   └── service/       # Regras de acesso e carregamento do usuário logado
└── resources/
    ├── db/migration/  # Scripts do Flyway (V1, V2, V3)
    ├── templates/     # Páginas Thymeleaf
    └── application.properties
```

---

## 👥 Integrantes

| RM | Nome | Turma |
|---|---|---|
| RM561713 | Eduardo Batista Locaspi | 2TDSPI |
| RM565799 | Leticia Santiago e Silva | 2TDSPW |
| RM565698 | Liana Lyumi Morisita Fujisima | 2TDSPI |
| RM561833 | Victor Alves Lopes | 2TDSPI |
