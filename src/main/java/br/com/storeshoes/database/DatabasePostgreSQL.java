package br.com.storeshoes.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabasePostgreSQL implements Database {
    private Connection connection;

    public DatabasePostgreSQL() {
    }

    public Connection conectar() {
        try {
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/storeShoes", "postgres", "master");
             if (connection != null){
                System.out.println("conexão realizada com Sucesso");
            }

            return this.connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void desconectar(Connection conn) {

    }

}
