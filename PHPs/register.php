<?php

include("conexao.php");

// User Info
$nome = $_POST['nome'];
$cpf = $_POST['cpf'];
$email = $_POST['email'];

// Account Info
$login = $_POST['login'];
$senha = $_POST['senha'];


$sql = "INSERT INTO usuario (nome_completo, cpf, email) VALUES ('$nome', '$cpf', '$email')";
$conexao->query($sql);

$sql = "SELECT user_id FROM usuario where CPF = '$cpf'";
$result = $conexao->query($sql);

$user_id = mysqli_fetch_assoc($result)["user_id"];

$sql = "INSERT INTO conta (user_id, login, senha) VALUES ('$user_id', '$login', '$senha')";
$conexao->query($sql);

mysqli_close($conexao);

