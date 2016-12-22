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
}

?>
