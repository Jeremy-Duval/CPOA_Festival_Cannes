/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Yann
 */
public class CalendarManager {

    ConnectionManager conn;
    
    public CalendarManager(ConnectionManager connection){
        conn=connection;
    }
    
    
    public class abTableModel extends AbstractTableModel
    {
        private Object[][] data;
        private String[] title;
        
        public abTableModel(Object[][] data, String[] title){
            this.data=data;
            this.title=title;
        }

        

        @Override
        public int getRowCount() {
            return this.data.length;
        }

        @Override
        public int getColumnCount() {
            return this.title.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return this.data[row][col];
        }
        
        public ResultSet getFilm() throws SQLException {
        ResultSet rset;
        try (Statement stmt = conn.createStatement()) {
            rset = stmt.executeQuery("SELECT titre,id_categorie, datetime FROM films, creneaux where creneaux.id_film=films.id ;");
        }
        return rset;
        }
        
        public void setValueAt(String nom, int row, int col, int index)
        {
        data[row][col]= nom;
        fireTableCellUpdated(row, col);
        }
        
        public void setCalendar() throws SQLException{
        String titre = new String();
        int categorie;
        String date;

        ResultSet rset=this.getFilm();
        while (rset.next())
        {
            titre=rset.getString(1);
            categorie=rset.getInt(2);
            date=rset.getString(3);
            int heure;
            int j=8;
            int i=11;
            String str= new String();
            while(i<=12)
            {
                str=str+date.charAt(i);
                i++;
            }
            heure=Integer.parseInt(str);
            while(j<=9)
            {
                str=str+date.charAt(j);
                j++;
            }
            int index= Integer.parseInt(str);
            heure=heure-8;
            index=index-8;
            setValueAt(titre,heure, categorie, index);
            
            
        }
        
        
    }
    }
    
    
    
}
