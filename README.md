# API Voll.med

![Status do Projeto](https://img.shields.io/badge/status-em_desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen)

## 📖 Sobre

API REST para a aplicação **Voll.med**, uma clínica fictícia para agendamento de consultas. Este projeto implementa as funcionalidades de back-end necessárias para gerir o cadastro de médicos e pacientes, seguindo os padrões de desenvolvimento modernos com Spring Boot.

---

## ✨ Funcionalidades Principais

A API gere duas entidades principais: Médicos e Pacientes.

* **CRUD de Médicos:**
    * `POST /medicos`: Cadastra um novo médico (com validação de dados).
    * `GET /medicos`: Lista todos os médicos ativos com paginação e ordenação (padrão de 10 por página, ordenado por nome).
    * `PUT /medicos`: Atualiza informações de um médico (nome, telefone, endereço).
    * `DELETE /{id}`: "Apaga" um médico (Exclusão Lógica / Soft Delete).

* **CRUD de Pacientes:**
    * `POST /pacientes`: Cadastra um novo paciente (com validação de dados).
    * `GET /pacientes`: Lista todos os pacientes ativos com paginação.
    * `PUT /pacientes`: Atualiza informações de um paciente (nome, telefone, endereço).
    * `DELETE /{id}`: "Apaga" um paciente (Exclusão Lógica / Soft Delete).

---

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias:

* **Java 17**
* **Spring Boot 3.5.7** (incluindo Spring Web, Spring Data JPA)
* **PostgreSQL** (Banco de Dados Relacional)
* **Flyway** (Ferramenta de Migrations de Banco de Dados)
* **Maven** (Gestor de Dependências)
* **Lombok** (Redução de boilerplate)
* **Jakarta Bean Validation** (Validação de DTOs)

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para executar a API localmente.

### Pré-requisitos

* Java 17 (JDK)
* Maven 3.8 ou superior
* Uma instância do **PostgreSQL** a correr (localmente ou num container Docker).

### 1. Clonar o Repositório

```bash
git clone <url-do-teu-repositorio>
cd api
