<!DOCTYPE html>
<html lang="fr">
  <head>
    <link rel="stylesheet" href="assets/css/styles2.css?version=2" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="assets/js/jquery-3.1.1.min.js"></script>
    <title><?php echo("$title"); ?></title>
  </head>
  <body>
  <header>
    <?php
      require("header.php");
    ?>
  </header>
    <div class="content">
      <?php
        echo("$content");
      ?>
    </div>
  </body>
</html>
