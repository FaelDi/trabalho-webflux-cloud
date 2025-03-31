The following work was done by the student Rafael Dias Ferreira, using Spring Boot, WebFlux, and Spring Cloud Circuit Breaker.

The purpose of the work is to use event publishing when a client receives a deposit above 20,000 reais, so that their manager can see that the client has available income and can act by offering some promotion, thus providing the best CRM direction.

Below are the DDLs for table creation:

CREATE TABLE public.eventos (
  id int8 NOT NULL GENERATED ALWAYS AS IDENTITY,
  cliente varchar NULL,
  saldo_atual float8 NULL,
  saldo_anterior float8 NULL,
  valor_recebido float8 NULL,
  "data" varchar NULL
);

CREATE TABLE public.contas (
  id int4 NOT NULL GENERATED ALWAYS AS IDENTITY,
  agencia int4 NOT NULL,
  conta int4 NOT NULL,
  cliente varchar NOT NULL,
  saldo float8 NOT NULL
);
