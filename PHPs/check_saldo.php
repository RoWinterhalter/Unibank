<?php

include("conexao.php");

$login = $_GET["login"];

$sql = "SELECT saldo FROM conta WHERE login = '$login'";
$result = $conexao->query($sql);
$json = mysqli_fetch_assoc($result);

mysqli_close($conexao);
echo json_encode($json);

?>