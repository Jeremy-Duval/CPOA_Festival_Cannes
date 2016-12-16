/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.modele;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Manager pour initialiser et terminer la connection.
 * A appeler en début, on transmettera l'objet Connexion aux autres managers.
 * @author Jérémy
 * @since 16/12/2016
 */
public class ConnectionManager {
    Connection conn;
    
    /**
     * Initialise la connexion via une fonction.
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException 
     * @author Jérémy
     * @since 16/12/2016
     */
    public ConnectionManager() throws IOException, ClassNotFoundException, SQLException {
        this.init_connexion();
    }
    
    /**
     * Créer la connexion via une fonction.
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException 
     * @author Jérémy
     * @since 16/12/2016
     */
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
        conn = ConfigConnection.getConnection("connexion.properties"); // Creation et execution d'un ordre SQL
        
    }
    
    /**
     * Ferme la connexion.
     * @throws SQLException 
     * @author Jérémy
     * @since 16/12/2016
     */
    public void close_connexion() throws SQLException{
        conn.close();
    }
    
    /**
     * Créer un Statement
     * @return stmt : Statement
     * @throws SQLException 
     * @author Jérémy
     * @since 16/12/2016
     */
    public Statement createStatement() throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt;
    }
}
