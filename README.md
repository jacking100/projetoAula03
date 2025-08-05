# 🛠️ Projeto de Gerenciamento com Java e MySQL

Este projeto consiste em um sistema simples de gerenciamento, desenvolvido com **Java** e **MySQL**, seguindo o padrão arquitetural **MVC** (Model-View-Controller). O foco principal é a organização em camadas para facilitar manutenção, leitura e evolução do código.

---

## 🚀 Tecnologias Utilizadas

- **Java** (JDK 17+)
- **MySQL 8.0.43**
- **JDBC** para acesso ao banco de dados
- **Docker** (opcional, para subir o banco)
- **Terminal/Console** como interface de interação

---

## 🧱 Estrutura do Projeto

O sistema é dividido nas seguintes camadas:

### 📦 Entidade (Model)
Classes que representam as tabelas do banco de dados.  
Exemplos:
- `Funcionario`
- `Endereco`

### 💾 Repositório (Repository)
Responsável por realizar operações no banco de dados (CRUD), usando SQL via JDBC.  
Exemplo:
- `FuncionarioRepository`
- `EnderecoRepository`

### 🧭 Controlador (Controller)
Controla o fluxo da aplicação, chamando os métodos do repositório e interagindo com os dados.  
Exemplo:
- `FuncionarioController`

---

## 🗄️ Banco de Dados

- Banco: `bd_projeto_aula03`
- Tabelas:
  - `endereco`
  - `funcionario`
- Relacionamento: um funcionário possui um endereço (`endereco_id`)

### Exemplo de criação do banco:
```sql
CREATE DATABASE bd_projeto_aula03;
USE bd_projeto_aula03;

CREATE TABLE endereco (
  id CHAR(36) PRIMARY KEY,
  logradouro VARCHAR(100) NOT NULL,
  numero VARCHAR(15) NOT NULL,
  complemento VARCHAR(50) NOT NULL,
  bairro VARCHAR(50) NOT NULL,
  cidade VARCHAR(50) NOT NULL,
  estado VARCHAR(25) NOT NULL,
  cep VARCHAR(10) NOT NULL
);

CREATE TABLE funcionario (
  id CHAR(36) PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) NOT NULL UNIQUE,
  dataadmissao DATE NOT NULL,
  endereco_id CHAR(36),
  FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

📂 Organização das Pastas (sugestão)

src/
├── model/              # Entidades
├── repository/         # Acesso ao banco
├── controller/         # Regras de negócio
└── main.java           # Execução da aplicação

