package fr.diginamic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionJdbc {


    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PW;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        DB_URL = bundle.getString("database.dist_url");
        DB_USER = bundle.getString("database.dist_user");
        DB_PW = bundle.getString("database.dist_pwd");

    }
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PW)){
            System.out.println(connection);
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
