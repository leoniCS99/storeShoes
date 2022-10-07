package br.com.storeshoes.controller;

import br.com.storeshoes.database.Database;
import br.com.storeshoes.database.DatabaseFactory;
import br.com.storeshoes.Produto;
import br.com.storeshoes.model.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

public class FxmlCadastroProduto implements Initializable {

    @FXML
    private TableView<Produto> tableViewProdutos;

    @FXML
    private TableColumn<Produto, String> tableColumnNomeProduto;

    @FXML
    private TableColumn<Produto, Integer> tableColumnQuantidadeProduto;

    @FXML
    private Button buttonInserir;

    @FXML
    private Button buttonAlterar;

    @FXML
    private Button buttonRemover;

    @FXML
    private Label labelDescricao;

    @FXML
    private Label tamanho;

    @FXML
    private Label codigoProduto;

    @FXML
    private Label cor;

    @FXML
    private Label preco;

    @FXML
    private Label marca;

    @FXML
    private Label quantidadeEstoque;

    @FXML
    private Label dataCadastro;

    @FXML
    private Label categoria;

    private List<Produto> listProdutos;

    private ObservableList<Produto> observableProdutos;

    private final Database database = DatabaseFactory.getDatabase("postgresql");
    private final Connection connection = database.conectar();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        produtoDAO.setConnection(connection);
        carregarTableViewProdutos();

        tableViewProdutos.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewProdutos(newValue));
    }


    public void carregarTableViewProdutos(){
        tableColumnNomeProduto.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableColumnQuantidadeProduto.setCellValueFactory(new PropertyValueFactory<>("quantidadeEstoque"));

        listProdutos = produtoDAO.listar();
        observableProdutos = FXCollections.observableArrayList(listProdutos);
        tableViewProdutos.setItems(observableProdutos);


    }

    public void selecionarItemTableViewProdutos(Produto produto){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        if (produto != null){
            codigoProduto.setText(String.valueOf(produto.getCodigoProduto()));
            tamanho.setText(produto.getTamanho());
            cor.setText(produto.getCor());
            preco.setText(String.valueOf(produto.getPreco()));
            marca.setText(produto.getMarca());
            dataCadastro.setText(formatter.format(produto.getDataCadastro()));
            categoria.setText(produto.getCategoria());
        }else {
            codigoProduto.setText("");
            tamanho.setText("");
            cor.setText("");
            preco.setText("");
            marca.setText("");
            dataCadastro.setText("");
            categoria.setText("");
        }

    }


}
