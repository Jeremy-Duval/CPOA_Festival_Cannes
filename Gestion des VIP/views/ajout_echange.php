<?php
  $title="Ajout d'un échange";
  ob_start();
?>

<h1>Ajout d'un échange pour <?php echo($prenom." ".$nom); ?></h1>
<div class="login-page">
  <div class="form">
    <form enctype="multipart/form-data" action="index.php?action=echange_sent" method="post" class="login-form" id="ajout_echange">

      <!-- Date -->
      <label for="Date" class="no-bottom">Selectionner une date <input type="date" name="date" required></label><br>

      <!-- Emetteur -->
      <input type="text" name="emetteur" placeholder="Entrer l'emetteur" required><br>

      <!-- Destinataire -->
      <input type="text" name="destinataire" placeholder="Entrer le destinataire" required><br>

      <!-- ID VIP -->
      <input type="hidden" name="id_vip" value="<?php echo($id_vip);?>">


      <!--Bouton de validation -->
      <input type="submit" value="Valider" class="button">
    </form>
  </div>
</div>

<?php
  $content=ob_get_clean();
  require("Views/layout.php");
?>
