# Instruções para Rodar o Frontend

Este é o frontend de uma aplicação para cadastro de usuários e gerenciamento de produtos.

## Como Executar o Frontend

1. **Instale as Dependências**: Antes de rodar a aplicação, é necessário instalar todas as dependências. No diretório do projeto, execute o seguinte comando:

   ```bash
   npm install
   ```

2. **Inicie o Servidor de Desenvolvimento**: Após a instalação das dependências, inicie o servidor de desenvolvimento com o seguinte comando:

   ```bash
   ng serve
   ```

3. **Acesse o Frontend**: O frontend estará disponível na URL padrão [http://localhost:4200](http://localhost:4200).

## Funcionalidades Principais

### Página Inicial e Login

- Ao acessar a aplicação, você será redirecionado para a rota padrão que é a página de **login**.
- Nesta página, é possível realizar o cadastro de um novo usuário clicando na opção de **cadastro**.

### Após o Login

- Uma vez logado, a aplicação carregará os produtos de **todos os usuários**.
- Os produtos serão exibidos como uma lista onde você poderá visualizar os itens cadastrados por outros usuários.

### Página Admin

- Ao acessar a página de **Admin**, você verá apenas **seus produtos** cadastrados.
- Nesta página, é possível excluir qualquer um dos seus produtos cadastrados clicando no botão **Excluir**.

## Notas Adicionais

- Certifique-se de que o backend da aplicação esteja rodando para que o frontend possa carregar os dados corretamente.
