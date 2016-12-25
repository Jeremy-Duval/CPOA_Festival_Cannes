<?php
  include_once("Model.php"); //la fonction doit être incluse une seule fois
  class Manager extends Model{



   	//sert à récupérer la liste des films
   	public function getColNames($table_name){

   	        $query = $this->executerRequete("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA='festival_cannes' AND TABLE_NAME='".$table_name."'"); // requête SQL
   	        $data = $query->fetchAll(PDO::FETCH_ASSOC);//on récupère un tableau de données

   	        //on libère le curseur
   	    	$query->closeCursor();

   	    	return $data;

   	}
}

?>
