# Sistema de Gestão de Pedidos para E-commerce

Projeto Integrador da Unidade Curricular **Desenvolvimento Back-end**
Curso Superior de Tecnologia em **Análise e Desenvolvimento de Sistemas** — Turma **CSTADS601**

---

## Equipe Vex

| Integrante                | Função                          |
| ------------------------- | ------------------------------- |
| **Felipe Mazzi**          | Responsável do dia              |
| **Eduardo Duran Teodoro** | Desenvolvimento e apoio técnico |

---

## Contextualização

O desenvolvimento back-end é uma competência essencial para a construção de sistemas estruturados, seguros e escaláveis. Este projeto tem como objetivo aplicar conceitos de **Programação Orientada a Objetos (POO)**, **versionamento com Git**, **testes automatizados** e **boas práticas de arquitetura de software**, simulando um ambiente real de desenvolvimento em equipe.

A atividade foi proposta na **Situação de Aprendizagem Desafiadora — Sistema de Gestão de Pedidos para E-commerce**, na qual uma equipe de desenvolvimento deve construir um sistema capaz de gerenciar produtos, clientes, pedidos e pagamentos, permitindo futura integração com outros sistemas e evolução contínua da aplicação.

---

## Objetivo do Projeto

Desenvolver um **sistema completo de gestão de pedidos para um e-commerce**, contemplando:

* Cadastro e gerenciamento de **produtos**;
* Cadastro e gerenciamento de **clientes**;
* Criação e acompanhamento de **pedidos**;
* Processamento de **pagamentos**;
* Aplicação dos princípios de **POO**;
* Uso de **Git/GitHub** com fluxo colaborativo;
* Implementação de **testes automatizados**;
* Evolução futura para **Spring Boot**, **API RESTful** e **CI/CD**.

---

## Funcionalidades Previstas

* [ ] Cadastro e Gerenciamento de produtos
* [ ] Cadastro e Gerenciamento de clientes
* [ ] Criação e Gerenciamento de pedidos
* [ ] Processamento de pagamentos (Pix, boleto e cartão)
* [ ] Tratamento de exceções
* [ ] Testes unitários e integração
* [ ] Persistência em banco de dados
* [ ] API RESTful para consumo pelo front-end
* [ ] Pipeline de integração contínua (CI/CD)

---

## Tecnologias Utilizadas

| Tecnologia | Finalidade                       |
| ---------- | -------------------------------- |
| **Java**   | Linguagem principal              |
| **Maven**  | Gerenciamento de dependências    |
| **Git**    | Controle de versão               |
| **GitHub** | Repositório remoto e colaboração |

### Tecnologias previstas para evolução

* Spring Boot
* JUnit 5
* Mockito
* PostgreSQL
* GitHub Actions
* Swagger / OpenAPI

---

## Estrutura do Projeto

```text
ecommerce-pedidos-vex/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/vex/ecommerce/
│   │           ├── modelo/
│   │           ├── servico/
│   │           ├── repositorio/
│   │           ├── excecao/
│   │           └── util/
│   └── test/
│       └── java/
│           └── com/vex/ecommerce/
├── pom.xml
├── README.md
├── LICENSE.txt
└── .gitignore
```

---

## Evolução do Projeto por Aula

| Aula   | Entrega                                                          |
| ------ | ---------------------------------------------------------------- |
| **01** | Estrutura inicial do repositório e README                        |
| **02** | Fluxo de branches e Pull Request                                 |
| **03** | Classe utilitária (`Utils`)                                      |
| **04** | Classes de domínio: `Produto`, `Cliente`, `Pedido`, `ItemPedido` |
| **05** | Encapsulamento e abstração                                       |
| **06** | Herança para formas de pagamento                                 |
| **07** | Relacionamentos entre entidades                                  |
| **08** | Polimorfismo no módulo de pagamento                              |
| **09** | Tratamento de exceções                                           |
| **10** | Testes unitários                                                 |
| **11** | Testes de integração                                             |
| **12** | Persistência — Create e Read                                     |
| **13** | Persistência — Update, Delete e Repository                       |
| **14** | Migração para Spring Boot                                        |
| **15** | API REST + CI/CD                                                 |
| **16** | Documentação final, deploy e apresentação                        |

