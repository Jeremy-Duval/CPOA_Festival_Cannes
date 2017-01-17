/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.vue;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import plannificationfilm.modele.CalendarManager.abTableModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jeremy
 */
public class ApplicationFrame extends javax.swing.JFrame {
    
    abTableModel modele;

    /**
     * Creates new form ApplicationFrame
     * @throws java.sql.SQLException
     */
    public ApplicationFrame() throws SQLException {
        String title[] = {"Heure", "Palme d'Or", "Grand Prix", "Interprétation féminine", "Interprétation masculine", "Courts métrages", "Prix du scénario", "Prix du Jury", "Prix Un Certain Regard", "Prix de la mise en scène"};
        Object[][] data ={
        {"Heure", "Palme d'Or", "Grand Prix", "Interprétation féminine", "Interprétation masculine", "Courts métrages", "Prix du scénario", "Prix du Jury", "Prix Un Certain Regard", "Prix de la mise en scène"},
        {8, null, null, "Star Wars 191", null, null, null, null, null, null},
        {9, null, null, "Star Wars 191", null, null, null, null, null, null},
        {10, null, null, null, null, null, null, null, null, null},
        {11, null, null, null, null, null, null, null, null, null},
        {12, null, null, null, null, null, null, null, null, null},
        {13, null, null, null, null, null, null, null, null, null},
        {14, null, null, null, null, null, null, null, null, null},
        {15, null, null, null, null, null, null, null, null, null},
        {16, null, null, null, null, null, null, null, null, null},
        {17, null, null, null, null, null, null, null, null, null},
        {18, null, null, null, null, null, null, null, null, null},
        {19, null, null, null, null, null, null, null, null, null},
        {20, null, null, null, null, null, null, null, null, null}
        };
        modele=new abTableModel(data, title);
        initComponents();
        
        jTabbedPane4.setSelectedIndex(0);   
        modele.setCalendar1();
        jTabbedPane4.setSelectedIndex(1);
        //modele.setCalendar2();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneMenu = new javax.swing.JTabbedPane();
        jPanelAjout = new javax.swing.JPanel();
        jLabelFilm = new javax.swing.JLabel();
        jComboBoxFilm = new javax.swing.JComboBox<>();
        jLabelCategorie = new javax.swing.JLabel();
        jComboBoxCategorie = new javax.swing.JComboBox<>();
        jLabelDate = new javax.swing.JLabel();
        jComboBoxDate = new javax.swing.JComboBox<>();
        jLabelDiff1 = new javax.swing.JLabel();
        jComboBoxDiff1 = new javax.swing.JComboBox<>();
        jLabelDiff2 = new javax.swing.JLabel();
        jComboBoxDiff2 = new javax.swing.JComboBox<>();
        jButtonValider = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jPanelModifier = new javax.swing.JPanel();
        jPanelCalendrier = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable14 = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable15 = new javax.swing.JTable();
        jLabelTitre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Planning des projections");

        jTabbedPaneMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelFilm.setText("Sélectionner un film :");

        jComboBoxFilm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jurassic Park", "Star Wars", "Le Seigneur des Anneaux", "Kingdom of Heaven" }));
        jComboBoxFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFilmActionPerformed(evt);
            }
        });

        jLabelCategorie.setText("Sélectionner une catégorie :");

        jComboBoxCategorie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compétition", "Hors compétition", "Un Certain Regard" }));
        jComboBoxCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategorieActionPerformed(evt);
            }
        });

        jLabelDate.setText("Sélectionner une date :");

        jComboBoxDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lundi", "Mardi", "Mercredi" }));

        jLabelDiff1.setText("Sélectionner l'heure de début de la première diffusion :");

        jComboBoxDiff1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "10", "12" }));

        jLabelDiff2.setText("Sélectionner l'heure de début de la seconde diffusion :");

        jComboBoxDiff2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "14", "16", "18" }));
        jComboBoxDiff2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDiff2ActionPerformed(evt);
            }
        });

        jButtonValider.setText("Valider");
        jButtonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAjoutLayout = new javax.swing.GroupLayout(jPanelAjout);
        jPanelAjout.setLayout(jPanelAjoutLayout);
        jPanelAjoutLayout.setHorizontalGroup(
            jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAjoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAjoutLayout.createSequentialGroup()
                        .addComponent(jLabelCategorie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAjoutLayout.createSequentialGroup()
                        .addComponent(jLabelFilm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAjoutLayout.createSequentialGroup()
                        .addComponent(jLabelDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAjoutLayout.createSequentialGroup()
                        .addComponent(jLabelDiff1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxDiff1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAjoutLayout.createSequentialGroup()
                        .addComponent(jLabelDiff2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxDiff2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAjoutLayout.createSequentialGroup()
                        .addComponent(jButtonValider)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAnnuler)))
                .addContainerGap(1180, Short.MAX_VALUE))
        );
        jPanelAjoutLayout.setVerticalGroup(
            jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAjoutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxDiff2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelAjoutLayout.createSequentialGroup()
                        .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFilm)
                            .addComponent(jComboBoxFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCategorie)
                            .addComponent(jComboBoxCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDate)
                            .addComponent(jComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDiff1)
                            .addComponent(jComboBoxDiff1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDiff2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonValider)
                    .addComponent(jButtonAnnuler))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneMenu.addTab("Ajout Film", jPanelAjout);

        javax.swing.GroupLayout jPanelModifierLayout = new javax.swing.GroupLayout(jPanelModifier);
        jPanelModifier.setLayout(jPanelModifierLayout);
        jPanelModifierLayout.setHorizontalGroup(
            jPanelModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1563, Short.MAX_VALUE)
        );
        jPanelModifierLayout.setVerticalGroup(
            jPanelModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        jTabbedPaneMenu.addTab("Modifier", jPanelModifier);

        jTable1.setModel(modele);
        jTable1.setToolTipText("");
        jTable1.setName(""); // NOI18N
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane4.addTab("08/05", jScrollPane1);

        jTable2.setModel(modele);
        jScrollPane2.setViewportView(jTable2);

        jTabbedPane4.addTab("09/05", jScrollPane2);

        jTable3.setModel(modele);
        jScrollPane3.setViewportView(jTable3);

        jTabbedPane4.addTab("10/05", jScrollPane3);

        jTable4.setModel(modele);
        jScrollPane4.setViewportView(jTable4);

        jTabbedPane4.addTab("11/05", jScrollPane4);

        jTable5.setModel(modele);
        jScrollPane5.setViewportView(jTable5);

        jTabbedPane4.addTab("12/05", jScrollPane5);

        jTable6.setModel(modele);
        jScrollPane6.setViewportView(jTable6);

        jTabbedPane4.addTab("13/05", jScrollPane6);

        jTable7.setModel(modele);
        jScrollPane7.setViewportView(jTable7);

        jTabbedPane4.addTab("14/05", jScrollPane7);

        jTable8.setModel(modele);
        jScrollPane8.setViewportView(jTable8);

        jTabbedPane4.addTab("15/05", jScrollPane8);

        jTable9.setModel(modele);
        jScrollPane9.setViewportView(jTable9);

        jTabbedPane4.addTab("16/05", jScrollPane9);

        jTable10.setModel(modele);
        jScrollPane10.setViewportView(jTable10);

        jTabbedPane4.addTab("17/05", jScrollPane10);

        jTable11.setModel(modele);
        jScrollPane11.setViewportView(jTable11);

        jTabbedPane4.addTab("18/05", jScrollPane11);

        jTable12.setModel(modele);
        jScrollPane12.setViewportView(jTable12);

        jTabbedPane4.addTab("19/05", jScrollPane12);

        jTable13.setModel(modele);
        jScrollPane13.setViewportView(jTable13);

        jTabbedPane4.addTab("20/05", jScrollPane13);

        jTable14.setModel(modele);
        jScrollPane14.setViewportView(jTable14);

        jTabbedPane4.addTab("21/05", jScrollPane14);

        jTable15.setModel(modele);
        jScrollPane15.setViewportView(jTable15);

        jTabbedPane4.addTab("22/05", jScrollPane15);

        javax.swing.GroupLayout jPanelCalendrierLayout = new javax.swing.GroupLayout(jPanelCalendrier);
        jPanelCalendrier.setLayout(jPanelCalendrierLayout);
        jPanelCalendrierLayout.setHorizontalGroup(
            jPanelCalendrierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalendrierLayout.createSequentialGroup()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 483, Short.MAX_VALUE))
        );
        jPanelCalendrierLayout.setVerticalGroup(
            jPanelCalendrierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalendrierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jTabbedPaneMenu.addTab("Calendrier", jPanelCalendrier);

        jLabelTitre.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabelTitre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitre.setText("Planning des projections");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelTitre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneMenu))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabelTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFilmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxFilmActionPerformed

