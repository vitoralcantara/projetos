<?php
require_once('authenticate.php');
?>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="arvore_genealogica.css">
<script type="text/javascript">
function closeSession() {
    
    location.reload();
    return false;
}
</script>

</head>

<body>

<h2>Arvore genealógica da família Alcântara Gregório - <small><a href="/inserir_pessoa.php">Adicionar pessoa à árvore</a></small><small> -<a a href="/close_session.php"> Sair</small></h2>
<hr>

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