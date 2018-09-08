<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="arvore_genealogica.css">
</head>

<body>

<h2>Arvore genealógica da família Alcântara Gregório</h2>

<div class="arvore">
<?php require_once "conexao_bd.php";

echo $res_array[0][1];

?>

</div>

<br>
<br>

<div class="footer">
<form action="/inserir_pessoa.php">
    <input type="submit" value="Adicionar pessoa à árvore" />
</form>

</div>

</body>



</html>