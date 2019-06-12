<?php

include("conexao.php");

$login = $_POST["login"];
$nome = $_POST["nome"];
$senha = $_POST["senha"];
$cpf = $_POST["cpf"];
$email = $_POST["email"];

$sql = "UPDATE conta SET senha = '$senha' WHERE login = '$login'";

$sql = "SELECT user_id FROM conta where login = '$login'";
$result = $conexao->query($sql);

$user_id = mysqli_fetch_assoc($result)["user_id"];

$sql = "update usuario set nome_completo = '$nome', cpf = '$cpf', email = '$email' where user_id = '$user_id'";
$conexao->query($sql);

mysqli_close($conexao);

?>