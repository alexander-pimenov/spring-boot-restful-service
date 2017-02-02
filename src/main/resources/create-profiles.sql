begin;

CREATE TABLE profiles
(
  id serial NOT NULL,
  first_name character varying(50) NOT NULL,
  last_name character varying(50) NOT NULL,
  CONSTRAINT profile_id_pk PRIMARY KEY (id)
);

insert into profiles (first_name, last_name) values ('Иван', 'Петров');

commit;