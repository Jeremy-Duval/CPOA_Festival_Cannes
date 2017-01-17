<?php $title="Acceuil Gestion des VIP";
ob_start();
?>


<!-- Affichage des films de la base de données -->
    <div class="table-title">
      <h1 class="inline">Liste des echanges pour <?php echo($prenom." ".$nom); ?></h1><br>
      <h2><?php echo("$count")?> échanges trouvé(s) dans la base de données.</h2><br>
      <h3>Veuillez séléctionner un échange pour accéder/éditer le contenu ou le supprimer</h3>
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
              foreach ($echanges as $ligne) {
                echo("<tr>");
                foreach ($colnames as $col) {
                  echo("<td class='text-center'>".$ligne[$col['COLUMN_NAME']]."</td>");
                }
                echo("</tr>");
              }
            }else{
              echo("<tr>");
              foreach ($colnames as $col) {
                echo("<td class='text-center'>".$echanges[$col['COLUMN_NAME']]."</td>");
              }
              echo("</tr>");
            }
          }
        ?>
      </tbody>
    </table>
<div class="groupe_boutton">
  <form enctype="multipart/form-data" action="index.php?action=ajout_echange" method="post" id="ajout_echange" class="inline">
    <!-- Prenom -->
    <input type='hidden' name='prenom' value=''>
    <!-- Nom -->
    <input type='hidden' name='nom' value=''>
    <!-- ID VIP -->
    <input type='hidden' name='id_vip' value=''>

    <!--Bouton de validation -->
    <input type="submit" value="Ajouter" class="bouttonAcceuil" >

  </form>
  <form enctype="multipart/form-data" action="index.php?action=edition_echange" method="post" id="edition_echange" class="inline">
    <!-- ID VIP  -->
    <input type='hidden' name='id_vip' value=''>
    <!-- ID  -->
    <input type='hidden' name='id' value=''>
    <!-- Date  -->
    <input type='hidden' name='date' value=''>
    <!-- Emetteur  -->
    <input type='hidden' name='emetteur' value=''>
    <!--Destinataire  -->
    <input type='hidden' name='destinataire' value=''>

    <!--Bouton de validation -->
    <input type="submit" value="Voir ou éditer contenu" class="bouttonAcceuil" onclick="checkIfSelected()">

  </form>
  <form enctype="multipart/form-data" action="index.php?action=echange_suppression" method="post" id="echange_suppression" class="inline" onsubmit="return confirm('Voulez-vous vraiment supprimer cet échange ?');">
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
  var emetteur=$(this).find('td:nth-child(3)').html();
  var destinataire=$(this).find('td:nth-child(4)').html();
  $("input[name='id']").val(id);
  $("input[name='date']").val(date);
  $("input[name='emetteur']").val(emetteur);
  $("input[name='destinataire']").val(destinataire);
 });

 function checkIfSelected(){
   if(!($(".table-hover tr").hasClass('selected'))){
     alert("Vous n'avez sélectionner aucun échange");
     event.preventDefault();
   }
 }
</script>

<?php
  $content=ob_get_clean();
  require("Views/layout.php");
?>
