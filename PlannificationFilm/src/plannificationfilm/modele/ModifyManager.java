/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plannificationfilm.modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
     * Manager de la partie vue servant à modifier les films.
     * @author Jérémy
     * @since 16/12/2016
     */
public class ModifyManager {

    ConnectionManager conn;

    /**
     * Constructeur du manager pour la modification de film.
     *
     * @param connection : Connection
     * @author Jérémy
     * @since 16/12/2016
     */
    public ModifyManager(ConnectionManager connection) {
        conn = connection;
    }

    /**
     * Fonction permettant de récupérer la liste des films.
     *
     * @author Jérémy
     * @return ResultSet : VARCHAR : liste des films
     * @throws java.sql.SQLException : erreur
     * @since 16/12/2016
     */
    public ResultSet getFilm() throws SQLException {
        ResultSet rset;
        try (Statement stmt = conn.createStatement()) {
            rset = stmt.executeQuery("SELECT DISTINCT titre FROM films JOIN creneaux ON films.id = creneaux.id_film;");
        }
        return rset;
    }
    
    /**
     * Fonction permettant de récupérer la liste des films.
     *
     * @author Jérémy
     * @return ResultSet : VARCHAR : liste des films
     * @throws java.sql.SQLException : erreur
     * @since 16/12/2016
     */
    public ResultSet getFilmToAdd() throws SQLException {
        ResultSet rset;
        try (Statement stmt = conn.createStatement()) {
            rset = stmt.executeQuery("SELECT titre FROM films WHERE id not in (SELECT id_film FROM creneaux);");
        }
        return rset;
    }

    /**
     * Fonction permettant de récupérer lles catégories de films.
     *
     * @author Jérémy
     * @return ResultSet : VARCHAR : liste des catégories
     * @throws java.sql.SQLException : erreur
     * @since 03/01/2016
     */
    public ResultSet getCategory() throws SQLException {
        ResultSet rset;
        try (Statement stmt = conn.createStatement()) {
            rset = stmt.executeQuery("SELECT * FROM categorie;");
        }
        return rset;
    }

    /**
     * Fonction permettant de récupérer la date des créneaux.
     *
     * @author Jérémy
     * @return ResultSet : Date : contient les dates en base.
     * @throws java.sql.SQLException : erreur
     * @since 03/01/2016
     */
    public ResultSet getDate() throws SQLException {
        ResultSet rset;
        try (Statement stmt = conn.createStatement()) {
            rset = stmt.executeQuery("SELECT distinct DATE(datetime) as day FROM creneaux where id_film = 0 order by day;");
        }
        return rset;
    }

    /**
     * Fonction permettant de récupérer la date et les horaires des crénaux.
     *
     * @author Jérémy
     * @param date : int : date pour laquelle il faut récupérer le DateTime.
     * @return ResultSet : DateTime : date + horaire disponible pour la date.
     * @throws java.sql.SQLException : erreur
     * @since 16/12/2016
     */
    public ResultSet getDateTime(int date) throws SQLException {
        ResultSet rset;
        try (Statement stmt = conn.createStatement()) {
            rset = stmt.executeQuery("SELECT datetime as day FROM creneaux where id_film = 0 and DAY(datetime) = " + date + " order by day;");
        }
        return rset;
    }
    
    /**
     * Fonction permettant de mettre à jour les crénaux dans la BD ainsi la categorie du film.
     * @author Jérémy
     * @param categorie
     * @param titre_film
     * @param date
     * @param horaire1
     * @param horaire2
     * @return ResultSet : DateTime : date + horaire disponible pour la date.
     * @throws java.sql.SQLException : erreur
     * @since 16/12/2016
     */
    public ResultSet updateBD(String categorie, String titre_film, String date, String horaire1, String horaire2) throws SQLException {
        ResultSet rset;
        try (Statement stmt = conn.createStatement()) {
            /************************film's category's update*************************/
            rset = stmt.executeQuery("UPDATE `films` SET `id_categorie`= "
                    + "(SELECT DISTINCT id FROM categorie WHERE nom = '"+categorie+"') WHERE titre = '"+titre_film+"';");
            /************************film's time slot update**************************/
            rset = stmt.executeQuery("UPDATE `creneaux` SET `id_film`= 0 WHERE "
                    + "id_film = (SELECT DISTINCT id FROM films WHERE titre = '"+titre_film+"');");
            rset = stmt.executeQuery("UPDATE `creneaux` SET `id_film`= "
                    + "(SELECT DISTINCT id FROM films WHERE titre = '"+titre_film+"')"
                    + " WHERE DAY(`datetime`)= "+date+" AND HOUR(`datetime`) = "+horaire1+";");
            rset = stmt.executeQuery("UPDATE `creneaux` SET `id_film`= "
                    + "(SELECT DISTINCT id FROM films WHERE titre = '"+titre_film+"')"
                    + " WHERE DAY(`datetime`)= "+date+" AND HOUR(`datetime`) = "+horaire2+";");
        }
        return rset;
    }

}
