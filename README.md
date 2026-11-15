
# Sistema de Empréstimo de Equipamentos

## 1. Descrição do projeto

API REST desenvolvida em Java e Spring Boot para gerenciar
o empréstimo e a devolução de equipamentos de uma organização.

O sistema permite cadastrar equipamentos e colaboradores,
realizar empréstimos, registrar devoluções e consultar
empréstimos por colaborador ou por situação de atraso.

## 2. Tecnologias utilizadas

- Java 21
- Spring Boot 4.1.2
- Spring Web MVC
- Spring Data JPA
- Hibernate
- Banco de dados H2
- Maven
- JUnit 5
- Docker

## 3. Funcionalidades

- Cadastro de equipamentos
- Cadastro de colaboradores
- Registro de empréstimos
- Registro de devoluções
- Controle de disponibilidade dos equipamentos
- Bloqueio de empréstimos de equipamentos indisponíveis
- Bloqueio de empréstimos para colaboradores com atrasos
- Consulta de empréstimos atrasados
- Consulta de empréstimos por colaborador

## 4. Endpoints da API

### Equipamentos

POST /equipamentos

Exemplo de JSON:

```json
{
  "nome": "Notebook Dell",
  "patrimonio": "PAT002",
  "tipo": "NOTEBOOK",
  "disponivel": true
}
```

### Colaboradores

POST /colaboradores

Exemplo de JSON:

```json
{
  "nome": "Maria Silva",
  "email": "maria.silva@exemplo.com",
  "cargo": "Analista"
}
```

### Empréstimos

Registrar empréstimo:

POST /emprestimos?equipamentoId=1&colaboradorId=1

Registrar devolução:

PUT /emprestimos/1/devolucao

Consultar empréstimos atrasados:

GET /emprestimos?atrasados=true

Consultar empréstimos por colaborador:

GET /emprestimos/colaborador/1

## 5. Regras de negócio

- Um equipamento indisponível não pode ser emprestado.
- Cada empréstimo possui uma data de realização.
- A previsão de devolução é calculada para 14 dias.
- A devolução atualiza a disponibilidade do equipamento.
- Um empréstimo já devolvido não pode ser devolvido novamente.
- Colaboradores com empréstimos atrasados não podem
  realizar novos empréstimos.

## 6. Como executar localmente

Requisitos:

- Java 21
- Maven
- Git (para clonar o repositório)

Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

Entre na pasta do projeto:

```bash
cd spring-boot-tutorial
```

Execute a aplicação:

```bash
mvn spring-boot:run
```

A API estará disponível em:

http://localhost:8080

## 7. Testes automatizados

O projeto utiliza JUnit 5 para validar o comportamento
das classes e as regras de negócio.

Arquivos de testes:

- EquipamentoTest.java
- EmprestimoTest.java
- SpringBootTutorialApplicationTests.java

Para executar os testes:

```bash
mvn test
```

## 8. Docker

O projeto possui um Dockerfile com Java 21.

Para construir a imagem:

```bash
docker build -t sistema-emprestimos .
```

Para executar:

```bash
docker run -p 8080:8080 sistema-emprestimos
```

## 9. Publicação

A aplicação será disponibilizada no Render.

URL da aplicação:
A preencher após a publicação.

## 10. Informações acadêmicas

Projeto: Sistema de Empréstimo de Equipamentos

Disciplina: Desenvolvimento Web

Objetivo: Aplicar conceitos de Java, Spring Boot,
API REST, persistência de dados, regras de negócio
e testes automatizados.