---

## Critérios Técnicos Considerados

O projeto será desenvolvido observando os principais critérios definidos para a UC:

* Aplicação adequada de **POO**;
* Uso de **encapsulamento, abstração, herança e polimorfismo**;
* Commits **descritivos e organizados**;
* Utilização de **branches** e **merge requests**;
* Implementação de **testes automatizados**;
* Cobertura mínima de **70%**;
* Configuração de **pipeline CI/CD**;
* Documentação técnica da arquitetura e das decisões de projeto.

---

## Como Executar

### Pré-requisitos

* Java 17 ou superior
* Maven 3.9+
* Git

### Clonar o repositório

```bash
git clone https://github.com/femazzi/ecommerce-pedidos-vex.git
cd ecommerce-pedidos-vex
```

> **Observação:** nesta etapa inicial do projeto algumas funcionalidades ainda estão em desenvolvimento e serão adicionadas progressivamente ao longo das aulas.

---

## Entregas Esperadas ao Final do Semestre

* Código-fonte **organizado e versionado**;
* Histórico consistente de commits;
* **Testes unitários e de integração**;
* Cobertura significativa de testes;
* **Documentação técnica detalhada**;
* **Pipeline CI/CD funcional**;
* Relatório técnico com justificativas de **arquitetura e design patterns** adotados.

---

## Regras da Equipe

1. Respeitar os prazos definidos em aula;
2. Realizar commits frequentes e descritivos;
3. Revisar alterações antes de realizar merge;
4. Manter comunicação clara entre os integrantes;
5. Colaborar na documentação e nos testes do projeto.

---

## Divisão do Trabalho

| Integrante | Módulo | Branch |
|---|---|---|
| Eduardo Duran | Produto | `feature/cadastro-produto` |
| Eduardo Duran | Pedidos | `feature/pedidos` |
| Felipe Mazzi | Cliente | `feature/cadastro-cliente` |
| Felipe Mazzi | Pagamentos | `feature/pagamentos` |

### Responsabilidades

**Eduardo Duran**
- Responsável pelo módulo de Produto. 
- Criar o esqueleto da classe `Produto`.
- Preparar a estrutura de testes do módulo.
- Manter a documentação relacionada ao módulo de Produto.

**Felipe Mazzi**
- Responsável pelo módulo de Cliente.
- Criar o esqueleto da classe `Cliente`.
- Preparar a estrutura de testes do módulo.
- Manter a documentação relacionada ao módulo de Cliente.

---

## Fluxo de Trabalho

Para manter o projeto organizado, a equipe seguirá o fluxo:

1. A branch `main` representa a versão principal e estável do projeto.
2. Cada integrante deve trabalhar em sua própria branch.
3. As branches de funcionalidades seguirão o padrão:
   `feature/nome-do-modulo`
4. Nenhum integrante deve realizar commits diretamente na `main`.
5. As alterações devem ser enviadas por meio de um Pull Request.
6. Todo Pull Request deverá ser revisado e aprovado antes do merge.
7. Os commits devem ser pequenos e representar uma única alteração.
8. Após o merge, a branch da funcionalidade poderá ser excluída.

### Padrão de Commits

Os commits seguirão o padrão:

`tipo: descrição da alteração`

### Convenção de Branches

As branches seguirão o padrão:

`feature/nome-do-modulo`

---

## Licença MIT

Projeto **acadêmico**, desenvolvido para fins educacionais na **Faculdade de Tecnologia SENAI "Antonio Adolpho Lobbe"**.

---

## Status do Projeto

**Em desenvolvimento — Aula 02**