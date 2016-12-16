/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.modele;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jeremy
 */
public class ModifyManager {
    ConnectionManager conn;
    /**
     * Constructeur du manager pour la modification de film.
     * @param connection : Connection
     * @author Jérémy
     * @since 16/12/2016
     */
    public ModifyManager(ConnectionManager connection){
        conn = connection;
    }
    
    public ResultSet getFilm() throws SQLException{
        Statement stmt = conn.createStatement();
        
        //A CHANGER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ResultSet rset = stmt.executeQuery("SELECT * FROM type;");

        System.out.println("Nom de la colonne : " + rset.getMetaData().getColumnName(1));

        stmt.close();

        return rset;
    }
}
