/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.controleur;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import plannificationfilm.modele.CalendarManager;
import plannificationfilm.modele.ConnectionManager;

/**
 *
 * @author Yann
 */
public class PlannificationFilm {
    
    /**
     *
     */
    private static CalendarManager caManager;
    private static ConnectionManager cManager;
    public static void main(String[] args)
    {
        try {
                cManager = new ConnectionManager();
                caManager = new CalendarManager(cManager);
            } catch (IOException | ClassNotFoundException | SQLException ex) {
                Logger.getLogger(PlannificationFilm.class.getName()).log(Level.SEVERE, null, ex);
            }    
    }
    
    public void setCalendar() throws SQLException{
        String titre = new String();
        int categorie;
        String date = new String();

        ResultSet rset=caManager.getFilm();
        while (rset.next())
        {
            titre=rset.getString(1);
            categorie=rset.getInt(2);
            date=rset.getString(3);
            JTable1[categorie][date]=titre;
            /*switch (categorie)
            {
                case 1 :
            }*/
            
        }
        
        
    }
    
}
