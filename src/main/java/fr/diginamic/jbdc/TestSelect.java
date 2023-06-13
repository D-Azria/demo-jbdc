package fr.diginamic.jbdc;
import fr.diginamic.jbdc.entites.Fournisseur;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestSelect {
    private static final Logger LOG = LoggerFactory.getLogger(TestSelect.class);
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
        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PW);
             Statement monStatement = connection.createStatement();
             ResultSet curseur = monStatement.executeQuery("SELECT * FROM FOURNISSEUR")){

            while (curseur .next()){
            int id = curseur.getInt("ID");
            String nom = curseur.getString("NOM");
            Fournisseur f = new Fournisseur(id, nom);
            fournisseurs.add(f);
        }
            System.out.println();
        } catch (SQLException e){
            LOG.error(e.getMessage());
        }

        for (Fournisseur f:fournisseurs){
            System.out.println(f);
            LOG.info(String.valueOf(f));
        }

    }
}
