<?php
  include_once("Model.php"); //la fonction doit être incluse une seule fois
  class ActionsManager extends Model{

    /***** Getters *****/
    public function getActions($id){
      $query = $this->executerRequete("SELECT id,date,cout FROM actions where id_vip='".$id."'"); // requête SQL
      $data = $query->fetchAll(PDO::FETCH_ASSOC);//on récupère un tableau de données
      $query->closeCursor();
      return $data;
    }


    public function getContenu($id){
      $query=$this->executerRequete("SELECT contenu from actions where id='".$id."'",array(1));
      $data=$query->fetch();
      return $data['contenu'];
    }





    /***** Ajout *****/
    public function ajoutAction($id,$date,$cout){
      $query=$this->executerRequete('SELECT max(id) as nb FROM actions');
      $data=$query->fetchAll(PDO::FETCH_ASSOC);
      $actionid = ($data[0]['nb'])+1;
      $query=$this->executerRequete("INSERT INTO actions VALUES ('".$actionid."','".$id."','".$date."','".$cout."','')",array(1));
      $query->closeCursor();
    }


    public function setContenu($id,$contenu){
      $query=$this->executerRequete("UPDATE actions set contenu='".$contenu."' where id='".$id."'",array(1));
    }


    /***** Suppression actions *****/
    public function delAction($id){
      $query=$this->executerRequete("DELETE from actions where id ='".$id."'",array(1));
    }
  }
?>
