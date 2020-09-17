## API REST - Gestão de CPF's

O objetivo desta API é criar uma solução para Gestão de __CPF's__.

A api permite, *cadastrar*, *consultar* e *deletar* CPF's.


#### Nome da API

	SGCPF
	
#### Tecnologias Utilizadas

	Java 11 - Spring 2.3.3 - H2 Database - Apache Maven 3.6.3 - Docker 19.03.12 - JUnit 

#### Objetivo

	O objetivo da API é fazer uma gestão de CPF's.

#### Breve descrição 

	A api permite o cadastro, consulta e deletar um CPF.

#### Como rodar e testar a api


Disponibilizei a última versão da API que pode ser baixa apartir do dockerhub.com


Digite o seguinte comando para obter a imagem do container: 

	sudo docker pull edsonbjr/spring-docker-sgcpf:0.0.1-SNAPSHOT


Execute o container

	sudo docker run -p 8080:8080 edsonbjr/spring-docker-sgcpf:0.0.1-SNAPSHOT


Feito isso ja temos um container da ultima versão da API em execução e pode ser testada conforme a explicação abaixo:


#### Como Utilizar a API


__Sugestão, utilizar o Postman para teste dos endpoints.__


#### Enpoints para teste


|Verbo|URI|Descrição|
|-|-|-|
|GET | http://localhost:8080/cpf | Listar todos os CPF's cadastrados  |
|GET | http://localhost:8080/cpf/{cpf} | Consultar se um CPF está cadastrado, nessário informar um CPF válido. |
|POST | http://localhost:8080/cpf | Cadastrar um CPF, necessário enviar um CPF no corpo da requisição, como exemplo: { "cpf": "cpfvalido" }|
|DELETE|http://localhost:8080/cpf/{cpf}|Deletar um CPF, necessário informar um CPF "válido" na url da requisição.|


OBS: A API verifica se o CPF informado é válido.


