<?php
  $title="Détails pour ".$prenom." ".$nom;
  ob_start();
?>
  <?php
    echo("<h1 class='margin_bottom_large'>Détails pour ".$prenom." ".$nom."</h1>");
    if($photo){
      echo("<img src='assets/img/vip/".$photo_name."' alt='Vip image' class='vip_photo margin_bottom_large'>");
    }
    echo("<div class='para_details'>");
    echo("<h2>Type : ".$type."</h2><br>");
    echo("<h2>Pays : ".$pays."</h2><br>");
    echo("<h2>Importance : ".$importance."</h2><br>");
    if(isset($compagnon)){
      echo("<h2>Compagnon : ".$compagnon."</h2>");
    }else if(isset($categorie_jure)){
      echo("<h2>Juré dans la catégorie : ".$categorie_jure."</h2>");
    }else if(isset($media)){
      echo("<h2>Media : ".$media."</h2>");
    }else if(isset($sponsor)){
      echo("<h2>Répresente l'organisation : ".$sponsor."</h2>");
    }
    echo("</div>");
  ?>

<?php
  $content=ob_get_clean();
  require("Views/layout.php");
?>
