# 📘 Diagrama de Casos de Uso
## Sistema de Ponto Eletrônico

---

# 🎯 1. Objetivo

Este documento descreve os casos de uso do Sistema de Ponto Eletrônico.

O objetivo é representar:

✅ funcionalidades do sistema  
✅ interação dos usuários  
✅ permissões de acesso  
✅ operações disponíveis  
✅ comportamento geral do sistema  

---

# 👥 2. Atores do Sistema

## 👨‍💼 Administrador

Responsável por:

- cadastrar empresas
- cadastrar funcionários
- gerenciar usuários
- gerar relatórios
- visualizar informações do sistema

---

## 👨 Funcionário

Responsável por:

- realizar login
- registrar ponto
- consultar histórico
- visualizar jornada

---

# 📋 3. Casos de Uso do Administrador

| Código | Caso de Uso |
|---|---|
| UC01 | Cadastrar Empresa |
| UC02 | Cadastrar Funcionário |
| UC03 | Gerenciar Usuários |
| UC04 | Gerar Relatórios |
| UC05 | Consultar Funcionários |
| UC06 | Consultar Registros de Ponto |

---

# 📋 4. Casos de Uso do Funcionário

| Código | Caso de Uso |
|---|---|
| UC07 | Realizar Login |
| UC08 | Registrar Entrada |
| UC09 | Registrar Saída para Almoço |
| UC10 | Registrar Volta do Almoço |
| UC11 | Registrar Saída Final |
| UC12 | Consultar Histórico |
| UC13 | Visualizar Jornada |

---

# 🔗 5. Relacionamento entre Atores e Casos de Uso

```text
                    ┌──────────────────────┐
                    │ Sistema de Ponto     │
                    └──────────────────────┘

👨‍💼 Administrador
     ├── Cadastrar Empresa
     ├── Cadastrar Funcionário
     ├── Gerenciar Usuários
     ├── Gerar Relatórios
     ├── Consultar Funcionários
     └── Consultar Registros

👨 Funcionário
     ├── Realizar Login
     ├── Registrar Entrada
     ├── Registrar Saída Almoço
     ├── Registrar Volta Almoço
     ├── Registrar Saída Final
     ├── Consultar Histórico
     └── Visualizar Jornada
```

---

# 🔄 6. Fluxo Geral do Sistema

## 📌 Fluxo Principal

```text
Funcionário realiza login
        ↓
Sistema valida credenciais
        ↓
Funcionário registra entrada
        ↓
Sistema libera saída almoço
        ↓
Funcionário registra saída almoço
        ↓
Sistema libera volta almoço
        ↓
Funcionário registra volta almoço
        ↓
Sistema libera saída final
        ↓
Funcionário registra saída final
        ↓
Sistema encerra jornada
```

---

# 🚫 7. Fluxos de Exceção

## ❌ Login inválido

```text
Usuário informa credenciais inválidas
↓
Sistema bloqueia acesso
↓
Sistema retorna mensagem de erro
```

---

## ❌ Registro fora da sequência

```text
Funcionário tenta registrar ponto fora da ordem
↓
Sistema bloqueia operação
↓
Sistema informa sequência inválida
```

---

## ❌ Registro duplicado

```text
Funcionário tenta repetir o mesmo registro
↓
Sistema bloqueia operação
↓
Sistema informa duplicidade
```

---

# 🧠 8. Regras de Negócio Relacionadas

## 📌 Regras Gerais

- funcionário deve pertencer a uma empresa
- email deve ser único
- usuário deve estar autenticado
- sistema deve registrar data e hora

---

## 📌 Regras Sequenciais do Ponto

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

## 🚫 O sistema NÃO permitirá

❌ registrar almoço antes da entrada  
❌ registrar volta antes da saída almoço  
❌ registrar saída final antes da volta  
❌ múltiplos registros iguais consecutivos  
❌ jornada duplicada aberta  

---

# 🔐 9. Controle de Permissões

| Perfil | Permissões |
|---|---|
| ADMIN | Controle total do sistema |
| FUNCIONARIO | Registro e consulta própria |

---

# ⚙️ 10. Tecnologias Relacionadas

| Tecnologia | Finalidade |
|---|---|
| Java 21 | Backend |
| Spring Boot | API REST |
| Spring Security | Segurança |
| JWT | Autenticação |
| MariaDB | Banco de Dados |
| Git/GitHub | Versionamento |

---

# 🏗️ 11. Objetivo Arquitetural

O diagrama de casos de uso auxilia:

✅ entendimento do sistema  
✅ levantamento de requisitos  
✅ definição das funcionalidades  
✅ organização do backend  
✅ modelagem das regras de negócio  

---

# 🚀 12. Próximas Etapas

Após este documento serão criados:

- Diagrama de Sequência
- DER (Diagrama Entidade Relacionamento)
- Modelagem do Banco de Dados
- Estrutura das Entidades JPA
- Arquitetura de Segurança JWT

---

# 📘 Considerações Finais

Este documento representa a interação entre os usuários e o Sistema de Ponto Eletrônico, servindo como base para o desenvolvimento backend e implementação das funcionalidades da aplicação.
