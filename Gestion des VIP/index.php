<?php
require("Model/Model.php");
require("Model/Manager.php");
require("Model/VIPManager.php");
$vm   = new VIPManager;
$m = new Manager;


if (isset($_GET['action']) && ($_GET['action'] == 'ajout')) {
  $pays= $vm->getPays();
  $type = $vm->getType();
  $errorFields = false;
  require("Views/ajout_vip.php");
}else if (isset($_GET['action']) && ($_GET['action'] == 'ajout1')) {
  $pays= $vm->getPays();
  $type = $vm->getType();
  $errorFields = true;
  require("Views/ajout_vip.php");
}else if(isset($_GET['action']) && ($_GET['action'] == 'vip_sent')){
  // Champs requis
    $requiredFields = array(
        'prenom',
        'nom',
    );

    // On vérifie qu'aucun champ n'est vide
    $errorFields = false;
    foreach ($requiredFields as $field) {
        if (empty($_POST[$field])) {
            $errorFields = true;
        }
    }

    if ($errorFields == false) {
      if (isset($_FILES['vip_picture']) and $_FILES['vip_picture']['size'] != 0) {
          $vipid = $vm->ajoutVIP($_POST['prenom'],$_POST['nom'], $_POST['importance'],$_POST['pays'], $_POST['type'], 1);
          move_uploaded_file($_FILES['vip_picture']['tmp_name'], "assets/img/vip/" . $_POST['prenom']."_".$_POST['nom']);
      } else {
          $vipid = $vm->ajoutVIP($_POST['prenom'],$_POST['nom'], $_POST['importance'],$_POST['pays'], $_POST['type'], 0);
      }
    }else{
      header("Location: index.php?action=ajout1");
    }

    if(($_POST['type']==1) || ($_POST['type']==2)){
      require("Views/ajout_people.php");
    }else if($_POST['type']==3){
      $categorie = $vm->getCategorie();
      require("Views/ajout_jure.php");
    }else if($_POST['type']==4){
      require("Views/ajout_journaliste.php");
    }else if($_POST['type']==5){
      require("Views/ajout_sponsor.php");
    }


}else if(isset($_GET['action']) && ($_GET['action'] == 'type_sent')){
  if(isset($_POST['media'])){
    $ajout=$vm->ajoutJournaliste($_POST['vipid'],$_POST['media']);
  }else if(isset($_POST['sponsor'])){
    $ajout=$vm->ajoutSponsor($_POST['vipid'],$_POST['sponsor']);
  }else if(isset($_POST['categorie'])){
    $ajout=$vm->ajoutJure($_POST['vipid'],$_POST['categorie']);
  }else if(isset($_POST['compagnon'])){
    $ajout=$vm->ajoutPeople($_POST['vipid'],$_POST['compagnon']);
  }
  header("Location: index.php");
}else if(isset($_GET['action']) && ($_GET['action'] == 'detail')){
  $id=$vm->getID($_POST['prenom'],$_POST['nom'],$_POST['importance']);
  header("Location: index.php?detail=".$id);
}else if(isset($_GET['detail'])){
  $p_id=$_GET['detail'];
  $detail=$vm->getDetail($p_id);
  $prenom=$detail['prenom'];
  $nom=$detail['nom'];
  $type=$detail['type'];
  $pays=$detail['pays'];
  $importance=$detail['importance'];
  if($type=="Acteur" || $type=="Realisateur"){
    $compagnon=$vm->getCompagnon($p_id);
  }else if($type=="Jure"){
    $categorie_jure=$vm->getCategorieJure($p_id);
  }else if($type=="Journaliste"){
    $media=$vm->getMedia($p_id);
  }else if($type=="Sponsor"){
    $sponsor=$vm->getOrganisation($p_id);
  }
  require("Views/detail.php");
}else if(isset($_GET['action']) && ($_GET['action'] == 'suppression')){
  $p_id=$vm->getID($_POST['prenom'],$_POST['nom'],$_POST['importance']);
  $detail=$vm->getDetail($p_id);
  $type=$detail['type'];
  if($type=="Acteur" || $type=="Realisateur"){
    $compagnon=$vm->delPeople($p_id);
  }else if($type=="Jure"){
    $categorie_jure=$vm->delJure($p_id);
  }else if($type=="Journaliste"){
    $media=$vm->delJournaliste($p_id);
  }else if($type=="Sponsor"){
    $sponsor=$vm->delSponsor($p_id);
  }

  $suppr=$vm->delVIP($p_id);
  header("Location: index.php");
}else if(isset($_GET['action']) && ($_GET['action'] == 'echanges')){
  $id=$vm->getID($_POST['prenom'],$_POST['nom'],$_POST['importance']);
  header("Location: index.php?echanges=".$id);
}else if(isset($_GET['echanges'])){
  $p_id=$_GET['echanges'];
  $colnames=$m->getColNames('echanges');
  $colnames=array_slice($colnames,2,3);
  $echanges=$vm->getEchanges($p_id);
  $count   = count($echanges);
  require("Views/echanges.php");
}else{
  $colnames=$m->getColNames('infovip');
  $vip = $vm->getVIP();
  $count   = count($vip);
  require("Views/home.php");

}
?>
