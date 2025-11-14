# API Voll.med

![Status do Projeto](https://img.shields.io/badge/status-em_desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen)


## 📖 Sobre o Projeto

API REST para a aplicação **Voll.med**, uma clínica fictícia para agendamento de consultas. Este projeto implementa as funcionalidades de back-end necessárias para gerir o cadastro de médicos, pacientes e o controlo de acesso via autenticação JWT.

## ✨ Funcionalidades Principais

A API gerencia três entidades principais: Médicos, Pacientes e Usuários.

  * **🔐 Segurança e Autenticação:**

      * `POST /login`: Autentica um usuário (baseado na tabela `usuarios`) e retorna um token JWT para acesso.
      * **Rotas Protegidas:** Todas as outras rotas (ex: `/medicos`, `/pacientes`) são protegidas e exigem um token JWT válido enviado no cabeçalho `Authorization`.

  * **CRUD de Médicos:**

      * `POST /medicos`: Cadastra um novo médico.
      * `GET /medicos`: Lista todos os médicos ativos com paginação e ordenação.
      * `PUT /medicos`: Atualiza informações de um médico (nome, telefone, endereço).
      * `DELETE /medicos/{id}`: "Apaga" um médico (Exclusão Lógica).
      * `GET /medicos/{id}`: Detalha um médico específico.

  * **CRUD de Pacientes:**

      * `POST /pacientes`: Cadastra um novo paciente.
      * `GET /pacientes`: Lista todos os pacientes ativos com paginação.
      * `PUT /pacientes`: Atualiza informações de um paciente.
      * `DELETE /pacientes/{id}`: "Apaga" um paciente (Exclusão Lógica).
      * `GET /pacientes/{id}`: Detalha um paciente específico.

## 🛠️ Tecnologias e Conceitos Aplicados

Este projeto foi construído com as seguintes tecnologias:

  * **Java 17**
  * **Spring Boot 3.5.7** (incluindo Spring Web, Spring Data JPA)
  * **Spring Security** (Controle de autenticação e autorização)
  * **JSON Web Token (JWT)** (Biblioteca Auth0 para geração e validação de tokens)
  * **PostgreSQL** (Banco de Dados Relacional)
  * **Flyway** (Ferramenta de Migrations de Banco de Dados)
  * **Maven** (Gerenciador de Dependências)
  * **Lombok** (Redução de boilerplate)
  * **Jakarta Bean Validation** (Validação de DTOs)

### Conceitos de Arquitetura e Boas Práticas

  * **Autenticação Stateless:** A API não usa sessões. A autenticação é feita via token JWT em cada requisição.
  * **Padrão DTO (Data Transfer Object):** A API utiliza Records do Java para separar os dados que chegam da API (DTOs de cadastro) dos dados que são persistidos no banco (Entidades).
  * **Database Migrations com Flyway:** O estado do banco de dados é 100% controlado por arquivos SQL versionados (na pasta `db/migration`).
  * **Exclusão Lógica (Soft Delete):** Nenhum registro é fisicamente apagado. Em vez disso, o campo `ativo` é definido como `false`.

## 🚀 Como Executar o Projeto

### Pré-requisitos

  * Java 17 (JDK)
  * Maven 3.8 ou superior
  * Uma instância do **PostgreSQL** em execução.

### 1\. Clonar o Repositório

```bash
git clone https://github.com/IgorVoidbot/med.voll.api.git
cd api
```

### 2\. Configurar o Banco de Dados

1.  Abra o seu cliente PostgreSQL (pgAdmin, DBeaver, etc.).
2.  Crie um novo banco de dados chamado `vollmed_api`.
3.  O Flyway criará todas as tabelas (`medicos`, `pacientes`, `usuarios`) automaticamente ao iniciar a aplicação.

### 3\. Configurar a Aplicação (Variáveis de Ambiente)

A aplicação espera que as seguintes variáveis de ambiente estejam configuradas:

  * `DB_HOST`: O endereço do seu banco (ex: `localhost`).
  * `DB_USER`: O nome de usuário do seu banco PostgreSQL.
  * `DB_PASSWORD`: A senha do seu banco PostgreSQL.
  * `JWT_SECRET`: Uma chave secreta longa e aleatória para a assinatura dos tokens JWT (ex: `minha-chave-secreta-super-segura-123456`).

*Na sua IDE (IntelliJ/Eclipse), você pode configurar estas variáveis na secção "Run/Debug Configurations".*

### 4\. Executar a API

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

-----

## 🔑 Como Usar a API

Todas as rotas (exceto `/login`) são protegidas. Você deve obter um token JWT e enviá-lo a cada requisição.

### Passo 1: Crie um Usuário

Como o login é necessário, primeiro você precisa de um usuário na tabela `usuarios`. O Flyway cria a tabela, mas não insere dados.

**Importante:** A senha deve ser um **hash BCrypt**. Use um gerador BCrypt online para criar um hash (ex: para a senha "123456").

```sql
-- Exemplo de como inserir um usuário manualmente no seu banco:
INSERT INTO usuarios (login, senha) 
VALUES ('user@oll.med', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.'); 
-- (Este hash corresponde à senha "123456")
```

### Passo 2: Obtenha seu Token

Envie uma requisição `POST` para `http://localhost:8080/login` com o `login` e a senha (em texto puro) do usuário que você criou.

**Requisição (Request):**
`POST /login`

```json
{
  "login": "user@oll.med",
  "senha": "123456"
}
```

**Resposta (Response):**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### Passo 3: Acesse as Rotas Protegidas

Copie o `token` recebido. Para todas as outras requisições (ex: `GET /medicos`), você deve enviar este token no cabeçalho `Authorization` no formato `Bearer`.

**Exemplo (no Postman/Insomnia):**

  * Vá para a aba `Auth`.
  * Selecione o tipo `Bearer Token`.
  * Cole o token no campo.

Agora você está autenticado e pode usar todas as funcionalidades da API.
