<?php
session_start();
require("Model/Model.php");
require("Model/Manager.php");
require("Model/VIPManager.php");


$vm   = new VIPManager;
$m = new Manager;

$colnames=$m->getColNames('vip');
$results = $vm->getVIP();
$count   = count($results);
require("Views/home.php");
?>
