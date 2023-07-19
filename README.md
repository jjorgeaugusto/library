# library
O projeto é uma demonstração de um sistema de bibliotecas. 

<br/>

## Funcionalidades:
<ul>
    <li>Cadastrar livro</li>
    <li>Emprestar livro</li> 
    <li>Atualizar informações do livro</li>
    <li>Excluir livros</li>
    <li>Pesquisar livros</li>
    <li>Pesquisar livros disponiveis</li>
    <li>Pesquisar livros por nome</li>
</ul>

<br/>

## Dependências
<ul>
    <li>Gradle</li>
    <li>Java 17</li>
</ul>

<br/>

# Como executar o aplicativo
</br>

```
# Baixar imagem do banco de dados no DockerHub
docker pull post

# Criar novo container a partir da imagem do banco de dados MySQL
# Nesse comando também está incluso a criação do banco que a aplicação irá se conectar e configuração da senha do usuário root
docker run --name mymysql -p 3306:3306 -e MYSQL_DATABASE=biblioteca -e MYSQL_ROOT_PASSWORD=root -d mysql



<br/>

## Tecnologias
<ul>
    <li>Linguagem: Java</li>
    <li>Gerenciador de dependências: Gradle</li>
    <li>Banco de dados: postgreSQL</li>
    <li>Virtualização: Docker</li>
</ul>
