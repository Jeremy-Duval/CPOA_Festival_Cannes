/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.controleur;

import java.awt.List;
import java.util.ArrayList;
import plannificationfilm.vue.ApplicationFrame;

/**
 * Classe controleur, classe principale.
 * @author Jérémy
 * @since 12/12/2016
 */
public class PlannificationFilm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
     * @return listCategory : ArrayList
     * @author Jérémy
     * @since 14/12/2016
     */
    public static ArrayList getFilm(){
        ArrayList listFilm;
        listFilm = new ArrayList<>();
        
        //link avec modele
        
        
        /***********POUR LES TESTS SANS BD***************/
        
        listFilm.add(0,"Star Wars");
        listFilm.add(1,"Blade");
        listFilm.add(2,"Pulp Fiction");
        
        /***********************************************/
        
        return listFilm;
    }
    
    /**
     * Récupère la liste des categorie depuis la fonction modele et l'envoi à la vue.
     * @return listCategory : ArrayList
     * @author Jérémy
     * @since 14/12/2016
     */
    public static ArrayList getCategorie(){
        ArrayList listCategory;
        listCategory = new ArrayList<>();
        
        //link avec modele
        
        
        /***********POUR LES TESTS SANS BD***************/
        
        listCategory.add(0,"Compétition");
        listCategory.add(1,"Hors Compétition");
        listCategory.add(2,"Coup de coeur");
        
        /***********************************************/
        
        return listCategory;
    }
    
}
