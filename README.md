## API REST - Gestão de CPF's

O objetivo desta API é prover uma solução centralizada para Gestão de __CPF's__, possibilitando o *cadastro*, a *consulta* e a *exclusão* dos CPF's a serem geridos.

#### Nome da API

sgcpf - acrônimo para Sistema de Gestão de CPF
	
#### Tecnologias Utilizadas

Java 11 - Spring 2.3.3 - H2 Database - Apache Maven 3.6.3 - Docker 19.03.12

#### Como rodar e testar a api

Duas são as opções de obter a api e executa-la:

Primeira Opção:
Atráves do download do repositorio do Docker Hub, abaixo segue o link para download:
[Docker Hub](https://hub.docker.com/repository/docker/edsonbjr/spring-docker-sgcpf)

Execute o seguinte comando para baixar a imagem, caso queira fazer pela linha de comando:

	sudo docker pull edsonbjr/spring-docker-sgcpf:0.0.1-SNAPSHOT
	
Após o download executar o comando abaixo para rodar a api como um container Docker

	sudo docker run -p 8080:8080 edsonbjr/spring-docker-sgcpf:0.0.1-SNAPSHOT

Feito isso ja temos um container da ultima versão da API em execução e pode ser testada conforme a explicação abaixo:

Segunda Opção:
Clone o projeto
Configure o arquivo POM.xml
Crie um Container
Rode o Container

#### Como Testar as funcionalidade da API

__Sugestão, utilizar o Postman para teste dos endpoints,__ mas caso queira o comando __curl__ executado pela linha de comando, também é bem vindo.

A tabela abaixo descreve o verbo http a uri do recurso e o que esperar de retorno da requisição.

|Verbo|URI|Retorn da Requisição|
|-|-|-|
|GET | http://localhost:8080/cpf | Listar todos os CPF's cadastrados  |
|GET | http://localhost:8080/cpf/{cpf} | Consultar se um CPF está cadastrado, nessário informar um CPF válido. |
|POST | http://localhost:8080/cpf | Cadastrar um CPF, necessário enviar um CPF no corpo da requisição, como exemplo: { "cpf": "cpfvalido" }|
|DELETE|http://localhost:8080/cpf/{cpf}|Deletar um CPF, necessário informar um CPF "válido" na url da requisição.|


OBS: A API sempre verifica se o CPF informado é válido. Está funcionalidade foi obtida de terceiros, na classe de nome ValidaCPF faço referência ao autor.


