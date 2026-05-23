# 🏗️ Arquitetura do Sistema

## Sistema de Ponto Eletrônico

---

> 📌 Documento responsável por definir a estrutura backend, organização das camadas e fluxo interno da aplicação.

---

# 🎯 1. Objetivo da Arquitetura

A arquitetura do sistema foi planejada para garantir:

✅ organização do código
✅ separação de responsabilidades
✅ facilidade de manutenção
✅ escalabilidade futura
✅ reutilização de componentes
✅ segurança
✅ padronização profissional

---

# 🧱 2. Arquitetura em Camadas

O sistema seguirá o padrão:

```text
Cliente
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Banco de Dados
```

---

# 📦 3. Estrutura de Packages

```bash
src/main/java/com/pontoeletronico/

├── controller
├── service
├── repository
├── model
├── dto
├── security
├── exception
├── config
└── enums
```

---

# 🔵 4. Camada Controller

## 📌 Responsabilidade

Responsável por:

* receber requisições HTTP
* validar entrada de dados
* chamar a camada Service
* retornar respostas da API

---

## ✅ Exemplos

* cadastrar empresa
* cadastrar funcionário
* registrar ponto
* autenticar usuário

---

## 📍 Exemplo de Endpoint

```http
POST /funcionarios
```

---

# 🟢 5. Camada Service

## 📌 Responsabilidade

Responsável pelas:

* regras de negócio
* validações
* processamento do sistema
* controle do fluxo interno

---

## ✅ Exemplos de Regras

* impedir e-mail duplicado
* validar sequência do ponto
* validar empresa existente
* controlar permissões

---

# 🟣 6. Camada Repository

## 📌 Responsabilidade

Responsável pela comunicação com o banco de dados.

Utilizará:

* Spring Data JPA
* Hibernate

---

## ✅ Funções

* salvar dados
* buscar registros
* atualizar informações
* remover registros

---

## 📍 Exemplo

```java
findById()
findAll()
save()
deleteById()
```

---

# 🟠 7. Camada Model

## 📌 Responsabilidade

Representar as entidades do sistema.

---

## ✅ Principais Entidades

| Entidade    | Função               |
| ----------- | -------------------- |
| Empresa     | Dados da empresa     |
| Funcionario | Dados do funcionário |
| Ponto       | Registros de jornada |
| Usuario     | Login do sistema     |
| Perfil      | Controle de acesso   |

---

# 🔐 8. Camada Security

## 📌 Responsabilidade

Responsável pela autenticação e autorização.

---

## ✅ Tecnologias

* Spring Security
* JWT

---

## 👤 Perfis Iniciais

| Perfil      | Permissões          |
| ----------- | ------------------- |
| ADMIN       | Controle total      |
| FUNCIONARIO | Registro e consulta |

---

# 🚨 9. Camada Exception

## 📌 Responsabilidade

Centralizar tratamento de erros do sistema.

---

## ✅ Objetivos

* evitar erros genéricos
* retornar mensagens padronizadas
* melhorar manutenção
* facilitar debugging

---

## 📍 Exemplo

```java
RecursoNaoEncontradoException
EmailJaCadastradoException
```

---

# 🔄 10. Fluxo de Requisição

## 📌 Fluxo Completo

```text
Cliente
↓
Controller
↓
Service
↓
Repository
↓
Banco de Dados
↓
Repository
↓
Service
↓
Controller
↓
Cliente
```

---

# 🗄️ 11. Banco de Dados

## 📌 Banco Utilizado

```text
MariaDB
```

---

## 📌 Principais Relacionamentos

```text
Empresa
   ↓
Funcionário
   ↓
Ponto
```

---

## ✅ Regras Importantes

* empresa possui vários funcionários
* funcionário possui vários registros
* ponto pertence a um funcionário

---

# ⏰ 12. Fluxo Sequencial do Ponto

## 📌 Ordem obrigatória

```text
1. Entrada
↓
2. Saída para almoço
↓
3. Volta do almoço
↓
4. Saída final
```

---

## 🚫 O sistema NÃO permitirá:

❌ voltar do almoço antes da saída
❌ saída final antes da volta
❌ registros duplicados consecutivos
❌ múltiplas jornadas ativas

---

# 🧠 13. Padrões Utilizados

| Padrão                 | Objetivo           |
| ---------------------- | ------------------ |
| REST                   | Comunicação HTTP   |
| DTO Pattern            | Separação de dados |
| Repository Pattern     | Persistência       |
| Injeção de Dependência | Desacoplamento     |
| Exception Handler      | Tratamento global  |
| Arquitetura em Camadas | Organização        |

---

# ⚙️ 14. Tecnologias Utilizadas

| Tecnologia      | Finalidade          |
| --------------- | ------------------- |
| Java 21         | Linguagem principal |
| Spring Boot     | Backend             |
| Spring Data JPA | Persistência        |
| Hibernate       | ORM                 |
| MariaDB         | Banco de dados      |
| Maven           | Dependências        |
| Git             | Versionamento       |
| GitHub          | Repositório remoto  |
| JWT             | Autenticação        |
| Postman         | Testes da API       |

---

# 🚀 15. Escalabilidade Futura

O sistema será preparado para futuras melhorias:

✅ frontend web
✅ aplicativo mobile
✅ dockerização
✅ deploy em nuvem
✅ microserviços
✅ biometria
✅ integração com folha de pagamento

---

# 📘 16. Considerações Finais

Esta arquitetura foi planejada para simular um ambiente profissional de engenharia de software.

O projeto seguirá:

* metodologia ágil
* organização corporativa
* boas práticas backend
* documentação técnica
* arquitetura escalável
* desenvolvimento incremental

---

# ✅ Status Atual do Projeto

| Etapa                   | Status          |
| ----------------------- | --------------- |
| Documento de Visão      | ✅ Concluído     |
| Documento de Requisitos | ✅ Concluído     |
| Arquitetura do Sistema  | 🚧 Em andamento |
| Diagramas UML           | ⏳ Próximo passo |
| Implementação Backend   | ⏳ Futuro        |

---

# 🏁 Próxima Etapa

📌 Criar Diagramas UML

* Diagrama de Classes
* Diagrama de Casos de Uso
* Diagrama de Sequência
* Diagrama de Contexto

