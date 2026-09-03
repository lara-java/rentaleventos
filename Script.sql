create database rental;

create table funcionario(
id serial primary key,
nome varchar(80) NOT NULL,
cargo varchar(50) NOT NULL,
cpf char(11),
data_nascimento date
);

create table cliente(
id serial primary key,
nome varchar(80) NOT NULL,
cpf char(11) NOT NULL,
email varchar(80) NOT NULL,
data_nascimento date, 
senha char(8)
);

create table equipamentos(
id serial primary key,
modelo varchar(50),
marca varchar(50),
categoria varchar(50),
petencia varchar(50),
material varchar(50),
peso decimal(5,2),
altura decimal(3,2),
largura decimal(5,2),
comprimento decimal(7,2),
cor varchar(30),
potencia int,
quantidade_disponivel int
);

create table historico(
id serial primary key,
id_movimentacao int,
foreign key (id_movimentacao)
	references movimentacao(id)
);

create table movimentacao (
id serial primary key, 
data_saida date NOT NULL,
data_entrada date NOT NULL,
tipo_movimentacao varchar(50),
id_funcionario int,
foreign key (id_funcionario)
	references funcionario(id),
id_equipamentos int,
foreign key (id_equipamentos)
	references equipamentos(id)
);
create table estoque(
id serial primary key,
quantidade_pecas int,
id_equipamentos int,
foreign key (id_equipamentos)
	references equipamentos(id)
);

create table alerta(
id serial primary key,
data date NOT NULL,
quantidade_minima int
);

INSERT INTO funcionario (id, nome, cargo, cpf, data_nascimento)
VALUES
(1, 'Carlos Silva', 'Gerente', '12345678901', '1985-05-10'),
(2, 'Mariana Souza', 'Atendente', '23456789012', '1990-08-20'),
(3, 'João Oliveira', 'Técnico', '34567890123', '1988-03-15');

select * from funcionario f;

INSERT INTO cliente (id, nome, cpf, email, data_nascimento, senha)
VALUES
(1, 'Ana Santos', '45678901234', 'ana@email.com', '1995-01-12', 'ana12345'),
(2, 'Pedro Costa', '56789012345', 'pedro@email.com', '1992-06-25', 'pedro123'),
(3, 'Lucas Ferreira', '67890123456', 'lucas@email.com', '1998-11-03', 'lucas123');

select * from cliente;


INSERT INTO equipamentos
(id, modelo, marca, categoria, potencia, material, peso, altura, largura, comprimento, cor, quantidade_disponivel)
VALUES
(1, 'PowerLite X49', 'Epson', 'Projetor', 3600, 'Plástico', 2.70, 0.087, 0.302, 0.237, 'Branco', 5),
(2, 'PartyBox 710', 'JBL', 'Caixa de Som', 800, 'Plástico', 7.00, 0.399, 0.310, 0.399, 'Preto', 8),
(3, 'SM58', 'Shure', 'Microfone', 0, 'Metal', 0.30, 0.162, 0.051, 0.051, 'Prata', 15),
(4, 'Mesa Dobrável 1,80m', 'Mor', 'Mesa', 0, 'Plástico', 2.50, 0.740, 0.760, 1.800, 'Branco', 20),
(5, 'Tiffany', 'N/A', 'Cadeira', 0, 'Plástico', 4.00, 0.920, 0.400, 0.450, 'Branco', 50);

select * from equipamentos;

INSERT INTO movimentacao (data_saida, data_entrada, tipo_movimentacao, id_funcionario, id_equipamentos)
VALUES
('2026-09-01', '2026-09-03', 'Saída para locação', 1, 1), 
('2026-09-02', '2026-09-05', 'Saída para locação', 2, 2), 
('2026-09-03', '2026-09-06', 'Devolução', 3, 3);

select * from movimentacao;

INSERT INTO historico
(id, id_movimentacao)
VALUES 
(1, 1), 
(2, 2), 
(3, 3);

select * from historico;

INSERT INTO estoque
(quantidade_pecas, id_equipamentos)
VALUES
(5, 1),
(8, 2),
(15, 3);

select * from estoque;

INSERT INTO alerta 
(data, quantidade_minima) 
values
('2026-09-01', 2),
('2026-09-02', 3), 
('2026-09-03', 5);

select * from alerta;





