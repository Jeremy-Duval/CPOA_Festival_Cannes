<?php
  include_once("Model.php"); //la fonction doit être incluse une seule fois
  class VIPManager extends Model{



   	//sert à récupérer la liste des films
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

}

?>
