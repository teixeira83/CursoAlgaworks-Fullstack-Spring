CREATE TABLE pessoa(
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    ativo tinyint(1),
    logradouro VARCHAR(100),
    numero VARCHAR(10),
    complemento VARCHAR(100),
    bairro VARCHAR(100),
    cep VARCHAR(10),
    cidade VARCHAR(50),
    estado VARCHAR(3)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado)
            values ('Rafael',0 ,'Rua A','11','casa 2','Campos','21542-524','Campos','RJ');

INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado)
            values ('Laryssa',1 ,'Rua B','12','casa 3','Campos','21542-524','Campos','RJ');

INSERT INTO pessoa (nome,ativo)
            values ('Lula',0 );

INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado)
            values ('Bolsonaro',1 ,'Rua C','211','casa 4','Campos','21542-524','Campos','RJ');

INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado)
            values ('Algaworks',0 ,'Rua A','11','casa 2','Campos','21542-524','Campos','RJ');

INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado)
            values ('Gel',1 ,'Rua N','11','casa 2','Campos','21542-524','Campos','RJ');
