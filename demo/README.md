# API para Cadastro de Usuários e Autenticação através do Login

Esta API permite o cadastro de usuários e autenticação via login. As rotas de produtos são protegidas através da autenticação fornecida nos **headers** de cada requisição, com uma validação do token informado no header.

Caso o token seja inválido ou inexistente, será retornado o erro **403 Forbidden** na requisição de produtos.

## Funcionalidades

Atualmente, é possível realizar um CRUD de produtos baseado no usuário logado. Esses produtos são listados em um frontend como se fossem uma lista de anúncios possíveis.

No momento, o frontend não possui funcionalidades adicionais, mas há planos para adicionar novos recursos, como:

- **Lista de Desejos:** Onde os usuários poderiam salvar os produtos de interesse.
- **Sistema de Mensageria:** Permitiria o envio de uma mensagem ao usuário que anunciou um produto, informando o interesse em adquiri-lo.

## Funcionalidades do Frontend

A aplicação frontend permite:

- **Login e Cadastro de Usuários.**
- **Listagem de Todos os Produtos** e dos produtos que você anunciou na página de administração.
- **Deleção de Produtos Anunciados** diretamente pela página de administração.

## Documentação da API

Para uma melhor visualização dos endpoints e parâmetros esperados em cada requisição, acesse o **Swagger** implementado nesta API através da URL:

[http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/)

## Instruções para Rodar o Projeto

Antes disso é necessario subir o ambiente do banco de dados que no caso e um banco postgresql,
atualmente ja vem com um arquivo de bkp que servira para voce subir o banco para o qual o springboot vai fazer a conexao,
as tabelas e as relaão sao criadas atraves do SPRING Data JPA nao nao exige um arquivo de initSQL para definir as tabelas e as rekações desse banco:




Este projeto é baseado no framework **Spring Boot**. Siga as instruções abaixo para rodar a aplicação localmente:

1. **Clone o Repositório**: Clone este repositório para sua máquina local.

2. **Instale as Dependências**: No diretório do projeto, execute o comando abaixo para instalar as dependências e construir o projeto:

3. Necessário ter a versão 17 do Java e versão 3 ou mais do Maven
   ```bash
   mvn install
   mvn spring-boot:run
   
