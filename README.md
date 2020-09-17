## API REST - Gestão de CPF's

O objetivo desta API é prover uma solução centralizada para Gestão de __CPF's__, possibilitando o *cadastro*, a *consulta* e a *exclusão* dos CPF's a serem geridos.

#### Nome da API

sgcpf - acrônimo para Sistema de Gestão de CPF
	
#### Tecnologias Utilizadas

Java 11 - Spring 2.3.3 - H2 Database - Apache Maven 3.6.3 - Docker 19.03.12

#### Como rodar e testar a api

### Duas são as opções de obter a api e executa-la:

### Primeira Opção:

Execute o seguinte comando para baixar a imagem:

	sudo docker pull edsonbjr/spring-docker-sgcpf:0.0.1-SNAPSHOT
	
Após o download, executar o comando abaixo para rodar a api como um container Docker:

	sudo docker run -p 8080:8080 edsonbjr/spring-docker-sgcpf:0.0.1-SNAPSHOT

Feito isso já temos um container com ultima versão da API em execução e pode testar conforme descrito no item abaixo, "Como Testar as funcionalidade da API"


### Segunda Opção:
Essa opção é para quem optar por fazer alguma alteração e personalizar a sua versão do container, por exemplo.

Clone o projeto, digitando o comando abaixo:

	git clone https://github.com/edsonBJR/sgcpf.git

Configure o arquivo POM.xml
A configuração deve ser feita na tag como aparece abaixo:

```xml
				<configuration>
					<useMavenSettingsForAuth>true</useMavenSettingsForAuth>
					<repository>{SEU_DOCKER_ID}/sgcpf</repository>
					<tag>${project.version}</tag>
					<buildArgs>
					  <JAR_FILE>${project.build.finalName}.jar</JAR_FILE>
					</buildArgs>
				</configuration>
```


Onde está escrito {SEU_DOCKER_ID}, altere para o seu Docker ID, que você obtêm quando se cadastar no repositorio Docker Hub, o resultado final deve ser como o exemplo abaixo:

```xml
				<configuration>
					<useMavenSettingsForAuth>true</useMavenSettingsForAuth>
					<repository>fulanodetal/sgcpf</repository>
					<tag>${project.version}</tag>
					<buildArgs>
					  <JAR_FILE>${project.build.finalName}.jar</JAR_FILE>
					</buildArgs>
				</configuration>
```

Crie um Container com o comando abaixo, que deve ser executado na pasta raiz do projeto, onde está o arquivo Dockerfile, lembre de ter o Apache Maven instalado e configurado.

	mvn package

Conferir se a imagem foi criada, com o comando:

	docker images

O resultado dever ser algo parecido com a tabela abaixo:

| REPOSITORY | TAG | IMAGE ID | CREATED | SIZE |
|-|-|-|-|-|
| {seu_docker_id}/sgcpf | 0.0.1 | 199670908460 | 21 hours ago | 465MB |
|-|-|-|-|-|

Agora já pode rodar sua imagem docker, use o comando abaixo:

	docker run -p 8080:8080 {seu_docker_id}/sgcpf:0.0.1

#### Como Testar as funcionalidade da API

__Sugestão, utilizar o Postman para teste dos endpoints,__ mas caso queira o comando __curl__ executado pela linha de comando, também é bem vindo.

A tabela abaixo descreve o verbo http a uri do recurso e o que esperar de retorno da requisição.

|Verbo|URI| CORPO |Retorno da Requisição|
|-|-|-|-|
|GET | http://localhost:8080/cpf | | Listar todos os CPF's cadastrados  |
|GET | http://localhost:8080/cpf/{cpf} | | Consultar se um CPF está cadastrado, nessário informar um CPF válido. |
|POST | http://localhost:8080/cpf | ```{ "cpf": "00012649074" }``` | Cadastrar um CPF, necessário enviar um CPF no corpo da requisição, somente os numeros|
|DELETE|http://localhost:8080/cpf/{cpf}| | Deletar um CPF, necessário informar um CPF "válido" na url da requisição.|

*O CPF utilizado na tabela acima, foi gerado aleatóriamente para exemplificar o teste.

OBS: A API sempre verifica se o CPF informado é válido. Está funcionalidade foi obtida de terceiros, na classe de nome ValidaCPF faço referência ao autor.


