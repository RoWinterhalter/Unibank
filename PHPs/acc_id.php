<?php

include("conexao.php");

$login = $_GET["login"];

$sql = "SELECT acc_id FROM conta WHERE login = '$login'";
$result = $conexao->query($sql);

echo json_encode(mysqli_fetch_assoc($result));

mysqli_close($conexao);

?>