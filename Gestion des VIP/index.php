<?php
  require("Model/Model.php");
  require("Model/Manager.php");
  require("Model/VIPManager.php");
  require("Model/DetailManager.php");
  require("Model/EchangesManager.php");
  require("Model/ActionsManager.php");

  $m  = new Manager;
  $vm = new VIPManager;
  $dm = new DetailManager;
  $em = new EchangesManager;
  $am = new ActionsManager;


  if (isset($_GET['action']) && ($_GET['action'] == 'ajoutvip')) {

    $pays= $vm->getPays();
    $type = $vm->getType();
    $errorFields = false;
    require("Views/ajout_vip.php");

  }else if (isset($_GET['action']) && ($_GET['action'] == 'ajouterror1')) {

    $pays= $vm->getPays();
    $type = $vm->getType();
    $errorFields = true;
    require("Views/ajout_vip.php");

  }else if(isset($_GET['action']) && ($_GET['action'] == 'vip_sent')){

      if (isset($_FILES['vip_picture'])){
        if($_FILES['vip_picture']['error']!=0){
          echo("Le fichier est trop gros !!! ");
        }else{
          $vipid = $vm->ajoutVIP($_POST['prenom'],$_POST['nom'], $_POST['importance'],$_POST['pays'], $_POST['type'], 1);
          move_uploaded_file($_FILES['vip_picture']['tmp_name'], "assets/img/vip/" . $_POST['prenom']."_".$_POST['nom']);
        }

      } else {
          $vipid = $vm->ajoutVIP($_POST['prenom'],$_POST['nom'], $_POST['importance'],$_POST['pays'], $_POST['type'], 0);
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
    $detail=$dm->getDetail($p_id);
    $prenom=$detail['prenom'];
    $nom=$detail['nom'];
    $type=$detail['type'];
    $pays=$detail['pays'];
    $importance=$detail['importance'];
    $photo=$detail['photo'];
    $photo_name=$prenom."_".$nom;
    if($type=="Acteur" || $type=="Realisateur"){
      $compagnon=$dm->getCompagnon($p_id);
    }else if($type=="Jure"){
      $categorie_jure=$dm->getCategorieJure($p_id);
    }else if($type=="Journaliste"){
      $media=$dm->getMedia($p_id);
    }else if($type=="Sponsor"){
      $sponsor=$dm->getOrganisation($p_id);
    }
    require("Views/detail.php");
  }else if(isset($_GET['action']) && ($_GET['action'] == 'suppression')){

    $p_id=$vm->getID($_POST['prenom'],$_POST['nom'],$_POST['importance']);
    $detail=$dm->getDetail($p_id);
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
    $detail=$dm->getDetail($p_id);
    $prenom=$detail['prenom'];
    $nom=$detail['nom'];
    $colnames=$m->getColNames('echanges');
    $colnames=array_merge(array_slice($colnames,0,1),array_slice($colnames,2,3));
    $echanges=$em->getEchanges($p_id);
    $count   = count($echanges);
    if($count==1){
      $echanges=$echanges[0];
    }
    require("Views/echanges.php");

  }else if(isset($_GET['action']) && $_GET['action']=='ajout_echange'){

    $prenom=$_POST['prenom'];
    $nom=$_POST['nom'];
    $id_vip=$_POST['id_vip'];
    require("Views/ajout_echange.php");

  }else if(isset($_GET['action']) && $_GET['action']=='echange_sent'){

    $ajout_echange=$em->ajoutEchange($_POST['id_vip'],$_POST['date'],$_POST['emetteur'],$_POST['destinataire']);

    header("Location: index.php?echanges=".$_POST['id_vip']);


  }else if(isset($_GET['action']) && $_GET['action']=='echange_suppression'){

    $del_echange=$em->delEchange($_POST['id']);
    header("Location: index.php?echanges=".$_POST['id_vip']);

  }else if(isset($_GET['action']) && $_GET['action']=='edition_echange'){

    $id_vip=$_POST['id_vip'];
    $id=$_POST['id'];
    $date=$_POST['date'];
    $emetteur=$_POST['emetteur'];
    $destinataire=$_POST['destinataire'];
    $contenu_echange=$em->getContenu($id);
    require("Views/edition_echange.php");

  }else if(isset($_GET['action']) && $_GET['action']=='echange_edite'){
    $edition=$em->setContenu($_POST['id'],$_POST['contenu_echange']);
    header("Location: index.php?echanges=".$_POST['id_vip']);
  }else if(isset($_GET['action']) && ($_GET['action'] == 'actions')){

    $id=$vm->getID($_POST['prenom'],$_POST['nom'],$_POST['importance']);
    header("Location: index.php?actions=".$id);

  }else if(isset($_GET['actions'])){

    $p_id=$_GET['actions'];
    $detail=$dm->getDetail($p_id);
    $prenom=$detail['prenom'];
    $nom=$detail['nom'];
    $colnames=$m->getColNames('actions');
    $colnames=array_merge(array_slice($colnames,0,1),array_slice($colnames,2,2));
    $actions=$am->getActions($p_id);
    $count   = count($actions);
    if($count==1){
      $actions=$actions[0];
    }
    require("Views/actions.php");

  }else if(isset($_GET['action']) && $_GET['action']=='ajout_action'){

    $prenom=$_POST['prenom'];
    $nom=$_POST['nom'];
    $id_vip=$_POST['id_vip'];
    require("Views/ajout_action.php");

  }else if(isset($_GET['action']) && $_GET['action']=='action_sent'){

    $ajout_action=$am->ajoutAction($_POST['id_vip'],$_POST['date'],$_POST['cout']);
    header("Location: index.php?actions=".$_POST['id_vip']);


  }else if(isset($_GET['action']) && $_GET['action']=='action_suppression'){

    $del_action=$am->delAction($_POST['id']);
    header("Location: index.php?actions=".$_POST['id_vip']);

  }else if(isset($_GET['action']) && $_GET['action']=='edition_action'){

    $id_vip=$_POST['id_vip'];
    $id=$_POST['id'];
    $date=$_POST['date'];
    $cout=$_POST['cout'];
    $contenu_action=$am->getContenu($id);
    require("Views/edition_action.php");

  }else if(isset($_GET['action']) && $_GET['action']=='action_edite'){

    $edition=$em->setContenu($_POST['id'],$_POST['contenu_action']);
    header("Location: index.php?actions=".$_POST['id_vip']);

  }else{

    $colnames=$m->getColNames('infovip');
    $vip = $vm->getVIP();
    $count   = count($vip);
    require("Views/home.php");

  }
?>
