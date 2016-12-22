<?php
session_start();
require("Model/Model.php");
require("Model/Manager.php");
require("Model/VIPManager.php");
$vm   = new VIPManager;
$m = new Manager;


if (isset($_GET['action']) && ($_GET['action'] == 'ajout')) {
  $pays= $vm->getPays();
  $type = $vm->getType();
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
    }


    if(($_POST['type']==1) && ($_POST['type']==2)){
      require("Views/ajout_people.php");
    }else if($_POST['type']==3){
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
  }
  header("Location: index.php");
}else{
  $colnames=$m->getColNames('vip');
  $vip = $vm->getVIP();
  $count   = count($vip);
  require("Views/home.php");

}
?>
