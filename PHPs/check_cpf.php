<?php

include("conexao.php");

$cpf = $_GET["cpf"];

$sql = "SELECT cpf FROM usuario WHERE cpf = '$cpf'";
$result = $conexao->query($sql);

$json = mysqli_fetch_assoc($result);

mysqli_close($conexao);
echo json_encode($json);


?>