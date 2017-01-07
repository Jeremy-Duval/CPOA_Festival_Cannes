<?php
  $title="Edition d'un échange";
  ob_start();
?>

<h1>Edition de l'échange <?php echo("N° ".$id." de ".$emetteur." à ".$destinataire.""); ?></h1>
<div class="login-page login-wide">
  <div class="form">
    <form enctype="multipart/form-data" action="index.php?action=echange_edite" method="post" class="login-form" id="edition_echange" onsubmit="return confirm('Sauvegarder contenu et retour aux échanges ?');">

      <!-- Contenu -->
      <textarea name="contenu_echange" form="edition_echange"><?php echo($contenu_echange);?></textarea>

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
