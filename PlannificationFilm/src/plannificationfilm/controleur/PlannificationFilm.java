/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.controleur;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import plannificationfilm.modele.ConnectionManager;
import plannificationfilm.modele.ModifyManager;
import plannificationfilm.vue.ApplicationFrame;

/**
 * Classe controleur, classe principale.
 * @author Jérémy
 * @since 12/12/2016
 */
public class PlannificationFilm {
    /****************************BD**************************/
    private static int colonne_film = 1;
    private static int colonne_category = 2;
    private static int colonne_datetime = 1;
    /*************************Connection*********************/
    private static ConnectionManager cManager;
    private static ModifyManager mManager;
    /*************************Génériques********************/
    private static DateFormat day_format = new SimpleDateFormat("dd");
    private static DateFormat hour_format = new SimpleDateFormat("hh");
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        
        /*************************Initialisation connection*********************/  
        cManager = new ConnectionManager();
        mManager = new ModifyManager(cManager);
        
        /*************************Démmarage appli*******************************/ 
            
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationFrame().setVisible(true);
            }
        });
        
    }
    
    /**
     * Récupère la liste des films depuis la fonction modele et l'envoi à la vue.
     * @return listHoraires : ArrayList
     * @author Jérémy
     * @throws java.sql.SQLException
     * @since 14/12/2016
     */
    public static ArrayList getFilm() {
        ArrayList listFilm;
        listFilm = new ArrayList<>();
        int i;
        
        /***********BD***************/
        ResultSet rset;
        
        try {
            rset = mManager.getFilm();
        
            i = 0;
            while (rset.next()) {
                listFilm.add(i,rset.getString(colonne_film));
                i++;
            }
            
            rset.close();
        } catch (SQLException ex) {
            Logger.getLogger(PlannificationFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        /***********************************************/
        
        return listFilm;
    }
    
    /**
     * Récupère la liste des categorie depuis la fonction modele et l'envoi à la vue.
     * @return listHoraires : ArrayList
     * @author Jérémy
     * @since 14/12/2016
     */
    public static ArrayList getCategory(){
        ArrayList listCategory;
        listCategory = new ArrayList<>();
        int i;

        /***********BD***************/
        ResultSet rset;
        
        try {
            rset = mManager.getCategory();
        
            i = 0;
            while (rset.next()) {
                listCategory.add(i,rset.getString(colonne_category));
                i++;
            }
            
            rset.close();
        } catch (SQLException ex) {
            Logger.getLogger(PlannificationFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        /***********************************************/
        
        return listCategory;
    }
    
    /**
     * Récupère la liste des date depuis la fonction modele et l'envoi à la vue.
     * @return listHoraires : ArrayList
     * @author Jérémy
     * @since 14/12/2016
     */
    public static ArrayList getDate(){
        java.util.Date date = new java.util.Date();
        ArrayList listDate;
        listDate = new ArrayList<>();
        int i;
        
        /***********BD***************/
        ResultSet rset;
        
        try {
            rset = mManager.getDate();
        
            i = 0;
            while (rset.next()) {
                //date = Calendar.getInstance().getTime();
                date = rset.getDate(colonne_datetime);
                listDate.add(i,day_format.format(date));
                i++;
            }
            
            rset.close();
        } catch (SQLException ex) {
            Logger.getLogger(PlannificationFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        /***********************************************/
        
        return listDate;
    }
    
    /**
     * Récupère la liste des heures de début de films disponibles depuis 
     * la fonction modele et l'envoi à la vue.
     * @param date : String : horaires pour ce jour
     * @return listHoraires : ArrayList
     * @author Jérémy
     * @since 14/12/2016
     */
    public static ArrayList getHoraires(String day){
        java.util.Date date = new java.util.Date();
        ArrayList listHoraires;
        listHoraires = new ArrayList<>();
        int i;
        
        /***********BD***************/
        ResultSet rset;
        
        try {
            rset = mManager.getHours(Integer.parseInt(day));
        
            i = 0;
            while (rset.next()) {
                //date = Calendar.getInstance().getTime();
                date = rset.getDate(colonne_datetime);
                listHoraires.add(i,hour_format.format(date));
                i++;
            }
            
            rset.close();
        } catch (SQLException ex) {
            Logger.getLogger(PlannificationFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
        /***********************************************/
        
        return listHoraires;
    }
    
    /**
     * Récupère les données à mettre à jour depuis la vu.
     * @param film : String : film à mettre à jour
     * @param categorie : String : nouvelle categorie
     * @param date : String : nouvelle date
     * @param heure1 : String : nouvelle premiere plage horaire 1
     * @param heure2 : String : nouvelle premiere plage horaire 2
     * @author Jérémy
     * @since 14/12/2016
     */
    public static void updatePlannig(String film, String categorie, String date, String heure1, String heure2){
        //update the BD !!!!!!!!!!!!!!!!!!!!!!!!!!!
        
        //link avec modele
        
        
        /***********POUR LES TESTS SANS BD***************/
        System.out.println("*************************************************");
            System.out.println("Film : "+film+"\nCategorie : "+categorie+"\nDate : "+date
                +"\nDebut première plage horaire : "+heure1+"\nDebut deuxième plage horaire : "+heure2);
            System.out.println("*************************************************");
    }
    
}
