
<%@page import="Modelo.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Produtos!</h1>
        
        <td>Id</td>
        <td>Descrição</td>
        <td>Preço</td>
        <br></br>
            <table border ="1">
    <%
        List<Produto> listar = (List<Produto>) request.getAttribute("todosProdutos");
        
            for ( Produto p : listar){
          %>
      
              <tr>
                  
                  <td><%=p.getId()%></td>
                  <td><%=p.getDescricao()%></td>
                  <td><%=p.getPreco()%></td>
                  
                  
              </tr>
         
         <%
                }
            
         %>
          </table>
         <br></br>
         <a href="Form.jsp"> Voltar </a>
    </body>
</html>
