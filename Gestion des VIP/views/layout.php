<!DOCTYPE html>
<html lang="fr">
  <head>
    <link rel="stylesheet" href="assets/CSS/styles.css" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><?php echo("$title"); ?></title>
  </head>
  <body>
  <header>
    <?php
      require("header/header.php");
    ?>
  </header>
    <div class="content">
      <?php
        echo("$content");
      ?>
    </div>
  </body>
</html>
