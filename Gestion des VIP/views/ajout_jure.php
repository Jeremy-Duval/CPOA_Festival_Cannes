<?php
  $title="Ajout d'un Juré";
  ob_start();
?>


<h1>Ajout d'un Juré -- Etape 2/2</h1>
<div class="login-page">
  <div class="form">
    <form enctype="multipart/form-data" action="index.php?action=type_sent" method="post" class="login-form" id="ajout_jure">
      <!-- ID -->
      <?php echo("<input type='hidden' name='vipid' value='".$vipid."'>");?>

      <!-- Categorie -->
      <select name="categorie" form="ajout_jure" required>
        <option value="" disabled selected>Selectionner la catégorie</option>
        <?php
        foreach ($categorie as $optionCategorie) {
          $idCategorie=$optionCategorie['id'];
          $nomCategorie=$optionCategorie['nom'];
          echo("<option value='$idCategorie'>".$nomCategorie."</option>");
        }
        ?>
      </select>

      <!--Bouton de validation -->
      <input type="submit" value="Valider" class="button">
    </form>
  </div>
</div>

<?php
  $content=ob_get_clean();
  require("Views/layout.php");
?>
