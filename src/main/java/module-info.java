module br.com.storeshoes {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens br.com.storeshoes  to javafx.fxml;
    exports br.com.storeshoes;
    exports br.com.storeshoes.controller;
    opens br.com.storeshoes.controller to javafx.fxml;
}