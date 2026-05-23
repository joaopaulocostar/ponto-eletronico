# 🗄️ DER — Diagrama Entidade Relacionamento
## Sistema de Ponto Eletrônico

---

# 🎯 1. Objetivo

Este documento define a modelagem relacional do banco de dados do Sistema de Ponto Eletrônico.

O objetivo é representar:

✅ tabelas do sistema  
✅ relacionamentos  
✅ chaves primárias  
✅ chaves estrangeiras  
✅ cardinalidade  
✅ regras estruturais do banco  

---

# 🏢 2. Entidade: Empresa

## 📌 Responsabilidade
Armazenar informações das empresas cadastradas.

---

## 📋 Estrutura da Tabela

| Campo | Tipo | Restrição |
|---|---|---|
| id | BIGINT | PK |
| nome | VARCHAR(150) | NOT NULL |
| cnpj | VARCHAR(18) | UNIQUE |
| email | VARCHAR(150) | UNIQUE |
| telefone | VARCHAR(20) | NULL |

---

# 👨‍💼 3. Entidade: Funcionario

## 📌 Responsabilidade
Armazenar informações dos funcionários.

---

## 📋 Estrutura da Tabela

| Campo | Tipo | Restrição |
|---|---|---|
| id | BIGINT | PK |
| nome | VARCHAR(150) | NOT NULL |
| email | VARCHAR(150) | UNIQUE |
| cpf | VARCHAR(14) | UNIQUE |
| cargo | VARCHAR(100) | NOT NULL |
| senha | VARCHAR(255) | NOT NULL |
| empresa_id | BIGINT | FK |

---

# ⏰ 4. Entidade: Ponto

## 📌 Responsabilidade
Armazenar registros de jornada de trabalho.

---

## 📋 Estrutura da Tabela

| Campo | Tipo | Restrição |
|---|---|---|
| id | BIGINT | PK |
| data_hora | DATETIME | NOT NULL |
| tipo_registro | VARCHAR(30) | NOT NULL |
| observacao | VARCHAR(255) | NULL |
| funcionario_id | BIGINT | FK |

---

# 🔐 5. Entidade: Usuario

## 📌 Responsabilidade
Controlar autenticação do sistema.

---

## 📋 Estrutura da Tabela

| Campo | Tipo | Restrição |
|---|---|---|
| id | BIGINT | PK |
| login | VARCHAR(100) | UNIQUE |
| senha | VARCHAR(255) | NOT NULL |
| ativo | BOOLEAN | NOT NULL |
| funcionario_id | BIGINT | FK |
| perfil_id | BIGINT | FK |

---

# 🛡️ 6. Entidade: Perfil

## 📌 Responsabilidade
Controlar permissões dos usuários.

---

## 📋 Estrutura da Tabela

| Campo | Tipo | Restrição |
|---|---|---|
| id | BIGINT | PK |
| nome | VARCHAR(50) | UNIQUE |

---

# 🔗 7. Relacionamentos

---

## 🏢 Empresa → Funcionário

```text
Empresa 1 ----- N Funcionarios
```

Uma empresa pode possuir vários funcionários.

Um funcionário pertence a apenas uma empresa.

---

## 👨‍💼 Funcionário → Ponto

```text
Funcionario 1 ----- N Pontos
```

Um funcionário pode possuir vários registros de ponto.

Um ponto pertence a apenas um funcionário.

---

## 👨‍💼 Funcionário → Usuário

```text
Funcionario 1 ----- 1 Usuario
```

Cada funcionário possuirá um usuário de acesso.

---

## 🛡️ Perfil → Usuário

```text
Perfil 1 ----- N Usuarios
```

Um perfil pode estar vinculado a vários usuários.

---

# 📌 8. Cardinalidade Geral

```text
EMPRESA
   |
   | 1
   |
   | N
FUNCIONARIO
   |
   | 1
   |
   | N
PONTO

FUNCIONARIO
   |
   | 1
   |
   | 1
USUARIO
   |
   | N
   |
   | 1
PERFIL
```

---

# 🔑 9. Chaves Primárias (PK)

| Tabela | Chave Primária |
|---|---|
| empresa | id |
| funcionario | id |
| ponto | id |
| usuario | id |
| perfil | id |

---

# 🔗 10. Chaves Estrangeiras (FK)

| Tabela | Campo FK | Referência |
|---|---|---|
| funcionario | empresa_id | empresa(id) |
| ponto | funcionario_id | funcionario(id) |
| usuario | funcionario_id | funcionario(id) |
| usuario | perfil_id | perfil(id) |

---

# 🚫 11. Regras do Banco de Dados

## 📌 Regras Gerais

- email do funcionário deve ser único
- cpf deve ser único
- cnpj deve ser único
- login deve ser único

---

## 📌 Regras de Integridade

- funcionário deve pertencer a uma empresa
- ponto deve pertencer a um funcionário
- usuário deve possuir perfil

---

## 📌 Regras Sequenciais do Ponto

```text
1. ENTRADA
↓
2. SAIDA_ALMOCO
↓
3. VOLTA_ALMOCO
↓
4. SAIDA_FINAL
```

---

# 🚫 O sistema NÃO permitirá

❌ ponto fora da sequência  \n❌ registros duplicados consecutivos  \n❌ múltiplas jornadas abertas  \n❌ funcionário sem empresa  \n❌ usuário sem perfil  \n

---

# 🧠 12. Enum TipoRegistro

## 📌 Valores Permitidos

```text
ENTRADA
SAIDA_ALMOCO
VOLTA_ALMOCO
SAIDA_FINAL
```

---

# ⚙️ 13. Tecnologias Relacionadas

| Tecnologia | Finalidade |
|---|---|
| MariaDB | Banco de dados |
| Spring Data JPA | Persistência |
| Hibernate | ORM |
| Flyway | Migrations |
| Spring Boot | Backend |

---

# 🏗️ 14. Objetivo Arquitetural

A modelagem foi criada visando:

✅ organização do banco  \n✅ escalabilidade  \n✅ integridade relacional  \n✅ manutenção simplificada  \n✅ consistência dos dados  \n

---

# 🚀 15. Evoluções Futuras

O banco foi preparado para futuras implementações:

✅ banco de horas  \n✅ férias  \n✅ justificativas  \n✅ notificações  \n✅ geolocalização  \n✅ biometria  \n✅ múltiplos perfis  \n

---

# 📘 16. Considerações Finais

Este DER representa a estrutura inicial do banco de dados do Sistema de Ponto Eletrônico.

Ele servirá como base para:

- criação das entidades JPA
- migrations
- repositories
- services
- controllers
- implementação da autenticação
- persistência das regras de negócio
