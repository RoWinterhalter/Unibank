<?php

include("conexao.php");

$login = $_POST["login"];
$saldo = $_POST["saldo"];

$sql = "UPDATE conta SET saldo = '$saldo' WHERE login = '$login'";

if (mysqli_query($conexao, $sql)){
    echo "Saldo do usuário '$login' atualizado com sucesso!";
}

else {
    echo "Aconteceu um erro ao atualizar o saldo.";
}

mysqli_close($conexao);

?>