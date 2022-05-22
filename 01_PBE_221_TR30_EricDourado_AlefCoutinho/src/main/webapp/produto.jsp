<%-- 
    Document   : produto
    Created on : 21 de mai. de 2022, 17:31:00
    Author     : Álef Vieira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto</title>
        <link rel="stylesheet" href="assets/style.css"/>
    </head>
    <body>
        <header>
            <div class="container">
                <div><a href="/" class="logo"> <span class="span1">Projeto</span><span class="span2"> Avaliativo </span> <span class="span3"> do</span> <span class="span4">Rômulo</span> </a> </div>
                <div>
                    <ul>
                        <li><a href="/">Inicio</a> </li>
                        <li><a href="/cadastro">Cadastrar</a> </li>
                        <li>
                            <form action="/search" method="post" class="form_search">
                                <input type="text" name="pesquisa" placeholder="Pesquisar..."/>
                                <input type="submit" value="Pesquisar"/>    
                            </form>
                        </li>
                    </ul>

                </div>
            </div>
        </header>

        <main>
            <section class="container section-produto">
                <h1>Informações do Produto ${produto.nomeProduto}</h1>
                <h2>Código do produto: ${produto.id}</h2>
                <h2>Categoria: ${produto.categoria}</h2>
                <h2>Preço: ${produto.preco}</h2>
                <h2>quantidade: ${produto.quantidade}</h2>
                <h2>Descrição: </h2>
                <p>${produto.descricao}</p>
            </section>
        </main>

        <footer>
            <div class="container">
                <h4>Desnvolvido por Álef Vieira e Eric </h4>
                <p>Copyright © Todos os direitos reservados.</p>
            </div>
        </footer>

    </body>
</html>
