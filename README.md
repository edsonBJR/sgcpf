# API REST - Gestão de CPF's

### O objetivo desta API é criar uma solução para Gestão de __CPF's__.

#### A api permite, *cadastrar*, *consultar* e *deletar* CPF's.


### Nome da API

	SGCPF

### Objetivo

	**O objetivo da API é fazer uma gestão de CPF's.**

### Breve descrição 

	**A api permite o cadastro, consulta e deletar um CPF.**

### Como rodar a api

	**Para rodar basta baixar (clone) o projeto apartir de github.**


### Como Utilizar a API

__Sugestão, utilizar o Postman para teste dos endpoints.__

##### Enpoints para teste

|Verbo|URI|Descrição|
|-|-|-|
|GET | http://localhost:8080/cpf | Listar todos os CPF's cadastrados  |
|GET | http://localhost:8080/cpf/{cpf} | Consultar se um CPF está cadastrado, nessário informar um CPF válido. |
|POST | http://localhost:8080/cpf | Cadastrar um CPF, necessário enviar um CPF no corpo da requisição, como exemplo: { "cpf": "cpfvalido" }|
|DELETE|http://localhost:8080/cpf/{cpf}|Deletar um CPF, necessário informar um CPF "válido" na url da requisição.|

OBS: A API faz verifica se o CPF informado é válido.


