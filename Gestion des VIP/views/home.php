<?php $title="Acceuil Gestion des VIP";
ob_start();
?>


<!-- Affichage des films de la base de données -->
    <div class="table-title">
      <h1 class="inline">Liste des VIP -</h1>
      <h2><?php echo("$count")?> VIP trouvé(s) dans la base de données.</h2>
    </div>
    <table class="table-fill">
      <thead>
        <tr>
          <?php
            foreach ($colnames as $col) {
              echo("<th class='text-center'>".$col['COLUMN_NAME']."</th>");
            }

          ?>
        </tr>
      </thead>
      <tbody class="table-hover">
        <?php
        foreach ($vip as $ligne) {
          echo("<tr>");
          foreach ($colnames as $col) {
            echo("<td class='text-center'>".$ligne[$col['COLUMN_NAME']]."</td>");
          }
          echo("</tr>");
        }?>
      </tbody>
    </table>
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
  <a href="#" class="bouttonAcceuil">Accés aux échanges</a>
  <a href="#" class="bouttonAcceuil">Accés aux actions</a>
  <a href="#" class="bouttonAcceuil">Suppression</a>
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
  $content=ob_get_clean();
  require("Views/layout.php");
?>
