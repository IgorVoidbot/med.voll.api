# API Voll.med

![Status do Projeto](https://img.shields.io/badge/status-em_desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen)

## 📖 Sobre o Projeto

API REST para a aplicação **Voll.med**, uma clínica fictícia para agendamento de consultas. Este projeto implementa as funcionalidades de back-end necessárias para gerir o cadastro de médicos e pacientes, seguindo os padrões de desenvolvimento modernos com Spring Boot.

## ✨ Funcionalidades Principais

A API gerencia duas entidades principais: Médicos e Pacientes.

* **CRUD de Médicos:**
    * `POST /medicos`: Cadastra um novo médico (com validação de dados).
    * `GET /medicos`: Lista todos os médicos ativos com paginação e ordenação (padrão de 10 por página, ordenado por nome).
    * `PUT /medicos`: Atualiza informações de um médico (nome, telefone, endereço).
    * `DELETE /medicos/{id}`: "Apaga" um médico (Exclusão Lógica / Soft Delete).

* **CRUD de Pacientes:**
    * `POST /pacientes`: Cadastra um novo paciente (com validação de dados).
    * `GET /pacientes`: Lista todos os pacientes ativos com paginação.
    * `PUT /pacientes`: Atualiza informações de um paciente (nome, telefone, endereço).
    * `DELETE /pacientes/{id}`: "Apaga" um paciente (Exclusção Lógica / Soft Delete).

## 🛠️ Tecnologias e Conceitos Aplicados

Este projeto foi construído com as seguintes tecnologias:

* **Java 17**
* **Spring Boot 3.5.7** (incluindo Spring Web, Spring Data JPA)
* **PostgreSQL** (Banco de Dados Relacional)
* **Flyway** (Ferramenta de Migrations de Banco de Dados)
* **Maven** (Gerenciador de Dependências)
* **Lombok** (Redução de boilerplate)
* **Jakarta Bean Validation** (Validação de DTOs)

### Conceitos de Arquitetura e Boas Práticas

* **Padrão DTO (Data Transfer Object):** A API utiliza Records do Java para separar os dados que chegam da API (DTOs de cadastro) dos dados que são persistidos no banco (Entidades `Medico`, `Paciente`).
* **Database Migrations com Flyway:** O estado do banco de dados é 100% controlado por arquivos SQL versionados (na pasta `db/migration`), garantindo um setup consistente em qualquer ambiente.
* **Exclusão Lógica (Soft Delete):** Nenhum registro é fisicamente apagado. Em vez disso, o campo `ativo` é definido como `false`. As listagens (GET) filtram e retornam apenas os registros ativos.

## 🚀 Como Executar o Projeto

Siga os passos abaixo para executar a API localmente.

### Pré-requisitos

* Java 17 (JDK)
* Maven 3.8 ou superior
* Uma instância do **PostgreSQL** em execução (localmente ou em um container Docker).

### 1. Clonar o Repositório

```bash
git clone <url-do-seu-repositorio>
cd api
```

### 2. Configurar o Banco de Dados

1.  Abra o seu cliente PostgreSQL (pgAdmin, DBeaver, etc.).
2.  Crie um novo banco de dados chamado `vollmed_api`.
3.  Você não precisa criar nenhuma tabela. O Flyway fará isso automaticamente!

### 3. Configurar a Aplicação

1.  Abra o arquivo `src/main/resources/application.properties`.
2.  Altere as seguintes linhas com o seu usuário e senha do PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost/vollmed_api
spring.datasource.username=seu_usuario_postgres
spring.datasource.password=sua_senha_postgres
```

### 4. Executar a API

Você pode executar a aplicação de duas formas:

* **Pela sua IDE (IntelliJ/Eclipse):**
    * Encontre a classe `ApiApplication.java` e execute o método `main()`.

* **Pelo Terminal (via Maven):**
    ```bash
    ./mvnw spring-boot:run
    ```

A API estará disponível em `http://localhost:8080`.