// <Méthode d'essai pour récupérer les valeurs des combobox>
    private void jButtonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderActionPerformed

        Object film, categorie, date, diff1, diff2;
        film = jComboBoxFilm.getSelectedItem();
        categorie = jComboBoxCategorie.getSelectedItem();
        date = jComboBoxDate.getSelectedItem();
        diff1 = jComboBoxDiff1.getSelectedItem();
        diff2 = jComboBoxDiff2.getSelectedItem();
        if (categorie!="Compétition")
        {
            System.out.print(film);
            System.out.print(categorie);
            System.out.print(date);
            System.out.print(diff1);
        }
        else 
        {
            System.out.print(film);
            System.out.print(categorie);
            System.out.print(date);
            System.out.print(diff1);
            System.out.print(diff2);
        }
        
    }//GEN-LAST:event_jButtonValiderActionPerformed

    private void jComboBoxDiff2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDiff2ActionPerformed

    }//GEN-LAST:event_jComboBoxDiff2ActionPerformed

//Méthode empêchant la saisie d'un deuxième horaire de diffusion s'il ne doit pas y en avoir 
    private void jComboBoxCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategorieActionPerformed
        if (jComboBoxCategorie.getSelectedItem()!="Compétition")
        {
            jComboBoxDiff2.disable();
        }
        else
        {
            jComboBoxDiff2.enable();
        }
        //Méthode empêchant la saisie d'un deuxième horaire de diffusion s'il ne doit pas y en avoir 
    }//GEN-LAST:event_jComboBoxCategorieActionPerformed

//Méthode retournant l'utilisateur vers le calendrier lorsqu'il annule
    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        jTabbedPaneMenu.setSelectedIndex(0);
        
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
                try {
                    new ApplicationFrame().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JComboBox<String> jComboBoxCategorie;
    private javax.swing.JComboBox<String> jComboBoxDate;
    private javax.swing.JComboBox<String> jComboBoxDiff1;
    private javax.swing.JComboBox<String> jComboBoxDiff2;
    private javax.swing.JComboBox<String> jComboBoxFilm;
    private javax.swing.JLabel jLabelCategorie;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelDiff1;
    private javax.swing.JLabel jLabelDiff2;
    private javax.swing.JLabel jLabelFilm;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JPanel jPanelAjout;
    private javax.swing.JPanel jPanelCalendrier;
    private javax.swing.JPanel jPanelModifier;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPaneMenu;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable14;
    private javax.swing.JTable jTable15;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    // End of variables declaration//GEN-END:variables
}
