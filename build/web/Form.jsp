<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     </head>
    <body>
        <h1> Cadastrar Produtos </h1>
        <form action="cadastrarproduto" method="GET">
            
            <p>Cadastro de Produtos:</p>
            
            <p> Descrição do Produto:</p> <input type="text" name="texto2">
            <p> Preço do Produto:<p> <input type="text" name="texto3">
                <input type="submit" name="btncad" value="Cadastrar">  <br>
        </form>   
         <h1> Alterar Produtos </h1>
        <form action="alterarproduto" method="GET">
            
            <p>Alterar produto:</p>
            
            <p>Id do Produto:</p> <input type="text" name="texto1">
            <p> Nova Descrição do Produto:</p> <input type="text" name="texto4">
            
            <input type="submit" name="btncad" value="Alterar"> <br>
        </form>   
         <h1> Excluir Produtos </h1>
        <form action="excluirproduto" method="GET">
            
            <p>Excluir produto:</p>
            
            <p>Produto ID:</p> <input type="text" name="texto1">
            
            
            <input type="submit" name="btncad" value="Excluir">
         </form>   
         <h1> Consultar Produto por ID </h1>
        <form action="consultarporID" method="GET">
            
            <p>Consultar produto:</p>
            
            <p>Produto ID:</p> <input type="text" name="texto5">      
            
            <%request.getAttribute("Produto");%> 
            
           
            <input type="submit" name="btncad" value="Consultar">
        </form>
        <p>Consultar Todos:</p>
        <a href = "listarprodutos">Consultar</a>
        
        <%request.getAttribute("Produto");%> 
        
        </form> 
    </body>
</html>
