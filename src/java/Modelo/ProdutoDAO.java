package Modelo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {
    
    
    public void cadastrar (Produto produto) throws ClassNotFoundException, SQLException{
     Connection con = FabricaConexao.getConexao();
     
        PreparedStatement comando = con.prepareStatement("insert into Produto (descricao, preco) values (?,?)");
     comando.setString(1, produto.getDescricao());
     comando.setDouble(2, produto.getPreco());
     comando.execute();
     
     con.close();
    } 
    
    
     public void atualizar (Produto produto) throws ClassNotFoundException, SQLException{
     Connection con = FabricaConexao.getConexao();
     
     PreparedStatement comando= con.prepareStatement("update Produto set descricao =? where id = ?");
     comando.setString(1,produto.getDescricao() );
     comando.setInt(2, produto.getId() );
     
     comando.execute();
     
     con.close();
    
    }
     
     public void excluir (Produto produto) throws ClassNotFoundException, SQLException{
     Connection con = FabricaConexao.getConexao();
     
     PreparedStatement comando= con.prepareStatement("delete from Produto where id = ?");
     comando.setInt(1, produto.getId() );   
   
     comando.execute();
     
     con.close();
     
    }
         
    
    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException{
        
    Connection con = FabricaConexao.getConexao();
    
    PreparedStatement comando = con.prepareStatement("select id, descricao, preco from Produto");
    ResultSet resultado = comando.executeQuery();
    
    List<Produto> todosProdutos = new ArrayList<Produto>();
    while (resultado.next()){
        
        Produto p = new Produto();
        
        p.setId(resultado.getInt("id"));
        p.setDescricao(resultado.getString("descricao"));
        p.setPreco(resultado.getDouble("preco"));
        
        todosProdutos.add(p);
        
    }
    
    con.close();
    
    return todosProdutos;
    }
    
    public Produto consultarPorID (Produto produto) throws ClassNotFoundException, SQLException{
    
        
    Connection con = FabricaConexao.getConexao();
    
    PreparedStatement comando = con.prepareStatement("select id, descricao, preco from Produto where id = ?");
    
      
    comando.setInt(1, produto.getId() );   
    
    ResultSet resultado = comando.executeQuery();
    
    if (resultado.next()){
    
    produto.setId(resultado.getInt("id"));
    produto.setDescricao(resultado.getString("descricao"));
    produto.setPreco(resultado.getDouble("preco"));
    }
    
    return produto;
}

    
}

