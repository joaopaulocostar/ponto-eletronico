# 🟦 Documento de Requisitos

# 🟩 Sistema de Ponto Eletrônico

---

# 🟨 1. Introdução

Este documento descreve os requisitos funcionais e não funcionais do Sistema de Ponto Eletrônico.

O sistema será desenvolvido para permitir o gerenciamento de empresas, funcionários e registros de jornada de trabalho, garantindo controle sequencial das marcações de ponto e segurança das informações.

O projeto será desenvolvido utilizando Java e Spring Boot, seguindo boas práticas de engenharia de software e arquitetura backend.

---

# 🟨 2. Objetivo do Sistema

O objetivo do sistema é automatizar o controle de jornada de trabalho dos funcionários de empresas, permitindo:

✅ cadastro de empresas  
✅ cadastro de funcionários  
✅ autenticação de usuários  
✅ registro de ponto eletrônico  
✅ controle de pausas para almoço  
✅ geração de relatórios  
✅ controle de acesso por perfil  

O sistema deverá garantir consistência dos registros e impedir marcações inválidas.

---

# 🟨 3. Escopo do Sistema

O sistema permitirá:

🟢 gerenciamento de empresas  
🟢 gerenciamento de funcionários  
🟢 autenticação de usuários  
🟢 registro de entrada  
🟢 registro de saída para almoço  
🟢 registro de volta do almoço  
🟢 registro de saída final  
🟢 consulta de histórico de pontos  
🟢 geração de relatórios  
🟢 controle de permissões  

---

# 🟨 4. Requisitos Funcionais

## 🔵 RF01 — Cadastro de Empresa

O sistema deverá permitir cadastrar empresas.

---

## 🔵 RF02 — Cadastro de Funcionário

O sistema deverá permitir cadastrar funcionários vinculados a uma empresa.

---

## 🔵 RF03 — Autenticação de Usuários

O sistema deverá permitir autenticação de usuários através de login e senha.

---

## 🔵 RF04 — Registro de Entrada

O sistema deverá permitir que o funcionário registre sua entrada no início da jornada.

---

## 🔵 RF05 — Registro de Saída para Almoço

O sistema deverá permitir registrar saída para almoço somente após o registro de entrada.

---

## 🔵 RF06 — Registro de Volta do Almoço

O sistema deverá permitir registrar volta do almoço somente após a saída para almoço.

---

## 🔵 RF07 — Registro de Saída Final

O sistema deverá permitir registrar saída final somente após a volta do almoço.

---

## 🔵 RF08 — Consulta de Histórico

O sistema deverá permitir consultar histórico de registros de ponto.

---

## 🔵 RF09 — Geração de Relatórios

O sistema deverá permitir gerar relatórios de jornada de trabalho.

---

## 🔵 RF10 — Controle Sequencial de Ponto

O sistema deverá liberar registros de ponto apenas na sequência correta:

1️⃣ Entrada  
2️⃣ Saída para almoço  
3️⃣ Volta do almoço  
4️⃣ Saída final  

---

## 🔵 RF11 — Controle de Permissões

O sistema deverá controlar permissões de acesso de acordo com o perfil do usuário.

---

# 🟨 5. Requisitos Não Funcionais

## 🟣 RNF01

O sistema deverá ser desenvolvido utilizando Java 21.

---

## 🟣 RNF02

O sistema deverá utilizar Spring Boot.

---

## 🟣 RNF03

O banco de dados utilizado será MariaDB.

---

## 🟣 RNF04

O sistema deverá seguir arquitetura REST.

---

## 🟣 RNF05

O sistema deverá utilizar autenticação JWT.

---

## 🟣 RNF06

O sistema deverá utilizar arquitetura em camadas.

---

## 🟣 RNF07

O sistema deverá ser versionado utilizando Git e GitHub.

---

## 🟣 RNF08

O sistema deverá retornar respostas em formato JSON.

---

## 🟣 RNF09

O sistema deverá possuir tratamento centralizado de exceções.

---

# 🟨 6. Atores do Sistema

## 👨‍💼 Administrador

Responsável por:

✅ cadastrar empresas  
✅ cadastrar funcionários  
✅ consultar relatórios  
✅ gerenciar acessos  

---

## 👨‍💻 Funcionário

Responsável por:

