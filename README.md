# A casa do código

Para iniciar um projeto spring MVC deve-se seguir os passos abaixo.

1) Via linha de comando entrar no diretorio da forge e criar um novo projeto.

``` cd /home/rafael/desenvolvimento/arquivosDesenvolvimento/forge/bin/./forge ```

2) Nesse ponto ele irá abrir o terminal do forge, aqui digitamos o código para criar o projeto.

``` project-new --named casadocodigo```

3) Após a criação do projeto iremos abrir o eclipse, e importar o projeto MAVEN já existente.

``` File > Import > Existing Maven Project > Ir até o diretório do projeto ```

# URL's

Cadastro de produtos: http://localhost:8080/casadocodigo/produtos/form

Lista de produtos: http://localhost:8080/casadocodigo/produtos

# Anotações Geral
O ModelAndView é uma classe do Spring que faz um relacionamento de um modelo (model) com uma visualização (view) . Este além de poder disponibilizar um outro objeto qualquer para a view pode fazer outras operações, como redirecionamento de páginas, entre outras. Veremos mais sobre ModelAndView posteriormente.

Quando fizermos um GET para /produtos o Spring deve chamar o método listar do nosso ProdutosController . Quando fizermos um POST para /produtos ele deve chamar o gravar, enviando um produto para ser gravado no banco de dados.
