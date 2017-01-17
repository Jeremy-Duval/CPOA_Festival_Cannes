/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.modele;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTabbedPane;
import javax.swing.table.AbstractTableModel;
import plannificationfilm.vue.ApplicationFrame;

/**
 *
 * @author Yann
 */
public class CalendarManager {

    static ConnectionManager conn;

    public CalendarManager(ConnectionManager connection) {
        conn = connection;
    }

    public static class abTableModel extends AbstractTableModel {

        private Object[][] data;
        private String[] title;

        public abTableModel(Object[][] data, String[] title) {
            this.data = data;
            this.title = title;
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

        
        
        /*public ResultSet getFilm1() throws SQLException {
            ResultSet rset;
            try (Statement stmt = conn.createStatement()) {
                rset = stmt.executeQuery("SELECT titre, id_categorie FROM films;");
            }
            System.out.println(rset);
            return rset;
        }
        
        public ResultSet getFilm2() throws SQLException {
            ResultSet rset;
            try (Statement stmt = conn.createStatement()) {
                rset = stmt.executeQuery("SELECT titre,id_categorie, DATE(datetime) FROM films, creneaux where creneaux.id_film=films.id and datetime like '2017-05-09%';");
            }
            return rset;
        }
        
        public void setValueAt(String nom, int row, int col) {
            data[row][col] = nom;
            fireTableCellUpdated(row, col);
        }

        public void setCalendar1() throws SQLException {
            String titre = new String();
            int categorie = 0;
            String date = null;

            ResultSet rset = getFilm1();
            while (rset.next()) {
                titre = rset.getString(1);
                categorie = rset.getInt(2);
                date = rset.getString(3);
                int heure;
                int j = 8;
                int i = 11;
                String str = new String();
                while (i <= 12) {
                    str = str + date.charAt(i);
                    i++;
                }
                heure = Integer.parseInt(str);
                heure = heure - 8;

                setValueAt(titre, heure, categorie);

            }

        }
        /*
        public void setCalendar2() throws SQLException {
            String titre = new String();
            int categorie = 0;
            String date = null;

            ResultSet rset = this.getFilm2();
            while (rset.next()) {
                titre = rset.getString(1);
                categorie = rset.getInt(2);
                date = rset.getString(3);
                int heure;
                int j = 8;
                int i = 11;
                String str = new String();
                while (i <= 12) {
                    str = str + date.charAt(i);
                    i++;
                }
                heure = Integer.parseInt(str);
                heure = heure - 8;

                setValueAt(titre, heure, categorie);

            }

        }

        /*public String[] getDate() throws SQLException
        {
            ResultSet rset;
            String str1 = null;
            String date= null;
            String tabdate[] = null;
            int x = 0;
            try (Statement stmt = conn.createStatement()) {
                rset = stmt.executeQuery("SELECT datetime FROM creneaux;");
            }
            
            while(rset.next())
            {
                str1=rset.getString(1);
                int i=0;
                while(i<=9)
                {                    
                    date=date+str1.charAt(i);                    
                    i++;
                }
                if(!tabdate[x-1].equals(date))
                {
                    tabdate[x]=date;
                    x++;
                }
                
            }
            
            return(tabdate);
            
        } */
    }

}
