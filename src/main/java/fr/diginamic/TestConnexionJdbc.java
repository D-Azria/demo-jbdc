package fr.diginamic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionJdbc {
    private static final String dbUrl = "jdbc:mariadb://localhost:3306/COMPTA2";
    private static final String dbUser = "root";
    private static final String dbPW = "root";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPW)){
            System.out.println(connection);
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
