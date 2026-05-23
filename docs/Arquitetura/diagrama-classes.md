# 📘 Diagrama de Classes

## Sistema de Ponto Eletrônico

---

# 🎯 Objetivo

Este documento define a modelagem inicial das entidades do Sistema de Ponto Eletrônico.

O objetivo é representar:

✅ entidades do domínio
✅ atributos
✅ relacionamentos
✅ cardinalidade
✅ regras estruturais
✅ organização backend

---

# 🏢 Classe: Empresa

## 📌 Responsabilidade

Representar a empresa responsável pelos funcionários.

---

## 📋 Atributos

| Atributo | Tipo   |
| -------- | ------ |
| id       | Long   |
| nome     | String |
| cnpj     | String |
| email    | String |
| telefone | String |

---

## 🔗 Relacionamentos

```text
Empresa 1 --- N Funcionarios
```

Uma empresa pode possuir vários funcionários.

---

# 👨‍💼 Classe: Funcionario

## 📌 Responsabilidade

Representar os funcionários vinculados a uma empresa.

---

## 📋 Atributos

| Atributo | Tipo   |
| -------- | ------ |
| id       | Long   |
| nome     | String |
| email    | String |
| cpf      | String |
| cargo    | String |
| senha    | String |

---

## 🔗 Relacionamentos

```text
Funcionario N --- 1 Empresa

Funcionario 1 --- N Pontos

Funcionario 1 --- 1 Usuario
```

---

# ⏰ Classe: Ponto

## 📌 Responsabilidade

Representar registros da jornada de trabalho.

---

## 📋 Atributos

| Atributo     | Tipo          |
| ------------ | ------------- |
| id           | Long          |
| dataHora     | LocalDateTime |
| tipoRegistro | TipoRegistro  |
| observacao   | String        |

---

## 🔗 Relacionamentos

```text
Ponto N --- 1 Funcionario
```

---

## 📌 Tipos de Registro

```text
ENTRADA
SAIDA_ALMOCO
VOLTA_ALMOCO
SAIDA_FINAL
```

---

# 🔐 Classe: Usuario

## 📌 Responsabilidade

Representar autenticação do sistema.

---

## 📋 Atributos

| Atributo | Tipo    |
| -------- | ------- |
| id       | Long    |
| login    | String  |
| senha    | String  |
| ativo    | Boolean |

---

## 🔗 Relacionamentos

```text
Usuario 1 --- 1 Funcionario

Usuario N --- 1 Perfil
```

---

# 🛡️ Classe: Perfil

## 📌 Responsabilidade

Controlar permissões de acesso.

---

## 📋 Atributos

| Atributo | Tipo   |
| -------- | ------ |
| id       | Long   |
| nome     | String |

---

## 📌 Perfis Iniciais

```text
ADMIN
FUNCIONARIO
```

---

# 🧠 Enum: TipoRegistro

## 📌 Responsabilidade

Controlar os tipos de marcação de ponto.

---

## 📋 Valores

```java
public enum TipoRegistro {
    ENTRADA,
    SAIDA_ALMOCO,
    VOLTA_ALMOCO,
    SAIDA_FINAL
}
```

---

# 🔄 Fluxo Sequencial do Ponto

## 📌 Ordem Obrigatória

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

# 🚫 Regras do Fluxo

O sistema NÃO permitirá:

❌ registrar saída antes da entrada
❌ registrar volta antes da saída para almoço
❌ registrar saída final antes da volta
❌ repetir registros consecutivos
❌ múltiplas jornadas abertas

---

# 🔗 Relacionamentos Gerais

```text
Empresa
   |
   | 1
   |
   | N
Funcionario
   |
   | 1
   |
   | N
Ponto

Funcionario
   |
   | 1
   |
   | 1
Usuario
   |
   | N
   |
   | 1
Perfil
```

---

# 🧱 Estrutura Conceitual do Backend

```text
Controller
↓
Service
↓
Repository
↓
Banco de Dados
```

---

# 📦 Estrutura de Packages

```bash
src/main/java/com/pontoeletronico/

├── controller
├── service
├── repository
├── model
├── dto
├── enums
├── security
├── exception
└── config
```

---

# 🚀 Escalabilidade Futura

O modelo foi preparado para futuras expansões:

✅ banco de horas
✅ controle de férias
✅ múltiplas empresas
✅ geolocalização
✅ biometria
✅ aplicativo mobile
✅ notificações

---

# 📘 Considerações Técnicas

O modelo seguirá:

* Programação Orientada a Objetos
* SOLID
* Arquitetura em Camadas
* JPA/Hibernate
* Relacionamentos ORM
* API REST

---

# 🏁 Próxima Etapa

📌 Criar:

* Diagrama de Casos de Uso
* Diagrama de Sequência
* Modelagem do Banco de Dados
* DER (Diagrama Entidade Relacionamento)

