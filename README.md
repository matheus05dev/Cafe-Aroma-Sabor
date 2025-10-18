# Café Aroma & Sabor

Este é um projeto simples desenvolvido para praticar a integração de **Thymeleaf** com **Spring Boot**.

**Atenção**: Este projeto foi criado com o objetivo de aprendizado rápido e, portanto, **não segue as melhores práticas de desenvolvimento** ou padrões de arquitetura recomendados para aplicações em produção. O foco principal é a funcionalidade e a demonstração do uso do Thymeleaf para renderização de páginas web dinâmicas.

## Tecnologias Utilizadas

*   Spring Boot
*   Thymeleaf
*   Java
*   Jakarta Persistence API (JPA) para persistência de dados

## Funcionalidades (Requisitos Funcionais - RFs)

O projeto implementa as seguintes funcionalidades principais:

*   **RF: Gerenciamento de Estoque**: Permite a entrada e saída de produtos do estoque, registrando as movimentações.
*   **RF: CRUD de Produtos**: Funcionalidades completas para Cadastro, Leitura, Alteração e Exclusão de informações de produtos.
*   **RF: Histórico de Movimentação de Estoque**: Mantém um registro detalhado de todas as transições de estoque, incluindo quem realizou a movimentação e a data.
*   **RF: CRUD de Usuários**: Funcionalidades completas para Cadastro, Leitura, Alteração e Exclusão de usuários (funcionários).
*   **RF: Alertas de Estoque**: Emite avisos quando a quantidade de um produto no estoque está abaixo do mínimo definido ou quando a data de validade está próxima.
*   **RF: Login de Usuários**: Sistema de autenticação para acesso à aplicação.

## Modelos de Dados (Entidades)

As principais entidades do sistema são:

### `Produto`
Representa um item que pode ser armazenado no estoque.
*   `id`: Identificador único do produto.
*   `nome`: Nome do produto.
*   `marca`: Marca ou fornecedor do produto.
*   `codigoInterno`: Código de identificação interno do produto.
*   `tipo`: Categoria do produto (ex: grãos, café moído, acessórios).

### `Estoque`
Gerencia as informações de estoque para cada produto.
*   `id`: Identificador único do registro de estoque.
*   `quantidadeAtual`: Quantidade atual do produto em estoque.
*   `estoqueMinimo`: Quantidade mínima desejável em estoque para o produto.
*   `dataValidade`: Data de validade do lote atual do produto (pode ser associada a um lote específico).
*   `produto`: Referência ao `Produto` associado a este registro de estoque.
*   **Funcionalidade**: Gera um aviso se a `quantidadeAtual` for menor ou igual ao `estoqueMinimo`.

### `MovimentacaoEstoque`
Registra cada transação de entrada ou saída de produtos no estoque.
*   `id`: Identificador único da movimentação.
*   `produto`: Referência ao `Produto` que foi movimentado.
*   `tipoMovimento`: Tipo da movimentação (entrada ou saída).
*   `quantidade`: Quantidade de itens movimentados.
*   `lote`: Lote do produto movimentado.
*   `dataValidade`: Data de validade do lote movimentado.
*   `dataMovimentacao`: Data em que a movimentação ocorreu.
*   `responsavel`: Nome ou identificador do usuário que realizou a movimentação.

### `Usuario`
Representa um funcionário com acesso ao sistema.
*   `id`: Identificador único do usuário.
*   `username`: Nome de usuário para login.
*   `senha`: Senha do usuário.
*   `nome`: Nome completo do funcionário.
*   `email`: Endereço de e-mail do funcionário.
*   `cpf`: Cadastro de Pessoa Física do funcionário.

## Como Rodar

**Importante**: Antes de rodar a aplicação, verifique e configure as propriedades de conexão com o banco de dados no arquivo `src/main/resources/application.properties` para evitar problemas.

1.  Clone o repositório.
2.  Abra o projeto em sua IDE favorita (IntelliJ IDEA, Eclipse, etc.).
3.  Execute a classe principal da aplicação Spring Boot.
4.  Acesse `http://localhost:8080` no seu navegador.