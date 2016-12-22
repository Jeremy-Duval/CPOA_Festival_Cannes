<?php $titre="Liste des films référencés";
ob_start();
?>


<!-- Affichage des films de la base de données -->
    <div class="table-title">
      <h1>Liste des VIP -</h1>
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
        foreach ($results as $ligne) {
          echo("<tr>");
          foreach ($colnames as $col) {
            echo("<td class='text-center'>".$ligne[$col['COLUMN_NAME']]."</td>");
          }
          echo("</tr>");
        }?>
      </tbody>
    </table>

<?php
  $content=ob_get_clean();
  require("Views/layout.php");
?>
