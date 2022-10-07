package br.com.storeshoes.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FxmlMainController implements Initializable {

    @FXML
    private MenuItem menuItemCadastroProduto;

    @FXML
    private MenuItem menuItemConsultarProduto;

    @FXML
    private AnchorPane anchorPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void handleMenuItemCadastroProduto() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("br/com/storeshoes/view/FxmlCadastroProduto.fxml"));
       anchorPane.getChildren().setAll(a);

    }

}
