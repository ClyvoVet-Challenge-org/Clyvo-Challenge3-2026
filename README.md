# Challenge 3 - Projeto Clyvo

Sistema de gestão da operação de clínicas e veterinários.

Link Vídeo: [https://youtu.be/Wt7WvxqQm9o](https://youtu.be/Wt7WvxqQm9o)

## Integrantes
* Eduardo Batista Locaspi - RM561713 - 2TDSPI
* Victor Alves Lopes - RM561833 - 2TDSPI
* Liana Lyumi Morisita Fujisima - RM565698 - 2TDSPI
* Letícia Santiago e Silva - RM565799 - 2TDSPW

## Desafio apresentado (e solução)

A falta de recorrência de responsáveis em consultas de check-up pode acabar agravando casos de determinadas doenças. Para ser mais preciso, os responsáveis podem ter dificuldades para analisar o contexto quando não possuem dados para se basear.

Nossa plataforma possui uma base de dados unificada que permite a gestão das atividades tanto da clínica quanto do veterinário, apresentando os principais indicadores e métricas de saúde pública, além de informações relacionadas ao desempenho do veterinário ou da clínica.

Dessa forma, os indicadores podem auxiliar veterinários e clínicas a melhorarem seus serviços e a personalizarem os avisos e lembretes enviados aos responsáveis.

## Funcionalidades

Esse é um projeto pensado para clínicas e veterinários associados à empresa Clyvo. O sistema permite:

* Autenticação de Clínicas;
* Autenticação de Veterinários;
* Edição dos dados de perfil da Clínica logada;
* Edição dos dados de perfil do Veterinário logado;
* Visualização dos veterinários contratados pela Clínica logada;
* Associação de um novo veterinário a uma Clínica logada;
* Visualização das consultas do Veterinário logado.

## Dependências e Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring MVC
* Spring Security
* Flyway
* Thymeleaf
* MySQL JDBC Driver
* Validation
* Bootstrap
* Spring Data JPA
* Hibernate
* Maven

## Configuração do Banco de Dados

O projeto utiliza o **MySQL**. Antes de executar a aplicação, é necessário criar o schema e configurar o usuário e a senha do banco de dados.

### 1. Criação do Schema

No MySQL, execute:

```sql
CREATE DATABASE clyvo_db;
```

### 2.  Crie um arquivo `.env` na raiz do projeto (mesmo nível do `pom.xml`), com o seguinte conteúdo:
   ```env
   SPRING_DATASOURCE_URL=jdbc:mysql://127.0.0.1:3306/clyvo_db
   SPRING_DATASOURCE_USERNAME=SEU_USUARIO
   SPRING_DATASOURCE_PASSWORD=SUA_SENHA
   ```
Substitua:

* `SEU_USUARIO` pelo usuário do MySQL;
* `SUA_SENHA` pela senha do usuário do MySQL.

### 3. Rode a aplicação:
   ```bash
   mvn spring-boot:run
   ```

## Arquitetura do Projeto

```text
src/
└── main/
    ├── java/
    │   └── com/example/clyvo_challenge3/
    │       ├── config/
    │       ├── controller/
    │       ├── model/
    │       └── repository/
    │
    └── resources/
        ├── static/
        ├── templates/
        └── application.properties
```

* **config/** → configurações do Spring Security.
* **controller/** → recebe as requisições e controla as páginas.
* **model/** → entidades do sistema.
* **repository/** → acesso aos dados do banco.
* **templates/** → páginas HTML utilizando Thymeleaf.
* **static/** → arquivos CSS, JavaScript e imagens.
* **application.properties** → configurações da aplicação e do banco de dados.
