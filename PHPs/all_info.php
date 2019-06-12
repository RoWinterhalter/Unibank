<?php

include("conexao.php");

$login = $_GET["login"];

$sql = "SELECT u.user_id, u.nome_completo, u.cpf, u.email, c.acc_id, c.login, c.senha, c.saldo FROM usuario as u
INNER JOIN conta as c ON u.user_id = c.user_id WHERE c.login = '$login'";

$result = $conexao->query($sql);
$json = mysqli_fetch_assoc($result);

echo json_encode($json);

mysqli_close($conexao);

?>