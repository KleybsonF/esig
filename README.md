# 📌 Projeto de Cadastro e Listagem de Tarefas

## 📋 Descrição
Este projeto consiste em um CRUD para gerenciamento de tarefas utilizando **Java Web** com **JSF**, **PostgreSQL** e **Tomcat 9**. Ele permite o cadastro, listagem e gerenciamento de tarefas com atributos como título, descrição, responsável, prioridade e deadline.

## ✅ Funcionalidades Implementadas
- ✅ Persistência no banco de dados PostgreSQL
- ✅ Interface responsiva utilizando Tailwind CSS
- ✅ Listagem de tarefas "Em andamento"
- 🟧 Cadastro de tarefas
- 🟧 Pesquisa de tarefas

## 📌 Tecnologias Utilizadas
- **Java EE (Jakarta EE)**
- **JSF (JavaServer Faces)**
- **PostgreSQL**
- **Tomcat 9**
- **JPA (Jakarta Persistence API)**
- **Tailwind CSS** (para estilização)

## 🚀 Como Executar o Projeto Localmente

### 🔹 1. Clonar o Repositório
```sh
git clone [git@github.com:KleybsonF/esig.git](https://github.com/KleybsonF/esig.git)
```

### 🔹 2. Configurar o Banco de Dados PostgreSQL
1. Criar um banco de dados no PostgreSQL:
```sql
CREATE DATABASE tarefas;
```
2. Configurar as credenciais no arquivo `persistence.xml`:
```xml
<property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/tarefas"/>
<property name="jakarta.persistence.jdbc.user" value="seu_usuario"/>
<property name="jakarta.persistence.jdbc.password" value="sua_senha"/>
```

### 🔹 3. Configurar o Tomcat 9
1. Adicionar o projeto no Tomcat via Eclipse
2. Iniciar o servidor Tomcat 9

### 🔹 4. Acessar a Aplicação
Abra o navegador e acesse:
```
http://localhost:8080/esig/index.html
```

Agora o sistema de cadastro e listagem de tarefas estará disponível! 🎯

