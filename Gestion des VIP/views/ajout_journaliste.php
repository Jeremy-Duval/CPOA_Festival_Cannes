<?php
  $title="Ajout d'un VIP";
  ob_start();
?>


<h1>Ajout d'un Journaliste -- Etape 2/2</h1>
<div class="login-page">
  <div class="form">
    <form enctype="multipart/form-data" action="index.php?action=type_sent" method="post" class="login-form" id="ajout_journaliste">
      <!-- ID -->
      <?php echo("<input type='hidden' name='vipid' value='".$vipid."'>");?>

      <!--Nom et prénom -->
      <input type="text" name="media" placeholder="Entrer le nom du media" class="big-font"><br>

      <!--Bouton de validation -->
      <input type="submit" value="Valider" class="button">
    </form>
  </div>
</div>

<?php
  $content=ob_get_clean();
  require("Views/layout.php");
?>
