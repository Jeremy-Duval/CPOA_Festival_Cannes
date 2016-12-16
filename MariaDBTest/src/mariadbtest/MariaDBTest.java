/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariadbtest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Adrien
 */
public class MariaDBTest {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
            // Charge le driver
            try {
                Class.forName("org.mariadb.jdbc.Driver"); //oracle.jdbc.driver.OracleDriver ?
            } catch (Exception e) {
                System.out.println("Impossible de charger le driver");
                return;
            }
        // Creation et execution d'un ordre SQL
            // Connexion à la base
            // Exemple à ne pas suivre : les informations de connexion sont en dur
            //Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@iutdoua-oracle.univ-lyon1.fr:1521:orcl", "p1501022", "239601"); // Creation et execution d'un ordre SQL
            Connection conn = ConfigConnection.getConnection("connexion.properties"); // Creation et execution d'un ordre SQL
            Statement stmt = conn.createStatement();
            // Récupère les données
            conn.setAutoCommit(false);

            ResultSet rset = stmt.executeQuery("SELECT * FROM type;");

            System.out.println("Nom de la colonne : " + rset.getMetaData().getColumnName(1));

            stmt.close();
            conn.close();

        
    }
    
}
