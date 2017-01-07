<?php
  include_once("Model.php"); //la fonction doit être incluse une seule fois
  class DetailManager extends Model{



    /***** Getters pour les détails *****/

    public function getDetail($id){
      $query = $this->executerRequete("SELECT
        vip.prenom as prenom,
        vip.nom as nom,
        CONCAT(UCASE(LEFT(type.nom, 1)),SUBSTRING(type.nom, 2)) as type,
        CONCAT(UCASE(LEFT(pays.nom, 1)),SUBSTRING(pays.nom, 2)) as pays,
        vip.importance as importance,
        photo
        FROM vip inner join type on vip.id_type=type.id INNER JOIN pays on vip.id_pays=pays.id where vip.id='".$id."'"); // requête SQL
      $data = $query->fetchAll(PDO::FETCH_ASSOC);//on récupère un tableau de données

      //on libère le curseur
      $query->closeCursor();

      return $data[0];
    }

    public function getCompagnon($id){
      $query=$this->executerRequete("SELECT nom_compagnon from people where id_vip ='".$id."'",array(1));
      $data=$query->fetch();

      return $data['nom_compagnon'];
    }

    public function getCategorieJure($id){
      $query=$this->executerRequete("SELECT nom from categorie where id in (SELECT id_categorie from jures where id_vip='".$id."')",array(1));
      $data=$query->fetch();

      return $data['nom'];
    }

    public function getMedia($id){
      $query=$this->executerRequete("SELECT media from journaliste where id_vip ='".$id."'",array(1));
      $data=$query->fetch();

      return $data['media'];
    }

    public function getOrganisation($id){
      $query=$this->executerRequete("SELECT institution from sponsor where id_vip ='".$id."'",array(1));
      $data=$query->fetch();

      return $data['institution'];
    }


}

?>
