<?php

include("conexao.php");

$login = $_POST["login"];

// Busca o ID do Usuário
$sql = "SELECT u.user_id FROM usuario as u INNER JOIN conta as c ON u.user_id = c.user_id WHERE c.login = '$login'";
$result = $conexao->query($sql);
$user_id = mysqli_fetch_assoc($result)["user_id"];

// Delete a conta do usuário
$sql = "DELETE FROM conta WHERE login = '$login'";
$conexao->query($sql);


// Deleta o usuário.
$sql = "DELETE FROM usuario WHERE user_id = '$user_id'";
$conexao->query($sql);
