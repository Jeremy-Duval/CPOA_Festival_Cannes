/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yann
 */
public class CalendarManager {

    ConnectionManager conn;
    
    public CalendarManager(ConnectionManager connection){
        conn=connection;
    }
    
    public ResultSet getFilm() throws SQLException {
        ResultSet rset;
        try (Statement stmt = conn.createStatement()) {
            rset = stmt.executeQuery("SELECT titre,id_categorie, datetime FROM films, creneaux where creneaux.id_film=films.id ;");
        }
        return rset;
    }
    
}
