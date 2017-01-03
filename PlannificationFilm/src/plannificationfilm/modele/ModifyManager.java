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
            rset = stmt.executeQuery("SELECT titre FROM films;");
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

}
