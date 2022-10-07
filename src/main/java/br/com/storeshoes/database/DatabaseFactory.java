package br.com.storeshoes.database;

public class DatabaseFactory {

    public static Database getDatabase(String nome) {
        if (nome.equals("postgresql")) {
            return new DatabasePostgreSQL();
        }

        return null;
    }

}
