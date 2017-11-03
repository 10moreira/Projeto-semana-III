CREATE TABLE cursos
(
  id serial NOT NULL,
  nomecurso character varying(50) NOT NULL,
  periodo character(20) NOT NULL,
  CONSTRAINT cursos_pkey PRIMARY KEY (id)
);


CREATE TABLE disciplina
(
  id serial NOT NULL,
  nomedisciplina character varying(50) NOT NULL,
  cargahoraria character varying(20) NOT NULL,
  numerodevagas integer NOT NULL,
  curso integer NOT NULL,
  CONSTRAINT disciplina_pkey PRIMARY KEY (id)
);
  

ALTER TABLE disciplina ADD CONSTRAINT curso FOREIGN KEY (id) REFERENCES cursos (id);




insert into cursos (nomecurso, periodo) values 
                    ('Sistemas de Informação','Noturno') , 
                    ('Zootecnia','Matutino');

insert into disciplina (nomedisciplina, cargahoraria, numerodevagas, curso) values
    ('Programação 1','100 horas', 30, 1),
    ('Gado de Corte 2', '80 horas', 25, 2);



select * from cursos;

select * from disciplina;



drop table cursos;

drop table disciplina;
