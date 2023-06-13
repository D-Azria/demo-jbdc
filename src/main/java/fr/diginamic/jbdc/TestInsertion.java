package fr.diginamic.jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PW;
    private static final String DB_NAME;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        DB_URL = bundle.getString("database.driver")+bundle.getString("database.dist_url")+":"+bundle.getString("database.dist_port")+"/"+bundle.getString("database.dist_name");
        DB_USER = bundle.getString("database.dist_user");
        DB_PW = bundle.getString("database.dist_pwd");
        DB_NAME = bundle.getString("database.dist_name");

    }
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
             Statement monStatement = connection.createStatement()){
            int nb = monStatement.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('La Maison de la Peinture')");
            System.out.println(nb);
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}