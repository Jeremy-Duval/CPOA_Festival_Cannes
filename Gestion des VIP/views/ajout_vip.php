<?php
  $title="Ajout d'un VIP";
  ob_start();
?>

<h1>Ajout d'un VIP -- Etape 1/2</h1>
<div class="login-page">
  <div class="form">
    <form enctype="multipart/form-data" action="index.php?action=vip_sent" method="post" class="login-form" id="ajout_vip">

      <!--Nom et prénom -->
      <input type="text" name="prenom" placeholder="Entrer le prenom"><br>
      <input type="text" name="nom" placeholder="Entrer le nom"><br>

      <!--Importance -->
      <label for="importance" id="importance-label">Selectionner importance: <output for="importance" id="importance_valeur">0</output>
      <input name="importance" id="importance" type ="range" min ="0" max="100" step ="1" value="0" oninput="outputUpdate(value)"/></label>
      <script>function outputUpdate(imp) {document.querySelector('#importance_valeur').value = imp;}</script>

      <!--Pays -->
      <select name="pays" form="ajout_vip" required>
        <option value="" disabled selected>Selectionner le pays</option>
        <?php
        foreach ($pays as $optionPays) {
          $idPays=$optionPays['id'];
          $nomPays=$optionPays['nom'];
          echo("<option value='$idPays'>".$nomPays."</option>");
        }
        ?>
      </select>

      <!--Type -->
      <select name="type" form="ajout_vip" required>
        <option value="" disabled selected>Selectionner le type</option>
        <?php
        foreach ($type as $optionType) {
          $idType=$optionType['id'];
          $nomType=$optionType['nom'];
          echo("<option value='$idType'>".$nomType."</option>");
        }
        ?>
      </select>

      <!--Image -->
      <input type="file" name="vip_picture" id="vip_picture-upload">
      <label for="vip_picture-upload" class="button">Choississez une image pour le VIP</label>

      <!--Bouton de validation -->
      <input type="submit" value="Valider" class="button">
      <?php
      if($errorFields==true){
        echo("<p class='erreur'>Veuillez renseigner tout les champs</p>");
      }
      ?>
    </form>
  </div>
</div>

<?php
  $content=ob_get_clean();
  require("Views/layout.php");
?>
