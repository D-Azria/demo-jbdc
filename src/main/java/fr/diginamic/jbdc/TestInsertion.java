package fr.diginamic.jbdc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {
    private static final Logger LOG = LoggerFactory.getLogger(TestInsertion.class);
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
            int nb = monStatement.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('La Maison de la Peinture')");
            System.out.println(nb);
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }
    }
}
