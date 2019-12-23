CREATE TABLE "FUNCIONARIO"(
 "IDFUNCIONARIO" bigint auto_increment,
 "NOME" varchar(30) NOT NULL,
 "SOBRENOME" varchar(50) NOT NULL,
 "EMAIL" varchar(300) NOT NULL,
 "NUMERONIS" varchar(11) NOT NULL
);

ALTER TABLE "FUNCIONARIO" ADD PRIMARY KEY ("IDFUNCIONARIO");

INSERT INTO "FUNCIONARIO" ("NOME", "SOBRENOME", "EMAIL", "NUMERONIS") VALUES
	('Cristian', 'Urbainski', 'cristianurbainskips@gmail.com', '12082966749'),
	('Jocimar',  'Ortigara',  'jocimar.ortigara@gmail.com',    '12082871462'),
	('Andre',    'Cesari',    'andre.cesari@gmail.com',        '12053371694'),
	('Roberto',  'Zonta',     'betozonta@gmail.com',           '12031225431');