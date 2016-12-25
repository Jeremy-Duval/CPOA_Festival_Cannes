<?php $title="Acceuil Gestion des VIP";
ob_start();
?>


<!-- Affichage des films de la base de données -->
    <div class="table-title">
      <h1 class="inline">Liste des Echanges -</h1>
      <h2><?php echo("$count")?> échanges trouvé(s) dans la base de données.</h2>
    </div>
    <table class="table-fill">
      <thead>
        <tr>
          <?php
            foreach ($colnames as $col) {
              echo("<th class='text-center'>".ucfirst($col['COLUMN_NAME'])."</th>");
            }

          ?>
        </tr>
      </thead>
      <tbody class="table-hover">
        <?php
        foreach ($echanges as $ligne) {
          echo("<tr>");
          foreach ($colnames as $col) {
            echo("<td class='text-center'>".$echanges[$col['COLUMN_NAME']]."</td>");
          }
          echo("</tr>");
        }?>
      </tbody>
    </table>
    --
<div class="groupe_boutton">
  <a href="index.php?action=ajout" class="bouttonAcceuil">Ajouter</a>
  <form enctype="multipart/form-data" action="index.php?action=detail" method="post" id="detail" class="inline">
    <!-- Prenom -->
    <input type='hidden' name='prenom' value=''>
    <!-- Nom -->
    <input type='hidden' name='nom' value=''>
    <!-- Importance -->
    <input type='hidden' name='importance' value=''>

    <!--Bouton de validation -->
    <input type="submit" value="Accéder au détail" class="bouttonAcceuil">

  </form>
  <a href="#" class="bouttonAcceuil" onclick="validation()">Accés aux échanges</a>
  <a href="#" class="bouttonAcceuil">Accés aux actions</a>
  <form enctype="multipart/form-data" action="index.php?action=suppression" method="post" id="suppression" class="inline" onsubmit="return confirm('Voulez-vous vraiment supprimer ce VIP ?');">
    <!-- Prenom -->
    <input type='hidden' name='prenom' value=''>
    <!-- Nom -->
    <input type='hidden' name='nom' value=''>
    <!-- Importance -->
    <input type='hidden' name='importance' value=''>

    <!--Bouton de validation -->
    <input type="submit" value="Suppression" class="bouttonAcceuil" onclick="validation()">
  </form>
</div>

<script>
  $(".table-hover tr").click(function(){
   $(this).addClass('selected').siblings().removeClass('selected');
   var prenom=$(this).find('td:first').html();
   var nom=$(this).find('td:nth-child(2)').html();
   var importance=$(this).find('td:nth-child(5)').html();
   $("input[name='prenom']").val(prenom);
   $("input[name='nom']").val(nom);
   $("input[name='importance']").val(importance);
  });
</script>

<?php
print_r($colnames);
print_r($echanges);
  $content=ob_get_clean();
  require("Views/layout.php");
?>
