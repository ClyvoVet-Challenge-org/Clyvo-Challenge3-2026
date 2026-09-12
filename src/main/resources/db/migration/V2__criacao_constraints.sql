    alter table T_CLYVO_ANIMAL 
       add constraint UKolwsnmlj7k8gwhm3vofmaxngb unique (nr_microchip_animal);
 
    alter table T_CLYVO_ANIMAL 
       add constraint UK952w1ec26cufhltkpwfoo1qh8 unique (rg_animal);
 
    alter table T_CLYVO_CLINICA 
       add constraint UKlsq2cv62dwfrwbary2y84d18 unique (cnpj_clinica);
 
    alter table T_CLYVO_CLINICA 
       add constraint UK6lc0udrpr1o7murxoaine1ifx unique (email);
 
    alter table T_CLYVO_ENDERECO_ANIMAL 
       add constraint UKo9mg6qgmlss06wwpsh88i3mx5 unique (id_animal);
 
    alter table T_CLYVO_ENDERECO_RESPONSAVEL 
       add constraint UK6jmnb05ihfv7uqv0tyy8hg4kk unique (id_responsavel);
 
    alter table T_CLYVO_PRESCRICAO 
       add constraint UK7ta8xxqvrrwjy0oin012psqcp unique (id_consulta);
 
    alter table T_CLYVO_RESPONSAVEL 
       add constraint UKks3avx5ouew0jqymo34bxpcoj unique (cpf_responsavel);
 
    alter table T_CLYVO_VET 
       add constraint UKtrfema6ol4ax1s1c7cy8uy3fn unique (cpf_vet);
 
    alter table T_CLYVO_VET 
       add constraint UKsfupmhmhc63qm6bqpljkwwtxa unique (crmv_vet);
 
    alter table T_CLYVO_VET 
       add constraint UKjwckmapf92yt9ey5yvul2dmk4 unique (email);
 
    alter table usuario 
       add constraint UKxr8tyld4kg1dxdkrk4y78y0p unique (id_clinica);
 
    alter table usuario 
       add constraint UKf0r6elyiwkeuid0huop07y717 unique (id_veterinario);
 
    alter table T_CLYVO_ANIMAL 
       add constraint FK753jx75gq8pn19o9jux1dk0l3 
       foreign key (id_responsavel) 
       references T_CLYVO_RESPONSAVEL (id_responsavel);
 
    alter table T_CLYVO_CLINICA_VET 
       add constraint FKqr5qg1ohjb00nia21b26wctq 
       foreign key (id_clinica) 
       references T_CLYVO_CLINICA (id_clinica);
 
    alter table T_CLYVO_CLINICA_VET 
       add constraint FKm8yy8mxcoutoij71tjtdvx69n 
       foreign key (id_veterinario) 
       references T_CLYVO_VET (id_vet);
 
    alter table T_CLYVO_CONSULTA 
       add constraint FK6h6sdvdty6xdy5wrp3kne5e3j 
       foreign key (id_animal) 
       references T_CLYVO_ANIMAL (id_animal);
 
    alter table T_CLYVO_CONSULTA 
       add constraint FK9xu8rpv3tqbcoohnxe852xqvc 
       foreign key (id_vet_cli) 
       references T_CLYVO_CLINICA_VET (id_clinica_vet);
 
    alter table T_CLYVO_ENDERECO_ANIMAL 
       add constraint FKjiqe64bytk6hnxapr07ndjrnt 
       foreign key (id_animal) 
       references T_CLYVO_ANIMAL (id_animal);
 
    alter table T_CLYVO_ENDERECO_CLINICA 
       add constraint FKrbjfaekqw0acpexw4btbo66xn 
       foreign key (id_clinica) 
       references T_CLYVO_CLINICA (id_clinica);
 
    alter table T_CLYVO_ENDERECO_RESPONSAVEL 
       add constraint FKl7a5qls9864d9g1sfec6fk1ax 
       foreign key (id_responsavel) 
       references T_CLYVO_RESPONSAVEL (id_responsavel);
 
    alter table T_CLYVO_MEDICAMENTO 
       add constraint FKmmq1y355hnnb38lfpxw256tmu 
       foreign key (id_prescricao) 
       references T_CLYVO_PRESCRICAO (id_prescricao);
 
    alter table T_CLYVO_PRESCRICAO 
       add constraint FKlr5f3mo5n7uls11fpfwjrfqvt 
       foreign key (id_consulta) 
       references T_CLYVO_CONSULTA (id_consulta);
 
    alter table T_CLYVO_VACINACAO 
       add constraint FKf1magpcwv8njj60gqb2m12l71 
       foreign key (id_animal) 
       references T_CLYVO_ANIMAL (id_animal);
 
    alter table usuario 
       add constraint FK41xj4p3xejpvkibl90g461m0j 
       foreign key (id_clinica) 
       references T_CLYVO_CLINICA (id_clinica);
 
    alter table usuario 
       add constraint FK2lye1amyxhm1agj11o5kk36w8 
       foreign key (id_veterinario) 
       references T_CLYVO_VET (id_vet);