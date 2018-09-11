<?php
require_once('authenticate.php');
?>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="arvore_genealogica.css">
</head>

<body>

<h2>Arvore genealógica da família Alcântara Gregório - <small><a href="/inserir_pessoa.php">Adicionar pessoa à árvore</a></small> </h2>

<div class="arvore">
<?php require_once "conexao_bd.php";

$random_family = getRandomFamily();

for($i = 0; $i < count($res_array);$i++){

    echo "<div class='person'>" . $res_array[$i][1] . "</div>";
    echo "<br/>";
    echo "<br/>";    
}

?>

</div>

<br>
<br>

<div class="footer">

</div>

</body>



</html>