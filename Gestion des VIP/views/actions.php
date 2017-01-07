<?php $title="Gestion des actions";
ob_start();
?>

    <div class="table-title">
      <h1 class="inline">Liste des actions pour <?php echo($prenom." ".$nom); ?></h1><br>
      <h2><?php echo("$count")?> actions trouvé(s) dans la base de données.</h2><br>
      <h3>Veuillez séléctionner une action pour accéder aux différentes options</h3>
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
          if($count!=0){
            if($count>1){
              foreach ($actions as $ligne) {
                echo("<tr>");
                foreach ($colnames as $col) {
                  echo("<td class='text-center'>".$ligne[$col['COLUMN_NAME']]."</td>");
                }
                echo("</tr>");
              }
            }else{
              echo("<tr>");
              foreach ($colnames as $col) {
                echo("<td class='text-center'>".$actions[$col['COLUMN_NAME']]."</td>");
              }
              echo("</tr>");
            }
          }
        ?>
      </tbody>
    </table>
<div class="groupe_boutton">
  <form enctype="multipart/form-data" action="index.php?action=ajout_action" method="post" id="ajout_action" class="inline">
    <!-- Prenom -->
    <input type='hidden' name='prenom' value=''>
    <!-- Nom -->
    <input type='hidden' name='nom' value=''>
    <!-- ID VIP -->
    <input type='hidden' name='id_vip' value=''>

    <!--Bouton de validation -->
    <input type="submit" value="Ajouter" class="bouttonAcceuil" onclick="checkIfSelected()">

  </form>
  <form enctype="multipart/form-data" action="index.php?action=edition_action" method="post" id="edition_action" class="inline">
    <!-- ID VIP  -->
    <input type='hidden' name='id_vip' value=''>
    <!-- ID  -->
    <input type='hidden' name='id' value=''>
    <!-- Date  -->
    <input type='hidden' name='date' value=''>
    <!-- Coût  -->
    <input type='hidden' name='cout' value=''>

    <!--Bouton de validation -->
    <input type="submit" value="Voir ou éditer description" class="bouttonAcceuil" onclick="checkIfSelected()">

  </form>
  <form enctype="multipart/form-data" action="index.php?action=action_suppression" method="post" id="action_suppression" class="inline" onsubmit="return confirm('Voulez-vous vraiment supprimer cette action ?');">
    <!-- ID VIP  -->
    <input type='hidden' name='id_vip' value=''>
    <!-- ID  -->
    <input type='hidden' name='id' value=''>

    <!--Bouton de validation -->
    <input type="submit" value="Suppression" class="bouttonAcceuil" onclick="checkIfSelected()">

  </form>
</div>

<script>
  $(document).ready( function(){
   var prenom='<?php echo($prenom);  ?>';
   var nom='<?php echo($nom);  ?>';
   var id_vip='<?php echo($p_id);  ?>';
   $("input[name='prenom']").val(prenom);
   $("input[name='nom']").val(nom);
   $("input[name='id_vip']").val(id_vip);
 });
 $(".table-hover tr").click(function(){
  $(this).addClass('selected').siblings().removeClass('selected');
  var id=$(this).find('td:first').html();
  var date=$(this).find('td:nth-child(2)').html();
  var cout=$(this).find('td:nth-child(3)').html();
  $("input[name='id']").val(id);
  $("input[name='date']").val(date);
  $("input[name='cout']").val(emetteur);
 });

 function checkIfSelected(){
   if(!($(".table-hover tr").hasClass('selected'))){
     alert("Vous n'avez sélectionner aucune action");
     event.preventDefault();
   }
 }
</script>

<?php
  $content=ob_get_clean();
  require("Views/layout.php");
?>
