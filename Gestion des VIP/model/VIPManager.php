<?php
  include_once("Model.php"); //la fonction doit être incluse une seule fois
  class VIPManager extends Model{



   	/***** Getters infos vip *****/
   	public function getVIP(){

   	        $query = $this->executerRequete('SELECT * FROM infovip'); // requête SQL
   	        $data = $query->fetchAll(PDO::FETCH_ASSOC);//on récupère un tableau de données

   	        //on libère le curseur
   	    	$query->closeCursor();

   	    	return $data;

   	}

    public function getPays(){

   	        $query = $this->executerRequete('SELECT id,CONCAT(UCASE(LEFT(nom, 1)),SUBSTRING(nom, 2)) as nom FROM pays order by nom asc'); // requête SQL
   	        $data = $query->fetchAll(PDO::FETCH_ASSOC);//on récupère un tableau de données

   	        //on libère le curseur
   	    	$query->closeCursor();

   	    	return $data;

   	}

    public function getType(){

   	        $query = $this->executerRequete('SELECT id,CONCAT(UCASE(LEFT(nom, 1)),SUBSTRING(nom, 2)) as nom FROM type'); // requête SQL
   	        $data = $query->fetchAll(PDO::FETCH_ASSOC);//on récupère un tableau de données

   	        //on libère le curseur
   	    	$query->closeCursor();

   	    	return $data;

   	}

    public function getCategorie(){

   	        $query = $this->executerRequete('SELECT id,CONCAT(UCASE(LEFT(nom, 1)),SUBSTRING(nom, 2)) as nom FROM categorie'); // requête SQL
   	        $data = $query->fetchAll(PDO::FETCH_ASSOC);//on récupère un tableau de données

   	        //on libère le curseur
   	    	$query->closeCursor();

   	    	return $data;

   	}


    /***** Ajout de VIP *****/


    public function ajoutVIP($prenom,$nom,$importance,$pays,$type,$photo){

      $query=$this->executerRequete('SELECT max(id) as nb FROM vip');
      $data=$query->fetchAll(PDO::FETCH_ASSOC);
      $vipid = ($data[0]['nb'])+1;
      $query=$this->executerRequete("INSERT INTO vip VALUES ('".$vipid."','".$type."','".$pays."','".$nom."','".$prenom."','".$importance."','".$photo."')",array(1));
      $query->closeCursor();
      return $vipid;
   	}

    public function ajoutJournaliste($id,$media){
      $query=$this->executerRequete("INSERT INTO journaliste VALUES ('".$id."','".$media."')",array(1));
   	}

    public function ajoutSponsor($id,$sponsor){
      $query=$this->executerRequete("INSERT INTO sponsor VALUES ('".$id."','".$sponsor."')",array(1));
   	}

    public function ajoutJure($id,$jure){
      $query=$this->executerRequete("INSERT INTO jures VALUES ('".$id."','".$jure."')",array(1));
   	}

    public function ajoutPeople($id,$compagnon){
      $query=$this->executerRequete("INSERT INTO people VALUES ('".$id."','".$compagnon."')",array(1));
   	}

    public function getID($prenom,$nom,$importance){
    $query=$this->executerRequete("SELECT id from vip where prenom ='".$prenom."' and nom='".$nom."' and importance='".$importance."'",array(1));
    $data=$query->fetch();

     return $data['id'];
    }

    /***** Getters pour les détails *****/

    public function getDetail($id){
      $query = $this->executerRequete("SELECT
        vip.prenom as prenom,
        vip.nom as nom,
        CONCAT(UCASE(LEFT(type.nom, 1)),SUBSTRING(type.nom, 2)) as type,
        CONCAT(UCASE(LEFT(pays.nom, 1)),SUBSTRING(pays.nom, 2)) as pays,
        vip.importance as importance
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


    /***** Getters pour échanges *****/
    public function getEchanges($id){
      $query = $this->executerRequete("SELECT
        date,emetteur,destinataire FROM echanges where id_vip='".$id."'"); // requête SQL
      $data = $query->fetchAll(PDO::FETCH_ASSOC);//on récupère un tableau de données

      //on libère le curseur
      $query->closeCursor();

      return $data[0];
    }



    /***** Suppression *****/

    public function delJournaliste($id){
      $query=$this->executerRequete("DELETE from journaliste where id_vip ='".$id."'",array(1));
   	}

    public function delSponsor($id){
      $query=$this->executerRequete("DELETE from sponsor where id_vip ='".$id."'",array(1));
   	}

    public function delJure($id){
      $query=$this->executerRequete("DELETE from jures where id_vip ='".$id."'",array(1));
   	}

    public function delPeople($id){
      $query=$this->executerRequete("DELETE from people where id_vip ='".$id."'",array(1));
   	}

    public function delVIP($id){
      $query=$this->executerRequete("DELETE from vip where id ='".$id."'",array(1));
   	}
}

?>
