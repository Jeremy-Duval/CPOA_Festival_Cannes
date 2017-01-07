<?php
  $title="Ajout d'une action";
  ob_start();
?>

<h1>Ajout d'une action pour <?php echo($prenom." ".$nom); ?></h1>
<div class="login-page">
  <div class="form">
    <form enctype="multipart/form-data" action="index.php?action=action_sent" method="post" class="login-form" id="ajout_action">

      <!-- Date -->
      <label for="Date" class="no-bottom">Selectionner une date <input type="date" name="date" required></label><br>

      <!-- Coût -->
      <input type="number" name="cout" placeholder="Entrer le coût" required><br>


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