✅ realizar login  
✅ registrar pontos  
✅ consultar histórico de registros  

---

# 🟨 7. Casos de Uso

📌 cadastrar empresa  
📌 cadastrar funcionário  
📌 autenticar usuário  
📌 registrar entrada  
📌 registrar saída para almoço  
📌 registrar volta do almoço  
📌 registrar saída final  
📌 consultar histórico  
📌 gerar relatório  
📌 controlar permissões  

---

# 🟨 8. Fluxo Principal — Registro Completo da Jornada

## 🟢 Fluxo Principal

1️⃣ Funcionário realiza login  
2️⃣ Sistema valida usuário  
3️⃣ Funcionário registra entrada  
4️⃣ Sistema libera saída para almoço  
5️⃣ Funcionário registra saída para almoço  
6️⃣ Sistema libera volta do almoço  
7️⃣ Funcionário registra volta do almoço  
8️⃣ Sistema libera saída final  
9️⃣ Funcionário registra saída final  
🔟 Sistema encerra jornada  

---

# 🟨 9. Fluxos Alternativos

## 🟠 FA01 — Funcionário esqueceu senha

1️⃣ Funcionário solicita recuperação de senha  
2️⃣ Sistema envia instruções de recuperação  
3️⃣ Funcionário redefine senha  
4️⃣ Sistema atualiza credenciais  

---

## 🟠 FA02 — Funcionário consulta histórico

1️⃣ Funcionário realiza login  
2️⃣ Funcionário acessa histórico  
3️⃣ Sistema exibe registros anteriores  

---

# 🟨 10. Fluxos de Exceção

## 🔴 FE01 — Usuário inválido

1️⃣ Usuário informa credenciais incorretas  
2️⃣ Sistema bloqueia autenticação  
3️⃣ Sistema informa erro de login  

---

## 🔴 FE02 — Registro fora da sequência

1️⃣ Funcionário tenta registrar ponto fora da ordem correta  
2️⃣ Sistema bloqueia operação  
3️⃣ Sistema informa sequência inválida  

---

## 🔴 FE03 — Registro duplicado

1️⃣ Funcionário tenta registrar o mesmo tipo consecutivamente  
2️⃣ Sistema bloqueia operação  
3️⃣ Sistema informa duplicidade  

---

## 🔴 FE04 — Funcionário inexistente

1️⃣ Sistema tenta localizar funcionário  
2️⃣ Funcionário não é encontrado  
3️⃣ Sistema retorna erro  

---

# 🟨 11. Regras de Negócio

## 🟢 RN01

Todo funcionário deverá pertencer a uma empresa.

---

## 🟢 RN02

O e-mail do funcionário deverá ser único.

---

## 🟢 RN03

Todos os registros deverão possuir data e hora.

---

## 🟢 RN04

Somente usuários autenticados poderão acessar o sistema.

---

## 🟢 RN05

A saída para almoço somente poderá ser registrada após a entrada.

---

## 🟢 RN06

A volta do almoço somente poderá ser registrada após a saída para almoço.

---

## 🟢 RN07

A saída final somente poderá ser registrada após a volta do almoço.

---

## 🟢 RN08

O sistema não permitirá registros duplicados consecutivos.

---

## 🟢 RN09

Cada funcionário poderá possuir apenas uma jornada ativa por vez.

---

# 🟨 12. Tecnologias Utilizadas

💻 Java 21  
🌱 Spring Boot  
🗄️ Spring Data JPA  
🔄 Hibernate  
🐬 MariaDB  
📦 Maven  
🌿 Git  
🐙 GitHub  
📮 Postman  
🔐 JWT  

---

# 🟨 13. Arquitetura Inicial

O sistema seguirá arquitetura em camadas:

🟦 Controller  
🟩 Service  
🟨 Repository  
🟪 Model  
🟥 Database  

A comunicação será realizada através de API REST utilizando JSON.

---

# 🟨 14. Considerações Finais

Este documento define os requisitos iniciais do Sistema de Ponto Eletrônico, servindo como base para:

✅ modelagem  
✅ arquitetura  
✅ desenvolvimento backend  
✅ documentação técnica  
✅ metodologia ágil  
✅ organização corporativa  

O objetivo é simular um ambiente profissional real de engenharia de software utilizando boas práticas de mercado.
