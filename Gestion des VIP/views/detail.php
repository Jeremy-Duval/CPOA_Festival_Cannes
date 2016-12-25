<?php
  $title="Détails pour ".$prenom." ".$nom;
  ob_start();
?>
  <?php
    echo("<h1>Détails pour ".$prenom." ".$nom."</h1>");
    echo("Type : ".$type."<br>");
    echo(" Pays : ".$pays."<br>");
    echo(" Importance : ".$importance."<br>");
    if(isset($compagnon)){
      echo("Compagnon : ".$compagnon);
    }else if(isset($categorie_jure)){
      echo("Juré dans la catégorie : ".$categorie_jure);
    }else if(isset($media)){
      echo("Media : ".$media);
    }else if(isset($sponsor)){
      echo("Répresente l'organisation : ".$sponsor);
    }
  ?>

<?php
  $content=ob_get_clean();
  require("Views/layout.php");
?>
