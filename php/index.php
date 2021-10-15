<?php
error_reporting(-1);
ini_set('display_errors', 'On');

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
<?php 
require "get_users.php";

$first_id = get_first_user_id();
$children = get_children($first_id);

var_dump($first_id);
// echo "<br/>";
var_dump($children);

// for($i = 0; $i < count($res_array);$i++){

//     echo "<div class='person'>" . $res_array[$i][1] . "</div>";
//     echo "<br/>";
//     echo "<br/>";    
// }

?>

</div>

<br>
<br>

<div class="footer">

</div>

</body>



</html>