<?php
  $title="Edition d'une action";
  ob_start();
?>

<h1>Edition de l'action <?php echo("N° ".$id." datant du ".$date.""); ?></h1>
<div class="login-page login-wide">
  <div class="form">
    <form enctype="multipart/form-data" action="index.php?action=action_edite" method="post" class="login-form" id="edition_action" onsubmit="return confirm('Sauvegarder description et retour aux actions ?');">
      <!-- Contenu -->
      <textarea name="contenu_action" form="edition_action"><?php echo($contenu_action);?></textarea>

      <!-- ID -->
      <input type="hidden" name="id" value="<?php echo($id);?>">

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
