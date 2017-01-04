/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.modele;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

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
    
    /**
     * Affiche le resultSet
     * @param rset : ResultSet : requete à afficher
     * @throws SQLException 
     * @author Jérémy
     * @since 16/12/2016
     */
    public void afficherResultSet(ResultSet rset) throws SQLException {
        ResultSetMetaData rsmd = rset.getMetaData();//récupère les méta données de la table
        System.out.println(rset.next());
        while (rset.next()) {//on parcours chaque ligne
            System.out.println("*********************************************");
            int i = 1;//une table commence à 1 et non 0
            switch (rsmd.getColumnType(i)) {//on traite les différents types de colonnes possible pour utiliser la méthode get correspondante et afficher la donnée de la colonne
                case Types.BIGINT:
                    System.out.println(rset.getLong(i));
                    break;
                case Types.BIT:
                    System.out.println(rset.getBoolean(i));
                    break;
                case Types.BOOLEAN:
                    System.out.println(rset.getBoolean(i));
                    break;
                case Types.CHAR:
                    System.out.println(rset.getString(i));
                    break;
                case Types.DATE:
                    System.out.println(rset.getDate(i));
                    break;
                case Types.DECIMAL:
                    System.out.println(rset.getBigDecimal(i));
                    break;
                case Types.DOUBLE:
                    System.out.println(rset.getDouble(i));
                    break;
                case Types.FLOAT:
                    System.out.println(rset.getDouble(i));
                    break;
                case Types.INTEGER:
                    System.out.println(rset.getInt(i));
                    break;
                case Types.NUMERIC:
                    System.out.println(rset.getBigDecimal(i));
                    break;
                case Types.REAL:
                    System.out.println(rset.getFloat(i));
                    break;
                case Types.SMALLINT:
                    System.out.println(rset.getShort(i));
                    break;
                case Types.TIME:
                    System.out.println(rset.getTime(i));
                    break;
                case Types.TIMESTAMP:
                    System.out.println(rset.getTimestamp(i));
                    break;
                case Types.TINYINT:
                    System.out.println(rset.getByte(i));
                    break;
                case Types.VARCHAR:
                    System.out.println(rset.getString(i));
                    break;
                default:
                    System.out.println("Type de colonne non traité");
            }
            i++;
        }
    }
}
