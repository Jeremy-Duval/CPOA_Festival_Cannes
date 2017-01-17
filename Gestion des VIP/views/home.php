<?php $title="Acceuil Gestion des VIP";
  ob_start();
?>

    <div class="table-title">
      <h1 class="inline">Liste des VIP -</h1>
      <h2><?php echo("$count")?> VIP trouvé(s) dans la base de données.</h2><br>
      <h3>Veuillez séléctionner un VIP pour accéder aux différentes options</h3>
    </div>
    <div class="scroller">
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
      </div>
    <div class="groupe_boutton">

      <a href="index.php?action=ajoutvip" class="bouttonAcceuil">Ajouter</a>

      <form enctype="multipart/form-data" action="index.php?action=detail" method="post" id="detail" class="inline">
        <!-- Prenom -->
        <input type='hidden' name='prenom' value=''>
        <!-- Nom -->
        <input type='hidden' name='nom' value=''>
        <!-- Importance -->
        <input type='hidden' name='importance' value=''>

        <!--Bouton de validation -->
        <input type="submit" value="Accéder au détail" class="bouttonAcceuil" onclick="checkIfSelected()">

      </form>

      <form enctype="multipart/form-data" action="index.php?action=echanges" method="post" id="echange" class="inline">
        <!-- Prenom -->
        <input type='hidden' name='prenom' value=''>
        <!-- Nom -->
        <input type='hidden' name='nom' value=''>
        <!-- Importance -->
        <input type='hidden' name='importance' value=''>
        <!--Bouton de validation -->
        <input type="submit" value="Accés aux échanges" class="bouttonAcceuil" onclick="checkIfSelected()">

      </form>

      <form enctype="multipart/form-data" action="index.php?action=actions" method="post" id="action" class="inline">
        <!-- Prenom -->
        <input type='hidden' name='prenom' value=''>
        <!-- Nom -->
        <input type='hidden' name='nom' value=''>
        <!-- Importance -->
        <input type='hidden' name='importance' value=''>
        <!--Bouton de validation -->
        <input type="submit" value="Accés aux actions" class="bouttonAcceuil" onclick="checkIfSelected()">

      </form>

      <form enctype="multipart/form-data" action="index.php?action=suppression" method="post" id="suppression" class="inline" onsubmit="return confirm('Voulez-vous vraiment supprimer ce VIP ?');">
        <!-- Prenom -->
        <input type='hidden' name='prenom' value=''>
        <!-- Nom -->
        <input type='hidden' name='nom' value=''>
        <!-- Importance -->
        <input type='hidden' name='importance' value=''>

        <!--Bouton de validation -->
        <input type="submit" value="Suppression" class="bouttonAcceuil" onclick="checkIfSelected()">
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
  
  function checkIfSelected(){
    if(!($(".table-hover tr").hasClass('selected'))){
      alert("Vous n'avez sélectionner aucun VIP");
      event.preventDefault();
    }
  }
</script>
<?php
  $content=ob_get_clean();
  require("Views/layout.php");
?>
