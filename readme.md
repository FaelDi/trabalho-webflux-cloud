o Trabalho a seguir foi feito pelo aluno Rafael Dias Ferreira, utilizando
spring boot, webflux, sprind cloud circuit break


O proposito do trabalho é utilizar da publicação de eventos quando um cliente receber um aporte acima de 20mil reais
pois assim o seu gerente conseguirá ver que o mesmo possui uma renda disponível e poderá atuar
oferecendo alguma oferta, atuando assim com o melhor direcionamento de CRM.

seguem as ddls para criação de tabelas

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