# Café Aroma & Sabor - Gestão de Cafeteria

![Status](https://img.shields.io/badge/Status-Conclu%C3%ADdo-brightgreen)

## 📖 Sobre o Projeto

**Café Aroma & Sabor** é uma aplicação web para a gestão de uma cafeteria, desenvolvida como projeto prático do curso técnico de **Desenvolvimento de Software** no **SENAI "Antonio Ermírio de Moraes"** (Alumínio-SP).

O desafio foi aplicar o conhecimento em todo o **ciclo de desenvolvimento de software**, desde a concepção até a entrega, focando em transformar requisitos em uma aplicação funcional.

> **Nota**: O foco deste projeto foi a conclusão do ciclo de desenvolvimento em um ambiente de aprendizado. Portanto, a aplicação de padrões de arquitetura complexos e boas práticas de código (como SOLID, Clean Code, etc.) não foi uma prioridade. O objetivo era entregar uma solução funcional que atendesse aos requisitos definidos.


## ✨ Funcionalidades

-   **Controle de Estoque**: Gerenciamento de entrada e saída de produtos.
-   **CRUD de Produtos**: Cadastro, leitura, alteração e exclusão de produtos.
-   **Histórico de Movimentações**: Rastreamento de todas as transações de estoque.
-   **CRUD de Usuários**: Gerenciamento de funcionários com acesso ao sistema.
-   **Alertas**: Notificações para estoque baixo ou produtos próximos da validade.
-   **Autenticação**: Sistema de login para controle de acesso.

## 🛠️ Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring](https://img.shields.io/badge/Spring_Boot-3.5.6-green)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.5.6-darkgreen)
![JPA](https://img.shields.io/badge/JPA-Hibernate-orange)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3.3-purple)
![Maven](https://img.shields.io/badge/Maven-4.0-blue?logo=apache-maven)
## 🚀 Como Executar

Siga os passos abaixo para rodar a aplicação em seu ambiente local.

**Pré-requisitos:**

*   Java JDK 21 ou superior
*   Maven
*   Uma instância do MySQL em execução

**Passos:**

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/seu-usuario/provacola.git
    cd provacola
    ```

2.  **Configure o Banco de Dados:**
    *   No arquivo `src/main/resources/application.properties`, altere as propriedades `spring.datasource.url`, `spring.datasource.username` e `spring.datasource.password` com as credenciais do seu banco de dados.

3.  **Execute a aplicação:**
    ```bash
    mvn spring-boot:run
    ```

4.  **Acesse a aplicação:**
    *   Abra seu navegador e acesse `http://localhost:8080`.

## 🧠 Principais Aprendizados

-   Aplicação prática do ciclo de vida de desenvolvimento de software.
-   Experiência com o ecossistema Spring Boot (Spring MVC, Spring Data JPA).
-   Criação de interfaces web dinâmicas com Thymeleaf e integração com o backend.
-   Modelagem de dados e mapeamento objeto-relacional (ORM) com JPA/Hibernate.
-   Levantamento de requisitos funcionais e sua tradução em funcionalidades de software.
