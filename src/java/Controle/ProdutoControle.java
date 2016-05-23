package Controle;


import Modelo.Produto;
import Modelo.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="ProdutoControle", urlPatterns = {"/cadastrarproduto","/alterarproduto","/excluirproduto","/consultarporID", "/listarprodutos"})
public class ProdutoControle extends HttpServlet {
    private Object con;
  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                   
        String uri = request.getRequestURI();
       
        
        if (uri.equals(request.getContextPath() + "/cadastrarproduto")){
    
            try {
                cadastrar(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            } else if (uri.equals(request.getContextPath()+"/alterarproduto")){
            try {
                alterar (request,response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else if (uri.equals(request.getContextPath() + "/excluirproduto")){
            try {
                excluir (request,response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else if (uri.equals(request.getContextPath() + "/consultarporID")){
                
            try {
                consultarPorID (request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else if (uri.equals(request.getContextPath() + "/listarprodutos")){
                
            try {
                consultarTodos (request,response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }           
       
        }      

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        
        ProdutoDAO p = new ProdutoDAO();
        
        Produto p2 = new Produto();
        
        //int id = Integer.parseInt(request.getParameter("texto"));
        String desc = request.getParameter("texto2");
        double prec = Double.parseDouble(request.getParameter("texto3"));
        //String btn = request.getParameter("btncad");
              
        // p2.setId(id);
        p2.setDescricao(desc);
        p2.setPreco(prec);
        
        p.cadastrar(p2);
        
        
        response.sendRedirect("sucess.jsp");
       
    }

   /* private void atualizar(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    private void alterar (HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        
        ProdutoDAO p = new ProdutoDAO();
        Produto p2 = new Produto();
        
        String desc = request.getParameter("texto4");
        int id = Integer.parseInt(request.getParameter("texto1"));
        
        p2.setId(id);
        p2.setDescricao(desc);
        
        p.atualizar(p2);
        
        response.sendRedirect("sucess.jsp");
        
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        
        ProdutoDAO p = new ProdutoDAO();
        Produto p2 = new Produto();
        
        int id = Integer.parseInt(request.getParameter("texto1"));
        
        p2.setId(id);
        
        p.excluir(p2);
        
        response.sendRedirect("sucess.jsp");
        
        
    }

    private void consultarPorID(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException {
    
        ProdutoDAO p = new ProdutoDAO();
        Produto p2 = new Produto();
        
        int id = Integer.parseInt(request.getParameter("p"));
        
        p2.setId(id);
        
        p.consultarPorID(p2);
        
        // request.setAttribute("Produto", p.consultarPorID(p2));
        
       // request.getRequestDispatcher("Form.jsp").forward(request, response);
    
    }

    private void consultarTodos(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        

       ProdutoDAO p = new ProdutoDAO();
        Produto p2 = new Produto();
        
        List<Produto> c = p.consultarTodos();
        
        request.setAttribute("todosProdutos", c);
        
        request.getRequestDispatcher("saidalista.jsp").forward(request, response);
    }
     
    
    
}

