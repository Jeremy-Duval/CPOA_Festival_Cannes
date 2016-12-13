/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.vue;

/**
 *
 * @author jeremy
 */
public class ApplicationFrame extends javax.swing.JFrame {
    private Object object;
    /*****************A modifier suivant les types************************/
    private Object film;
    private Object categorie;
    private Object date;
    private Object heure1;
    private Object heure2;
    /**
     * Creates new form ApplicationFrame
     */
    public ApplicationFrame() {
        initComponents();
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
        jPanelCalendrier = new javax.swing.JPanel();
        jPanelAjout = new javax.swing.JPanel();
        jPanelModifier = new javax.swing.JPanel();
        jLabelSelectionF = new javax.swing.JLabel();
        jComboBoxFilms = new javax.swing.JComboBox();
        jLabelCategorieF = new javax.swing.JLabel();
        jComboBoxCategories = new javax.swing.JComboBox();
        jLabelDateF = new javax.swing.JLabel();
        jComboBoxDate = new javax.swing.JComboBox();
        jComboBoxHeure1 = new javax.swing.JComboBox();
        jLabelHeure1F = new javax.swing.JLabel();
        jComboBoxHeure2 = new javax.swing.JComboBox();
        jLabelHeure2F = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonValiderModif = new javax.swing.JButton();
        jButtonAnnulerModif = new javax.swing.JButton();
        jLabelTitre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPaneMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanelCalendrierLayout = new javax.swing.GroupLayout(jPanelCalendrier);
        jPanelCalendrier.setLayout(jPanelCalendrierLayout);
        jPanelCalendrierLayout.setHorizontalGroup(
            jPanelCalendrierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );
        jPanelCalendrierLayout.setVerticalGroup(
            jPanelCalendrierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        jTabbedPaneMenu.addTab("Calendrier", jPanelCalendrier);

        javax.swing.GroupLayout jPanelAjoutLayout = new javax.swing.GroupLayout(jPanelAjout);
        jPanelAjout.setLayout(jPanelAjoutLayout);
        jPanelAjoutLayout.setHorizontalGroup(
            jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );
        jPanelAjoutLayout.setVerticalGroup(
            jPanelAjoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );

        jTabbedPaneMenu.addTab("Ajout Film", jPanelAjout);

        jLabelSelectionF.setText("Sélectionnez un film : ");

        jComboBoxFilms.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxFilms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFilmsActionPerformed(evt);
            }
        });

        jLabelCategorieF.setText("Nouvelle catégorie film :");

        jComboBoxCategories.setEnabled(false);

        jLabelDateF.setText("Nouvelle date  :");

        jComboBoxDate.setEnabled(false);

        jComboBoxHeure1.setEnabled(false);

        jLabelHeure1F.setText("Nouvelle heure de début de la première plage de diffusion  :");

        jComboBoxHeure2.setEnabled(false);

        jLabelHeure2F.setText("Nouvelle heure de début de la première plage de diffusion  :");

        jButtonValiderModif.setText("Valider");
        jButtonValiderModif.setEnabled(false);
        jButtonValiderModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValiderModifActionPerformed(evt);
            }
        });

        jButtonAnnulerModif.setText("Annuler");
        jButtonAnnulerModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerModifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelModifierLayout = new javax.swing.GroupLayout(jPanelModifier);
        jPanelModifier.setLayout(jPanelModifierLayout);
        jPanelModifierLayout.setHorizontalGroup(
            jPanelModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanelModifierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModifierLayout.createSequentialGroup()
                        .addGroup(jPanelModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelModifierLayout.createSequentialGroup()
                                .addComponent(jLabelSelectionF)
                                .addGap(36, 36, 36)
                                .addComponent(jComboBoxFilms, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelModifierLayout.createSequentialGroup()
                                .addComponent(jLabelCategorieF)
                                .addGap(39, 39, 39)
                                .addComponent(jComboBoxCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelModifierLayout.createSequentialGroup()
                                .addComponent(jLabelDateF)
                                .addGap(40, 40, 40)
                                .addComponent(jComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelModifierLayout.createSequentialGroup()
                                .addComponent(jLabelHeure1F)
                                .addGap(40, 40, 40)
                                .addComponent(jComboBoxHeure1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelModifierLayout.createSequentialGroup()
                                .addComponent(jLabelHeure2F)
                                .addGap(40, 40, 40)
                                .addComponent(jComboBoxHeure2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(258, Short.MAX_VALUE))
                    .addGroup(jPanelModifierLayout.createSequentialGroup()
                        .addComponent(jButtonValiderModif)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAnnulerModif)
                        .addGap(23, 23, 23))))
        );
        jPanelModifierLayout.setVerticalGroup(
            jPanelModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModifierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSelectionF)
                    .addComponent(jComboBoxFilms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanelModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCategorieF)
                    .addComponent(jComboBoxCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanelModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDateF)
                    .addComponent(jComboBoxDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanelModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHeure1F)
                    .addComponent(jComboBoxHeure1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanelModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHeure2F)
                    .addComponent(jComboBoxHeure2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelModifierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonValiderModif)
                    .addComponent(jButtonAnnulerModif))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneMenu.addTab("Modifier", jPanelModifier);

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
                .addComponent(jTabbedPaneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelTitre)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPaneMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxFilmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFilmsActionPerformed
        object = jComboBoxFilms.getSelectedItem();
        System.out.println(object);
        if(object!=null){
            jComboBoxCategories.setEnabled(true);
            jComboBoxDate.setEnabled(true);
            jComboBoxHeure1.setEnabled(true);
            jComboBoxHeure2.setEnabled(true);
            jButtonValiderModif.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBoxFilmsActionPerformed

    private void jButtonValiderModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValiderModifActionPerformed
        film = jComboBoxFilms.getSelectedItem();
        categorie = jComboBoxCategories.getSelectedItem();
        date = jComboBoxDate.getSelectedItem();
        heure1 = jComboBoxHeure1.getSelectedItem();
        heure2 = jComboBoxHeure2.getSelectedItem();
        System.out.println("*************************************************");
        System.out.println("Film : "+film+"\nCategorie : "+categorie+"\nDate : "+date
            +"\nDebut première plage horaire : "+heure1+"\nDebut deuxième plage horaire : "+heure2);
        System.out.println("*************************************************");
        // ***UPDATE**** DE LA BD
        // RETOUR AU CALENDRIER
    }//GEN-LAST:event_jButtonValiderModifActionPerformed

    private void jButtonAnnulerModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerModifActionPerformed
        if(!jButtonValiderModif.isEnabled()){ // retour sur calendrier
            System.out.println("ann, no val");
            this.initComponents();
        }else{ //annulation selection film
            System.out.println("ann, val");
            //remise à 0 de la selection de film et vidage des combo box
            jComboBoxFilms.setSelectedIndex(0);
            jComboBoxCategories.removeAllItems();
            jComboBoxDate.removeAllItems();
            jComboBoxHeure1.removeAllItems();
            jComboBoxHeure2.removeAllItems();
        }
    }//GEN-LAST:event_jButtonAnnulerModifActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnulerModif;
    private javax.swing.JButton jButtonValiderModif;
    private javax.swing.JComboBox jComboBoxCategories;
    private javax.swing.JComboBox jComboBoxDate;
    private javax.swing.JComboBox jComboBoxFilms;
    private javax.swing.JComboBox jComboBoxHeure1;
    private javax.swing.JComboBox jComboBoxHeure2;
    private javax.swing.JLabel jLabelCategorieF;
    private javax.swing.JLabel jLabelDateF;
    private javax.swing.JLabel jLabelHeure1F;
    private javax.swing.JLabel jLabelHeure2F;
    private javax.swing.JLabel jLabelSelectionF;
    private javax.swing.JLabel jLabelTitre;
    private javax.swing.JPanel jPanelAjout;
    private javax.swing.JPanel jPanelCalendrier;
    private javax.swing.JPanel jPanelModifier;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPaneMenu;
    // End of variables declaration//GEN-END:variables
}
