/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariadbtest;

import java.sql.Connection;
import java.sql.DriverManager;
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
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName( "org.mariadb.jdbc.Driver" );
        Connection connection = DriverManager.getConnection("jdbc:mariadb://iutdoua-web.univ-lyon1.fr:3306/p1503760?user=p1503760&password=241494");

            // Creation et execution d'un ordre SQL
        Statement stmt = connection.createStatement ();
        ResultSet rset = stmt.executeQuery ("SELECT * FROM type");

        System.out.println("Nom de la colonne : " + rset.getMetaData().getColumnName(1));
    }
    
}
