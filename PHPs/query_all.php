<?php

include("conexao.php");

$login = $_GET["login"];

$sql = "SELECT u.id, u.nome_completo, u.cpf, u.email, c.acc_id, c.login, c.senha, c.saldo FROM usuario AS u INNER JOIN conta AS c ON u.id = c.user_id WHERE login = '$login'";

$result = $conexao->query($sql);

$json = mysqli_fetch_assoc($result);

mysqli_close($conexao);
echo json_encode($json);    


?>