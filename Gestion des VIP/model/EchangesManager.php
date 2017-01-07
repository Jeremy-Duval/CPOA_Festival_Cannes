<?php
  include_once("Model.php"); //la fonction doit être incluse une seule fois
  class EchangesManager extends Model{

    /***** Getters *****/
    public function getEchanges($id){
      $query = $this->executerRequete("SELECT id,date,emetteur,destinataire FROM echanges where id_vip='".$id."'"); // requête SQL
      $data = $query->fetchAll(PDO::FETCH_ASSOC);//on récupère un tableau de données
      $query->closeCursor();
      return $data;
    }


    public function getContenu($id){
      $query=$this->executerRequete("SELECT contenu from echanges where id='".$id."'",array(1));
      $data=$query->fetch();
      return $data['contenu'];
    }





    /***** Ajout *****/
    public function ajoutEchange($id,$date,$emetteur,$destinataire){
      $query=$this->executerRequete('SELECT max(id) as nb FROM echanges');
      $data=$query->fetchAll(PDO::FETCH_ASSOC);
      $echangeid = ($data[0]['nb'])+1;
      $query=$this->executerRequete("INSERT INTO echanges VALUES ('".$echangeid."','".$id."','".$date."','".$emetteur."','".$destinataire."','')",array(1));
      $query->closeCursor();
    }


    public function setContenu($id,$contenu){
      $query=$this->executerRequete("UPDATE echanges set contenu='".$contenu."' where id='".$id."'",array(1));
    }


    /***** Suppression Echanges *****/
    public function delEchange($id){
      $query=$this->executerRequete("DELETE from echanges where id ='".$id."'",array(1));
    }
  }
?>
