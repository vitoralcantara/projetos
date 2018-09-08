<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="arvore_genealogica.css">
</head>

<body>

<h2>Arvore genealógica da família Alcântara Gregório - <small><a href="/inserir_pessoa.php">Adicionar pessoa à árvore</a></small> </h2>

<div class="arvore">
<?php require_once "conexao_bd.php";

for($i = 0; $i < count($res_array);$i++){

    echo $res_array[$i][1] . " ";
    //echo "<br/>";    
}

?>

</div>

<br>
<br>

<div class="footer">

</div>

</body>



</html>