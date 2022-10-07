package br.com.storeshoes.model;

import br.com.storeshoes.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class ProdutoDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean remover(Produto Produto) {
        String sql = "DELETE FROM Produtos WHERE cdProduto=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            //stmt.setInt(1, Produto.getCategoria());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public List<Produto> listar() {
        String sql = "SELECT * FROM Produtos";
        List<Produto> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
               Produto produto = new Produto();
               produto.setCodigoProduto(resultado.getInt("codigoproduto"));
               produto.setTamanho(resultado.getString("tamanho"));
               produto.setCategoria(resultado.getString("Categoria"));
               produto.setCor(resultado.getString("cor"));
               produto.setPreco(resultado.getBigDecimal("preco"));
               produto.setMarca(resultado.getString("marca"));
               produto.setDataCadastro(resultado.getDate("datacadastro"));
               produto.setQuantidadeEstoque(resultado.getInt("quantidadeEstoque"));
               produto.setDescricao(resultado.getString("descricao"));
               retorno.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(retorno);
        return retorno;
    }

}
