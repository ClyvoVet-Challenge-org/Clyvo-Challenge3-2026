    create table T_CLYVO_ANIMAL (
        dt_nascimento_animal date not null,
        peso_animal decimal(5,2) not null,
        id_animal bigint not null auto_increment,
        id_responsavel bigint not null,
        nr_microchip_animal varchar(20),
        rg_animal varchar(20),
        especie_animal varchar(50) not null,
        raca_animal varchar(50) not null,
        nm_animal varchar(100) not null,
        primary key (id_animal)
    )  engine=InnoDB;
 
    create table T_CLYVO_CLINICA (
        id_clinica bigint not null auto_increment,
        cnpj_clinica varchar(20) not null,
        email varchar(100) not null,
        nm_clinica varchar(100) not null,
        senha varchar(255) not null,
        st_contrato enum ('ATIVO','INATIVO') not null,
        primary key (id_clinica)
    )  engine=InnoDB;
 
    create table T_CLYVO_CLINICA_VET (
        id_clinica bigint not null,
        id_clinica_vet bigint not null auto_increment,
        id_veterinario bigint not null,
        primary key (id_clinica_vet)
    )  engine=InnoDB;
 
    create table T_CLYVO_CONSULTA (
        dt_consulta date not null,
        id_animal bigint not null,
        id_consulta bigint not null auto_increment,
        id_vet_cli bigint not null,
        historico_consulta varchar(200) not null,
        st_consulta enum ('CANCELADA','EM_ANDAMENTO','FUTURA','PASSADA') not null,
        primary key (id_consulta)
    )  engine=InnoDB;
 
    create table T_CLYVO_ENDERECO_ANIMAL (
        id bigint not null auto_increment,
        id_animal bigint not null,
        cep varchar(9) not null,
        nr_rua varchar(15) not null,
        bairro varchar(20) not null,
        cidade varchar(20) not null,
        complemento varchar(20),
        estado varchar(20) not null,
        pais varchar(20) not null,
        logradouro varchar(50) not null,
        primary key (id)
    )  engine=InnoDB;
 
    create table T_CLYVO_ENDERECO_CLINICA (
        id bigint not null auto_increment,
        id_clinica bigint not null,
        cep varchar(9) not null,
        nr_rua varchar(15) not null,
        bairro varchar(20) not null,
        cidade varchar(20) not null,
        complemento varchar(20),
        estado varchar(20) not null,
        pais varchar(20) not null,
        logradouro varchar(50) not null,
        primary key (id)
    )  engine=InnoDB;
 
    create table T_CLYVO_ENDERECO_RESPONSAVEL (
        id bigint not null auto_increment,
        id_responsavel bigint not null,
        cep varchar(9) not null,
        nr_rua varchar(15) not null,
        bairro varchar(20) not null,
        cidade varchar(20) not null,
        complemento varchar(20),
        estado varchar(20) not null,
        pais varchar(20) not null,
        logradouro varchar(50) not null,
        primary key (id)
    )  engine=InnoDB;
 
    create table T_CLYVO_MEDICAMENTO (
        qt_dias integer not null check ((qt_dias>=1)),
        qt_frequencia integer not null check ((qt_frequencia>=1)),
        qt_medicamento integer not null check ((qt_medicamento>=1)),
        vl_dose decimal(5,2) not null,
        id bigint not null auto_increment,
        id_prescricao bigint not null,
        un_dose varchar(20) not null,
        un_frequencia varchar(20) not null,
        nm_medicamento varchar(100) not null,
        forma_farmaceutica enum ('LIQUIDA','SEMI_SOLIDA','SOLIDA') not null,
        primary key (id)
    )  engine=InnoDB;
  
    create table T_CLYVO_PRESCRICAO (
        dt_emissao date not null,
        dt_expiracao date not null,
        id_consulta bigint not null,
        id_prescricao bigint not null auto_increment,
        observacoes_gerais varchar(255),
        primary key (id_prescricao)
    )  engine=InnoDB;
   
    create table T_CLYVO_RESPONSAVEL (
        id_responsavel bigint not null auto_increment,
        cpf_responsavel varchar(14) not null,
        nr_telefone_responsavel varchar(20) not null,
        ds_email varchar(100) not null,
        nm_responsavel varchar(100) not null,
        primary key (id_responsavel)
    )  engine=InnoDB;
   
    create table T_CLYVO_VACINACAO (
        dt_vacinacao_efetuada date,
        dt_vacinacao_prevista date not null,
        id_animal bigint not null,
        id_vacinacao bigint not null auto_increment,
        nm_vacina varchar(40) not null,
        st_vacinacao enum ('ATRASADA','CANCELADA','EFETUADA','PENDENTE') not null,
        primary key (id_vacinacao)
    )  engine=InnoDB;
   
    create table T_CLYVO_VET (
        id_vet bigint not null auto_increment,
        cpf_vet varchar(14) not null,
        crmv_vet varchar(20) not null,
        email varchar(100) not null,
        nm_vet varchar(100) not null,
        senha varchar(255) not null,
        primary key (id_vet)
    )  engine=InnoDB;
    
    create table usuario (
        id bigint not null auto_increment,
        id_clinica bigint,
        id_veterinario bigint,
        senha varchar(255),
        username varchar(255),
        tipo enum ('CLINICA','VETERINARIO'),
        primary key (id)
    )  engine=InnoDB;