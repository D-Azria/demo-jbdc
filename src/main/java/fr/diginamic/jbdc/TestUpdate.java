package fr.diginamic.jbdc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {
    private static final Logger LOG = LoggerFactory.getLogger(TestUpdate.class);
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

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
             Statement monStatement = connection.createStatement()){
            int nb = monStatement.executeUpdate("UPDATE FOURNISSEUR SET NOM='La Maison des Peintures' WHERE NOM='La Maison de la Peinture'");
            LOG.info(String.valueOf(nb));
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }
    }
}
