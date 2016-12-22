<?php $title="Acceuil Gestion des VIP";
ob_start();
?>


<!-- Affichage des films de la base de données -->
    <div class="table-title">
      <h1 class="inline">Liste des VIP -</h1>
      <h2><?php echo("$count")?> VIP trouvés dans la base de données.</h2>
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
  <a href="#" class="bouttonAcceuil">Accéder au détail</a>
  <a href="#" class="bouttonAcceuil">Accés aux échanges</a>
  <a href="#" class="bouttonAcceuil">Accés aux actions</a>
  <a href="#" class="bouttonAcceuil">Suppression</a>
</div>
<?php
  $content=ob_get_clean();
  require("Views/layout.php");
?>
