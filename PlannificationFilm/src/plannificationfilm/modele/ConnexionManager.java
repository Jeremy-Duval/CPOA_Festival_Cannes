/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.modele;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Manager pour initialiser et terminer la connection.
 * A appeler en début, on transmettera l'objet Connexion aux autres managers.
 * @author Jérémy
 * @since 16/12/2016
 */
public class ConnexionManager {
    Connection conn;
    
    public ConnexionManager() throws IOException, ClassNotFoundException, SQLException {
        this.init_connexion();
    }
    
    private void init_connexion() throws IOException, ClassNotFoundException, SQLException{
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
        conn = ConfigConnection.getConnection("connexion.properties"); // Creation et execution d'un ordre SQL
        
    }
    
    public void close_connexion() throws SQLException{
        conn.close();
    }
}
